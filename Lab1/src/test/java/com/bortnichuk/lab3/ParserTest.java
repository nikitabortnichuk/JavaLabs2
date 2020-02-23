package com.bortnichuk.lab3;

import com.bortnichuk.entity.Window;
import com.bortnichuk.entity.exception.IncorrectInputException;
import com.bortnichuk.parser.WindowParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {

    WindowParser windowParser = new WindowParser();

    @Test
    public void testParse(){

        String data = "    1    2 3   4    blue";

        Window expected = new Window(4, 1, 2, 3, "blue");

        assertEquals(expected, windowParser.parse(data));

    }

    @Test
    public void testIncorrectNumber(){
        String data = "  blue  1    2 3   4 ";

        assertThrows(NumberFormatException.class, () -> windowParser.parse(data));
    }

    @Test
    public void testIncorrectInput(){
        String data = " 1 2 3 4 5 6 red 1 2 89 3 5 blue";

        assertThrows(IncorrectInputException.class, () -> windowParser.parse(data));
    }

}
