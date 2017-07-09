package com.valmaraz.chat.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.valmaraz.chat.R;
import com.valmaraz.chat.model.entity.Contact;
import com.valmaraz.chat.view.activity.ContactDetailActivity;
import com.valmaraz.chat.view.activity.ContactDetailFragment;

/**
 * Created by vAlmaraz on 09/07/2017.
 * https://www.valmaraz.com
 */

public class Navigator {

    public static void loadChat(FragmentManager fragmentManager, Contact contact) {
        Bundle arguments = new Bundle();
        arguments.putString(ContactDetailFragment.ARG_CONTACT_ID, contact.getId());
        arguments.putString(ContactDetailFragment.ARG_CONTACT_NAME, contact.getName());
        ContactDetailFragment fragment = new ContactDetailFragment();
        fragment.setArguments(arguments);
        fragmentManager.beginTransaction()
                .replace(R.id.contact_detail_container, fragment)
                .commit();
    }

    public static void navigateToChat(Context context, Contact contact) {
        Intent intent = new Intent(context, ContactDetailActivity.class);
        intent.putExtra(ContactDetailFragment.ARG_CONTACT_ID, contact.getId());
        intent.putExtra(ContactDetailFragment.ARG_CONTACT_NAME, contact.getName());
        context.startActivity(intent);
    }
}
