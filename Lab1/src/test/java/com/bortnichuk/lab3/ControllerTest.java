package com.bortnichuk.lab3;

import com.bortnichuk.controller.WindowController;
import com.bortnichuk.dao.WindowDao;
import com.bortnichuk.model.entity.IWindow;
import com.bortnichuk.model.entity.TextWindow;
import com.bortnichuk.model.entity.RectangleWindow;
import com.bortnichuk.service.WindowService;
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

    private WindowService windowService;

    @BeforeEach
    void init(){
        windowService = new WindowService(windowDao);
    }

    @Test
    public void returnAllWindows(){

        when(windowDao.getWindowList()).thenReturn(getWindowsList());

        List<IWindow> expected = getWindowsList();
        List<IWindow> actual = windowService.getWindows();

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
        windowService.save(window, textWindow);

        verify(windowDao).addWindow(getWindowsList().get(0));
    }

    private List<IWindow> getWindowsList() {
        List<IWindow> windows = new ArrayList<>();
        windows.add(
                RectangleWindow.builder()
                        .color("blue")
                        .top(23)
                        .right(40)
                        .bottom(23)
                        .left(40)
                        .textWindow(getTextWindows().get(0))
                        .build()
        );

        windows.add(
                RectangleWindow.builder()
                        .color("red")
                        .top(60)
                        .right(60)
                        .bottom(60)
                        .left(60)
                        .textWindow(getTextWindows().get(0))
                        .build()
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
