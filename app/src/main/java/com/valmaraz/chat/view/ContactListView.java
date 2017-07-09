package com.valmaraz.chat.view;

import com.valmaraz.chat.model.entity.Contact;

import java.util.List;

/**
 * Created by vAlmaraz on 09/07/2017.
 * https://www.valmaraz.com
 */
public interface ContactListView extends BaseView {

    void renderContactList(List<Contact> contactList);
}
