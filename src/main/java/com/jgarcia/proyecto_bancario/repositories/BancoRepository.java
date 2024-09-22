package com.jgarcia.proyecto_bancario.repositories;

import com.jgarcia.proyecto_bancario.models.Banco;

import java.util.List;

public interface BancoRepository {
    List<Banco> obtenerTodos();

    Banco buscarPorId(Long id);

    void actualizar(Banco banco);
}
