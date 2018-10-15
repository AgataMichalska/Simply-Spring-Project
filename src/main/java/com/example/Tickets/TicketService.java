package com.example.Tickets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    private static List<Ticket> list = new ArrayList<>();

    static {
        list.add(new Ticket("Login error",TicketState.CREATED));
        list.add(new Ticket("The search doesn't work",TicketState.PROGRESS));
        list.add(new Ticket("E-mails sending error",TicketState.COMPLETED));
    }

    public List<Ticket> getList() {
        return ticketRepository.findAll();
    }

    public Ticket getByMessage(String message){
        return ticketRepository.findByMessage(message);
    }

    public void saveTicket(Ticket t) {
        ticketRepository.save(t);
    }
}