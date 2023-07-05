package com.example.springmvcproject.service;

import com.example.springmvcproject.dto.ClubDTO;

import java.util.List;

public interface ClubService {
    List<ClubDTO> findAllClubs();
}
