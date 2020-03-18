package com.bortnichuk.model.entity;

import com.bortnichuk.model.annotation.MyAnnotation;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class TextWindow {

    String text;
    String textColor;

    @MyAnnotation
    public void changeText(String newText){
        text = newText;
    }

    public void changeColor(String color) {
        textColor = color;
    }

    public int getTextLength(){
        return text.length();
    }

}
