package com.example.labclients.lab_clients.infrastructure.rest;

import com.example.labclients.lab_clients.application.dto.ClientDTO;
import com.example.labclients.lab_clients.application.services.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<ClientDTO> getAll() {
        return clientService.getAllClients();
    }

    @PostMapping
    public ClientDTO create(@RequestBody ClientDTO client) {
        return clientService.createClient(client);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}
