package com.model.db;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "csv_file")
public class CsvFileEntity {
    @Id
    @Column(name = "original_name")
    private String originalName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_original_name")
    private List<ClientEntity> clientEntities;

    public CsvFileEntity() {
    }

    public CsvFileEntity(String originalName, List<ClientEntity> clients) {
        this.originalName = originalName;
        this.clientEntities = clients;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public List<ClientEntity> getClientEntities() {
        return clientEntities;
    }

    public void setClientEntities(List<ClientEntity> clientEntities) {
        this.clientEntities = clientEntities;
    }
}
