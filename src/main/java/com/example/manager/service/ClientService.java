package com.example.manager.service;

import com.example.manager.model.Client;
import com.example.manager.model.Contact;
import com.example.manager.repository.ClientRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public void deleteClient(Long clientId) {
        clientRepository.deleteById(clientId);
    }

    @Transactional
    public Client updateClient(Long clientId, Client updatedClient) {
        return clientRepository.findById(clientId)
                .map(client -> {
                    if (updatedClient.getName() != null)
                        client.setName(updatedClient.getName());
                    if (updatedClient.getLastName() != null)
                        client.setLastName(updatedClient.getLastName());
                    if (updatedClient.getContact() != null) {
                        Contact updatedContact = updatedClient.getContact();
                        if (client.getContact() == null)
                            client.setContact(new Contact());
                        if (updatedContact.getPhone() != null)
                            client.getContact().setPhone(updatedContact.getPhone());
                        if (updatedContact.getEmail() != null)
                            client.getContact().setEmail(updatedContact.getEmail());
                    }
                    return clientRepository.save(client);
                }).orElseThrow(() -> new IllegalArgumentException("Client ID "+clientId+" doesnt exist"));
    }

    public Optional<Client> getClientById(Long clientId) {
        return clientRepository.findById(clientId);
    }
}
