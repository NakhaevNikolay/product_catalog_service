package org.main;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
	private String nickName;
	private String password;

	public User(String nickName, String password) {
		this.nickName = nickName;
		this.password = password;
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

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return Objects.equals(nickName, user.nickName) && Objects.equals(password, user.password);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nickName, password);
	}
}
