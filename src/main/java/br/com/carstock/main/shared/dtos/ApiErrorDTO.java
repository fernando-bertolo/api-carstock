package br.com.carstock.main.shared.dtos;

import java.time.LocalDateTime;

public record ApiErrorDTO(int statusCode, String message, LocalDateTime timestamp) {
}
