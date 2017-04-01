package com.company;

import javafx.beans.binding.Bindings;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.util.converter.NumberStringConverter;

/**
 * Created by Grant on 4/1/2017.
 */
public class View extends GridPane{
    private final Model model;

    private Label restrauntLable = new Label("Restraunt Name:");
    private Label billAmountLabel = new Label("Bill Amount:");
    private Label tipPercentageLabel = new Label("Tip Percentage:");
    private Label calculatedTipLabel = new Label("Tip Amount:");
    private Label calculatedTotalBillLabel = new Label("Bill Total w/Tip:");

    protected TextField restrauntField = new TextField();
    protected TextField billAmountField = new TextField();
    protected TextField tipPercentageField = new TextField();
    protected TextField tipAmountField = new TextField();
    protected TextField calculatedTotalBillField = new TextField();

    Button calculate = new Button("Calculate");
    Button clear = new Button("Clear");




    /**
     * Constructor
     * @param model sets instance of model
     */
    public View(Model model){
        this.model=model;
        layoutForm();
        //initFieldData();
        bindFieldsToModel();
    }


    /**
     * Set form layout
     */
    private void layoutForm() {
        this.setHgap(5);
        this.setVgap(5);

        this.add(restrauntLable,1,1);
        this.add(billAmountLabel,1,2);
        this.add(tipPercentageLabel,1,3);
        this.add(calculate,1,4);
        this.add(calculatedTipLabel,1,5);
        this.add(calculatedTotalBillLabel,1,6);
        this.add(restrauntField,2,1);
        this.add(billAmountField,2,2);
        this.add(tipPercentageField,2,3);
        this.add(clear,2,4);
        this.add(tipAmountField,2,5);
        this.add(calculatedTotalBillField,2,6);

        //tipAmountField.setDisable(true);
        //calculatedTotalBillField.setDisable(true);

        //tipAmountField.setVisible(false);
        //calculatedTotalBillField.setVisible(false);

        restrauntField.setPromptText("");
    }

    /**
     * Sets binding to model properties
     */
    public void bindFieldsToModel(){
        //restrauntField.textProperty().bindBidirectional(model.restrauntNameProperty());
        Bindings.bindBidirectional(restrauntField.textProperty(), model.restrauntNameProperty());
        //restrauntField.textProperty().bind(model.restrauntNameProperty());
        Bindings.bindBidirectional(billAmountField.textProperty(), model.billAmountProperty(), new NumberStringConverter());
        //billAmountField.textProperty().bind(Bindings.convert(model.billAmountProperty()));
        Bindings.bindBidirectional(tipPercentageField.textProperty(), model.tipPercentageProperty(), new NumberStringConverter());
        //tipPercentageField.textProperty().bind(Bindings.convert(model.tipPercentageProperty()));
        tipAmountField.textProperty().bind(Bindings.convert(model.tipPercentAmountProperty().asString("%.2f")));
        calculatedTotalBillField.textProperty().bind(Bindings.convert(model.totalBillAmountProperty().asString("%.2f")));
    }


}
