package com.seatecnologia.processos_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seatecnologia.processos_api.models.Processo;

public interface ProcessoRepository extends JpaRepository<Processo, Long>{

}
