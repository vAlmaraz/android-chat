package com.valmaraz.chat.model.usecase;

import com.valmaraz.chat.Environment;
import com.valmaraz.chat.model.repository.chat.ChatRepository;
import com.valmaraz.chat.model.repository.chat.ConnectionListener;
import com.valmaraz.chat.model.repository.chat.InitializationListener;
import com.valmaraz.chat.model.repository.chat.ReceptionListener;
import com.valmaraz.chat.model.repository.chat.TransmissionListener;
import com.valmaraz.chat.model.entity.RxError;
import com.valmaraz.chat.model.entity.RxMessage;
import com.valmaraz.chat.model.entity.TxMessage;
import com.valmaraz.chat.model.entity.TxStart;

/**
 * Created by vAlmaraz on 09/07/2017.
 * https://www.valmaraz.com
 */
public class ChatUseCase implements ReceptionListener {

    private ChatRepository repository;
    private ChatUseCaseListener chatUseCaseListener;

    public ChatUseCase(ChatUseCaseListener chatUseCaseListener) {
        this.chatUseCaseListener = chatUseCaseListener;
        this.repository = new ChatRepository(this);
    }

    public void init() {
        ConnectionListener connectionListener = new ConnectionListener() {
            @Override
            public void onConnectionSuccess() {
                start();
            }

            @Override
            public void onFailure(String message) {
                chatUseCaseListener.onFailure(message);
            }
        };
        repository.connect(connectionListener);
    }

    public void send(String contactId, String message) {
        TxMessage txMessage = new TxMessage(Environment.CURRENT_USER);
        txMessage.setTo(contactId);
        txMessage.setMessage(message);

        TransmissionListener transmissionListener = new TransmissionListener() {
            @Override
            public void onMessageSent() {
                chatUseCaseListener.onMessageTransmitted();
            }

            @Override
            public void onFailure(String message) {
                chatUseCaseListener.onFailure(message);
            }
        };

        repository.sendMessage(txMessage, transmissionListener);
    }

    public void disconnect() {
        repository.disconnect();
    }

    @Override
    public void onMessageReceived(RxMessage rxMessage) {
        chatUseCaseListener.onMessageReceived(rxMessage);
    }

    @Override
    public void onErrorReceived(RxError rxError) {
        chatUseCaseListener.onFailure(rxError.getError());
    }

    @Override
    public void onFailure(String message) {
        chatUseCaseListener.onFailure(message);
    }

    private void start() {
        TxStart txStart = new TxStart(Environment.CURRENT_USER);
        InitializationListener initializationListener = new InitializationListener() {
            @Override
            public void onStarted() {
                chatUseCaseListener.onInitialized();
            }

            @Override
            public void onFailure(String message) {
                chatUseCaseListener.onFailure(message);
            }
        };
        repository.start(txStart, initializationListener);
    }
}
