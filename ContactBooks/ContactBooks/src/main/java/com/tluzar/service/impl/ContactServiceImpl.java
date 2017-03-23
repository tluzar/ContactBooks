package com.tluzar.service.impl;
import com.tluzar.dao.ContactDAO;
import com.tluzar.entity.Contact;
import com.tluzar.service.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ContactServiceImpl implements ContactService {
	
	public ContactServiceImpl() {
		System.out.println("ContactServiceImpl()");
	}
	
    @Autowired
    private ContactDAO contactDAO;

    @Override
    public long createContact(Contact contact) {
        return contactDAO.createContact(contact);
    }
    @Override
    public Contact updateContact(Contact contact) {
        return contactDAO.updateContact(contact);
    }
    @Override
    public void deleteContact(long id) {
    	contactDAO.deleteContact(id);
    }
    @Override
    public List<Contact> getAllContacts() {
        return contactDAO.getAllContacts();
    }
    @Override
    public Contact getContact(long id) {
        return contactDAO.getContact(id);
    }    
    @Override
    public List<Contact> getAllContacts(String contactName) {
    	return contactDAO.getAllContacts(contactName);
    }
}
