package br.com.evento.controller;

import br.com.evento.model.Participant;
import br.com.evento.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.UUID;

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

            // Gera um código único para o participante
            String uniqueCode = UUID.randomUUID().toString();
            participant.setUniqueCode(uniqueCode);

            participantService.saveParticipant(participant);

            // Redireciona para a página de confirmação com o código único
            return "redirect:/confirmation?code=" + uniqueCode;

        } catch (IllegalStateException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return showHomePage(model);
        }
    }

    @GetMapping("/confirmation")
    public String showConfirmationPage(@RequestParam("code") String code, Model model) {
        model.addAttribute("successMessage", "Inscrição feita com sucesso!");
        model.addAttribute("uniqueCode", code);
        return "confirmation";
    }
}