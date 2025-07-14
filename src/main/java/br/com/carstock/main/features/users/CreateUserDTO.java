package br.com.carstock.main.features.users;

import java.util.List;
import java.util.UUID;

public record CreateUserDTO(
        String email,
        String password,
        Role role,
        List<UUID> branches
) {
}
