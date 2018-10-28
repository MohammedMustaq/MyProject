package com.mpt.model.beans;

public class UserAuth {
int attempts;
boolean lock;
long locktime;

public int getAttempts() {
	return attempts;
}
public void setAttempts(int attempts) {
	this.attempts = attempts;
}
public boolean isLock() {
	return lock;
}
public void setLock(boolean lock) {
	this.lock = lock;
}
public long getLocktime() {
	return locktime;
}
public void setLocktime(long locktime) {
	this.locktime = locktime;
}
public void incCount(int attempts) {
	this.attempts=attempts+1;
}
public void time() 
{
	this.lock=false;
	this.attempts=0;
}

}