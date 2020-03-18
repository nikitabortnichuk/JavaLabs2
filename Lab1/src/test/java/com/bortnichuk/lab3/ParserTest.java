package com.bortnichuk.lab3;

import com.bortnichuk.model.entity.RectangleWindow;
import com.bortnichuk.model.exception.IncorrectInputException;
import com.bortnichuk.service.RectangleWindowParser;
import com.bortnichuk.service.WindowParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {

    WindowParser windowParser = new RectangleWindowParser();

    @Test
    public void testParse(){

        String data = "    1    2 3   4    blue";

        RectangleWindow expected = RectangleWindow.builder()
                .left(4)
                .top(1)
                .right(2)
                .bottom(3)
                .color("blue")
                .build();

        assertEquals(expected, windowParser.parseWindow(data));

    }

    @Test
    public void testIncorrectNumber(){
        String data = "  blue  1    2 3   4 ";

        assertThrows(NumberFormatException.class, () -> windowParser.parseWindow(data));
    }

    @Test
    public void testIncorrectInput(){
        String data = " 1 2 3 4 5 6 red 1 2 89 3 5 blue";

        assertThrows(IncorrectInputException.class, () -> windowParser.parseWindow(data));
    }

}
