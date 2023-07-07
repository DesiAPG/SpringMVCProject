package com.example.springmvcproject.service;

import com.example.springmvcproject.dto.ClubDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClubService {
    List<ClubDTO> findAllClubs();
}
