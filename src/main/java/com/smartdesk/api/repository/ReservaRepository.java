package com.smartdesk.api.repository;

import com.smartdesk.api.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    @Query("SELECT r FROM Reserva r WHERE r.mesa.id = :idMesa " +
            "AND r.dataInicio < :dataFim " +
            "AND r.dataFim > :dataInicio")
    List<Reserva> findConflitosDeHorario(
            @Param("idMesa") Long idMesa,
            @Param("dataInicio") LocalDateTime dataInicio,
            @Param("dataFim") LocalDateTime dataFim
    );
}
