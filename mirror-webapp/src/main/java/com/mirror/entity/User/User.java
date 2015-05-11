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
	private String nickName;

	@Column(name = "password")
	private String password;
	
	@Column(name="email")
	private String email;

	@Column(name="location_ID")
	private long locationID;

	//位置名称
	@Column(name="location_name")
	private String locationName;

	//头像路径
	@Column(name="iconpath")
	private String iconPath;
	
	//个人描述
	@Column(name="personal_desc")
	private String personalDesc;

	@Column(name="signup_date",insertable = true)
	@Temporal(TemporalType.DATE)
	private Date signupDate;

	@Column(name="is_signin", nullable=true)
	private int isSignin;

	@Column(name="douban_ID")
	private long doubanID; 

	@Column(name="douban_name")
	private String doubanName;

	@Column(name="weibo_ID")
	private long weiboID; 

	@Column(name="weibo_name")
	private String weiboName;

	//人群分类
	@Column(name="crowd_type")
	private int crowdType;
	
	@Column(name="placeHolder1")
	private String placeHolder1;

	@Column(name="placeHolder2")
	private String placeHolder2;

	
	@Column(name="placeHolder3")
	private String placeHolder3;
	
	@Column(name = "IOSID")
	private String iosID;
	
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

	public String getIosID() {
		return iosID;
	}

	public void setIosID(String iosID) {
		this.iosID = iosID;
	}

	public User(){
		
	}

	public User(String nickName, String password, String email,
			long locationID, String locationName, String icon, String personalDesc,
			Date signupDate, int isSignin, long doubanID,
			String doubanName, long weiboID, String weiboName, int crowdType) {
		super();
		this.nickName = nickName;
		this.password = password;
		this.email = email;
		this.locationID = locationID;
		this.locationName = locationName;
		this.iconPath = icon;
		this.personalDesc = personalDesc;
		this.signupDate = signupDate;
		this.isSignin = isSignin;
		this.doubanID = doubanID;
		this.doubanName = doubanName;
		this.weiboID = weiboID;
		this.weiboName = weiboName;
		this.crowdType = crowdType;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getLocationID() {
		return locationID;
	}

	public void setLocationID(long locationID) {
		this.locationID = locationID;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getIconPath() {
		return iconPath;
	}

	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}

	public String getPersonalDesc() {
		return personalDesc;
	}

	public void setPersonalDesc(String personalDesc) {
		this.personalDesc = personalDesc;
	}

	public Date getSignupDate() {
		return signupDate;
	}

	public void setSignupDate(Date signupDate) {
		this.signupDate = signupDate;
	}

	public int getIsSignin() {
		return isSignin;
	}

	public void setIsSignin(int isSignin) {
		this.isSignin = isSignin;
	}

	public long getDoubanID() {
		return doubanID;
	}

	public void setDoubanID(long doubanID) {
		this.doubanID = doubanID;
	}

	public String getDoubanName() {
		return doubanName;
	}

	public void setDoubanName(String doubanName) {
		this.doubanName = doubanName;
	}

	public long getWeiboID() {
		return weiboID;
	}

	public void setWeiboID(long weiboID) {
		this.weiboID = weiboID;
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
