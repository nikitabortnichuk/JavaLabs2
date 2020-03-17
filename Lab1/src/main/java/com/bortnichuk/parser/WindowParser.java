package com.bortnichuk.parser;

import com.bortnichuk.entity.TextWindow;
import com.bortnichuk.entity.Window;
import com.bortnichuk.entity.exception.IncorrectInputException;

import static java.lang.Integer.parseInt;

public class WindowParser {

    private static final String SPACES = "\\s+";
    private static final String SPACE = " ";
    private static final String UNDERLYING = "_";

    private static WindowParser instance;

    private WindowParser(){}

    public static WindowParser getInstance(){
        if(instance == null){
            instance = new WindowParser();
        }
        return instance;
    }

    public Window parseWindow(String data){
        String[] parameters = getParameters(data, SPACE);

        return createSmartphone(parameters);
    }

    public TextWindow parseTextWindow(String data){
        String[] parameters = getParameters(data, UNDERLYING);

        return createTextWindow(parameters);
    }

    private String[] getParameters(String data, String delimiter) {
        data = data.replaceAll(SPACES, SPACE).trim();
        return data.split(delimiter);
    }

    private Window createSmartphone(String[] parameters) {

        if (parameters.length != 5){
            throw new IncorrectInputException("INCORRECT INPUT! Number of parameters must be 5!");
        }
        return Window.builder()
                .top(parseInt(parameters[0]))
                .right(parseInt(parameters[1]))
                .bottom(parseInt(parameters[2]))
                .left(parseInt(parameters[3]))
                .color(parameters[4])
                .build();

    }

    private TextWindow createTextWindow(String[] parameters){
        if (parameters.length != 2){
            throw new IncorrectInputException("INCORRECT INPUT! Number of parameters must be 2!");
        }
        return TextWindow.builder()
                .text(parameters[0])
                .textColor(parameters[1])
                .build();
    }

}
