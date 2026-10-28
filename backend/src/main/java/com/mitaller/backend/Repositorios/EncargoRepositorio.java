package com.mitaller.backend.Repositorios;

import com.mitaller.backend.Entidades.Encargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncargoRepositorio extends JpaRepository<Encargo, Long> {
}