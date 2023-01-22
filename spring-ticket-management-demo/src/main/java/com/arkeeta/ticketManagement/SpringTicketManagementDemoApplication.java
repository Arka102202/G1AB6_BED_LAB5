package com.arkeeta.ticketManagement;

import com.arkeeta.ticketManagement.service.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.yaml.snakeyaml.comments.CommentLine;

@SpringBootApplication
public class SpringTicketManagementDemoApplication{
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SpringTicketManagementDemoApplication.class);
		app.run(args);
	}

}
