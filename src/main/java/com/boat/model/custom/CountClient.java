package com.boat.model.custom;

import com.boat.model.ClientModel;

public class CountClient {
    private Integer total;
    private ClientModel client;

    public CountClient(Integer total, ClientModel client) {
        this.total = total;
        this.client = client;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public ClientModel getClient() {
        return client;
    }

    public void setClient(ClientModel client) {
        this.client = client;
    }
}
