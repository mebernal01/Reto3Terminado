package com.boat.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "message")
public class MessageModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;

    @Column(name = "messageText", nullable = false, length = 250)
    private String messageText;


    @ManyToOne
    @JoinColumn(name = "boatId")
    @JsonIgnoreProperties({"messages", "reservations"})
    private BoatModel boat;

    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties({"messages", "reservations"})
    private ClientModel client;

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessageModel) {
        this.idMessage = idMessageModel;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public BoatModel getBoat() {
        return boat;
    }

    public void setBoat(BoatModel boat) {
        this.boat = boat;
    }

    public ClientModel getClient() {
        return client;
    }

    public void setClient(ClientModel client) {
        this.client = client;
    }
}
