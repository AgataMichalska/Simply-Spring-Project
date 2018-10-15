package com.example.Tickets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket getByMessage(String message) {
        return ticketRepository.findByMessage(message);
    }

    public void saveTicket(Ticket t) {
        ticketRepository.save(t);
    }

    public void remove(Ticket id) {
        ticketRepository.delete(id);
    }

    public void edit(){}
}