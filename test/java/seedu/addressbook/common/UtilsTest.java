package seedu.addressbook.common;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Name;


public class UtilsTest {

	@Test
    public void nullInput_returnsTrue() {
		String nullString = null;
		boolean result = Utils.isAnyNull(nullString);
        assertTrue(result);
    }
	
	@Test
    public void containsNull_returnsTrue() {
		boolean result = Utils.isAnyNull("1", null, "3");
        assertTrue(result);
    }
	
	@Test
    public void noNull_returnsFalse() {
		ArrayList<String> array = new ArrayList<String>();
		array.add("1");
		array.add("2");
		array.add("3");
		boolean result = Utils.isAnyNull(array);
        assertFalse(result);
    }
	
	@Test
    public void uniqueElement_returnsTrue() throws IllegalValueException {
		ArrayList<Name> array = new ArrayList<Name>();
		array.add(new Name("nameOne"));
		array.add(new Name("nameTwo"));
		boolean result = Utils.elementsAreUnique(array);
        assertTrue(result);
    }
	
	@Test
    public void sameElement_returnsFalse() throws IllegalValueException {
		ArrayList<Name> array = new ArrayList<Name>();
		array.add(new Name("nameOne"));
		array.add(new Name("nameOne"));
		boolean result = Utils.elementsAreUnique(array);
        assertFalse(result);
    }
}
