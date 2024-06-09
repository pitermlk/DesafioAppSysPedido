package br.com.evento.controller;

import br.com.evento.model.Participant;
import br.com.evento.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;

    @GetMapping("/")
    public String showHomePage(Model model) {
        LocalDate eventDate = LocalDate.of(2024, 12, 31); // Data do evento
        long daysUntilEvent = participantService.getDaysUntilEvent(eventDate);
        model.addAttribute("daysUntilEvent", daysUntilEvent);
        model.addAttribute("participant", new Participant());
        return "index";
    }

    @PostMapping("/register")
    public String registerParticipant(@ModelAttribute Participant participant, Model model) {
        try {
            participant.setEventDate(LocalDate.of(2024, 12, 31)); // Data do evento
            participantService.saveParticipant(participant);
            model.addAttribute("successMessage", "Registration successful!");
        } catch (IllegalStateException e) {
            model.addAttribute("errorMessage", e.getMessage());
        }
        return showHomePage(model);
    }
}