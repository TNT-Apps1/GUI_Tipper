package com.company;

/**
 * Created by Grant on 4/1/2017.
 */
public class Controller {

    private final Model model;
    private final View view;

    /**
     * Constructor
     * @param model Model class instance
     * @param view View Class instance
     */
    public Controller(Model model, View view){
        this.model=model;
        this.view=view;
        attatchEvents();
    }


    /**
     * Events handled utilizing lamda expressions
     */
    private void attatchEvents() {
        view.calculate.setOnAction(e -> calculateData());
        view.clear.setOnAction(e -> clearData());
    }


    /**
     * Gets total bill amount through binding of data
     */
    private void calculateData(){

        model.getTotalBillAmount();

    }


    /**
     * clears data
     */
    private void clearData() {
        view.restrauntField.setText("");
        view.billAmountField.setText("0.0");
        view.tipPercentageField.setText("0.0");
        model.getTotalBillAmount();


    }


}
