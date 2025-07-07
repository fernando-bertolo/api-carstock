package br.com.carstock.main.features.branches;

import br.com.carstock.main.features.addresses.AddressEntity;
import br.com.carstock.main.features.company.CompanyEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "branches")
public class BranchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String legal_name;
    private String trade_name;

    @Column(unique = true, length = 14)
    private String cnpj;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "disabled_at", nullable = true, updatable = false)
    private LocalDateTime disabledAt;


    @ManyToOne()
    @JoinColumn(name = "company_id", nullable = false)
    private CompanyEntity company;

    @ManyToOne()
    @JoinColumn(name = "address_id", nullable = false)
    private AddressEntity address;

    public void disable(){
        this.disabledAt = LocalDateTime.now();
    }

    public boolean isDisabled(){
        return this.disabledAt != null;
    }

    public BranchEntity(String legal_name, String trade_name, String cnpj, CompanyEntity company, AddressEntity address) {
        this.legal_name = legal_name;
        this.trade_name = trade_name;
        this.cnpj = cnpj;
        this.company = company;
        this.address = address;
    }

    public BranchEntity(UUID id, String legal_name, String trade_name, String cnpj, CompanyEntity company, AddressEntity address) {
        this.id = id;
        this.legal_name = legal_name;
        this.trade_name = trade_name;
        this.cnpj = cnpj;
        this.company = company;
        this.address = address;
    }

    public BranchEntity() {
        this.id = UUID.randomUUID();
        this.legal_name = "";
        this.trade_name = "";
        this.cnpj = "";
        this.company = null;
        this.address = null;
    }

    public UUID getId() {
        return id;
    }

    public String getLegal_name() {
        return legal_name;
    }

    public String getTrade_name() {
        return trade_name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public CompanyEntity getCompany() {
        return company;
    }

}
