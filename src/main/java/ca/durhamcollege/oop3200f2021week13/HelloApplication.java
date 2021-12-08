package ca.durhamcollege.oop3200f2021week13;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
        // step 1 - instantiate controls
        Label helloLabel = new Label("Hello, World!");
        Label goodbyeLabel = new Label("Good Bye!");

        Label helloLabel1 = new Label("Hello, World!");
        Label goodbyeLabel1 = new Label("Good Bye!");

        Button clickMeButton = new Button("Click Me!");


        // step 2 - instantiate containers
        //HBox hbox = new HBox(); // like a Horizontal Stack (side by side) - Column Data

        //hbox.getChildren().add(helloLabel); // similar to an addChild function
        //hbox.getChildren().add(goodbyeLabel);

        GridPane row0 = BuildRow0(helloLabel, goodbyeLabel);

        GridPane row1 = BuildRow1(helloLabel1, goodbyeLabel1);

        GridPane row2 = BuildRow2(clickMeButton);


        VBox vbox = new VBox(row0, row1, row2); // like a Vertical Stack (like a vertical list ) - Row Data
        vbox.setStyle("-fx-border-color: red; -fx-border-width: 1px; -fx-font-family: Consolas");

        // Step 3 - setup and configure the Scene (Screen)
        Scene scene = new Scene(vbox, 640, 480);

        // Step 4 - setup the stage (Window)
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    private GridPane BuildRow0(Label helloLabel, Label goodbyeLabel) {
        GridPane row = new GridPane();
        row.setStyle("-fx-border-color: green; " +
                     "-fx-border-width: 1px; " +
                     "-fx-font-family: Garamond;" +
                     "-fx-font-size: 20px");

        helloLabel.setStyle("-fx-font-family: 'Arial Black'; -fx-font-weight: bold; -fx-text-fill: green;");

        ColumnConstraints column0 = new ColumnConstraints();
        column0.setPercentWidth(17); // two columns - each column is 8%
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(33); // four columns
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(33); // four columns
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPercentWidth(17); // two columns
        row.getColumnConstraints().addAll(column0, column1, column2, column3);

        HBox hbox = new HBox(helloLabel);
        hbox.setAlignment(Pos.CENTER);
        hbox.setStyle("-fx-border-color: black; -fx-border-width: 1px;");

        row.add(hbox, 1, 0);
        row.add(goodbyeLabel, 2, 0);

        /*var firstNode = row.getChildren().get(0);
        firstNode.setVisible(false);*/
        return row;
    }

    private GridPane BuildRow1(Label helloLabel, Label goodbyeLabel)
    {
        GridPane row = new GridPane();
        row.setStyle("-fx-border-color: blue; -fx-border-width: 1px");

        helloLabel.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                helloLabel.setStyle("-fx-font-weight: bold");
            }
        });

        helloLabel.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                helloLabel.setStyle("-fx-font-weight: normal");
            }
        });

        ColumnConstraints column0 = new ColumnConstraints();
        column0.setPercentWidth(9); // two columns - each column is 8%
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(49); // four columns
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(25); // four columns
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPercentWidth(17); // two columns
        row.getColumnConstraints().addAll(column0, column1, column2, column3);

        row.add(helloLabel, 1, 0);
        row.add(goodbyeLabel, 2, 0);
        return row;
    }

    private GridPane BuildRow2(Button button)
    {
        GridPane row = new GridPane();

        ColumnConstraints column0 = new ColumnConstraints();
        column0.setPercentWidth(17); // two columns - each column is 8%
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(33); // four columns
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(33); // four columns
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPercentWidth(17); // two columns
        row.getColumnConstraints().addAll(column0, column1, column2, column3);

        button.setOnAction(new EventHandler()
        {
            @Override
            public void handle(Event event)
            {
                System.out.println("ClickMeButton Clicked!!!");
            }
        });

        button.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                button.setStyle("-fx-opacity: 0.5");
            }
        });

        button.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                button.setStyle("-fx-opacity: 1.0");
            }
        });

        row.add(button, 2, 0);
        return row;
    }



    public static void main(String[] args)
    {
        launch();
    }
}