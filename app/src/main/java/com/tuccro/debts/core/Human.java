package com.tuccro.debts.core;

public class Human {

    private int id;
    private String name;
    private String phone;
    private long dateAdd;

    public Human(int id, String name, String phone, long dateAdd) {
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

    public long getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(long dateAdd) {
        this.dateAdd = dateAdd;
    }
}
