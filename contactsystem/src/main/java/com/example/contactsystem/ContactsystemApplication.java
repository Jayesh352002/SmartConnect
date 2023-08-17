package com.example.contactsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.contactsystem.entity.Contact;
import com.example.contactsystem.entity.User;
import com.google.gson.Gson;

@SpringBootApplication
public class ContactsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactsystemApplication.class, args);
		
		Contact con = new Contact("","","","","",new User());
		
		System.out.print(new Gson().toJson(con));
	}

}
