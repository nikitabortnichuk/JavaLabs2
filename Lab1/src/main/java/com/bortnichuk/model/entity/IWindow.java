package com.bortnichuk.model.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public abstract class IWindow {

    private String color;
    private TextWindow textWindow;

    public abstract double getLength();
    public abstract double getSquare();

    public void changeColor(String color){
        this.color = color;
    }

    public abstract void show();

    public IWindow(IWindow target){
        if(target != null){
            this.color = target.color;
            this.textWindow = target.textWindow;
        }
    }

    public abstract IWindow clone();
}
