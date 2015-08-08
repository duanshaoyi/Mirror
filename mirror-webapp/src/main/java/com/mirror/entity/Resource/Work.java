package com.mirror.entity.Resource;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.mirror.entity.BaseEntity;
import com.mirror.entity.User.User;

@Entity
@Table(name = "resource_work")
public class Work extends BaseEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7121573434953462455L;

	//作者id
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "uid")
	private User user;

	//作品标题
	@Column(name = "title")
	private String title;

	//作品描述
	@Column(name = "description")
	private String desciption;

	//作品标签
	@Column(name = "tags")
	private String tags;

	//视频
	@OneToOne(targetEntity = Video.class, cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name = "video_id", unique = true, nullable=true)
	private Video video;

	@OneToOne(targetEntity = Audio.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name = "audio_id", unique = true, nullable=true)
	private Audio audio;

	@OneToOne(targetEntity = Image.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name = "snapshot_id", unique = true, nullable=true)
	private Image snapshot;

	//上传时间
	@Column(name = "uploadtime", insertable = true)
	private Timestamp uploadTime;

	// public/private/friend
	@Column(name = "privacy")
	private String privacy;

	//
	@Column(name = "canReply")
	private boolean canReply = true;

	//
	@Column(name = "status")
	private int status = 1;

	//作品录制坐标
	@Column(name = "geolocation")
	private String geolocation;

	//作品播放次数
	@Column(name = "play_count")
	private Long playCount = 0L;
	
	@Column(name = "placeHolder2")
	private String placeHolder2;

	@Column(name = "placeHolder3")
	private String placeHolder3;

	public Work() {

	}

	public Work(String title, String desciption, Timestamp uploadTime,
			String privacy, int status, String geolocation) {
		super();
		this.title = title;
		this.desciption = desciption;
		this.uploadTime = uploadTime;
		this.privacy = privacy;
		// this.canReply = canReply;
		this.status = status;
		this.geolocation = geolocation;
	}

	public Work(String title, String desciption, String tags, Video video,
			Audio audio, Image snapshot, Timestamp uploadTime, String privacy,
			int status, String geolocation) {
		super();
		this.title = title;
		this.desciption = desciption;
		this.tags = tags;
		this.video = video;
		this.audio = audio;
		this.snapshot = snapshot;
		this.uploadTime = uploadTime;
		this.privacy = privacy;
		// this.canReply = canReply;
		this.status = status;
		this.geolocation = geolocation;
	}

	public Work(User user, String title, String desciption, String tags,
			Video video, Audio audio, Image snapshot, Timestamp uploadTime,
			String privacy, int status, String geolocation) {
		super();
		this.user = user;
		this.title = title;
		this.desciption = desciption;
		this.tags = tags;
		this.video = video;
		this.audio = audio;
		this.snapshot = snapshot;
		this.uploadTime = uploadTime;
		this.privacy = privacy;
		// this.canReply = canReply;
		this.status = status;
		this.geolocation = geolocation;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public Audio getAudio() {
		return audio;
	}

	public void setAudio(Audio audio) {
		this.audio = audio;
	}

	public Image getSnapshot() {
		return snapshot;
	}

	public void setSnapshot(Image snapshot) {
		this.snapshot = snapshot;
	}

	public Timestamp getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Timestamp uploadTime) {
		this.uploadTime = uploadTime;
	}

	public String getPrivacy() {
		return privacy;
	}

	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}

	public boolean isCanReply() {
		return canReply;
	}

	public void setCanReply(boolean canReply) {
		this.canReply = canReply;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getGeolocation() {
		return geolocation;
	}

	public void setGeolocation(String geolocation) {
		this.geolocation = geolocation;
	}
	
	public Long getPlayCount() {
		return playCount;
	}

	public void setPlayCount(Long playCount) {
		this.playCount = playCount;
	}

	// Work
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Work other = (Work) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		return true;
	}
}
