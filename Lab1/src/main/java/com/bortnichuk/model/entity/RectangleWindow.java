package com.bortnichuk.model.entity;

import com.bortnichuk.model.annotation.MyAnnotation;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter

public class RectangleWindow extends IWindow {

    private int left;
    private int top;
    private int right;
    private int bottom;

    public RectangleWindow(RectangleWindow target){
        super(target);
        if(target != null){
            this.left = target.left;
            this.top = target.top;
            this.right = target.right;
            this.bottom = target.bottom;
        }
    }

    @MyAnnotation
    public boolean isQuadratic(){
        return isRectangle() && left == bottom;
    }

    public boolean isRectangle(){
        return left == right && bottom == top;
    }

    @MyAnnotation
    public void changeColorToBlue(){
        this.setColor("blue");
    }

    @MyAnnotation
    public void changeColorToRed(){
        this.setColor("red");
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
        System.out.println("Object: " + this);
        System.out.println("Window type: Rectangle");
        System.out.println("color: " + this.getColor());
        System.out.println("size:");
        System.out.println("top: " + this.top);
        System.out.println("right: " + this.right);
        System.out.println("bottom: " + this.bottom);
        System.out.println("left: " + this.left);
        System.out.println("text: " + this.getTextWindow().getText());
        System.out.println("\tcolor: " + this.getTextWindow().getTextColor());
        System.out.println("*************************");
    }

    @Override
    public IWindow clone() {
        return new RectangleWindow(this);
    }
}
