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
        t.setTicketState(TicketState.CREATED);
        ticketRepository.save(t);
    }

    public void remove(Ticket id) {
        ticketRepository.delete(id);
    }

    public void edit(Integer id) {
        Ticket ticketToUpdate = ticketRepository.findById(id).orElseGet(null);
        if (ticketToUpdate.getTicketState().equals(TicketState.CREATED)) {
            ticketToUpdate.setTicketState(TicketState.PROGRESS);
        } else if (ticketToUpdate.getTicketState().equals(TicketState.PROGRESS)) {
            ticketToUpdate.setTicketState(TicketState.COMPLETED);
        }
        ticketRepository.save(ticketToUpdate);
    }
}