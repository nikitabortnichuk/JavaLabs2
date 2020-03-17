package com.bortnichuk.entity;

import com.bortnichuk.entity.annotation.MyAnnotation;
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
