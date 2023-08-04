package com.quizlery.controller;

import com.quizlery.dto.ClientDto;
import com.quizlery.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/id/{id}")
    public ClientDto findClientById(@PathVariable Integer id) {
        return clientService.findClientById(id);
    }

    @GetMapping
    public List<ClientDto> findAll() {
        return clientService.findAll();
    }

    @GetMapping("/username/{username}")
    public ClientDto findClientByUsername(@PathVariable String username) {
        return clientService.findClientByUsername(username);
    }

    @PostMapping
    public ClientDto addClient(@RequestBody ClientDto clientDto) {
        return clientService.addClient(clientDto);
    }

    @PutMapping("/id/{id}")
    public ClientDto updateClient(@RequestBody ClientDto clientDto, @PathVariable Integer id) {
        return clientService.updateClient(clientDto, id);
    }

    @DeleteMapping("/id/{id}")
    public void deleteClientById(@PathVariable Integer id) {
        clientService.deleteClientById(id);
    }
}
