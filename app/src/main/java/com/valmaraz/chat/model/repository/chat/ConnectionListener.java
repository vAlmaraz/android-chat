package com.valmaraz.chat.model.repository.chat;

import com.valmaraz.chat.model.repository.RepositoryListener;

/**
 * Created by vAlmaraz on 09/07/2017.
 * https://www.valmaraz.com
 */
public interface ConnectionListener extends RepositoryListener {
    void onConnectionSuccess();
}
