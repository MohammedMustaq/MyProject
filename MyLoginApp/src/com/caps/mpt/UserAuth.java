package com.caps.mpt;

import java.util.Date;

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

}