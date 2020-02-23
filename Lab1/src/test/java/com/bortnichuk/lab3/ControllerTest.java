package com.bortnichuk.lab3;

import com.bortnichuk.controller.WindowController;
import com.bortnichuk.dao.WindowDao;
import com.bortnichuk.entity.Window;
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

    private WindowController windowController;

    @BeforeEach
    void init(){
        windowController = new WindowController(windowDao);
    }

    @Test
    public void returnAllWindows(){

        when(windowDao.getWindowList()).thenReturn(getWindowsList());

        List<Window> expected = getWindowsList();
        List<Window> actual = windowController.getWindows();

        assertEquals(expected, actual);
    }

    @Test
    public void testAddingWindow(){
        String input = " 23 40 23 40 blue ";
        windowController.saveWindow(input);
        verify(windowDao).addWindow(getWindowsList().get(0));
    }

    private List<Window> getWindowsList() {
        List<Window> windows = new ArrayList<>();
        windows.add(
                Window.builder()
                        .color("blue")
                        .top(23)
                        .right(40)
                        .bottom(23)
                        .left(40)
                        .build()
        );

        windows.add(
                Window.builder()
                        .color("red")
                        .top(60)
                        .right(60)
                        .bottom(60)
                        .left(60)
                        .build()
        );

        return windows;
    }

}
