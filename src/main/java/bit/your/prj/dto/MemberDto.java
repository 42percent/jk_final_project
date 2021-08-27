package bit.your.prj.dto;

import java.io.Serializable;

public class MemberDto implements Serializable {
   
   private int seq;
   private String id;
   private String pwd;
   private String name;
   private String nickname;
   private String birth;
   private String gender;
   private String email;
   private String phone;
   private String address1;
   private String address2;
   private String address3;
   private String sns_Type;
   private String joindate;
   private int auth;
   
   public MemberDto() {
	
}

public MemberDto(int seq, String id, String pwd, String name, String nickname, String birth, String gender,
		String email, String phone, String address1, String address2, String address3, String sns_Type, String joindate,
		int auth) {
	super();
	this.seq = seq;
	this.id = id;
	this.pwd = pwd;
	this.name = name;
	this.nickname = nickname;
	this.birth = birth;
	this.gender = gender;
	this.email = email;
	this.phone = phone;
	this.address1 = address1;
	this.address2 = address2;
	this.address3 = address3;
	this.sns_Type = sns_Type;
	this.joindate = joindate;
	this.auth = auth;
}

public int getSeq() {
	return seq;
}

public void setSeq(int seq) {
	this.seq = seq;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getPwd() {
	return pwd;
}

public void setPwd(String pwd) {
	this.pwd = pwd;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getNickname() {
	return nickname;
}

public void setNickname(String nickname) {
	this.nickname = nickname;
}

public String getBirth() {
	return birth;
}

public void setBirth(String birth) {
	this.birth = birth;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getAddress1() {
	return address1;
}

public void setAddress1(String address1) {
	this.address1 = address1;
}

public String getAddress2() {
	return address2;
}

public void setAddress2(String address2) {
	this.address2 = address2;
}

public String getAddress3() {
	return address3;
}

public void setAddress3(String address3) {
	this.address3 = address3;
}

public String getSns_Type() {
	return sns_Type;
}

public void setSns_Type(String sns_Type) {
	this.sns_Type = sns_Type;
}

public String getJoindate() {
	return joindate;
}

public void setJoindate(String joindate) {
	this.joindate = joindate;
}

public int getAuth() {
	return auth;
}

public void setAuth(int auth) {
	this.auth = auth;
}

@Override
public String toString() {
	return "MemberDto [seq=" + seq + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", nickname=" + nickname
			+ ", birth=" + birth + ", gender=" + gender + ", email=" + email + ", phone=" + phone + ", address1="
			+ address1 + ", address2=" + address2 + ", address3=" + address3 + ", sns_Type=" + sns_Type + ", joindate="
			+ joindate + ", auth=" + auth + "]";
}

   
}