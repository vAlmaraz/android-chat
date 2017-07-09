package com.valmaraz.chat.model.repository.chat;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.WebSocket;
import com.valmaraz.chat.Environment;
import com.valmaraz.chat.model.entity.RxError;
import com.valmaraz.chat.model.entity.RxMessage;
import com.valmaraz.chat.model.entity.TxMessage;
import com.valmaraz.chat.model.entity.Rx;
import com.valmaraz.chat.model.entity.TxStart;

/**
 * Created by vAlmaraz on 09/07/2017.
 * https://www.valmaraz.com
 */
public class ChatClient {

    private static final String TAG = ChatClient.class.getName();

    private Gson gson;
    private WebSocket ws;
    private ReceptionListener receptionListener;

    public ChatClient(@NonNull ReceptionListener receptionListener) {
        this.gson = new Gson();
        this.receptionListener = receptionListener;
    }

    public void connect(@NonNull final ConnectionListener connectionListener) {
        AsyncHttpClient.getDefaultInstance().websocket(Environment.socketAddress, null, new AsyncHttpClient.WebSocketConnectCallback() {
            @Override
            public void onCompleted(Exception ex, WebSocket webSocket) {
                if (ex != null) {
                    ex.printStackTrace();
                    connectionListener.onFailure(ex.getMessage());
                    return;
                }
                webSocket.setStringCallback(new WebSocket.StringCallback() {
                    public void onStringAvailable(String s) {
                        Rx rx = gson.fromJson(s, Rx.class);
                        if (rx.isOk()) {
                            RxMessage rxMessage = gson.fromJson(s, RxMessage.class);
                            receptionListener.onMessageReceived(rxMessage);
                        } else {
                            RxError rxError = gson.fromJson(s, RxError.class);
                            receptionListener.onErrorReceived(rxError);
                        }
                    }
                });
                /*
                webSocket.setDataCallback(new DataCallback() {
                    public void onDataAvailable(DataEmitter emitter, ByteBufferList byteBufferList) {
                        System.out.println("I got some bytes!");
                        // note that this data has been read
                        byteBufferList.recycle();
                    }
                });
                */
                ws = webSocket;
                connectionListener.onConnectionSuccess();
            }
        });
    }

    public void start(TxStart txStart, @NonNull InitializationListener initializationListener) {
        ws.send(gson.toJson(txStart));
        initializationListener.onStarted();
    }

    public void sendMessage(TxMessage txMessage, @NonNull TransmissionListener transmissionListener) {
        ws.send(gson.toJson(txMessage));
        transmissionListener.onMessageSent();
    }

    public void disconnect() {
        ws.close();
    }
}
