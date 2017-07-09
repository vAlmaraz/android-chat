package com.valmaraz.chat.view.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.valmaraz.chat.R;
import com.valmaraz.chat.model.entity.Contact;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by vAlmaraz on 09/07/2017.
 * https://www.valmaraz.com
 */
public class ContactViewHolder extends RecyclerView.ViewHolder {

    public View view;
    @BindView(R.id.name)
    public TextView tvName;

    public Contact contact;

    public ContactViewHolder(View view) {
        super(view);
        this.view = view;
        ButterKnife.bind(this, view);
    }

    @Override
    public String toString() {
        return super.toString() + " '" + tvName.getText() + "'";
    }
}
