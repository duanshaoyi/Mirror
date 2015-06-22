/**
 * 
 */
package com.mirror.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mirror.API_interface.Qiniu.Qiniu_Uploader;
import com.mirror.entity.Resource.Audio;
import com.mirror.entity.Resource.Image;
import com.mirror.entity.Resource.Video;
import com.mirror.entity.Resource.Work;
import com.mirror.service.StreamService;
import com.mirror.util.StringUtil;

/**
 * Controller for Resource operations
 * 
 * @author ShaoyiDuan
 */
@RestController
@RequestMapping("/stream")
public class ResourceController {

	@Resource(name = "StreamServiceImpl")
	private StreamService streamservice;

	public StreamService getStreamservice() {
		return streamservice;
	}

	public void setStreamservice(StreamService streamservice) {
		this.streamservice = streamservice;
	}

	@RequestMapping(value = { "/upload" }, method = { RequestMethod.POST })
	@ResponseBody
	public JSONObject work_upload(HttpServletRequest request,
			@RequestParam("file") MultipartFile file) {

		int is_success = 0;

		try {

			// 解析JSON数据
//			String fileJson_utf8 = java.net.URLDecoder
//					.decode(fileJson, "UTF-8");
//			JSONObject object = JSONObject.fromObject(fileJson_utf8);

			String publishTime = String.valueOf(new Date().getTime());
			// 上传数据
			if (!file.isEmpty()) {// 判断是否为空

				byte[] bytes = file.getBytes();

				Qiniu_Uploader qt = new Qiniu_Uploader();

				String key = request.getParameter("Work_videokey");
				String authorid = request.getParameter("authorid");
				String fileKey = authorid + "/" + publishTime + "/" + key;
//				String key = fileJson;

				// 文件上传Qiniu uploader token
				int upload_is_succ = qt.upload(bytes, fileKey);

				if (upload_is_succ == 0) {//上传失败
					return StringUtil.getResponseJSON(1, null, null);
				}

			} else {
				// 上传失败
				return StringUtil.getResponseJSON(1, null, null);
			}

			// parse work related info
			Long author_id = Long.parseLong(request.getParameter("ID_Authorid"));

			String work_title = request.getParameter("Work_title");
			String work_privacy = request.getParameter("Work_privacy");
			String work_desc = request.getParameter("Work_desc");
			String work_video_key = request.getParameter("Work_videokey");
			String work_audio_key = request.getParameter("Work_audiokey");
			String work_snapshot_key = request.getParameter("Work_snapshotkey");
			String work_geolocation = request.getParameter("Work_geolocation");
			String work_timestamp = publishTime;

			// generate work
			Work w = new Work(work_title, work_desc,
					Timestamp.valueOf(work_timestamp), work_privacy, 1,
					work_geolocation);

			// generate relevant image/audio/video entity
			Video video = null;
			Audio audio = null;
			Image snapshot = null;
			if (!work_video_key.isEmpty()) {
				video = new Video(work_video_key, w.ID, author_id,
						Timestamp.valueOf(work_timestamp), 1);
				w.setVideo(video);
			}

			if (!work_audio_key.isEmpty()) {
				audio = new Audio(work_audio_key, w.ID, author_id,
						Timestamp.valueOf(work_timestamp), 1);
				w.setAudio(audio);
			}

			if (!work_audio_key.isEmpty()) {
				snapshot = new Image(work_snapshot_key, w.ID, author_id,
						Timestamp.valueOf(work_timestamp), 1);
				w.setSnapshot(snapshot);
			}

			is_success = streamservice.work_upload(w, author_id);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return StringUtil.getResponseJSON(1, null, null);
		}

		return StringUtil.getResponseJSON(is_success, null, null);
	}

	@RequestMapping(value = { "/user_timeline" }, method = { RequestMethod.POST }, produces = { "application/json" })
	@ResponseBody
	public JSONObject user_timeline(HttpServletRequest request) {
		JSONArray Results_Json = new JSONArray();

		try {

			String uid_str = request.getParameter("userid");
			String authorid_str = request.getParameter("authorid");
			String page_str = request.getParameter("pageno");

			Long authorid = Long.parseLong(authorid_str);
			Long uid = Long.parseLong(uid_str);
			int pageNo = Integer.parseInt(page_str);

			// List<timeline_work> tw= new List<timeline_work>()
			Results_Json = streamservice.get_usertimeline(uid, authorid, pageNo);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return StringUtil.getResponseJSON(0, null, Results_Json);
	}

	@RequestMapping(value = { "/recommd_timeline" }, method = { RequestMethod.POST }, produces = { "application/json" })
	@ResponseBody
	public JSONObject recommd_timeline(HttpServletRequest request) {
		JSONArray Results_Json = new JSONArray();
		
		try {

			String uid_str = request.getParameter("userid");
			String page_str = request.getParameter("pageno");

			Long uid = Long.parseLong(uid_str);
			int pageNo = Integer.parseInt(page_str);

			Results_Json = streamservice.get_recomandtimeline(uid, pageNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return StringUtil.getResponseJSON(0,null,Results_Json);
	}
	
//	@RequestMapping(value = { "/playVideo" }, method = { RequestMethod.GET }, produces = { "application/json" })
//	@ResponseBody
//	public String playVideo(HttpServletRequest request,@RequestParam("videoID") String videoID) {
//
//		Long video = Long.valueOf(request.getParameter("videoID"));
//		String v = request.getParameter("videoID");
//
//		return StringUtil.findVideoURL(video);
//	}

}
