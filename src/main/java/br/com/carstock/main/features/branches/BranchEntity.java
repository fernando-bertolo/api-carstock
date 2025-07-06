package br.com.carstock.main.features.branches;

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

    @Column(unique = true)
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

    public void disable(){
        this.disabledAt = LocalDateTime.now();
    }

    public boolean isDisabled(){
        return this.disabledAt != null;
    }

}
