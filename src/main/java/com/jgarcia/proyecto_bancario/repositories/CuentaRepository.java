package com.jgarcia.proyecto_bancario.repositories;

import com.jgarcia.proyecto_bancario.models.Cuenta;

import java.util.List;

public interface CuentaRepository {
    List<Cuenta> obtenerTodos();

    Cuenta buscarPorId(Long id);

    void actualizar(Cuenta cuenta);
}
