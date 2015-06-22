package com.mirror.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.mirror.Dao.TagDao;
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
import com.mirror.service.StreamService;
import com.mirror.util.StringUtil;

@Service("StreamServiceImpl")
public class StreamServiceImpl extends BaseServiceImpl<Work, Long> implements
		StreamService {

	// DAO层依赖注入
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

	private final static int PageSize = 3;

	/**
	 * 请求一个特定作者的个人作品，以分页形式返回作品列表，每页作品最多五个作品 请求者uid @param uid 作者uid @param
	 * authorid 页序数 @param pageNo
	 * 
	 * @return 作品信息，
	 */
	public JSONArray get_usertimeline(Long uid, Long authorid, int pageNo) {
		JSONArray JSON = new JSONArray();
		List<Work> worklist = null;
		List<UserUser> usrusrllist = null;
		List<UserWork> usrworkllist = null;

		// 根据authorid 生成作者实体，用于查询
		User author = new User();
		author.setID(authorid);
		// author.setEmail("email");

		// 获得作者的作品集，以分页形式返回
		worklist = workDao.findPageByUser(author, pageNo, PageSize);// 定义全局变量

		// 获取请求者与当前作者关系(是否关注)
		int usr_relation_status = useruserRelationDao.findstatusByuids(uid,
				authorid);

		// 获取请求者与作品间关系（是否收藏）
		usrworkllist = userworkRelationDao.findFavoriteWorksbyUid(uid);

		// 生成JSON
		JSON = genJSON_forWorkList(worklist, usr_relation_status, usrworkllist);

		return JSON;
	}

	public JSONArray get_recomandtimeline(Long uid, int pageNo) {
		List<Map_TagUser> mtulist = null;
		List<Map_TagWork> mtwlist = null;
		List<Work> worklist = null;

		// 获得作者所对应的标签集合
		mtulist = tagDao.findtagsbyUser(uid);
		// 生成标签id集合
		// if num of results equals 0 then return
//		if (mtulist.size() == 0) {
//			return null;
//		}

		List<Long> tagids = new ArrayList<Long>();
		// String tagids="(0";

		Iterator<Map_TagUser> mtu_it = mtulist.iterator();

		while (mtu_it.hasNext()) {
			tagids.add(mtu_it.next().getTid());
		}

		// 获取一组tag所对应的作品集合
		mtwlist = tagDao.findWorkstagsbyTagids(tagids);
		// 生成work id集合
		List<Long> workids = new ArrayList<Long>();

		// if num of results equals 0 then return
//		if (workids.size() == 0) {
//			return null;
//		}

		Iterator<Map_TagWork> mtw_it = mtwlist.iterator();
		while (mtw_it.hasNext()) {
			workids.add(mtw_it.next().getWid());
		}

		double RecomandworksSize = workDao.getRecomandStreamSize(workids);

		double TotalRecomandPageSize = Math.ceil(RecomandworksSize / PageSize);

		double offset = RecomandworksSize % PageSize;

		if (pageNo <= TotalRecomandPageSize) {// 获取推荐信息流

			// 获取所推荐的worklist
			worklist = workDao.findByIDs(workids, pageNo, PageSize);

			// if num of results equals 0 then return 3 random works
			if (0 < worklist.size() && worklist.size() < PageSize) {
				int limit = (int) (PageSize - offset);

				List<Work> supplement= workDao.findTopNByExcludeIDs(workids,limit);
				
				worklist.addAll(supplement);
//				return null;
			}
		} else {// 获取默认信息流
			
			int pageNoDefault=(int) (pageNo-TotalRecomandPageSize);
			
			worklist= workDao.findBySpecifyIndex(workids, (int)offset, pageNoDefault, PageSize);

		}

		// 生成JSON
		return genJSON_forWorkList(worklist);
	}

	public int work_upload(Work w, Long authorid) {
		int Res = 1;

		// 设置作者
		User author = userDao.find(authorid);
		w.setUser(author);

		workDao.persist(w);

		// return the entity itself rather than its ID
		// When the transaction ends, the flush will happen, and ID will be
		// generated

		// 插入成功
		if (w.ID > 0) {
			Res = 0;
		}

		return Res;
	}

	/**
	 * <b>function:</b>转换Java List集合到JSON 并附带好友及收藏关系
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

			object.element("Work_title", work_current.getTitle());
			object.element("Work_privacy", work_current.getPrivacy());
			object.element("Work_desc", work_current.getDesciption());
			object.element("Work_videokey", StringUtil.findDownloadURL(work_current.getVideo()
					.getFileKey()));

			// 应需求 取消音频与图片成员
			// object.element("Work_audiokey",
			// work_current.getAudio().getFileKey());
			// object.element("Work_snapshotkey",
			// work_current.getSnapshot().getFileKey());

			object.element("Work_geolocation", work_current.getGeolocation());
			object.element("Work_publishtime", work_current.getUploadTime());

			object.element("Work_author_id", work_current.getUser().getID());
			object.element("Work_author_nickname", work_current.getUser()
					.getNickName());
			object.element("Work_author_avatar_key", StringUtil.findDownloadURL(work_current.getUser()
					.getIconPath()));

			arrayres.add(object);
		}

		JSONres = arrayres.toString();

		return arrayres;
	}

	/**
	 * <b>function:</b>转换Java List集合到JSON
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

			object.element("Work_title", work_current.getTitle());
			object.element("Work_privacy", work_current.getPrivacy());
			object.element("Work_desc", work_current.getDesciption());
			object.element("Work_videokey", StringUtil.findDownloadURL(work_current.getVideo()
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

			// 请求者与作者间的关系
			object.element("Author_relation_status", usr_relation_status);

			// 是否收藏当前作品
			boolean isfavorite = false;
			if (usrworklist.contains(work_current)) {
				isfavorite = true;
			}

			object.element("Work_isfavorite", isfavorite);

			arrayres.add(object);

		}

		return arrayres;
	}

//	public String findVideoURL(Long id) {
//		Video video = videoDao.find(id);
//		if (video == null)
//			return "1";
//		Auth auth = Auth.create(this.ACCESS_KEY, this.SECRET_KEY);
//		// String token = auth.uploadToken("demomy");
//		String url = domain + video.getFileKey();
//		String urlSigned = auth.privateDownloadUrl(url);
//		return urlSigned;
//	}
	
	
}
