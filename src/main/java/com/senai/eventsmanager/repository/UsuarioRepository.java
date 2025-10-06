package com.senai.eventsmanager.repository;


import com.senai.eventsmanager.Enum.UsuarioEnum;
import com.senai.eventsmanager.entity.Usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository  extends
        JpaRepository<Usuario, Long> {


                @Query("select u from Usuario u WHERE u.tipo = :tipo")
                List<Usuario> findByTipo(UsuarioEnum tipo);
}
