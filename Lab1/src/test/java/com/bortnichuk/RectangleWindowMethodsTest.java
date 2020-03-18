package com.bortnichuk;

import com.bortnichuk.model.entity.TextWindow;
import com.bortnichuk.model.entity.RectangleWindow;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class RectangleWindowMethodsTest {

    private RectangleWindow window;
    private TextWindow textWindow;

    @BeforeEach
    void init(){
        window = createWindow();
        textWindow = createTextWindow();
    }

    @Test
    public void checkIfWindowIsRectangle(){

        assertTrue(window.isRectangle());

        window.setLeft(9);

        assertFalse(window.isRectangle());

    }

    @Test
    public void checkIfWindowIsQuadratic(){

        assertFalse(window.isQuadratic());

        window.setLeft(6);
        window.setRight(6);

        assertTrue(window.isRectangle());

    }

    @Test
    @DisplayName("new test for length")
    public void getLength(){

        assertEquals(28, window.getLength());

        assertNotEquals(34, window.getLength());
    }

    @Test
    @DisplayName("new test for square of rectangle window")
    public void getSquareRectangle(){

        assertEquals(48, window.getSquare());

        assertNotEquals(20, window.getSquare());
    }

    @Test
    @DisplayName("new test for square of quadratic window")
    public void getSquareQuadratic(){

        window.setBottom(8);
        window.setTop(8);

        assertEquals(64, window.getSquare());

        assertNotEquals(60, window.getSquare());
    }

    @Test
    public void checkThrowingSquareException(){
        window.setLeft(10);

        assertThrows(RuntimeException.class, window::getSquare);
    }

    @Test
    public void checkChangeColorToBlue(){

        window.changeColorToBlue();

        assertEquals("blue", window.getColor());
        assertNotEquals("white", window.getColor());
    }


    @Test
    public void checkChangeColorToRed(){

        window.changeColorToRed();

        assertEquals("red", window.getColor());
        assertNotEquals("white", window.getColor());
    }


    @Test
    public void checkChangeColor(){

        window.changeColor("green");

        assertEquals("green", window.getColor());
        assertNotEquals("white", window.getColor());
    }

    @Test
    public void checkChangeText(){

        textWindow.changeText("Happy Women`s Day");

        assertEquals("Happy Women`s Day", textWindow.getText());
        assertNotEquals("Happy Valentine`s Day", textWindow.getText());
    }

    @Test
    public void checkChangeTextColor(){

        textWindow.changeColor("black");

        assertEquals("black", textWindow.getTextColor());
        assertNotEquals("pink", textWindow.getTextColor());
    }

    @Test
    public void checkWindowTextLength(){
        int textLength = textWindow.getTextLength();

        assertEquals(21, textLength);
    }

    private TextWindow createTextWindow(){
        return new TextWindow("Happy Valentine`s Day", "pink");
    }

    private RectangleWindow createWindow() {
        return RectangleWindow.builder()
                .left(8)
                .top(6)
                .right(8)
                .bottom(6)
                .color("white")
                .build();
    }

}
