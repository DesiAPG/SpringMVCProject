package com.example.springmvcproject.service;

import com.example.springmvcproject.dto.ClubDTO;
import com.example.springmvcproject.models.Club;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClubService {
    List<ClubDTO> findAllClubs();

    Club save(Club club);

    ClubDTO findById(long clubId);

    void updateClub(ClubDTO clubDTO);
}
