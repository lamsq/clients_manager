package com.example.manager;

import com.example.manager.model.Client;
import com.example.manager.model.Contact;
import com.example.manager.service.ClientService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ManagerApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Autowired
    private ClientService clientService;

    @Test
    void contextLoads() {
        assertThat(clientService).isNotNull();
    }

    @Test
    void testCreateClient() {
        Contact con = new Contact("88005553535", "test@test.ru");
        Client cl = new Client("Test", "Ttest", con);

        ResponseEntity<Client> r = restTemplate.postForEntity(
                "http://localhost:"+port+"/api/clients", cl, Client.class
        );

        assertThat(r.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(r.getBody()).isNotNull();
        assertThat(r.getBody().getName()).isEqualTo("Test");
    }
}
