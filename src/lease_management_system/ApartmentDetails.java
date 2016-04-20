package lease_management_system;

public class ApartmentDetails {

	public String ApartmentNo;
	public String Type;
	public String Facilities;
	public String MaximumPeople;
	public String Rent;
	public String Deposits;
	public String Vacant;
	public String Available;
	public String Appointments;
	public String Operation;
	public String AppointmentDate;
	public String AppointmentResult;

	public ApartmentDetails() {

	}

	public ApartmentDetails(String apartmentNo, String type, String facilities,
			String maximumPeople, String rent, String deposits, String vacant,
			String available, String appointments, String operation,
			String appointmentDate, String appointmentResult) {
		super();
		ApartmentNo = apartmentNo;
		Type = type;
		Facilities = facilities;
		MaximumPeople = maximumPeople;
		Rent = rent;
		Deposits = deposits;
		Vacant = vacant;
		Available = available;
		Appointments = appointments;
		Operation = operation;
		AppointmentDate = appointmentDate;
		AppointmentResult = appointmentResult;

	}

	public ApartmentDetails(String apartmentNo, String type, String facilities,
			String maximumPeople, String rent, String deposits, String vacant,
			String appointmentDate, String appointmentResult) {
		super();
		ApartmentNo = apartmentNo;
		Type = type;
		Facilities = facilities;
		MaximumPeople = maximumPeople;
		Rent = rent;
		Deposits = deposits;
		Vacant = vacant;
		AppointmentDate = appointmentDate;
		AppointmentResult = appointmentResult;

	}

	public ApartmentDetails(String apartmentNo, String type, String facilities,
			String maximumPeople, String rent, String deposits, String vacant) {
		super();
		ApartmentNo = apartmentNo;
		Type = type;
		Facilities = facilities;
		MaximumPeople = maximumPeople;
		Rent = rent;
		Deposits = deposits;
		Vacant = vacant;
	}

	public String getApartmentNo() {
		return ApartmentNo;
	}

	public void setApartmentNo(String apartmentNo) {
		ApartmentNo = apartmentNo;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getFacilities() {
		return Facilities;
	}

	public void setFacilities(String facilities) {
		Facilities = facilities;
	}

	public String getMaximumPeople() {
		return MaximumPeople;
	}

	public void setMaximumPeople(String maximumPeople) {
		MaximumPeople = maximumPeople;
	}

	public String getRent() {
		return Rent;
	}

	public void setRent(String rent) {
		Rent = rent;
	}

	public String getDeposits() {
		return Deposits;
	}

	public void setDeposits(String deposits) {
		Deposits = deposits;
	}

	public String getVacant() {
		return Vacant;
	}

	public void setVacant(String vacant) {
		Vacant = vacant;
	}

	public String getAvailable() {
		return Available;
	}

	public void setAvailable(String available) {
		Available = available;
	}

	public String getAppointments() {
		return Appointments;
	}

	public void setAppointments(String appointments) {
		Appointments = appointments;
	}

	public String getOperation() {
		return Operation;
	}

	public void setOperation(String operation) {
		Operation = operation;
	}

	public String getAppointmentDate() {
		return AppointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		AppointmentDate = appointmentDate;
	}

	public String getAppointmentResult() {
		return AppointmentResult;
	}

	public void setAppointmentResult(String appointmentResult) {
		AppointmentResult = appointmentResult;
	}

}