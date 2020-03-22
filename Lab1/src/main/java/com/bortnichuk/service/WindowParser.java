package com.bortnichuk.service;

import com.bortnichuk.model.entity.IWindow;
import com.bortnichuk.model.entity.TextWindow;
import com.bortnichuk.model.entity.RectangleWindow;
import com.bortnichuk.model.exception.IncorrectInputException;

import static java.lang.Integer.parseInt;

public abstract class WindowParser {

    private static final String SPACES = "\\s+";
    private static final String SPACE = " ";
    private static final String UNDERLYING = "_";

    public IWindow parseWindow(String data){
        String[] parameters = getParameters(data, SPACE);

        return createWindow(parameters);
    }

    private static String[] getParameters(String data, String delimiter) {
        data = data.replaceAll(SPACES, SPACE).trim();
        return data.split(delimiter);
    }

    protected abstract IWindow createWindow(String[] parameters);


    public static TextWindow parseTextWindow(String data){
        String[] parameters = getParameters(data, UNDERLYING);

        return createTextWindow(parameters);
    }

    private static TextWindow createTextWindow(String[] parameters){
        if (parameters.length != 2){
            throw new IncorrectInputException("INCORRECT INPUT! Number of parameters must be 2!");
        }
        return TextWindow.builder()
                .text(parameters[0])
                .textColor(parameters[1])
                .build();
    }

}
