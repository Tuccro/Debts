package com.tuccro.debts.core;

public class Human {

    private int id;
    private String name;
    private String phone;
    private String dateAdd;

    public Human(int id, String name, String phone, String dateAdd) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.dateAdd = dateAdd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(String dateAdd) {
        this.dateAdd = dateAdd;
    }
}
