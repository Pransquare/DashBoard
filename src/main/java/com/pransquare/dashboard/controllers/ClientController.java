package com.pransquare.dashboard.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pransquare.dashboard.entities.ClientEntity;
import com.pransquare.dashboard.exceptions.ResourceNotFoundException;
import com.pransquare.dashboard.models.ClientModel;
import com.pransquare.dashboard.services.ClientService;

@RestController
@RequestMapping("/Pransquare/MasterConfiguration/clients")
public class ClientController {

    private static final Logger logger = LoggerFactory.getLogger(LeaveTypeController.class);

    @Autowired
    private ClientService clientService;

    @GetMapping("/getAllClients")
    public ResponseEntity<List<ClientEntity>> getAllClients() {
        try {
            return ResponseEntity.ok(clientService.getAllClients());
        } catch (Exception e) {
            logger.error("Error getting all clients: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/dedupeClient/{clientCode}")
    public ResponseEntity<ClientEntity> dedupeCheckWithClientCode(@PathVariable String clientCode) {
        try {
            ClientEntity clientEntity = clientService.dedupeCheckWithClientCode(clientCode);
            if (clientEntity != null) {
                return ResponseEntity.ok(clientEntity);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            logger.error("Error checking dedupe for client code: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/createOrUpdateClient")
    public ResponseEntity<ClientEntity> createOrUpdateClient(@RequestBody ClientModel clientModel) {
        try {
            ClientEntity clientEntity = clientService.createOrUpdateClient(clientModel);
            if (clientModel.getClientId() == null) {
                return ResponseEntity.status(HttpStatus.CREATED).body(clientEntity);
            } else {
                return ResponseEntity.ok(clientEntity);
            }
        } catch (Exception e) {
            logger.error("Error creating or updating client: ", e);
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    @PostMapping("/deleteClient/{clientId}")
    public ResponseEntity<ClientEntity> deleteClient(@PathVariable Integer clientId) {
        try {
            return ResponseEntity.ok(clientService.deleteClient(clientId));
        } catch (Exception e) {
            logger.error("Error deleting client: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}