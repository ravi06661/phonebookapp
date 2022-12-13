package com.dollop.dao;

import java.util.ArrayList;

import com.dollop.entity.Contact;

public interface ContactInterfaceDAO {
	public boolean createContact(Contact contact);
	public ArrayList<Contact> viewAllContact();
	public Contact viewContactById(Integer id);
	public boolean updateContact(Contact contact);
	public boolean deleteContact(Integer id);

}
