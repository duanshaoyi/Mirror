package com.mirror.entity.Resource;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Work extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7121573434953462455L;

	// //�ϴ��û�uid
	// @Column(name="uid")
	// private Long uid;

	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "uid")
	private User user;

	// ��Ʒ����
	@Column(name = "title")
	private String title;

	// ��Ʒ����
	@Column(name = "description")
	private String desciption;

	// ��Ʒ��ǩ
	@Column(name = "tags")
	private String tags;

	// ��Ʒ��Ƶʵ��
	@OneToOne(targetEntity = Video.class)
	@JoinColumn(name = "video_id", unique = true)
	private Video video;

	// ��Ʒ��Ƶʵ��
	@OneToOne(targetEntity = Audio.class)
	@JoinColumn(name = "audio_id", unique = true)
	private Audio audio;

	// ��Ʒ��Ƶʵ��
	@OneToOne(targetEntity = Image.class)
	@JoinColumn(name = "snapshot_id", unique = true)
	private Image snapshot;

	// �ϴ�ʱ��
	@Column(name = "uploadtime", insertable = true)
	private Timestamp uploadTime;

	// ��ƷȨ�� public/private/friend
	@Column(name = "privacy")
	private String privacy;

	// ��Ʒ�ܷ�����
	@Column(name = "canReply")
	private boolean canReply;

	// ��Ʒ״̬
	@Column(name = "status")
	private int status;

	@Column(name = "geolocation")
	private String geolocation;

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

	// Work������ж����� id���
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
