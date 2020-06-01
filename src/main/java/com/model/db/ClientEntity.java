package com.model.db;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String email;

    private String phone;

    @ManyToOne
    @JoinColumn(name = "file_original_name")
    private CsvFileEntity csvFileEntity;

    public ClientEntity() {
    }

    public ClientEntity(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public CsvFileEntity getCsvFileEntity() {
        return csvFileEntity;
    }

    public void setCsvFileEntity(CsvFileEntity csvFileEntity) {
        this.csvFileEntity = csvFileEntity;
    }
}
