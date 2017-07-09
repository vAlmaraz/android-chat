package com.valmaraz.chat.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.valmaraz.chat.R;
import com.valmaraz.chat.presenter.ContactListPresenter;
import com.valmaraz.chat.view.ContactListView;
import com.valmaraz.chat.view.adapter.ContactsAdapter;
import com.valmaraz.chat.model.entity.Contact;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Optional;

/**
 * An activity representing a list of Contacts. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link ContactDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class ContactListActivity extends AppCompatActivity implements ContactListView {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean twoPane;
    private ContactListPresenter presenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.contact_list)
    RecyclerView recyclerView;
    @Nullable
    @BindView(R.id.contact_detail_container)
    View container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        if (container != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            twoPane = true;
        }

        if (presenter == null) {
            presenter = new ContactListPresenter(this);
        }

        presenter.initialize();
    }

    // =============================================================================
    // VIEW IMPLEMENTATION
    // =============================================================================

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void showTemporaryMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void renderContactList(List<Contact> contactList) {
        recyclerView.setAdapter(new ContactsAdapter(getSupportFragmentManager(), contactList, twoPane));
    }
}
