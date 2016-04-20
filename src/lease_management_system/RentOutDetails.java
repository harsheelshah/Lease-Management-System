package lease_management_system;

public class RentOutDetails {

	public String LeaseTerminationDate;
	public String LeaseHolderName;
	public String ListOfDocuments;
	public String Rent;
	public String Deposits;

	public RentOutDetails(String leaseTerminationDate, String leaseHolderName,
			String listOfDocuments, String rent, String deposits) {
		super();
		LeaseTerminationDate = leaseTerminationDate;
		LeaseHolderName = leaseHolderName;
		ListOfDocuments = listOfDocuments;
		Rent = rent;
		Deposits = deposits;
	}

	public String getLeaseTerminationDate() {
		return LeaseTerminationDate;
	}

	public void setLeaseTerminationDate(String leaseTerminationDate) {
		LeaseTerminationDate = leaseTerminationDate;
	}

	public String getLeaseHolderName() {
		return LeaseHolderName;
	}

	public void setLeaseHolderName(String leaseHolderName) {
		LeaseHolderName = leaseHolderName;
	}

	public String getListOfDocuments() {
		return ListOfDocuments;
	}

	public void setListOfDocuments(String listOfDocuments) {
		ListOfDocuments = listOfDocuments;
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

}
