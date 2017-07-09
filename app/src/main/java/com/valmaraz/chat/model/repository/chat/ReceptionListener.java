package com.valmaraz.chat.model.repository.chat;

import com.valmaraz.chat.model.repository.RepositoryListener;
import com.valmaraz.chat.model.entity.RxError;
import com.valmaraz.chat.model.entity.RxMessage;

/**
 * Created by vAlmaraz on 09/07/2017.
 * https://www.valmaraz.com
 */
public interface ReceptionListener extends RepositoryListener {
    void onMessageReceived(RxMessage rxMessage);

    void onErrorReceived(RxError rxError);
}
