package com.app.restapi.databases;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import com.app.restapi.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
