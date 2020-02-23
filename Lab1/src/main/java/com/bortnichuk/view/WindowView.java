package com.bortnichuk.view;

import com.bortnichuk.controller.WindowController;
import com.bortnichuk.entity.Window;

import java.util.List;
import java.util.Scanner;

public class WindowView {

    private WindowController windowController;
    private Scanner scanner;

    public WindowView() {
        windowController = new WindowController();
        scanner = new Scanner(System.in);
    }

    public void input() {
        int number;
        do {
            menu();
            number = scanner.nextInt();
            switch (number) {
                case 1:
                    showAllWindows();
                    break;
                case 2:
                    saveWindow();
                    break;
                default:
                    break;
            }
        }
        while (number == 1 || number == 2);

    }

    private void menu() {
        System.out.println(
                "Choose one of the following:\n" +
                        "1. Show all windows\n" +
                        "2. Enter new window\n" +
                        "0. Exit"
        );
    }

    private void showAllWindows() {
        List<Window> windowList = windowController.getWindows();
        if(windowList.isEmpty()){
            System.out.println("There is no windows");
        }
        else {
            windowList.forEach(this::showWindow);
        }
    }

    private void saveWindow() {
        enterWindowColorMessage();
        String colorInput = scanner.next();
        enterWindowParametersMessage();
        String dataInput = scanner.useDelimiter("\n").next();

        String input = dataInput + " " + colorInput;

        Window window = windowController.saveWindow(input);
        saveMessage();
        showWindow(window);
    }

    private void enterWindowColorMessage(){
        System.out.println("Enter window color: ");
    }
    private void enterWindowParametersMessage() {
        System.out.println("Enter window size parameters separated by space in the following sequence: top right bottom left");
    }

    private void saveMessage() {
        System.out.println("Window was successfully saved");
    }

    private void showWindow(Window window) {
        System.out.println("*************************");
        System.out.println("color: " + window.getColor());
        System.out.println("size:");
        System.out.println("top: " + window.getTop());
        System.out.println("right: " + window.getRight());
        System.out.println("bottom: " + window.getBottom());
        System.out.println("left: " + window.getLeft());
        System.out.println("*************************");
    }

}
