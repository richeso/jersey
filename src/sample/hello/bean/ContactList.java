package sample.hello.bean;

import java.util.ArrayList;
import java.util.List;


public class ContactList {
	private String contactListName;
	private List   contacts;
	
	public ContactList() {
		contactListName = "This is a contact List";
		contacts = new ArrayList<Contact>();
	}

	public String getContactListName() {
		return contactListName;
	}

	public void setContactListName(String contactListName) {
		this.contactListName = contactListName;
	}

	public List getContacts() {
		return contacts;
	}

	public void setContacts(List contacts) {
		this.contacts = contacts;
	}
	
	
	
}
