package com.pransquare.dashboard.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pransquare.dashboard.entities.ClientEntity;
import com.pransquare.dashboard.exceptions.ResourceNotFoundException;
import com.pransquare.dashboard.models.ClientModel;
import com.pransquare.dashboard.repositories.ClientRepository;
import com.pransquare.dashboard.utils.IntegerUtils;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<ClientEntity> getAllClients() {
        return clientRepository.findAllByStatusNot("deleted");
    }

    public ClientEntity dedupeCheckWithClientCode(String clientCode) {
        return clientRepository.findByClientCodeAndStatusNot(clientCode, "deleted");
    }

    public ClientEntity createOrUpdateClient(ClientModel clientModel) {
        try {
            ClientEntity clientEntity;
            if (!IntegerUtils.isNotNull(clientModel.getClientId())) {
                List<ClientEntity> clientEntities = clientRepository
                        .findByClientNameAndStatusNot(clientModel.getClientName(), "deleted");
                if (!clientEntities.isEmpty()) {
                    throw new ResourceNotFoundException("Client Name already exists");
                }
                clientEntity = new ClientEntity();
                clientEntity.setStatus("active");
                clientEntity.setCreatedBy(clientModel.getUser());
                clientEntity.setCreatedDate(LocalDateTime.now());
            } else {
                Optional<ClientEntity> existingClient = clientRepository.findById(clientModel.getClientId());
                clientEntity = existingClient.get();
                clientEntity.setModifiedBy(clientModel.getUser());
                clientEntity.setModifiedDate(LocalDateTime.now());
            }
            clientEntity.setClientCode(clientModel.getClientCode());
            clientEntity.setClientName(clientModel.getClientName());
            clientEntity.setAddressLine1(clientModel.getAddressLine1());
            clientEntity.setAddressLine2(clientModel.getAddressLine2());
            clientEntity.setAddressLine3(clientModel.getAddressLine3());
            clientEntity.setCountry(clientModel.getCountry());
            clientEntity.setState(clientModel.getState());
            clientEntity.setPostalCode(clientModel.getPostalCode());
            return clientRepository.save(clientEntity);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public ClientEntity deleteClient(Integer clientId) {
        if (!IntegerUtils.isNotNull(clientId)) {
            throw new IllegalArgumentException("Leave type ID cannot be null");
        }
        ClientEntity clientEntity = clientRepository.findById(clientId).orElseThrow(() -> new IllegalArgumentException(
                "Leave type with ID " + clientId + " not found"));
        clientEntity.setStatus("deleted");
        return clientRepository.save(clientEntity);
    }
}