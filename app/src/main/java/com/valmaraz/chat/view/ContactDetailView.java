package com.valmaraz.chat.view;

import com.valmaraz.chat.model.entity.RxMessage;

/**
 * Created by vAlmaraz on 09/07/2017.
 * https://www.valmaraz.com
 */
public interface ContactDetailView extends BaseView {
    void connected();
    void showReceivedMessage(RxMessage message);
}
