package com.valmaraz.chat.model.usecase;

import com.valmaraz.chat.Environment;
import com.valmaraz.chat.model.entity.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vAlmaraz on 09/07/2017.
 * https://www.valmaraz.com
 */
public class ContactUseCase {

    public List<Contact> getContactList() {
        List<Contact> contactList = new ArrayList<Contact>();
        if (!Environment.CURRENT_USER.equals("contact_1")) {
            Contact c1 = new Contact();
            c1.setId("contact_1");
            c1.setName("Contact 1");
            contactList.add(c1);
        }
        if (!Environment.CURRENT_USER.equals("contact_2")) {
            Contact c2 = new Contact();
            c2.setId("contact_2");
            c2.setName("Contact 2");
            contactList.add(c2);
        }
        if (!Environment.CURRENT_USER.equals("contact_3")) {
            Contact c3 = new Contact();
            c3.setId("contact_3");
            c3.setName("Contact 3");
            contactList.add(c3);
        }
        if (!Environment.CURRENT_USER.equals("contact_4")) {
            Contact c4 = new Contact();
            c4.setId("contact_4");
            c4.setName("Contact 4");
            contactList.add(c4);
        }
        if (!Environment.CURRENT_USER.equals("contact_5")) {
            Contact c5 = new Contact();
            c5.setId("contact_5");
            c5.setName("Contact 5");
            contactList.add(c5);
        }
        return contactList;
    }
}
