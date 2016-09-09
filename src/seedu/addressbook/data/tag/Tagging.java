package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

/**
 * An association class that stores information of a tag-update operation
 */
public class Tagging {
	
	private final String ADD_PREFIX = "+ ";
	private final String DELETE_PREFIX = "- "; 
	
	private Person person;
	private Tag tag;
	private boolean isAdd;
	
	public Tagging(Person person, Tag tag, boolean isAdd) {
		this.person = person;
		this.tag = tag;
		this.isAdd = isAdd;
	}
	
	/**
     * Print out the tag update for the person 
     */
	public void printUpdate() {
		if (isAdd) {
			System.out.println(ADD_PREFIX + person.getName() + " " + tag.toString());
		} else {
			System.out.println(DELETE_PREFIX + person.getName() + " " + tag.toString());
		}
	}
}
