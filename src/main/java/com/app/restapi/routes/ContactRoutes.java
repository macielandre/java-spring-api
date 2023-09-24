package com.app.restapi.routes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.restapi.databases.ContactRepository;
import com.app.restapi.entity.Contact;

@RestController
@RequestMapping("/contact")
public class ContactRoutes {
    @Autowired
    private ContactRepository repository;

    @GetMapping
    public List<Contact> listAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public List<Contact> list() {
        return repository.findAll();
    }

    @PostMapping
    public void create(@RequestBody Contact contact) {
        repository.save(contact);
    }

    @PatchMapping("/{id}")
    public void update(@RequestParam Long id, @RequestBody Contact contact) {
        repository.save(contact);
    }

    @DeleteMapping("/{id}")
    public void delete(@RequestParam Long id) {
        repository.deleteById(id);
    }
}
