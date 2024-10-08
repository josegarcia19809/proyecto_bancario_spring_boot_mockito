package com.jgarcia.proyecto_bancario;

import com.jgarcia.proyecto_bancario.models.Banco;
import com.jgarcia.proyecto_bancario.models.Cuenta;

import java.math.BigDecimal;

public class Datos {
    public static final Cuenta CUENTA_001 = new Cuenta(1L, "José", new BigDecimal("1000"));
    public static final Cuenta CUENTA_002 = new Cuenta(2L, "Rox", new BigDecimal("2000"));
    public static final Banco BANCO = new Banco(1L, "El banco financiero", 0);
}
