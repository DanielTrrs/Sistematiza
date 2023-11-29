package com.sistematizacao.entregadores.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EntregadoresDto( @NotBlank String nome,
		@NotNull String cpf,
		@NotNull int capacidade) {
}
