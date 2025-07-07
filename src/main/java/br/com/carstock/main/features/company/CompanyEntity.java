package br.com.carstock.main.features.company;

import br.com.carstock.main.features.branches.BranchEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "companies")
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private final String name;
    private final String cnpj;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<BranchEntity> branch = new HashSet<>();

    public CompanyEntity(String name, String cnpj) {
        this.name = name;
        this.cnpj = cnpj;
    }

    public CompanyEntity(UUID id, String name, String cnpj) {
        this.id = id;
        this.name = name;
        this.cnpj = cnpj;
    }

    public CompanyEntity() {
        this.id = UUID.randomUUID();
        this.name = "";
        this.cnpj = "";
    }

    public UUID getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
    
    public String getCnpj() {
        return this.cnpj;
    }
}
