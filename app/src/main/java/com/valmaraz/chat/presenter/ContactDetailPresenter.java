package com.valmaraz.chat.presenter;

import com.valmaraz.chat.model.entity.RxMessage;
import com.valmaraz.chat.model.entity.TxMessage;
import com.valmaraz.chat.model.usecase.ChatUseCase;
import com.valmaraz.chat.model.usecase.ChatUseCaseListener;
import com.valmaraz.chat.view.ContactDetailView;

/**
 * Created by vAlmaraz on 09/07/2017.
 * https://www.valmaraz.com
 */

public class ContactDetailPresenter implements Presenter, ChatUseCaseListener {

    private ContactDetailView view;
    private ChatUseCase chatUseCase;

    public ContactDetailPresenter(ContactDetailView view) {
        this.view = view;
        chatUseCase = new ChatUseCase(this);
    }

    @Override
    public void initialize() {
        chatUseCase.init();
    }

    @Override
    public void destroy() {
        chatUseCase.disconnect();
        chatUseCase = null;
    }

    public void send(String contactId, String message) {
        chatUseCase.send(contactId, message);
    }

    // =============================================================================
    // CHAT LISTENER
    // =============================================================================

    @Override
    public void onInitialized() {
        view.connected();
    }

    @Override
    public void onMessageTransmitted() {
    }

    @Override
    public void onMessageReceived(RxMessage rxMessage) {
        view.showReceivedMessage(rxMessage);
    }

    @Override
    public void onFailure(String message) {
        view.showTemporaryMessage(message);
    }
}
