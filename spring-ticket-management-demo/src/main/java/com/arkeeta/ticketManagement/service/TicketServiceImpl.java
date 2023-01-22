package com.arkeeta.ticketManagement.service;

import com.arkeeta.ticketManagement.entity.Ticket;
import com.arkeeta.ticketManagement.repository.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService{
    @Autowired
    private TicketRepo ticketRepo;

    @Override
    public List<Ticket> findAll(Sort sort) {
        return ticketRepo.findAll(sort);
    }

    @Override
    public Ticket findById(int id) {
        return ticketRepo.findById(id).get();
    }

    @Override
    public Ticket addOrUpdateTicket(Ticket ticket) {
         return ticketRepo.save(ticket);
    }

    @Override
    public void deleteTicket(Ticket ticket) {
        ticketRepo.delete(ticket);
    }

    @Override
    public List<Ticket> searchTicket(String title) {
        return ticketRepo.findByTitle(title);
    }

//    @Override
//    public List<Ticket> getAllTicketsWithNoDesc() {
//
//        Ticket ticket = new Ticket();
//        ticket.setShortDesc("");
//        ExampleMatcher exampleMatcher = ExampleMatcher
//                .matching()
//                .withMatcher("shortDesc", ExampleMatcher
//                        .GenericPropertyMatchers
//                        .exact())
//                .withIgnorePaths("id","title","createDate");
//
//        Example<Ticket> example = Example.of(ticket, exampleMatcher);
//        return ticketRepo.findAll(example);
//    }

    @Override
    public List<Ticket> getAllTicketsWithNoDesc() {

        Ticket ticket = new Ticket();
        ticket.setId(52);
        ExampleMatcher exampleMatcher = ExampleMatcher
                .matching()
//                .withMatcher("shortDesc", ExampleMatcher
//                        .GenericPropertyMatchers
//                        .exact())
                .withIgnorePaths("title","createDate");

        Example<Ticket> example = Example.of(ticket, exampleMatcher);
        return ticketRepo.findAll(example);
    }
}
