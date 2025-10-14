package lab3;

//Will be used know the position on the board
    //Constructor of class Position
    public record Position(int row, int column) {
        //this.row = row; // assign row number. use "this.row" because "row" is a local variable, same name as the instance variable.
        //this.column = column; // assign column number use "this.column" because "column" is a local variable, same name as the instance variable.
    }

    //public int getRow() { //get row number so other classes can access it
        //return row;
    //}

    //public int getColumn() { //get column number so other classes can access it
        //return column;
   // }
//}
