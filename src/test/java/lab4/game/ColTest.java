package lab4.game;

import org.junit.jupiter.api.Test; //import Test annotation
import static org.junit.jupiter.api.Assertions.assertEquals; //to check if two values are equal

import static org.junit.jupiter.api.Assertions.assertThrows;  //to check if a method throws an exception

public class ColTest {
    @Test //annotation. below will be the test case
    void testValidInput() { //we want to check if the input and valid and should return the correct col
        assertEquals(Col.Left, Col.from("1")); //check if "1" is Col.left
        assertEquals(Col.Middle, Col.from("2")); //check if "2" is Col.middle
        assertEquals(Col.Right, Col.from("3")); //check if "3" is Col.right
        assertEquals(Col.Left, Col.from("l"));
        assertEquals(Col.Middle, Col.from("m"));
        assertEquals(Col.Middle, Col.from("c"));
        assertEquals(Col.Right, Col.from("r"));
    }
    @Test //annotation marking the second test
    void testCaseInsensitive() {
        assertEquals(Col.Left, Col.from("L"));
        assertEquals(Col.Middle, Col.from("M"));
        assertEquals(Col.Right, Col.from("R"));
    }

    @Test //annotation marking the third test
    void testInvalidInputs() {
        assertThrows(IllegalArgumentException.class, () -> Col.from("4"));
        assertThrows(IllegalArgumentException.class, () -> Col.from("x"));
        assertThrows(IllegalArgumentException.class, () -> Col.from(""));
        assertThrows(IllegalArgumentException.class, () -> Col.from("left"));
    }

}