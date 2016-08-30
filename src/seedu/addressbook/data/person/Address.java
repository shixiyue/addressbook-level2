package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "An valid address is in the following format BLOCK, STREET, UNIT, POSTAL_CODE";
    
    private static final int ADDRESS_NUMBER_OF_PARTS = 4;
    private static final int BLOCK = 0;
    private static final int STREET = 1;
    private static final int UNIT = 2;
    private static final int POSTAL_CODE = 3;

    public final String value;
    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        if (!isValidAddress(address)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        // Adapted from Tomasz Nurkiewicz's answer
        // http://stackoverflow.com/questions/10631715/how-to-split-a-comma-separated-string
        String[] values = address.split("\\s*,\\s*");
        initializeValues(values);
        this.value = toString();
    }

    /**
     * Returns true if a given string is a valid address
     * i.e., the given string contains 4 parts separated by comma.
     */
    public static boolean isValidAddress(String test) {
        return test.split(",").length == ADDRESS_NUMBER_OF_PARTS;
    }
    
    /**
     * Initialize values for block, street, unit and postal code.
     */
    private void initializeValues(String[] values) {
    	block = new Block(values[BLOCK]);
        street = new Street(values[STREET]);
        unit = new Unit(values[UNIT]);
        postalCode = new PostalCode(values[POSTAL_CODE]);
    }

    @Override
    public String toString() {
    	String seperator = ", ";
        return block.getBlock() + seperator + street.getStreet() + seperator
        		+ unit.getUnit() + seperator + postalCode.getPostalCode();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}