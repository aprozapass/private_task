package com.model.csv;

import com.opencsv.bean.CsvBindByPosition;

public class ClientCsvBean implements CsvBean{
    @CsvBindByPosition(position = 0)
    private String name;
    @CsvBindByPosition(position = 1)
    private String email;
    @CsvBindByPosition(position = 2)
    private String phone;

    public ClientCsvBean() {
    }

    public ClientCsvBean(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
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
}
