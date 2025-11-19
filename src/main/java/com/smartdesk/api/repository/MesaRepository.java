package com.smartdesk.api.repository;

import com.smartdesk.api.entity.Mesa;
import com.smartdesk.api.enums.StatusMesa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface MesaRepository extends JpaRepository<Mesa,Long> {
    @Query("SELECT m FROM Mesa m WHERE m.statusMesa = com.smartdesk.api.enums.StatusMesa.DISPONIVEL " +
            "AND m.id NOT IN (" +
            "    SELECT r.mesa.id FROM Reserva r " +
            "    WHERE r.dataInicio < :dataFim AND r.dataFim > :dataInicio" +
            ")")
    Page<Mesa> findMesasDisponiveis(
            @Param("dataInicio") LocalDateTime dataInicio,
            @Param("dataFim") LocalDateTime dataFim,
            Pageable pageable
    );
}
