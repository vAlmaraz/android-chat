package com.valmaraz.chat.model.repository.chat;

import android.support.annotation.NonNull;

import com.valmaraz.chat.model.entity.TxMessage;
import com.valmaraz.chat.model.entity.TxStart;

/**
 * Created by vAlmaraz on 09/07/2017.
 * https://www.valmaraz.com
 */

public class ChatRepository {

    private ChatClient client;

    public ChatRepository(@NonNull ReceptionListener listener) {
        client = new ChatClient(listener);
    }

    public void connect(@NonNull ConnectionListener listener) {
        client.connect(listener);
    }

    public void start(@NonNull TxStart txStart, @NonNull InitializationListener listener) {
        client.start(txStart, listener);
    }

    public void sendMessage(@NonNull TxMessage txMessage, @NonNull TransmissionListener listener) {
        client.sendMessage(txMessage, listener);
    }

    public void disconnect() {
        client.disconnect();
    }
}
