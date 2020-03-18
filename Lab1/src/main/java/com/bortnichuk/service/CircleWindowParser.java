package com.bortnichuk.service;

import com.bortnichuk.model.entity.CircleWindow;
import com.bortnichuk.model.entity.IWindow;
import com.bortnichuk.model.entity.RectangleWindow;
import com.bortnichuk.model.exception.IncorrectInputException;

import static java.lang.Integer.parseInt;

public class CircleWindowParser extends WindowParser {

    @Override
    protected IWindow createWindow(String[] parameters) {
        if (parameters.length != 2){
            throw new IncorrectInputException("INCORRECT INPUT! Number of parameters must be 2!");
        }
        CircleWindow window = CircleWindow.builder()
                .radius(parseInt(parameters[0]))
                .build();
        window.setColor(parameters[1]);
        return window;
    }
}
