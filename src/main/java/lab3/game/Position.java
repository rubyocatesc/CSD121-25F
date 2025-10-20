package lab3.game;

public class Position { //this will hold the row and column values for a position
    private final Row row;
    private final Column column;
    //initialize the position
    public Position(Row row, Column column) {
        this.row = row; //set the row value for this position
        this.column = column; //set the column value for this position
    }
    //returns the row for this position
    public Row row() {
        return row;
    }
    //returns the column for this position
    public Column column() {
        return column;
    }
}
