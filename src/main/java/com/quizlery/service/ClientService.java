package com.quizlery.service;

import com.quizlery.dto.ClientDto;
import com.quizlery.dto.QuizDto;
import com.quizlery.exception.EntityNotFoundException;
import com.quizlery.model.Client;
import com.quizlery.model.Quiz;
import com.quizlery.repository.ClientRepo;
import com.quizlery.service.Inter.ClientServiceInter;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientService implements ClientServiceInter {

    private final ClientRepo clientRepo;
    private final ModelMapper modelMapper;
    @Override
    public ClientDto findClientById(Integer id) {
        Optional<Client> clientOptional = clientRepo.findById(id);
        if (clientOptional.isPresent()){
            ClientDto clientDto = modelMapper.map(clientOptional.get(), ClientDto.class);
            return clientDto;
        }
        throw new EntityNotFoundException("Not Found Client");
    }

    @Override
    public List<ClientDto> findAll() {
        List<Client> clients = clientRepo.findAll();
        return clients.stream()
                .map(client -> modelMapper.map(client, ClientDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ClientDto findClientByUsername(String username) {
        Optional<Client> clientOptional = clientRepo.findByUsername(username);
        if (clientOptional.isPresent()){
            ClientDto clientDto = modelMapper.map(clientOptional.get(), ClientDto.class);
            return clientDto;
        }
        throw new EntityNotFoundException("Not Found Client");
    }

    @Override
    public ClientDto addClient(ClientDto clientDto) {
        Client client = modelMapper.map(clientDto, Client.class);
        client = clientRepo.save(client);

        return modelMapper.map(client, ClientDto.class);
    }

    @Override
    public ClientDto updateClient(ClientDto clientDto, Integer id) {
        Optional<Client> clientOptional = clientRepo.findById(id);
        if (clientOptional.isPresent()){
            Client client = modelMapper.map(clientDto, Client.class);
            client.setId(id);
            Client updated = clientRepo.save(client);
            return modelMapper.map(updated, ClientDto.class);
        }
        throw new EntityNotFoundException("Not Found Client");
    }

    @Override
    public void deleteClientById(Integer id) {
        Optional<Client> client = clientRepo.findById(id);
        if (client.isPresent()){
            clientRepo.deleteById(id);
        }else{
            throw new  EntityNotFoundException("Not Found Client");
        }
    }
}
