package com.mirror.serviceImpl;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.mirror.Dao.UserDao;
import com.mirror.Dao.UserWorkRelationDao;
import com.mirror.Dao.UserUserRelationDao;
import com.mirror.Dao.VideoDao;
import com.mirror.Dao.WorkDao;
import com.mirror.entity.Relation.UserUser;
import com.mirror.entity.Relation.UserWork;
import com.mirror.entity.Resource.Video;
import com.mirror.entity.Resource.Work;
import com.mirror.entity.User.User;
import com.mirror.service.StreamService;
import com.qiniu.util.Auth;

@Service("StreamServiceImpl")
public class StreamServiceImpl extends BaseServiceImpl<Work, Long> implements
		StreamService {

	// DAO������ע��
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
	
	//��ţ����
	@Value("${qiniu.domain}")
	private String domain;
	
	private String ACCESS_KEY = "2RI_6FfJDyrXak6Z1LLR1uqIIarS3JEBRdvHVlNP";
	/**
	 * ����һ���ض����ߵĸ�����Ʒ���Է�ҳ��ʽ������Ʒ�б�ÿҳ��Ʒ��������Ʒ
	 * ������uid	 @param uid
	 * ����uid	 @param authorid
	 * ҳ����  		 @param pageNo
	 * @return ��Ʒ��Ϣ��
	 */
	public String get_usertimeline(Long uid, Long authorid, int pageNo) {
		String JSON = null;
		List<Work> worklist = null;
		List<UserUser> usrusrllist = null;
		List<UserWork> usrworkllist = null;

		// ����authorid ��������ʵ�壬���ڲ�ѯ
		User author = new User();
		author.setID(authorid);
		author.setEmail("email");

		// ������ߵ���Ʒ�����Է�ҳ��ʽ����
		worklist = workDao.findPageByUser(author, pageNo, 5);// ����ȫ�ֱ���

		// ��ȡ�������뵱ǰ���߹�ϵ���Ƿ��ע��
		int usr_relation_status = useruserRelationDao.findstatusByuids(uid,authorid);

		// ��ȡ����������Ʒ���ϵ���Ƿ��ղأ�
		usrworkllist = userworkRelationDao.findFavoriteWorksbyUid(uid);

		// ����JSON
		JSON = genJSON_forWorkList(worklist, usr_relation_status, usrworkllist);

		return JSON;
	}
	
//	public String get_recomandtimeline(Long uid, int pageNo) {
//		String JSON = null;
//		List<Work> worklist = null;
//		List<UserUser> usrusrllist = null;
//		List<UserWork> usrworkllist = null;
//
//		// ����authorid ��������ʵ�壬���ڲ�ѯ
//		User author = new User();
//		author.setID(authorid);
//		author.setEmail("email");
//
//		// ������ߵ���Ʒ�����Է�ҳ��ʽ����
//		worklist = workDao.findPageByUser(author, pageNo, 5);// ����ȫ�ֱ���
//
//		// ��ȡ�������뵱ǰ���߹�ϵ���Ƿ��ע��
////		int usr_relation_status = usrusrRelationDao.findstatusByuids(uid,authorid);
//
//		// ��ȡ����������Ʒ���ϵ���Ƿ��ղأ�
//		usrworkllist = userworkRelationDao.findFavoriteWorksbyUid(uid);
//
//		// ����JSON
////		JSON = genJSON_forWorkList(worklist, usr_relation_status, usrworkllist);
//
//		return JSON;
//	}

	public String work_upload(Work w, Long authorid) {
		String Res = null;

		// ��������
		User author = userDao.find(authorid);
		w.setUser(author);

		workDao.persist(w);
		return Res;
	}

	/**
	 * <b>function:</b>ת��Java List���ϵ�JSON
	 * 
	 * @author
	 * @createDate
	 */
	public String genJSON_forWorkList(List<Work> worklist,
			int usr_relation_status, List<UserWork> usrworklist) {

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
			object.element("Work_videokey", work_current.getVideo()
					.getFileKey());
			object.element("Work_audiokey", work_current.getAudio()
					.getFileKey());
			object.element("Work_snapshotkey", work_current.getSnapshot()
					.getFileKey());
			object.element("Work_geolocation", work_current.getGeolocation());
			object.element("Work_publishtime", work_current.getUploadTime());

			object.element("Work_author_id", work_current.getUser().getID());
			object.element("Work_author_nickname", work_current.getUser()
					.getNickName());
			object.element("Work_author_avatar_key", work_current.getUser()
					.getIconPath());

			// �����������߼�Ĺ�ϵ
			object.element("Author_relation_status", usr_relation_status);

			// �Ƿ��ղص�ǰ��Ʒ
			boolean isfavorite = false;
			if (usrworklist.contains(work_current)) {
				isfavorite = true;
			}

			object.element("Work_isfavorite", isfavorite);

			arrayres.add(object);

		}

		JSONres = arrayres.toString();

		return JSONres;
	}
	
	public String findVideoURL(Long id){
		Video video = videoDao.find(id);
		if(video == null)
			return "1";
		String ACCESS_KEY = "2RI_6FfJDyrXak6Z1LLR1uqIIarS3JEBRdvHVlNP";
		String SECRET_KEY = "igdpaFrIWjkmBAfUGlxLMEfJLSGwLPe4Jj_LDmMR";
		Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
		String token = auth.uploadToken("demomy");
		String url = domain+video.getFileKey()+"?"+"token="+token;
		return url;
	}
}
