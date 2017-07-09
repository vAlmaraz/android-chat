package com.valmaraz.chat.presenter;

import com.valmaraz.chat.model.usecase.ContactUseCase;
import com.valmaraz.chat.view.ContactListView;

/**
 * Created by vAlmaraz on 09/07/2017.
 * https://www.valmaraz.com
 */
public class ContactListPresenter implements Presenter {

    private ContactListView view;
    private ContactUseCase useCase;

    public ContactListPresenter(ContactListView view) {
        this.view = view;
        this.useCase = new ContactUseCase();
    }

    @Override
    public void initialize() {
        view.renderContactList(useCase.getContactList());
    }

    @Override
    public void destroy() {
        view = null;
        useCase = null;
    }
}
