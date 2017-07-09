package com.valmaraz.chat.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.valmaraz.chat.R;
import com.valmaraz.chat.view.activity.ContactDetailActivity;
import com.valmaraz.chat.view.activity.ContactDetailFragment;
import com.valmaraz.chat.model.entity.Contact;
import com.valmaraz.chat.view.viewholder.ContactViewHolder;

import java.util.List;

/**
 * Created by vAlmaraz on 09/07/2017.
 * https://www.valmaraz.com
 */
public class ContactsAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    private FragmentManager fragmentManager;
    private List<Contact> contactList;
    private boolean twoPane;

    public ContactsAdapter(FragmentManager fragmentManager, List<Contact> contactList, boolean twoPane) {
        this.fragmentManager = fragmentManager;
        this.contactList = contactList;
        this.twoPane = twoPane;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_list_content, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ContactViewHolder holder, int position) {
        holder.contact = contactList.get(position);
        holder.tvName.setText(contactList.get(position).getName());

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (twoPane) {
                    Bundle arguments = new Bundle();
                    arguments.putString(ContactDetailFragment.ARG_CONTACT_ID, holder.contact.getId());
                    arguments.putString(ContactDetailFragment.ARG_CONTACT_NAME, holder.contact.getName());
                    ContactDetailFragment fragment = new ContactDetailFragment();
                    fragment.setArguments(arguments);
                    fragmentManager.beginTransaction()
                            .replace(R.id.contact_detail_container, fragment)
                            .commit();
                } else {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, ContactDetailActivity.class);
                    intent.putExtra(ContactDetailFragment.ARG_CONTACT_ID, holder.contact.getId());
                    intent.putExtra(ContactDetailFragment.ARG_CONTACT_NAME, holder.contact.getName());

                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }
}
