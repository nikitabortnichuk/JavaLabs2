package com.bortnichuk;

import com.bortnichuk.entity.annotation.MyAnnotation;
import com.bortnichuk.entity.IWindow;
import com.bortnichuk.entity.handler.MyInvocationHandler;
import com.bortnichuk.entity.TextWindow;
import com.bortnichuk.entity.Window;
import com.bortnichuk.entity.exception.SetterCalledException;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class WindowReflectionTest {

    private Window window;
    private TextWindow textWindow;

    @BeforeEach
    void init(){
        window = createWindow();
        textWindow = createTextWindow();
    }

    @Test
    @SneakyThrows
    public void shouldCallMethodWithAnnotations() {
        for (Method method : window.getClass().getMethods()) {
            if (method.isAnnotationPresent(MyAnnotation.class)) {
                method.invoke(window);
            }
        }

        assertEquals("red", window.getColor());

    }

    @Test
    public void shouldCallTextWindowClass() {

        String actual = textWindow.getClass().getSimpleName();

        assertEquals("TextWindow", actual );
    }

    @Test
    public void shouldCallMethodsWithAccessSpecifiersAndParameterTypes() {

        Arrays.stream(window.getClass().getDeclaredMethods())
                .map(method -> Modifier.toString(method.getModifiers()) +
                        " " + method.getReturnType().getName() +
                        " " + method.getName() +
                        "(" + getParameters(method) + ")")
                .forEach(System.out::println);

        int actual = window.getClass().getDeclaredMethods().length;

        assertEquals(24, actual);

    }

    private String getParameters(Method method) {
        return Arrays.stream(method.getParameters())
                .map(parameter -> parameter.getType().getName() + " " + parameter.getName())
                .collect(Collectors.joining(","));
    }

    @Test
    public void shouldCallSuperClassName(){

        String superClass = textWindow.getClass().getSuperclass().getSimpleName();

        assertEquals("Window", superClass);
    }

    @Test
    public void shouldThrowExceptionProxy(){

        IWindow windowProxy = (IWindow) Proxy.newProxyInstance(
                Window.class.getClassLoader(),
                Window.class.getInterfaces(),
                new MyInvocationHandler(window));

        String color = windowProxy.getColor();

        assertEquals("white", color);

        assertThrows(SetterCalledException.class, () -> windowProxy.setColor("blue"));
    }

    private TextWindow createTextWindow(){
        return new TextWindow("Happy Valentine`s Day", "pink");
    }

    private Window createWindow() {
        return Window.builder()
                .left(8)
                .top(6)
                .right(8)
                .bottom(6)
                .color("white")
                .build();
    }

}
