/**
 * 
 */
package com.mirror.controller;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mirror.Dao.WorkDao;
import com.mirror.entity.Resource.Audio;
import com.mirror.entity.Resource.Image;
import com.mirror.entity.Resource.Video;
import com.mirror.entity.Resource.Work;
import com.mirror.service.StreamService;

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

	@RequestMapping(value = { "/upload" }, method = { RequestMethod.POST }, produces = { "application/json" })
	@ResponseBody
	public int work_upload(HttpServletRequest request) {
		
		//String Results_Json = null;
		int is_success=0;
		
		// 请求字符串
		String rawquery_str = request.getQueryString();

		// 使用URLDecoder解码字符串
		try {
			
			String queryStr = java.net.URLDecoder.decode(rawquery_str, "UTF-8");
			JSONObject object = JSONObject.fromObject(queryStr);

			//parse request_str
			Long author_id = Long.parseLong(request.getParameter("ID_Authorid"));

			String work_title=request.getParameter("Work_title");
			String work_privacy=request.getParameter("Work_privacy");
			String work_desc=request.getParameter("Work_desc");
			String work_video_key=request.getParameter("Work_videokey");
			String work_audio_key=request.getParameter("Work_audiokey");
			String work_snapshot_key=request.getParameter("Work_snapshotkey");
			String work_geolocation = request.getParameter("Work_geolocation");			
			String work_timestamp= request.getParameter("Work_publishtime");
//					
//			String author_name = object.getString("Author_nickname");
//			String author_avatar_key = object.getString("Author_avatar_key");
//			String is_followed = object.getString("Author_isfollowed");
//			
//			String is_favorite = object.getString("Work_isfavorite");		
			
			//generate work
			Work w=new Work(work_title, work_desc, Timestamp.valueOf(work_timestamp), work_privacy, 1,work_geolocation);
			
			//generate relevant image/audio/video
			Video video=null;
			Audio audio=null;
			Image snapshot=null;
			if(!work_video_key.isEmpty()){
				video=new Video(work_video_key,w.ID, author_id, Timestamp.valueOf(work_timestamp),1);
				w.setVideo(video);
			}
			
			if(!work_audio_key.isEmpty()){
				audio=new Audio(work_audio_key,w.ID, author_id, Timestamp.valueOf(work_timestamp),1);
				w.setAudio(audio);
			}
			
			if(!work_audio_key.isEmpty()){
				snapshot=new Image(work_snapshot_key,w.ID, author_id, Timestamp.valueOf(work_timestamp),1);
				w.setSnapshot(snapshot);
			}
			
			streamservice.work_upload(w,author_id);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return is_success;
	}

	@RequestMapping(value = { "/user_timeline" }, method = { RequestMethod.GET }, produces = { "application/json" })
	@ResponseBody
	public String user_timeline(HttpServletRequest request) {
		// 信息流请求结果
		String Results_Json = null;

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

		return Results_Json;
	}

	@RequestMapping(value = { "/recommd_timeline" }, method = { RequestMethod.POST }, produces = { "application/json" })
	@ResponseBody
	public String recommd_timeline(HttpServletRequest request) {
		// 信息流请求结果
		String Results_Json = null;

		String parameter = request.getQueryString();
		JSONObject object = JSONObject.fromObject(parameter);
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");
		String email = request.getParameter("eamil");
		Long locationID = Long.valueOf(request.getParameter("locationID"));
		String locationName = request.getParameter("locationName");
		String iconName = request.getParameter("iconName");
		String iconPath = "";
		String personalDesc = request.getParameter("personalDesc");

		return Results_Json;
	}
	
	//获取视频作品播放地址
	@RequestMapping(value = { "/playVideo" }, method = { RequestMethod.POST }, produces = { "application/json" })
	@ResponseBody
	public String playVideo(HttpServletRequest request,@RequestParam("videoID") String videoID) {

		Long video = Long.valueOf(request.getParameter("videoID"));
		

		return streamservice.findVideoURL(video);
	}

}
