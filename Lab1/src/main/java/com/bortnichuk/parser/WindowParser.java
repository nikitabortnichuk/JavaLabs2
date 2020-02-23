package com.bortnichuk.parser;

import com.bortnichuk.entity.Window;
import com.bortnichuk.entity.exception.IncorrectInputException;

import static java.lang.Integer.parseInt;

public class WindowParser {

    private static final String SPACES = "\\s+";
    private static final String SPACE = " ";

    public Window parse(String data){
        data = data.replaceAll(SPACES, SPACE).trim();
        String[] parameters = data.split(SPACE);

        return createSmartphone(parameters);
    }

    private Window createSmartphone(String[] parameters) {

        if (parameters.length != 5){
            throw new IncorrectInputException("Number of parameters must be 5");
        }
        return Window.builder()
                .top(parseInt(parameters[0]))
                .right(parseInt(parameters[1]))
                .bottom(parseInt(parameters[2]))
                .left(parseInt(parameters[3]))
                .color(parameters[4])
                .build();

    }

}
