package com.example.manager.controller;

import com.example.manager.model.Contact;
import com.example.manager.service.ContactService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @PostMapping
    public Contact createClient(@RequestBody Contact contact) {
        return contactService.createContact(contact);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        contactService.deleteContact(id);
    }

    @PutMapping("/{id}")
    public Contact updateClient(@PathVariable Long id, @RequestBody Contact updatedContact) {
        return contactService.updateContact(id, updatedContact);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClientById(@PathVariable Long id) {
        Optional<Contact> contact = contactService.getContactById(id);
        if (contact.isPresent()) {
            return ResponseEntity.ok(contact.get());
        } else {
            return ResponseEntity.status(404).body("Contact ID "+id+" doesnt exist");
        }
    }
}
