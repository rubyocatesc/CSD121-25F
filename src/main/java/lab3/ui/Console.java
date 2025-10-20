package lab3.ui;

import lab3.game.Position;
import lab3.game.Row;
import lab3.game.Column;
import java.util.Scanner;

public class Console {
    private Scanner scanner; //scanner is used to read the input from the console
    public Console() {
        //set scanner to read the user input.
        scanner = new Scanner(System.in);
    }
    //used to show a message to the player in the console
    public void displayMessage(String message) {
        System.out.println(message);
    }

//convert a string input into a Row enum value
private Row parseRow(String rowStr) {
    switch (rowStr) {
        case "1": case "t": return Row.TOP; //Top row will only accept values "1" or "t"
        case "2": case "m": case "c" : return Row.MIDDLE; //Middle row will only accept values "2", "m" or "c"
        case "3": case "b": return Row.BOTTOM; //Bottom row will only accept values "3" or "b"
        default: throw new IllegalArgumentException("Invalid row"); //If the input doesn't match any of the valid options above, throw this error message.
    }
}

private Column parseColumn(String columnStr) {
    switch (columnStr) {
        case "1": case "l": return Column.LEFT; //Left column will only accept values "1" or "l"
        case "2": case "m": case "c" : return Column.MIDDLE; //Middle column will only accept values "2", "m" or "c"
        case "3": case "r": return Column.RIGHT; //Right column will only accept values "3" or "r"
        default: throw new IllegalArgumentException("Invalid column"); //If the input doesn't match any of the valid options above, throw this error message. 
    }
}
//Ask the current player to enter their move and return it as position
public Position getNextMove(char currentPlayer) {
    while (true) { //repeat until a valid move is entered
        System.out.print("Player " + currentPlayer + ", enter your move: "); //prompt to enter move
        String input = scanner.nextLine().trim().toLowerCase(); //retrieve the input but not including the next line separator, then remove any spaces and convert all characters in lowercase

        try {
            String[] parts = input.split(" "); //split the input into two parts
            if (parts.length != 2) { // check if it does not contain exactly two parts, then throw the error message. 
                throw new IllegalArgumentException("Please enter two values. (ex: '1 2' or 't r')");
            }
            
            Row row = parseRow(parts[0]); //convert the first part of input into a row using the parseRow()
            Column column = parseColumn(parts[1]); //convert the second part of input into a column using the parseColumn()
            //once conversion is done, create and return a new object Position
            return new Position(row, column);
        }

        catch (Exception e) {
            //catch any errors and display the message.
            System.out.println("Invalid move! Please try again. ");
        }
        }
    }
}  
