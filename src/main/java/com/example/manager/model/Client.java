package com.example.manager.model;

import jakarta.persistence.*;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    private String name;
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private Contact contact;

    public Client() {}

    public Client(String name, String lastName, Contact contact) {
        this.name = name;
        this.lastName = lastName;
        this.contact = contact;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
