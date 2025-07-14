package br.com.carstock.main.features.users;

import br.com.carstock.main.features.branches.BranchEntity;
import br.com.carstock.main.features.branches.BranchService;
import br.com.carstock.main.shared.exceptions.ResourceNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BranchService branchService;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(
            UserRepository userRepository,
            BranchService branchService
    ) {
        this.userRepository = userRepository;
        this.branchService = branchService;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public UserEntity create(CreateUserDTO dto) {
        System.out.println(dto.branches());
        List<BranchEntity> branches = this.branchService.findAllById(dto.branches());

        if(branches.isEmpty()) {
            throw new ResourceNotFoundException("No branch found");
        }

        UserEntity user = new UserEntity();
        user.setEmail(dto.email());
        user.setPassword(passwordEncoder.encode(dto.password()));
        user.setRole(dto.role());

        for (BranchEntity branch : branches) {
            user.addBranch(branch);
            branch.addUsers(user);
        }

        return userRepository.save(user);
    }

    public UserEntity findByEmail(String email) {
        return this.userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
}
