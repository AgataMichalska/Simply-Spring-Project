package com.example.Tickets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;


    @PostMapping("/tickets")
    public void postBook(@RequestBody Ticket t) {
        ticketService.saveTicket(t);
    }
}
