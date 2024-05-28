package com.mx.globant.Entity;

import jakarta.persistence.*;

@Entity
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "action")
    private String action;

    @Column(name = "date")
    private String date;

    @Column(name = "detail")
    private String details;

    public History() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "History{" +
                "id=" + id +
                ", action='" + action + '\'' +
                ", date='" + date + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
