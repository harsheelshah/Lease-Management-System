package lease_management_system;

import java.util.Date;

import javax.print.attribute.DateTimeSyntax;

import com.sun.org.apache.xerces.internal.impl.dv.xs.DateTimeDV;

public class UserDetails {

	private String Username;
	private String EmailID;
	private String Password;
	private String ConfirmPassword;
	private String ContactNumber;
	private String NoofPeople;
	private String Occupation;
	private String Type;
	private String Preferences;
	private String NeedfromDate;
	private boolean request;

	public UserDetails() {

	}

	public UserDetails(String username, String emailID, String password,
			String confirmPassword, String contactNumber, String noofPeople,
			String occupation, String type, String preferences,
			String needfromDate) {
		super();
		Username = username;
		EmailID = emailID;
		Password = password;
		ConfirmPassword = confirmPassword;
		ContactNumber = contactNumber;
		NoofPeople = noofPeople;
		Occupation = occupation;
		Type = type;
		Preferences = preferences;
		NeedfromDate = needfromDate;
	}

	public UserDetails(String username, String password, String emailID) {
		super();
		Username = username;
		Password = password;
		EmailID = emailID;

	}

	public String getConfirmPassword() {
		return ConfirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.ConfirmPassword = confirmPassword;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		this.Username = username;
	}

	public String getEmailID() {
		return EmailID;
	}

	public void setEmailID(String emailID) {
		this.EmailID = emailID;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}

	public String getContactNumber() {
		return ContactNumber;
	}

	public void setContactNumber(String contactNumber) {
		ContactNumber = contactNumber;
	}

	public String getNoofPeople() {
		return NoofPeople;
	}

	public void setNoofPeople(String noofPeople) {
		NoofPeople = noofPeople;
	}

	public String getOccupation() {
		return Occupation;
	}

	public void setOccupation(String occupation) {
		Occupation = occupation;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getPreferences() {
		return Preferences;
	}

	public void setPreferences(String preferences) {
		Preferences = preferences;
	}

	public String getNeedfromDate() {
		return NeedfromDate;
	}

	public void setNeedfromDate(String needfromDate) {
		NeedfromDate = needfromDate;
	}

	public boolean isRequest() {
		return request;
	}

	public void setRequest(boolean request) {
		this.request = request;
	}

}