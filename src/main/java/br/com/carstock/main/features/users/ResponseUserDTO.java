package br.com.carstock.main.features.users;

import br.com.carstock.main.features.branches.BranchEntity;
import br.com.carstock.main.features.users.Role;
import br.com.carstock.main.features.users.UserEntity;

import java.util.List;
import java.util.UUID;

public record ResponseUserDTO (
        UUID id,
        String email,
        Role role,
        List<UUID> branchIds
) {
    public static ResponseUserDTO fromEntity(UserEntity user) {
        List<UUID> branchIds = user.getBranches()
                .stream()
                .map(BranchEntity::getId)
                .toList();

        return new ResponseUserDTO(
                user.getId(),
                user.getEmail(),
                user.getRole(),
                branchIds
        );
    }
}
