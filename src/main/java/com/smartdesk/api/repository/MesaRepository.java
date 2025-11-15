package com.smartdesk.api.repository;

import com.smartdesk.api.entity.Mesa;
import com.smartdesk.api.enums.StatusMesa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MesaRepository extends JpaRepository<Mesa,Long> {
    List<Mesa> findByStatusMesa(StatusMesa status);
}
