package com.tluzar.controller;
import com.tluzar.entity.Contact;
import com.tluzar.service.ContactService;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ContactController {
	
	private static final Logger logger = Logger.getLogger(ContactController.class);
	
	public ContactController() {
		System.out.println("ContactController()");
	}

    @Autowired
    private ContactService contactService;

    @RequestMapping("createContact")
    public ModelAndView createContact(@ModelAttribute Contact contact) {
    	logger.info("Creating Contact. Data: "+contact);
        return new ModelAndView("contactForm");
    }
    
    @RequestMapping("editContact")
    public ModelAndView editContact(@RequestParam long id, @ModelAttribute Contact contact) {
    	logger.info("Updating the Contact for the Id "+id);
    	contact = contactService.getContact(id);
        return new ModelAndView("contactForm", "contactObject", contact);
    }
    
    @RequestMapping("saveContact")
    public ModelAndView saveContact(@ModelAttribute Contact contact) {
    	logger.info("Saving the Contact. Data : "+contact);
        if(contact.getId() == 0){ // if contact id is 0 then creating the contact other updating the contact
        	contactService.createContact(contact);
        } else {
        	contactService.updateContact(contact);
        }
        return new ModelAndView("redirect:getAllContacts");
    }
    
    @RequestMapping("deleteContact")
    public ModelAndView deleteContact(@RequestParam long id) {
    	logger.info("Deleting the Contact. Id : "+id);
    	contactService.deleteContact(id);
        return new ModelAndView("redirect:getAllContacts");
    }
    
    @RequestMapping(value = {"getAllContacts", "/"})
    public ModelAndView getAllContacts() {
    	logger.info("Getting the all Contacts.");
        List<Contact> contactList = contactService.getAllContacts();
        return new ModelAndView("contactList", "contactList", contactList);
    }
    
    @RequestMapping("searchContact")
    public ModelAndView searchContact(@RequestParam("searchName") String searchName) {  
    	logger.info("Searching the Contact. Contact Names: "+searchName);
    	List<Contact> contactList = contactService.getAllContacts(searchName);
        return new ModelAndView("contactList", "contactList", contactList);    	
    }
}