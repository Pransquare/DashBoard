package com.pransquare.dashboard.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pransquare.dashboard.entities.ClientEntity;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Integer> {

    ClientEntity findByClientCodeAndStatusNot(String clientCode, String status);

    List<ClientEntity> findByClientNameAndStatusNot(String clientName, String status);

    List<ClientEntity> findAllByStatusNot(String string);
}