package com.mirror.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.mirror.Dao.TagDao;
import com.mirror.Dao.TagWorkDao;
import com.mirror.Dao.UserDao;
import com.mirror.Dao.UserWorkRelationDao;
import com.mirror.Dao.UserUserRelationDao;
import com.mirror.Dao.VideoDao;
import com.mirror.Dao.WorkDao;
import com.mirror.entity.Relation.Map_TagUser;
import com.mirror.entity.Relation.Map_TagWork;
import com.mirror.entity.Relation.UserUser;
import com.mirror.entity.Relation.UserWork;
import com.mirror.entity.Resource.Work;
import com.mirror.entity.User.User;
import com.mirror.entity.tag.Tag;
import com.mirror.service.StreamService;
import com.mirror.util.StringUtil;

@Service("StreamServiceImpl")
public class StreamServiceImpl extends BaseServiceImpl<Work, Long> implements
		StreamService {

	@Resource(name = "workDaoImpl")
	private WorkDao workDao;

	@Resource(name = "userDaoImpl")
	private UserDao userDao;

	@Resource(name = "userUserRelationDaoImpl")
	private UserUserRelationDao useruserRelationDao;

	@Resource(name = "userWorkRelationDaoImpl")
	private UserWorkRelationDao userworkRelationDao;

	@Resource(name = "videoDaoImpl")
	private VideoDao videoDao;

	@Resource(name = "TagDaoImpl")
	private TagDao tagDao;

	@Resource(name = "tagWorkDaoImpl")
	private TagWorkDao tagWorkDao;
	
	private final static int PageSize = 3;

	/**
	 * 
	 * @param uid
	 *            当前用户id
	 * @param authorid
	 *            当前作品的作者id
	 * 
	 * @return 该作者作品list
	 */
	public JSONArray get_usertimeline(Long uid, Long authorid, int pageNo) {
		JSONArray JSON = new JSONArray();
		List<Work> worklist = null;
		List<UserUser> usrusrllist = null;
		List<UserWork> usrworkllist = null;

		User author = new User();
		author.setID(authorid);
		// author.setEmail("email");

		worklist = workDao.findPageByUser(author, pageNo, PageSize);

		int usr_relation_status = useruserRelationDao.findstatusByuids(uid,
				authorid);

		usrworkllist = userworkRelationDao.findFavoriteWorksbyUid(uid);

		// JSON
		JSON = genJSON_forWorkList(worklist, usr_relation_status, usrworkllist);

		return JSON;
	}
	
	//根据作者id，获取所有该作者work
	public JSONArray getAllWorksByAuthor(Long uid, Long authorid){
		JSONArray JSON = new JSONArray();
		List<Work> worklist = null;
		List<UserUser> usrusrllist = null;
		List<UserWork> usrworkllist = null;


		worklist = workDao.findAllWorkByUser(authorid);

		int usr_relation_status = useruserRelationDao.findstatusByuids(uid,
				authorid);

		usrworkllist = userworkRelationDao.findFavoriteWorksbyUid(uid);

		// JSON
		JSON = genJSON_forWorkList(worklist, usr_relation_status, usrworkllist);

		return JSON;
	}


	public JSONArray get_recomandtimeline(Long uid, int pageNo) {
		List<Map_TagUser> mtulist = null;
		List<Map_TagWork> mtwlist = null;
		List<Work> worklist = null;

		mtulist = tagDao.findtagsbyUser(uid);

		// if num of results equals 0 then return
		// if (mtulist.size() == 0) {
		// return null;
		// }

		List<Long> tagids = new ArrayList<Long>();
		// String tagids="(0";

		Iterator<Map_TagUser> mtu_it = mtulist.iterator();

		while (mtu_it.hasNext()) {
			tagids.add(mtu_it.next().getTid());
		}

		mtwlist = tagDao.findWorkstagsbyTagids(tagids);
		List<Long> workids = new ArrayList<Long>();

		// if num of results equals 0 then return
		// if (workids.size() == 0) {
		// return null;
		// }

		Iterator<Map_TagWork> mtw_it = mtwlist.iterator();
		while (mtw_it.hasNext()) {
			workids.add(mtw_it.next().getWid());
		}

		double RecomandworksSize = workDao.getRecomandStreamSize(workids);

		double TotalRecomandPageSize = Math.ceil(RecomandworksSize / PageSize);

		double offset = RecomandworksSize % PageSize;

		if (pageNo <= TotalRecomandPageSize) {

			worklist = workDao.findByIDs(workids, pageNo, PageSize);

			// if num of results equals 0 then return 3 random works
			if (0 < worklist.size() && worklist.size() < PageSize) {
				int limit = (int) (PageSize - offset);

				List<Work> supplement = workDao.findTopNByExcludeIDs(workids,
						limit);

				worklist.addAll(supplement);
				// return null;
			}
		} else {

			int pageNoDefault = (int) (pageNo - TotalRecomandPageSize);

			worklist = workDao.findBySpecifyIndex(workids, (int) offset,
					pageNoDefault, PageSize);

		}

		return genJSON_forWorkList(worklist);
	}

	public int work_upload(Work w, Long authorid) {
		int Res = 1;

		User author = userDao.find(authorid);
		w.setUser(author);

		workDao.persist(w);

		// return the entity itself rather than its ID
		// When the transaction ends, the flush will happen, and ID will be
		// generated

		if (w.ID > 0) {
			Res = 0;
		}

		return Res;
	}

	/**
	 * <b>function:</b>
	 * 
	 * @author
	 * @createDate
	 */
	public JSONArray genJSON_forWorkList(List<Work> worklist) {

		String JSONres = null;

		JSONArray arrayres = new JSONArray();
		// JSONres = JSONArray.fromObject(worklist).toString();

		Iterator<Work> it = worklist.iterator();
		while (it.hasNext()) {
			Work work_current = it.next();
			JSONObject object = new JSONObject();

			object.element("workid", work_current.getID());
			object.element("workPlayCount", work_current.getPlayCount());
			object.element("Work_title", work_current.getTitle());
			object.element("Work_privacy", work_current.getPrivacy());
			object.element("Work_desc", work_current.getDesciption());
			object.element("Work_videokey", StringUtil
					.findDownloadURL(work_current.getVideo().getFileKey()));

			// object.element("Work_audiokey",
			// work_current.getAudio().getFileKey());
			// object.element("Work_snapshotkey",
			// work_current.getSnapshot().getFileKey());

			object.element("Work_geolocation", work_current.getGeolocation());
			object.element("Work_publishtime", work_current.getUploadTime());

			object.element("Work_author_id", work_current.getUser().getID());
			object.element("Work_author_nickname", work_current.getUser()
					.getNickName());
			object.element("Work_author_avatar_key", StringUtil
					.findDownloadURL(work_current.getUser().getIconPath()));
			object.element("thumbnailURL", StringUtil
					.findWorkFrameDownloadURL(work_current.getVideo()
							.getFileKey()));

			arrayres.add(object);
		}

		JSONres = arrayres.toString();

		return arrayres;
	}

	/**
	 * <b>function:</b>Java ListJSON
	 * 
	 * @author
	 * @createDate
	 */
	public JSONArray genJSON_forWorkList(List<Work> worklist,
			int usr_relation_status, List<UserWork> usrworklist) {

		JSONArray arrayres = new JSONArray();
		// JSONres = JSONArray.fromObject(worklist).toString();

		Iterator<Work> it = worklist.iterator();
		while (it.hasNext()) {
			Work work_current = it.next();
			JSONObject object = new JSONObject();

			object.element("workid", work_current.getID());
			object.element("workPlayCount", work_current.getPlayCount());
			object.element("Work_title", work_current.getTitle());
			object.element("Work_privacy", work_current.getPrivacy());
			object.element("Work_desc", work_current.getDesciption());
			object.element("Work_videokey", StringUtil
					.findDownloadURL(work_current.getVideo().getFileKey()));
			object.element("thumbnailURL", StringUtil
					.findWorkFrameDownloadURL(work_current.getVideo()
							.getFileKey()));
			// object.element("Work_audiokey", work_current.getAudio()
			// .getFileKey());
			// object.element("Work_snapshotkey", work_current.getSnapshot()
			// .getFileKey());
			object.element("Work_geolocation", work_current.getGeolocation());
			object.element("Work_publishtime", work_current.getUploadTime());

			object.element("Work_author_id", work_current.getUser().getID());
			object.element("Work_author_nickname", work_current.getUser()
					.getNickName());
			object.element("Work_author_avatar_key", work_current.getUser()
					.getIconPath());

			object.element("Author_relation_status", usr_relation_status);

			boolean isfavorite = false;
			if (usrworklist.contains(work_current)) {
				isfavorite = true;
			}

			object.element("Work_isfavorite", isfavorite);

			arrayres.add(object);

		}

		return arrayres;
	}

	// public String findVideoURL(Long id) {
	// Video video = videoDao.find(id);
	// if (video == null)
	// return "1";
	// Auth auth = Auth.create(this.ACCESS_KEY, this.SECRET_KEY);
	// // String token = auth.uploadToken("demomy");
	// String url = domain + video.getFileKey();
	// String urlSigned = auth.privateDownloadUrl(url);
	// return urlSigned;
	// }

	public JSONArray getAllTagsService() {
		JSONArray tagsArray = new JSONArray();
		List<Tag> tagList = tagDao.findAllTags();
		for (int i = 0; i < tagList.size(); i++) {
			JSONObject tagObject = new JSONObject();
			tagObject.put("tagid", tagList.get(i).getID());
			tagObject.put("content", tagList.get(i).getContent());
			tagsArray.add(tagObject);
		}
		return tagsArray;
	}
	
	public void updateCurrentWorkPlayCount(Long currentWorkid, Integer playCount){
		Work currentWork = workDao.find(currentWorkid);
		currentWork.setPlayCount(currentWork.getPlayCount()+playCount);
		workDao.merge(currentWork);
	}
	
	public String getNextWorkPlayCount(Long nextWorkid){
		
		return String.valueOf(workDao.find(nextWorkid).getPlayCount());
	}
	
	@Override
	public void insertTags(Long wid, String[] tags){
		
		for(int i = 0; i < tags.length; i++){
			Map_TagWork tagWork = new Map_TagWork();
			tagWork.setWid(wid);
			tagWork.setTid(Long.valueOf(tags[i]));
			tagWorkDao.persist(tagWork);
		}
	}
}
