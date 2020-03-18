package com.bortnichuk.model.entity;

import com.bortnichuk.model.annotation.MyAnnotation;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

public class RectangleWindow implements IWindow {

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

    public double getLength(){
        return left + top + right + bottom;
    }

    public double getSquare(){
        if(isQuadratic()){
            return left * left;
        }
        else if(isRectangle()){
            return left * top;
        }
        else
            throw new RuntimeException("Cannot calculate square!");
    }

    public void show(){
        System.out.println("*************************");
        System.out.println("Window type: Rectangle");
        System.out.println("color: " + this.color);
        System.out.println("size:");
        System.out.println("top: " + this.top);
        System.out.println("right: " + this.right);
        System.out.println("bottom: " + this.bottom);
        System.out.println("left: " + this.left);
        System.out.println("text: " + this.textWindow.getText());
        System.out.println("\tcolor: " + this.textWindow.getTextColor());
        System.out.println("*************************");
    }
}
