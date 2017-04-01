package com.company;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUITipperApp extends Application{



    @Override
    public void start(Stage primaryStage) throws Exception {
        //Model model = new Model("McDonalds", 100.25, 20.00);
        Model model = new Model();
        View view = new View(model);
        Controller controller = new Controller(model, view);


        Scene scene = new Scene(view);


        view.setStyle("-fx-padding: 10;" +
        "-fx-border-style: solid inside;" +
        "-fx-border-width: 2;" +
        "-fx-border-insets: 5;" +
        "-fx-border-color: blue;");

        primaryStage.setScene(scene);
        primaryStage.setTitle("Thompson Tipper App");
        primaryStage.show();

    }
}
