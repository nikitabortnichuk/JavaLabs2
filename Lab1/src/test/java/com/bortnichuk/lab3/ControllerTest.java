package com.bortnichuk.lab3;

import com.bortnichuk.controller.WindowController;
import com.bortnichuk.model.entity.*;
import com.bortnichuk.service.WindowService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {

    @Mock
    private WindowService windowService;

    @InjectMocks
    private WindowController windowController;

    @Test
    public void returnAllWindows(){

        when(windowService.getWindows()).thenReturn(getWindowsList());

        List<IWindow> expected = getWindowsList();
        List<IWindow> actual = windowController.getWindows();

        assertEquals(expected, actual);
    }

    @Test
    public void testAddingWindow(){

        String windowInput = " 23 40 23 40 blue ";
        int rectangleInput = 1;
        RectangleWindow window = (RectangleWindow) windowController.parseWindow(windowInput, rectangleInput);
        String textInput = " Happy Birthday!_blue ";
        TextWindow textWindow = windowController.parseTextWindow(textInput);
        window.setTextWindow(textWindow);
        windowController.save(window);

        verify(windowService).save(getWindowsList().get(0));
    }


    private List<IWindow> getWindowsList() {
        List<IWindow> windows = new ArrayList<>();

        RectangleWindow window1 = RectangleWindow.builder()
                .top(23)
                .right(40)
                .bottom(23)
                .left(40)
                .build();
        window1.setColor("blue");
        window1.setTextWindow(getTextWindows().get(0));


        windows.add(window1);

        RectangleWindow window2 = RectangleWindow.builder()
                .top(60)
                .right(60)
                .bottom(60)
                .left(60)
                .build();
        window2.setColor("red");
        window2.setTextWindow(getTextWindows().get(0));

        windows.add(
                window2
        );

        return windows;
    }

    private List<TextWindow> getTextWindows(){
        List<TextWindow> textWindows = new ArrayList<>();

        textWindows.add(
                TextWindow.builder()
                .text("Happy Birthday!")
                .textColor("blue")
                .build()
        );

        return textWindows;
    }

}
