package br.com.evento.service;

import br.com.evento.model.Participant;
import br.com.evento.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;

    public List<Participant> getAllParticipants() {
        return participantRepository.findAll();
    }

    public Participant saveParticipant(Participant participant) {
        Optional<Participant> existingParticipant = participantRepository.findByEmail(participant.getEmail());
        if (existingParticipant.isPresent()) {
            throw new IllegalStateException("Email already registered.");
        }
        return participantRepository.save(participant);
    }

    public Optional<Participant> findByEmailOrPhoneNumber(String email, String phoneNumber) {
        // Procura um participante na base de dados pelo email OU pelo telefone
        return participantRepository.findByEmail(email);
    }

    public long getDaysUntilEvent(LocalDate eventDate) {
        return LocalDate.now().until(eventDate).getDays();
    }
}