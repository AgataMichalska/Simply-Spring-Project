package com.example.Tickets;

import jdk.net.SocketFlow;
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

    @PutMapping("/tickets/{id}")
    public void editTicket(@PathVariable Integer id) {
        ticketService.edit(id);
    }

    @PostMapping("/tickets")
    public void postTicket(@RequestBody Ticket t) {
        ticketService.saveTicket(t);
    }


    @DeleteMapping("/tickets/{id}")
    public void deleteTicket(@PathVariable("id") Ticket ticketId) {
        ticketService.remove(ticketId);
    }
}