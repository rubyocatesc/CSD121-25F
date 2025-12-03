package lab6;

import javafx.application.Application; // extend application
import javafx.event.EventHandler; // implement EventHandler
import javafx.event.ActionEvent; // to use ActionEvent in handle()
import javafx.geometry.Insets; // to add spacing around the box
import javafx.geometry.Pos; // to center the contents of the box. Pos.CENTER
import javafx.scene.Scene; // to create scene
import javafx.scene.layout.StackPane; // used to stack the title and the rectangle.
import javafx.scene.layout.VBox; //to contain all the components in vertical box layout
import javafx.scene.paint.Color; // apply colors to components and draw borders
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle; //shape class to create rectangle.

/** Basic Calculator application using JavaFX
 * User will enter two numbers and choose an operation (+, -, *, /)*/
public class Main extends Application {
    private TextField firstNumber; // this allows user to input a text  the
    private TextField secondNumber; // this allows user to input a text
    private Label result;

/** Starts the application and creates the GUI
 * @param stage the stage to display the GUI on*/

    @Override
    public void start(Stage stage) {
        VBox root = new VBox(10); //create a vertical box and give it a spacing of 10 pixels
        root.setPadding(new Insets(20)); //add spacing around the box, 20 pixels on all sides
        root.setAlignment(Pos.CENTER); //center the contents of the box

        Rectangle titleBackground = new Rectangle(350, 70);
        titleBackground.setFill(Color.LIGHTBLUE); //fill LightBlue inside the rectangle
        titleBackground.setStroke(Color.BLACK); //draw a black border around the rectangle
        titleBackground.setStrokeWidth(3); //make the border thicker
        titleBackground.setArcWidth(15); //make the corners rounded
        titleBackground.setArcHeight(15); //make the corners rounded

        Label title = new Label("Basic Calculator"); //Title
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: darkblue;"); //make the title larger and bold

        StackPane titlePane = new StackPane(); //create a pane to stack the title and the rectangle
        titlePane.getChildren().addAll(titleBackground, title); //add the rectangle first to be the background and then title

        firstNumber = new TextField(); //create a text field for the first number.
        firstNumber.setPromptText("Enter first number");
        firstNumber.setMaxWidth(50);

        secondNumber = new TextField(); //create a text field for the second number.
        secondNumber.setPromptText("Enter second number");
        secondNumber.setMaxWidth(50);

        Button addButton = new Button("Add (+)");
        Button subtractButton = new Button("Subtract (-)");
        Button multiplyButton = new Button("Multiply (*)");
        Button divideButton = new Button("Divide (÷)");

        Label resultTitle = new Label("Result:");
        resultTitle.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        CalculatorHandler handler = new CalculatorHandler();
        addButton.setOnAction(handler);
        subtractButton.setOnAction(handler);
        multiplyButton.setOnAction(handler);
        divideButton.setOnAction(handler);

        result = new Label("0");
        result.setStyle("-fx-font-size: 18px; -fx-background-color: lightblue; -fx-padding: 20px; -fx-border-color: black; -fx-border-width: 2px; -fx-min-width: 250;");

        root.getChildren().addAll( //add all the components to the root. It will appear in the order they are added.
                titlePane,
                new Label("Enter two numbers:"),
                firstNumber,
                secondNumber,
                new Label("Choose an operations:"),
                addButton,
                subtractButton,
                multiplyButton,
                divideButton,
                resultTitle,
                result);

        Scene scene = new Scene(root, 400, 550);
        stage.setScene(scene);
        stage.setTitle("Basic Calculator");
        stage.show();
    }
/** main entry point of the application
 *  */

    public static void main(String[] args) {
        launch(args);
    }
/** This handles button clicks and calculates the result based on the operation selected
 * error will be displayed if the user enters invalid input*/
    private class CalculatorHandler implements EventHandler<ActionEvent>{

        /** This handles the action event when a button is clicked
         * Numbers from text fields are converted to double and the result is displayed
         * and display error message if the user enters invalid input*/
        @Override
        public void handle(ActionEvent event) { //Action event handler tells which button was selected

            try { //check if the user entered valid numbers
                double num1 = Double.parseDouble(firstNumber.getText()); //get the numbers from the text fields, then convert it to number
                double num2 = Double.parseDouble(secondNumber.getText()); //get the numbers from the text fields, then convert it to number
                double answer = 0; //initialize answer to be zero

                Button clickedButton = (Button) event.getSource(); //which button was selected, then cast to Button
                String buttonText = clickedButton.getText();

                if (buttonText.contains("Add")) {
                    answer = num1 + num2;
                } else if (buttonText.contains("Subtract")) {
                    answer = num1 - num2;
                } else if (buttonText.contains("Multiply")) {
                    answer = num1 * num2;
                } else if (buttonText.contains("Divide")) {
                    if (num2 == 0) {
                        result.setText("Error: Cannot divide by zero");
                        result.setStyle("-fx-font-size: 14px; -fx-background-color: red; -fx-padding: 20px; -fx-border-color: black; -fx-border-width: 2px; -fx-min-width: 250;"); // visual effect to emphasize the error
                        return;
                    }
                    answer = num1 / num2;
                }
                result.setText(" " + answer);
                result.setStyle("-fx-font-size: 14px; -fx-background-color: lightgreen; -fx-padding: 20px; -fx-border-color: black; -fx-border-width: 2px; -fx-min-width: 250;"); // visual effect to emphasize the result

            } catch (NumberFormatException e) {
                result.setText("Error: Invalid input. Enter numbers only.");
                result.setStyle("-fx-font-size: 14px; -fx-background-color: red; -fx-padding: 20px; -fx-border-color: black; -fx-border-width: 2px; -fx-min-width: 250;"); // visual effect to emphasize the error


            }

        }
    }
}
