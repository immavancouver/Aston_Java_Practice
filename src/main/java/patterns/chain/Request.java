package patterns.chain;

public class Request {

	private final String username;
	private final String role;
	private final boolean hasToken;

	public Request(String username, String role, boolean hasToken) {
		this.username = username;
		this.role = role;
		this.hasToken = hasToken;
	}

	public String getUsername() {
		return username;
	}

	public String getRole() {
		return role;
	}

	public boolean hasToken() {
		return hasToken;
	}
}
