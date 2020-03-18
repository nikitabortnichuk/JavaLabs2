package com.bortnichuk.lab4;

import com.bortnichuk.model.entity.IWindow;
import com.bortnichuk.model.entity.RectangleWindow;
import com.bortnichuk.model.entity.TextWindow;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PrototypeTest {

    @Test
    public void shouldReturnDifferentButIdenticalObjects(){

        IWindow window = getWindow();

        IWindow clonedWindow = getWindow().clone();

        assertNotSame(window, clonedWindow);
        assertEquals(window, clonedWindow);
    }


    private IWindow getWindow(){
        RectangleWindow window = RectangleWindow.builder()
                .top(60)
                .right(60)
                .bottom(60)
                .left(60)
                .build();
        window.setColor("red");
        window.setTextWindow(new TextWindow("Hello", "blue"));
        return window;
    }

}
