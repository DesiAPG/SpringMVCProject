package com.example.springmvcproject.repository;

import com.example.springmvcproject.models.Club;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<Club,Long> {
}
