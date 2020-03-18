package com.bortnichuk.lab3;

import com.bortnichuk.controller.WindowController;
import com.bortnichuk.dao.WindowDao;
import com.bortnichuk.model.entity.IWindow;
import com.bortnichuk.model.entity.TextWindow;
import com.bortnichuk.model.entity.RectangleWindow;
import com.bortnichuk.service.WindowServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
    private WindowDao windowDao;

    private WindowServiceImpl windowServiceImpl;

    @BeforeEach
    void init(){
        windowServiceImpl = new WindowServiceImpl(windowDao);
    }

    @Test
    public void returnAllWindows(){

        when(windowDao.getWindowList()).thenReturn(getWindowsList());

        List<IWindow> expected = getWindowsList();
        List<IWindow> actual = windowServiceImpl.getWindows();

        assertEquals(expected, actual);
    }

    @Test
    public void testAddingWindow(){
        WindowController windowController = new WindowController();
        String windowInput = " 23 40 23 40 blue ";
        int rectangleInput = 1;
        RectangleWindow window = (RectangleWindow) windowController.getWindow(windowInput, rectangleInput);
        String textInput = " Happy Birthday!_blue ";
        TextWindow textWindow = windowController.getTextWindow(textInput);
        window.setTextWindow(textWindow);
        windowServiceImpl.save(window);

        verify(windowDao).addWindow(getWindowsList().get(0));
    }

    @Test
    public void testAddingProxyWindow(){
        WindowController windowController = new WindowController();

        String windowInput = " 23 40 23 40 blue ";
        int rectangleInput = 1;
        RectangleWindow window = (RectangleWindow) windowController.getWindow(windowInput, rectangleInput);
        String textInput = " Happy Birthday!_blue ";
        TextWindow textWindow = windowController.getTextWindow(textInput);
        window.setTextWindow(textWindow);
        windowServiceImpl.save(window);

        verify(windowDao).addWindow(getWindowsList().get(0));
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
