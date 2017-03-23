
package com.tluzar.dao.impl;
import com.tluzar.dao.ContactDAO;
import com.tluzar.entity.Contact;
import com.tluzar.util.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ContactDAOImpl implements ContactDAO {
    
	public ContactDAOImpl() {
    	System.out.println("ContactDAOImpl");
    }
	
	@Autowired
    private HibernateUtil hibernateUtil;

    @Override
    public long createContact(Contact contact) {        
        return (Long) hibernateUtil.create(contact);
    }
    
    @Override
    public Contact updateContact(Contact contact) {        
        return hibernateUtil.update(contact);
    }
    
    @Override
    public void deleteContact(long id) {
    	Contact contact = new Contact();
    	contact.setId(id);
        hibernateUtil.delete(contact);
    }
    
    @Override
    public List<Contact> getAllContacts() {        
        return hibernateUtil.fetchAll(Contact.class);
    }
    
    @Override
    public Contact getContact(long id) {
        return hibernateUtil.fetchById(id, Contact.class);
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> getAllContacts(String contactName) { 
		String query = "SELECT e.* FROM ContactBooks e WHERE e.name like '%"+ contactName +"%'";
		List<Object[]> contactObjects = hibernateUtil.fetchAll(query);
		List<Contact> contacts = new ArrayList<Contact>();
		for(Object[] contactObject: contactObjects) {
			Contact contact = new Contact();
			long id = ((BigInteger) contactObject[0]).longValue();			
			String surname = (String) contactObject[1];
			String name = (String) contactObject[2];
			String phone = (String) contactObject[3];
			contact.setId(id);
			contact.setName(name);
			contact.setSurname(surname);
			contact.setPhone(phone);
			contacts.add(contact);
		}
		System.out.println(contacts);
		return contacts;
	}
}