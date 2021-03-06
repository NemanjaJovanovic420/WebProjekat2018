package model;

public class User {
	
	protected String username;
	protected String password;
	protected String email;
	protected String firstName;
	protected String lastName;
	protected String profilePicture;
	protected UserType userType;
	protected String phoneNumber;
	protected String territoryId;
	
	public User() {
		super();
	}

	public User(String username, String password, String email, String firstName, String lastName,
			String profilePicture, UserType userType, String phoneNumber, String territoryId) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.profilePicture = profilePicture;
		this.userType = userType;
		this.phoneNumber = phoneNumber;
		this.territoryId = territoryId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	

	public String getTerritoryId() {
		return territoryId;
	}

	public void setTerritoryId(String territoryId) {
		this.territoryId = territoryId;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", email=" + email + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", profilePicture=" + profilePicture + ", userType=" + userType
				+ ", phoneNumber=" + phoneNumber + ", territory=" + territoryId + "]";
	}
	
}

