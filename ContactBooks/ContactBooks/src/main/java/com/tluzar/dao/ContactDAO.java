
package com.tluzar.dao;

import java.util.List;
import com.tluzar.entity.Contact;


public interface ContactDAO {
    public long createContact(Contact contact);
    public Contact updateContact(Contact contact);
    public void deleteContact(long id);
    public List<Contact> getAllContacts();
    public Contact getContact(long id);	
    public List<Contact> getAllContacts(String contactName);
}
