package com.jgarcia.proyecto_bancario.services;

import com.jgarcia.proyecto_bancario.models.Banco;
import com.jgarcia.proyecto_bancario.models.Cuenta;
import com.jgarcia.proyecto_bancario.repositories.BancoRepository;
import com.jgarcia.proyecto_bancario.repositories.CuentaRepository;

import java.math.BigDecimal;

public class CuentaServiceImpl implements CuentaService {
    private CuentaRepository cuentaRepository;
    private BancoRepository bancoRepository;

    public CuentaServiceImpl(CuentaRepository cuentaRepository, BancoRepository bancoRepository) {
        this.cuentaRepository = cuentaRepository;
        this.bancoRepository = bancoRepository;
    }

    @Override
    public Cuenta buscarPorId(Long id) {
        return cuentaRepository.buscarPorId(id);
    }

    @Override
    public int revisarTotalTransferencias(Long bancoId) {
        Banco banco = bancoRepository.buscarPorId(bancoId);
        return banco.getTotalTransferencias();
    }

    @Override
    public BigDecimal revisarSaldo(Long cuentaId) {
        Cuenta cuenta = cuentaRepository.buscarPorId(cuentaId);
        return cuenta.getSaldo();
    }

    @Override
    public void transferir(Long numCuentaOrigen, Long numCuentaDestino, BigDecimal monto,
                           Long bancoId) {
        Banco banco = bancoRepository.buscarPorId(bancoId);
        int totalTransferencias = banco.getTotalTransferencias();
        banco.setTotalTransferencias(++totalTransferencias);
        bancoRepository.actualizar(banco);

        Cuenta cuentaOrigen = cuentaRepository.buscarPorId(numCuentaOrigen);
        cuentaOrigen.debito(monto);
        cuentaRepository.actualizar(cuentaOrigen);

        Cuenta cuentaDestino = cuentaRepository.buscarPorId(numCuentaDestino);
        cuentaDestino.credito(monto);
        cuentaRepository.actualizar(cuentaDestino);
    }
}
