package com.geraxiquin.restapi.dao

import com.geraxiquin.restapi.model.Paciente
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PacienteRepository : JpaRepository<Paciente, Int>