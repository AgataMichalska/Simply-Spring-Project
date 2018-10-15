package com.example.Tickets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/tickets-search")
    public Ticket getByMessage(@RequestParam("message") String message) {
        return ticketService.getByMessage(message);
    }

    @GetMapping("/tickets")
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }


    @PostMapping("/tickets")
    public void postBook(@RequestBody Ticket t) {
        ticketService.saveTicket(t);
    }


    @DeleteMapping("/tickets/{id}")
    public void deleteTicket(@PathVariable("id") Ticket ticketId) {
        ticketService.remove(ticketId);
    }
}