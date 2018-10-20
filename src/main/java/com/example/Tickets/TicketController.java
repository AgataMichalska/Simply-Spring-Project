package com.example.Tickets;

import jdk.net.SocketFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;


    @GetMapping("/ticket")
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/ticket/getByMessage")
    public Ticket getByMessage(@RequestParam("message") String message) {
        return ticketService.getByMessage(message);
    }

    @PutMapping("/ticket")
    public void editTicket(@PathVariable Integer id) {
        ticketService.edit(id);
    }

    @PostMapping("/ticket")
    public void postTicket(@RequestBody Ticket t) {
        ticketService.saveTicket(t);
    }


    @DeleteMapping("/ticket/{id}")
    public void deleteTicket(@PathVariable("id") Integer ticketId) {
        ticketService.remove(ticketId);
    }
}