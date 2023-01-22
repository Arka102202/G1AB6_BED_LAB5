package com.arkeeta.ticketManagement.controller;

import com.arkeeta.ticketManagement.entity.Ticket;
import com.arkeeta.ticketManagement.service.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RequestMapping("/admin")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    Logger logger = LoggerFactory.getLogger(TicketController.class);
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";

    @RequestMapping("/tickets")
    public String showTickets(Model model){

        logger.info(ANSI_WHITE + "something" + ANSI_RESET);

        model.addAttribute
                ("tickets",
                        ticketService.findAll(
                                Sort.by(Sort.Direction.ASC, "title")
                        )
                );
        model.addAttribute("title", "");
        return "ticket-list";
    }

    @GetMapping("/edit-page")
    public String showEditPage(@RequestParam("id") int id,Model model){
        if (id > 0) model.addAttribute("ticket", ticketService.findById(id));
        else model.addAttribute("ticket", new Ticket());
        return "edit-page";
    }

    @GetMapping("/view-page")
    public String showViewPage(@RequestParam("id") int id,Model model){
        model.addAttribute("ticket", ticketService.findById(id));
        return "view-page";
    }

    @PostMapping("/new-update-ticket")
    public String createNewTicket(@ModelAttribute("ticket") Ticket ticket){
        ticketService.addOrUpdateTicket(ticket);
        return "redirect:/admin/tickets";
    }

    @GetMapping("/delete-ticket")
    public String deleteTicket(@RequestParam("id") int id){
        ticketService.deleteTicket(ticketService.findById(id));
        return "redirect:/admin/tickets";
    }

    @GetMapping("/search-ticket")
    public String searchTicket(@RequestParam("title") String title, Model model){
        model.addAttribute("tickets", ticketService.searchTicket(title));
        model.addAttribute("title", "");
        return "ticket-list";
    }

}
