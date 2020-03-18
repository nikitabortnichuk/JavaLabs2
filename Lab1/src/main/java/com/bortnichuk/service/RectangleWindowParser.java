package com.bortnichuk.service;

import com.bortnichuk.model.entity.IWindow;
import com.bortnichuk.model.entity.RectangleWindow;
import com.bortnichuk.model.exception.IncorrectInputException;

import static java.lang.Integer.parseInt;

public class RectangleWindowParser extends WindowParser {

    @Override
    protected IWindow createWindow(String[] parameters) {
        if (parameters.length != 5){
            throw new IncorrectInputException("INCORRECT INPUT! Number of parameters must be 5!");
        }
        return RectangleWindow.builder()
                .top(parseInt(parameters[0]))
                .right(parseInt(parameters[1]))
                .bottom(parseInt(parameters[2]))
                .left(parseInt(parameters[3]))
                .color(parameters[4])
                .build();
    }
}
