package com.tuccro.debts.core;

public class Money {

    int id;
    int idHuman;
    int idCurrency;
    double sum;
    String note;
    long dateAdd;
    long dateBegin;
    long dateEnd;

    public Money(int id, int idHuman, int idCurrency, double sum, String note, long dateAdd, long dateBegin, long dateEnd) {
        this.id = id;
        this.idHuman = idHuman;
        this.idCurrency = idCurrency;
        this.sum = sum;
        this.note = note;
        this.dateAdd = dateAdd;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
    }

    public Money(int id, int idHuman, int idCurrency, double sum, String note, long dateAdd, long dateBegin) {
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

    public long getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(long dateAdd) {
        this.dateAdd = dateAdd;
    }

    public long getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(long dateBegin) {
        this.dateBegin = dateBegin;
    }

    public long getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(long dateEnd) {
        this.dateEnd = dateEnd;
    }
}
