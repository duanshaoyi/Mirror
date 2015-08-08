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
	public JSONObject work_upload(HttpServletRequest request ,  @RequestParam("file") MultipartFile file) {
		int is_success = 0;

		try {

//			String fileJson_utf8 = java.net.URLDecoder
//					.decode(fileJson, "UTF-8");
//			JSONObject object = JSONObject.fromObject(fileJson_utf8);

			Timestamp publishTime = new Timestamp(new Date().getTime());
			String key = request.getParameter("Work_videokey");
			String authorid = request.getParameter("authorid");
			String fileKey = authorid + "/" + String.valueOf(publishTime.getTime()) + "/" + key;
			if (!file.isEmpty()) {

				byte[] bytes = file.getBytes();

				Qiniu_Uploader qt = new Qiniu_Uploader();
		
//				String key = fileJson;

				// Qiniu uploader token
				int upload_is_succ = qt.upload(bytes, fileKey);

				if (upload_is_succ == 0) {
					return StringUtil.getResponseJSON(1, null, null);
				}

			} else {
				return StringUtil.getResponseJSON(1, null, null);
			}

			// parse work related info
			Long author_id = Long.parseLong(authorid);

			String work_title = request.getParameter("Work_title");
			String work_privacy = request.getParameter("Work_privacy");
			String work_desc = request.getParameter("Work_desc");
			String work_video_key = fileKey;
			String work_audio_key = request.getParameter("Work_audiokey");
			String work_snapshot_key = request.getParameter("Work_snapshotkey");
			String work_geolocation = request.getParameter("Work_geolocation");

			// generate work
			Work w = new Work(work_title, work_desc,
					publishTime, work_privacy, 1,
					work_geolocation);

			// generate relevant image/audio/video entity
			Video video = null;
			Audio audio = null;
			Image snapshot = null;
			if (null != work_video_key && !work_video_key.isEmpty()) {
				video = new Video(work_video_key, w.ID, author_id,
						publishTime, 1);
				w.setVideo(video);
			}

			if (null != work_audio_key && !work_audio_key.isEmpty()) {
				audio = new Audio(work_audio_key, w.ID, author_id,
						publishTime, 1);
				w.setAudio(audio);
			}

			if (null != work_snapshot_key && !work_snapshot_key.isEmpty()) {
				snapshot = new Image(work_snapshot_key, w.ID, author_id,
						publishTime, 1);
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

	//Get 3 works based on authorid, userid
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
	
	// Get all works based on authorid, userid
	@RequestMapping(value = { "/user_allTimeline" }, method = { RequestMethod.POST }, produces = { "application/json" })
	@ResponseBody
	public JSONObject user_allTimeline(HttpServletRequest request) {
		JSONArray Results_Json = new JSONArray();

		try {

			String uid_str = request.getParameter("userid");
			String authorid_str = request.getParameter("authorid");

			Long authorid = Long.parseLong(authorid_str);
			Long uid = Long.parseLong(uid_str);

			Results_Json = streamservice.getAllWorksByAuthor(uid, authorid);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return StringUtil.getResponseJSON(0, null, Results_Json);
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

	@RequestMapping(value = { "/getTags" }, produces = { "application/json" })
	@ResponseBody
	public JSONObject getTags() {
		return StringUtil.getResponseJSON(0, null, this.streamservice.getAllTagsService());
	}
	
	//Update play count of current work and get next work play count
	@RequestMapping(value = { "/getPlayCount" }, method = { RequestMethod.POST }, produces = { "application/json" })
	@ResponseBody
	public JSONObject getPlayCount(HttpServletRequest request) {
		JSONObject nextWorkPlayCount = new JSONObject();
		try {

			Long currentWorkid = Long.valueOf(request.getParameter("currentWorkid"));
			Integer playCount = Integer.valueOf(request.getParameter("playCount"));
			Long nextWorkid = Long.valueOf(request.getParameter("nextWorkid"));
			streamservice.updateCurrentWorkPlayCount(currentWorkid, playCount);
			nextWorkPlayCount.put("nextWorkPlayCount", streamservice.getNextWorkPlayCount(nextWorkid));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return StringUtil.getResponseJSONObject(0, null, nextWorkPlayCount);
	}
	
	//用户打标签
		@RequestMapping(value = { "/tags" }, method = { RequestMethod.POST }, produces = { "application/json" })
		@ResponseBody
		public JSONObject tags(HttpServletRequest request){
			Long wid = Long.valueOf(request.getParameter("workid"));
			String[] tags = request.getParameter("tags").split("_");		
			streamservice.insertTags(wid, tags);
			return StringUtil.getResponseJSON(0, null, null);
		}
}
