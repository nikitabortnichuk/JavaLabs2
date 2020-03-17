package com.bortnichuk.entity;

import com.bortnichuk.entity.annotation.MyAnnotation;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class Window implements IWindow {

    private int left;
    private int top;
    private int right;
    private int bottom;
    private String color;
    
    private TextWindow textWindow;

    @MyAnnotation
    public boolean isQuadratic(){
        return isRectangle() && left == bottom;
    }

    public boolean isRectangle(){
        return left == right && bottom == top;
    }

    public void changeColor(String newColor){
        color = newColor;
    }

    @MyAnnotation
    public void changeColorToBlue(){
        color = "blue";
    }

    @MyAnnotation
    public void changeColorToRed(){
        color = "red";
    }

    public int getLength(){
        return calculateLength();
    }

    private int calculateLength(){
        return left + top + right + bottom;
    }

    public int getSquare(){
        return calculateSquare();
    }

    private int calculateSquare(){
        if(isQuadratic()){
            return left * left;
        }
        else if(isRectangle()){
            return left * top;
        }
        else
            throw new RuntimeException("Cannot calculate square!");
    }
}
