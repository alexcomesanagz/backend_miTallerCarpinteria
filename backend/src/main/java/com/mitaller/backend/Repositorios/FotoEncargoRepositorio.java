package com.mitaller.backend.Repositorios;

import com.mitaller.backend.Entidades.FotoEncargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotoEncargoRepositorio extends JpaRepository<FotoEncargo, Long> {
}