package com.boat.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservation" )
public class ReservationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    private Date startDate; //fecha de inicio
    private Date devolutionDate;
    private String status = "created";

    @ManyToOne
    @JoinColumn(name = "boatId")
    @JsonIgnoreProperties("reservations")
    private BoatModel boat;

    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties({"reservations", "messages"})
    private ClientModel client;

    @OneToOne
    @JsonIgnoreProperties("reservation")
    private ScoreModel score;

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservationModel) {
        this.idReservation = idReservationModel;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public ScoreModel getScore() {
        return score;
    }

    public void setScore(ScoreModel score) {
        this.score = score;
    }
}
