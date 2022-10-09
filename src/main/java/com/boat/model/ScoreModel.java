package com.boat.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "score")
public class ScoreModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idScore;
    private String messageText;
    private Integer starts;

    @OneToOne
    @JsonIgnoreProperties("score")
    private ReservationModel reservation;

    public Integer getIdScore() {
        return idScore;
    }

    public void setIdScore(Integer idScoreModel) {
        this.idScore= idScoreModel;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Integer getStarts() {
        return starts;
    }

    public void setStarts(Integer starts) {
        this.starts = starts;
    }

    public ReservationModel getReservation() {
        return reservation;
    }

    public void setReservation(ReservationModel reservation) {
        this.reservation = reservation;
    }
}
