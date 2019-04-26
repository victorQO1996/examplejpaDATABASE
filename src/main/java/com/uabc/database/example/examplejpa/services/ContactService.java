package com.uabc.database.example.examplejpa.services;



import com.uabc.database.example.examplejpa.entity.Contact;
import com.uabc.database.example.examplejpa.model.ContactModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("contactService")
public interface ContactService {
    public abstract ContactModel addContact(ContactModel contactModel);

    public abstract List<ContactModel> listAllContacts();

    public abstract Contact findContactById(int id);

    public abstract void removeContact(int id);

    public abstract ContactModel findContactByIdModel(int id);

}
