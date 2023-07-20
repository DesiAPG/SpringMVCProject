package com.example.springmvcproject.controller;

import com.example.springmvcproject.dto.ClubDTO;
import com.example.springmvcproject.models.Club;
import com.example.springmvcproject.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Controller

public class ClubController {
    private ClubService clubService;

    @Autowired
    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping("/clubs")
    public String listClubs(Model model) {
        List<ClubDTO> clubs = clubService.findAllClubs();
        model.addAttribute("clubs", clubs);
        return "clubs-list";
    }

    @GetMapping("/clubs/new")
    public String createClubForm(Model model) {
        Club club = new Club();
        model.addAttribute("club", club);
        return "club-create";
    }

    @PostMapping("/clubs/new")
    public String saveClub(@ModelAttribute("club") Club club) {
        clubService.save(club);
        return "redirect:/clubs";
    }

    @GetMapping("/clubs/{clubId}/edit")
    public String editClub(@PathVariable("clubId") long clubId, Model model) {
        ClubDTO clubDTO = clubService.findById(clubId);
        model.addAttribute("club", clubDTO);
        return "clubs-edit";
    }

    @PostMapping("/clubs/{clubId}/edit")
    public String updateClub(@PathVariable("clubId") long clubId, @ModelAttribute("club") ClubDTO clubDTO) {
        clubDTO.setId(clubId);
        clubService.updateClub(clubDTO);
        return "redirect:/clubs";
    }
}
