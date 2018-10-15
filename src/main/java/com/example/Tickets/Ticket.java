package com.example.Tickets;

import javax.persistence.*;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String message;
    @Enumerated(EnumType.STRING)
    private TicketState ticketState;
    //private boolean isRead;

    public Ticket() {
    }

    public Ticket(String message, TicketState ticketState) {
        this.message = message;
        this.ticketState = ticketState;
    }


    public TicketState getTicketState() {
        return ticketState;
    }

    public void setTicketState(TicketState ticketState) {
        this.ticketState = ticketState;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", ticketState=" + ticketState +
                '}';
    }
}
