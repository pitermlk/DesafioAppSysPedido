package br.com.evento.repository;


import br.com.evento.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    Optional<Participant> findByEmail(String email);
}