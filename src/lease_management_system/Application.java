package lease_management_system;

public class Application {
	static int counter = 0;
	public Integer ApplicationNo;
	public String Username;
	public String Status;
	public String RescheduledDate;
	public String RuledOutDate;
	public String RentedOut;
	public String ApartmentNo;
	public String Rent;
	public String RentPaid;
	public String Month;
	public String Year;

	public Application() {
		this.ApplicationNo = ++counter;

	}

	public Application(Integer applicationNo, String username, String status,
			String rescheduledDate, String ruledOutDate, String rentedOut,
			String apartmentNo) {
		super();
		ApplicationNo = applicationNo;
		Username = username;
		Status = status;
		RescheduledDate = rescheduledDate;
		RuledOutDate = ruledOutDate;
		RentedOut = rentedOut;
		ApartmentNo = apartmentNo;
	}

	public Application(String username, String rent, String apartmentNo) {
		super();

		Username = username;
		Rent = rent;
		ApartmentNo = apartmentNo;
	}

	public Application(String username, String apartmentNo, String rent,
			String rentPaid, String month, String year) {
		super();
		Username = username;
		ApartmentNo = apartmentNo;
		Rent = rent;
		RentPaid = rentPaid;
		Month = month;
		Year = year;
	}

	public Integer getApplicationNo() {
		return ApplicationNo;
	}

	public void setApplicationNo(Integer applicationNo) {
		ApplicationNo = applicationNo;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getRescheduledDate() {
		return RescheduledDate;
	}

	public void setRescheduledDate(String rescheduledDate) {
		RescheduledDate = rescheduledDate;
	}

	public String getRuledOutDate() {
		return RuledOutDate;
	}

	public void setRuledOutDate(String ruledOutDate) {
		RuledOutDate = ruledOutDate;
	}

	public String getRentedOut() {
		return RentedOut;
	}

	public void setRentedOut(String rentedOut) {
		RentedOut = rentedOut;
	}

	public String getApartmentNo() {
		return ApartmentNo;
	}

	public void setApartmentNo(String apartmentNo) {
		ApartmentNo = apartmentNo;
	}

	public String getRent() {
		return Rent;
	}

	public void setRent(String rent) {
		Rent = rent;
	}

	public String getRentPaid() {
		return RentPaid;
	}

	public void setRentPaid(String rentPaid) {
		RentPaid = rentPaid;
	}

	public String getMonth() {
		return Month;
	}

	public void setMonth(String month) {
		Month = month;
	}

	public String getYear() {
		return Year;
	}

	public void setYear(String year) {
		Year = year;
	}

}
