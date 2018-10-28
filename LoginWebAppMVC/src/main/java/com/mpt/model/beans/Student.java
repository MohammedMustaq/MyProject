package com.mpt.model.beans;

public class Student {

int sid;
String name;
String password;
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "Student [sid=" + sid + ", name=" + name + ", password=" + password + "]";
}
}