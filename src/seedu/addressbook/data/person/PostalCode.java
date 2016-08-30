package seedu.addressbook.data.person;

public class PostalCode {
	
	private String value;
	
	public PostalCode(String postalCode) {
		this.value = postalCode;
	}
	
	/**
	 * Returns the postal code
	 */
	public String getPostalCode() {
		return value;
	}
}
