package com.quizlery.service.Inter;

import com.quizlery.dto.ClientDto;

import java.util.List;

public interface ClientServiceInter {

    ClientDto findClientById(Integer id);
    List<ClientDto> findAll();
    ClientDto findClientByUsername(String username);
    ClientDto addClient(ClientDto clientDto);
    ClientDto updateClient(ClientDto clientDto, Integer id);
    void deleteClientById(Integer id);
}
