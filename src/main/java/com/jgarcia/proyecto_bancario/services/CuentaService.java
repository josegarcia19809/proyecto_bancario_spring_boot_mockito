package com.jgarcia.proyecto_bancario.services;

import com.jgarcia.proyecto_bancario.models.Cuenta;

import java.math.BigDecimal;

public interface CuentaService {
    Cuenta buscarPorId(Long id);

    int revisarTotalTransferencias(Long bancoId);

    BigDecimal revisarSaldo(Long cuentaId);

    void transferir(Long numCuentaOrigen, Long numCuentaDestino,
                    BigDecimal monto, Long bancoId);

}
