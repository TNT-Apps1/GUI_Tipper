package com.company;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Grant on 4/1/2017.
 */
public class Model {

    private final StringProperty restrauntName = new SimpleStringProperty(this, "restrauntName", null);
    private final DoubleProperty billAmount = new SimpleDoubleProperty(this, "billAmount", 0D);
    private final DoubleProperty tipPercentage = new SimpleDoubleProperty(this, "tipPercentage", 0D);
    private final DoubleProperty tipPercentAmount = new SimpleDoubleProperty(this, "tipPercentAmount", 0D);
    private final DoubleProperty totalBillAmount = new SimpleDoubleProperty(this, "totalBillAmount", 0D);


    /**
     * Default Constructor
     */
    public Model() {
    }

    public Model(String restrauntName, Double billAmount, Double tipPercentage) {
        this.restrauntName.set(restrauntName);
        this.billAmount.set(billAmount);
        this.tipPercentage.set(tipPercentage);
    }

    /**
     * Get tip percent amount
     * @return tip percent amount binded
     */
    public double getTipPercentAmount() {
        return tipPercentAmount.get();
    }

    public DoubleProperty tipPercentAmountProperty() {
        return tipPercentAmount;
    }

    public void setTipPercentAmount(double tipPercentAmount) {
        this.tipPercentAmount.set(tipPercentAmount);
    }

    public DoubleProperty totalBillAmountProperty() {
        return totalBillAmount;
    }

    public void setTotalBillAmount(double totalBillAmount) {
        this.totalBillAmount.set(totalBillAmount);
    }



    public String getRestrauntName() {
        return restrauntName.get();
    }

    public StringProperty restrauntNameProperty() {
        return restrauntName;
    }

    public void setRestrauntName(String restrauntName) {
        this.restrauntName.set(restrauntName);
    }


    public double getBillAmount() {
        return billAmount.get();
    }

    public DoubleProperty billAmountProperty() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount.set(billAmount);
    }


    public double getTipPercentage() {
        return tipPercentage.get();
    }

    public DoubleProperty tipPercentageProperty() {
        return tipPercentage;
    }

    public void setTipPercentage(double tipPercentage) {
        this.tipPercentage.set(tipPercentage);
    }



    public Double getTipAmount(){

        tipPercentAmount.set((getBillAmount()*getTipPercentage())/100);
        return getBillAmount()*getTipPercentage();
    }

    public Double getTotalBillAmount(){
        totalBillAmount.set((getBillAmount()+(getTipAmount()/100)));
        return getBillAmount()+getTipAmount();
    }
}
