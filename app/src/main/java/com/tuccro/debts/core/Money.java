package com.tuccro.debts.core;

public class Money {

    int id;
    int idHuman;
    int idCurrency;
    double sum;
    String note;
    String dateAdd;
    String dateBegin;
    String dateEnd;
    int idStatus;

    public Money(int id, int idHuman, int idCurrency, double sum, String note, String dateAdd, String dateBegin, String dateEnd, int idStatus) {
        this.id = id;
        this.idHuman = idHuman;
        this.idCurrency = idCurrency;
        this.sum = sum;
        this.note = note;
        this.dateAdd = dateAdd;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.idStatus = idStatus;
    }

    public Money(int idStatus, String dateBegin, String dateAdd, String note, double sum, int idCurrency, int idHuman, int id) {
        this.idStatus = idStatus;
        this.dateBegin = dateBegin;
        this.dateAdd = dateAdd;
        this.note = note;
        this.sum = sum;
        this.idCurrency = idCurrency;
        this.idHuman = idHuman;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdHuman() {
        return idHuman;
    }

    public void setIdHuman(int idHuman) {
        this.idHuman = idHuman;
    }

    public int getIdCurrency() {
        return idCurrency;
    }

    public void setIdCurrency(int idCurrency) {
        this.idCurrency = idCurrency;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(String dateAdd) {
        this.dateAdd = dateAdd;
    }

    public String getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(String dateBegin) {
        this.dateBegin = dateBegin;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }
}
