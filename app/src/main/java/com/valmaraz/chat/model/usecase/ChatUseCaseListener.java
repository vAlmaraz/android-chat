package com.valmaraz.chat.model.usecase;

import com.valmaraz.chat.model.entity.RxMessage;

/**
 * Created by vAlmaraz on 09/07/2017.
 * https://www.valmaraz.com
 */
public interface ChatUseCaseListener extends UseCaseListener {
    void onInitialized();

    void onMessageTransmitted();

    void onMessageReceived(RxMessage rxMessage);
}
