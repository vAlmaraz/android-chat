package com.valmaraz.chat.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by vAlmaraz on 09/07/2017.
 * https://www.valmaraz.com
 */
public class RxError extends Rx {

    @SerializedName("error")
    @Expose
    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
