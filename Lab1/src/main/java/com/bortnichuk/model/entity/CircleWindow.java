package com.bortnichuk.model.entity;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CircleWindow extends IWindow {

    private int radius;

    public CircleWindow(CircleWindow target) {
        super(target);
        if(target != null){
            this.radius = target.radius;
        }
    }

    @Override
    public double getLength() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getSquare() {
        return Math.PI * radius * radius;
    }


    @Override
    public void show() {
        System.out.println("*************************");
        System.out.println("Object: " + this);
        System.out.println("Window type: Circle");
        System.out.println("color: " + this.getColor());
        System.out.println("size:");
        System.out.println("radius: " + this.radius);
        System.out.println("text: " + this.getTextWindow().getText());
        System.out.println("\tcolor: " + this.getTextWindow().getTextColor());
        System.out.println("*************************");
    }

    @Override
    public IWindow clone() {
        return new CircleWindow(this);
    }


}
