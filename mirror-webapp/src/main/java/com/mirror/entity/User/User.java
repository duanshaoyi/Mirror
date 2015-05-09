package com.mirror.entity.User;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.mirror.entity.BaseEntity;


@Entity
@Table(name = "user")
public class User extends BaseEntity{
	
	/**
	 * 用户实体类
	 */
	private static final long serialVersionUID = 1645625857955422208L;
	
	@Column(name = "nickname")
	private String userName;

	@Column(name = "password")
	private String password;
	
	@Column(name="Email")
	private String Email;

	@Column(name="locationId")
	private Long locationId;

	//位置名称
	@Column(name="locationName")
	private String locationName;

	//头像路径
	@Column(name="avatar")
	private String icon;
	
	//个人描述
	@Column(name="personalDesc")
	private String desc;

	@Column(name="signupDate",insertable = true)
	@Temporal(TemporalType.DATE)
	private Date signupDate;

	@Column(name="isSignin", nullable=true)
	private Integer Issignin;

	public String getPlaceHolder1() {
		return placeHolder1;
	}

	public void setPlaceHolder1(String placeHolder1) {
		this.placeHolder1 = placeHolder1;
	}

	public String getPlaceHolder2() {
		return placeHolder2;
	}

	public void setPlaceHolder2(String placeHolder2) {
		this.placeHolder2 = placeHolder2;
	}

	public String getPlaceHolder3() {
		return placeHolder3;
	}

	public void setPlaceHolder3(String placeHolder3) {
		this.placeHolder3 = placeHolder3;
	}

	@Column(name="doubanId")
	private long doubanId; 

	@Column(name="doubanName")
	private String doubanName;

	@Column(name="weiboId")
	private long WeiboId; 

	@Column(name="weiboName")
	private String weiboName;

	//人群分类
	@Column(name="crowdType")
	private int crowdType;
	
	@Column(name="placeHolder1")
	private String placeHolder1;

	@Column(name="placeHolder2")
	private String placeHolder2;

	
	@Column(name="placeHolder3")
	private String placeHolder3;

	
	public User(){
		
	}

	public User(String userName, String password, String email,
			long locationId, String locationName, String icon, String desc,
			Date signupDate, int issignin, long doubanId,
			String doubanName, long weiboId, String weiboName, int crowdType) {
		super();
		this.userName = userName;
		this.password = password;
		Email = email;
		this.locationId = locationId;
		this.locationName = locationName;
		this.icon = icon;
		this.desc = desc;
		this.signupDate = signupDate;
		Issignin = issignin;
		this.doubanId = doubanId;
		this.doubanName = doubanName;
		WeiboId = weiboId;
		this.weiboName = weiboName;
		this.crowdType = crowdType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public long getLocationId() {
		return locationId;
	}

	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getSignupDate() {
		return signupDate;
	}

	public void setSignupDate(Date signupDate) {
		this.signupDate = signupDate;
	}

	public int isIssignin() {
		return Issignin;
	}

	public void setIssignin(int issignin) {
		Issignin = issignin;
	}

	public long getDoubanId() {
		return doubanId;
	}

	public void setDoubanId(long doubanId) {
		this.doubanId = doubanId;
	}

	public String getDoubanName() {
		return doubanName;
	}

	public void setDoubanName(String doubanName) {
		this.doubanName = doubanName;
	}

	public long getWeiboId() {
		return WeiboId;
	}

	public void setWeiboId(long weiboId) {
		WeiboId = weiboId;
	}

	public String getWeiboName() {
		return weiboName;
	}

	public void setWeiboName(String weiboName) {
		this.weiboName = weiboName;
	}

	public int getCrowdType() {
		return crowdType;
	}

	public void setCrowdType(int crowdType) {
		this.crowdType = crowdType;
	}

}
