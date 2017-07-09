package com.valmaraz.chat.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by vAlmaraz on 09/07/2017.
 * https://www.valmaraz.com
 */

public abstract class Tx {

    protected final static String TYPE_START = "start";
    protected final static String TYPE_MESSAGE = "message";

    @SerializedName("id")
    @Expose
    protected String id;
    @SerializedName("type")
    @Expose
    protected String type;

    public Tx(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
