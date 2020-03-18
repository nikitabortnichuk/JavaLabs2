package com.bortnichuk.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CircleWindow implements IWindow {

    private int radius;
    private String color;
    private TextWindow textWindow;

    @Override
    public double getLength() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getSquare() {
        return Math.PI * radius * radius;
    }

    @Override
    public void changeColor(String color) {
        this.color = color;
    }

    @Override
    public void show() {
        System.out.println("*************************");
        System.out.println("Window type: Circle");
        System.out.println("color: " + this.color);
        System.out.println("size:");
        System.out.println("radius: " + this.radius);
        System.out.println("text: " + this.textWindow.getText());
        System.out.println("\tcolor: " + this.textWindow.getTextColor());
        System.out.println("*************************");
    }
}
