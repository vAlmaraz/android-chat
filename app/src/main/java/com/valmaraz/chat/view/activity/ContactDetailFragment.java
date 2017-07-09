package com.valmaraz.chat.view.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.valmaraz.chat.R;
import com.valmaraz.chat.model.entity.RxMessage;
import com.valmaraz.chat.presenter.ContactDetailPresenter;
import com.valmaraz.chat.view.ContactDetailView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A fragment representing a single Contact detail screen.
 * This fragment is either contained in a {@link ContactListActivity}
 * in two-pane mode (on tablets) or a {@link ContactDetailActivity}
 * on handsets.
 */
public class ContactDetailFragment extends Fragment implements ContactDetailView {

    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_CONTACT_ID = "contact_id";
    public static final String ARG_CONTACT_NAME = "contact_name";

    @BindView(R.id.tv_chat)
    TextView tvChat;
    @BindView(R.id.et_message)
    EditText etMessage;
    @BindView(R.id.bt_send)
    Button btSend;

    /**
     * The contactId chat this fragment is presenting.
     */
    private String contactId;
    private ContactDetailPresenter presenter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ContactDetailFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        presenter = new ContactDetailPresenter(this);
        presenter.initialize();
        Toast.makeText(getContext(), R.string.connecting, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_CONTACT_ID)) {
            contactId = getArguments().getString(ARG_CONTACT_ID);

            Activity activity = this.getActivity();
            activity.setTitle(getArguments().getString(ARG_CONTACT_NAME));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.contact_detail, container, false);
        ButterKnife.bind(this, rootView);

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.destroy();
    }

    @OnClick(R.id.bt_send)
    public void onClick(View view) {
        // Send message if not empty
        String message = etMessage.getText().toString();
        if (TextUtils.isEmpty(message)) {
            showTemporaryMessage(getString(R.string.write_a_message));
        } else {
            // Send message
            presenter.send(contactId, message);
            showMessage(">> " + message);
            etMessage.getText().clear();
        }
    }

    // =============================================================================
    // VIEW IMPLEMENTATION
    // =============================================================================

    @Override
    public void showTemporaryMessage(final String message) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void connected() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                etMessage.setEnabled(true);
                btSend.setEnabled(true);
                Toast.makeText(getContext(), R.string.connected, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void showReceivedMessage(final RxMessage message) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                showMessage(message.getMessage());
            }
        });
    }

    private void showMessage(String message) {
        String currentHistory = tvChat.getText().toString();
        currentHistory += message + "\n";
        tvChat.setText(currentHistory);
    }
}
