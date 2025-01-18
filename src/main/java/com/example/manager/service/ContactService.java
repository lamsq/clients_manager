package com.example.manager.service;

import com.example.manager.model.Contact;
import com.example.manager.repository.ContactRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public void deleteContact(Long contactId) {
        contactRepository.deleteById(contactId);
    }

    @Transactional
    public Contact updateContact(Long contactId, Contact updatedContact) {
        return contactRepository.findById(contactId)
                .map(contact -> {
                    if (updatedContact.getPhone() != null)
                        contact.setPhone(updatedContact.getPhone());
                    if (updatedContact.getEmail() != null)
                        contact.setEmail(updatedContact.getEmail());
                    return contactRepository.save(contact);
                }).orElseThrow(() -> new IllegalArgumentException("Contact ID "+contactId+" doesnt exist"));
    }

    public Optional<Contact> getContactById(Long contactId) {
        return contactRepository.findById(contactId);
    }
}
