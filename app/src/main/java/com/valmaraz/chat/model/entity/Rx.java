package com.valmaraz.chat.model.entity;

import android.text.TextUtils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by vAlmaraz on 09/07/2017.
 * https://www.valmaraz.com
 */
public class Rx {

    private final static String STATUS_OK = "ok";
    private final static String STATUS_KO = "ko";

    @SerializedName("status")
    @Expose
    protected String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isOk() {
        return !TextUtils.isEmpty(status) && status.equals(STATUS_OK);
    }
}
