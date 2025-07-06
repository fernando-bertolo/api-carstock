package br.com.carstock.main.features.company;

import br.com.carstock.main.features.branches.BranchEntity;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "companies")
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private final String name;
    private final String cnpj;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<BranchEntity> branch = new HashSet<>();

    public CompanyEntity(String name, String cnpj) {
        this.name = name;
        this.cnpj = cnpj;
    }

    public CompanyEntity(Long id, String name, String cnpj) {
        this.id = id;
        this.name = name;
        this.cnpj = cnpj;
    }

    public CompanyEntity() {
        this.id = 0L;
        this.name = "";
        this.cnpj = "";
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
    
    public String getCnpj() {
        return this.cnpj;
    }
}
