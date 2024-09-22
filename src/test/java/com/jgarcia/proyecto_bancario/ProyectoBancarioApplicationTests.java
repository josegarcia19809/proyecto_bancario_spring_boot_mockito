package com.jgarcia.proyecto_bancario;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.jgarcia.proyecto_bancario.repositories.BancoRepository;
import com.jgarcia.proyecto_bancario.repositories.CuentaRepository;
import com.jgarcia.proyecto_bancario.services.CuentaService;
import com.jgarcia.proyecto_bancario.services.CuentaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;


@SpringBootTest
class ProyectoBancarioApplicationTests {

    CuentaRepository cuentaRepository;
    BancoRepository bancoRepository;

    CuentaService service;

    @BeforeEach
    void setUp() {
        cuentaRepository = mock(CuentaRepository.class);
        bancoRepository = mock(BancoRepository.class);
        service = new CuentaServiceImpl(cuentaRepository, bancoRepository);
    }

    @Test
    void contextLoads() {
        when(cuentaRepository.buscarPorId(1L)).thenReturn(Datos.CUENTA_001);
        when(cuentaRepository.buscarPorId(2L)).thenReturn(Datos.CUENTA_002);
        when(bancoRepository.buscarPorId(1L)).thenReturn(Datos.BANCO);

        BigDecimal saldoOrigen = service.revisarSaldo(1L);
        BigDecimal saldoDestino = service.revisarSaldo(2L);
        assertEquals("1000", saldoOrigen.toPlainString());
        assertEquals("2000", saldoDestino.toPlainString());

        // Hacemos una transferencia y dejamos las pruebas preparadas
        service.transferir(1L, 2L, new BigDecimal("100"), 1L);

        saldoOrigen = service.revisarSaldo(1L);
        saldoDestino = service.revisarSaldo(2L);

        assertEquals("900", saldoOrigen.toPlainString());
        assertEquals("2100", saldoDestino.toPlainString());
    }

}
