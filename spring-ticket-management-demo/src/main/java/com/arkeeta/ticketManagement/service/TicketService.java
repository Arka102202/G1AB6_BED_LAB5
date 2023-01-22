package com.arkeeta.ticketManagement.service;

import com.arkeeta.ticketManagement.entity.Ticket;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface TicketService {

    List<Ticket> findAll(Sort sort);

    Ticket findById(int id);

    Ticket addOrUpdateTicket(Ticket ticket);

    void deleteTicket(Ticket ticket);

    List<Ticket> searchTicket(String title);
}
