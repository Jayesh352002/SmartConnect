package com.example.contactsystem.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.contactsystem.entity.Contact;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;


@Repository
public class ContactRepo {

	@Autowired
	private EntityManager entityManager;
	
	@Transactional
	public void save(Contact contact) {
        entityManager.persist(contact);
    }
	
	@Transactional
	public Contact update(Contact contact) {
	    return entityManager.merge(contact);
	}
}
