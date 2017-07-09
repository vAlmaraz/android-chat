package com.valmaraz.chat.view;

import android.content.Context;

/**
 * Created by vAlmaraz on 09/07/2017.
 * https://www.valmaraz.com
 */
public interface BaseView {
    Context getContext();
    void showTemporaryMessage(String message);
}
