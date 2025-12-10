package modelo;

public class Usuario {
	private String nickname;
	private String password;
	private String email;
	private boolean esAdmin;

	public Usuario(String nickname, String password, String email, boolean esAdmin) {
		this.nickname = nickname;
		this.password = password;
		this.email = email;
		this.esAdmin = esAdmin;
	}

	public String getNickname() {
		return nickname;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public boolean isAdmin() {
		return esAdmin;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}