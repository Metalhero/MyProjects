package io.portfolio.application.service;

import io.portfolio.application.domain.Client;
import io.portfolio.application.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public void save(Client client) {
        clientRepository.save(client);
    }

    public Client findById(Long id) {
        return clientRepository.findById(id).get();
    }

    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

}