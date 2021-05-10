package com.example.product.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class IdsList implements Serializable {
    private List<Long> ids = new ArrayList<>();

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}
