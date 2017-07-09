package com.valmaraz.chat.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by vAlmaraz on 09/07/2017.
 * https://www.valmaraz.com
 */

public class TxMessage extends Tx {

    @SerializedName("to")
    @Expose
    private String to;
    @SerializedName("message")
    @Expose
    private String message;

    public TxMessage(String id) {
        super(id);
        setType(TYPE_MESSAGE);
    }

    public String getType() {
        return TYPE_MESSAGE;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
