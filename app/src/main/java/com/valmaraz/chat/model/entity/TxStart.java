package com.valmaraz.chat.model.entity;

/**
 * Created by vAlmaraz on 09/07/2017.
 * https://www.valmaraz.com
 */

public class TxStart extends Tx {

    public TxStart(String id) {
        super(id);
        setType(TYPE_START);
    }

    public String getType() {
        return TYPE_START;
    }
}
