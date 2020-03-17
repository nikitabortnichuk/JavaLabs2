package com.bortnichuk.view;

import com.bortnichuk.controller.WindowController;
import com.bortnichuk.controller.command.CopyWindowCommand;
import com.bortnichuk.controller.command.CutWindowCommand;
import com.bortnichuk.controller.command.PasteWindowCommand;
import com.bortnichuk.entity.TextWindow;
import com.bortnichuk.entity.Window;
import com.bortnichuk.entity.exception.IncorrectInputException;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Scanner;

public class WindowView {

    private WindowController windowController;
    private Scanner scanner;

    @Getter
    @Setter
    private Window windowBackUp;

    @Getter
    @Setter
    private Window currentWindow;

    public WindowView() {
        windowController = new WindowController();
        scanner = new Scanner(System.in);
    }

    public void input() {
        WindowView view = this;
        int number;
        do {
            menu();
            number = scanner.nextInt();
            switch (number) {
                case 1:
                    showAllWindows();
                    break;
                case 2:
                    try {
                        saveWindowFromInput();
                    }
                    catch (IncorrectInputException e){
                        System.out.println(e.getMessage());
                        break;
                    }
                    break;
                case 3:
                    new CopyWindowCommand(view).execute();
                    break;
                case 4:
                    new CutWindowCommand(view).execute();
                    break;
                case 5:
                    new PasteWindowCommand(view).execute();
                    break;
                default:
                    break;
            }
        }
        while (number != 0);

    }

    private void menu() {
        System.out.println(
                "Choose one of the following:\n" +
                        "1. Show all windows\n" +
                        "2. Enter new window\n" +
                        "3. Copy last saved Window\n" +
                        "4. Cut last saved Window\n" +
                        "5. Paste copied Window\n" +
                        "0. Exit"
        );
    }

    private void showAllWindows() {
        List<Window> windowList = windowController.getWindows();
        if (windowList.isEmpty()) {
            System.out.println("There is no windows!");
        } else {
            windowList.forEach(this::showWindow);
        }
    }

    private void saveWindowFromInput() {

        Window window = windowController.getWindow(getWindowInput());

        TextWindow textWindow = windowController.getTextWindow(getTextWindowInput());

        currentWindow = windowController.save(window, textWindow);

        saveMessage();
        showWindow(window);
    }


    public void deleteLastWindow(){
        windowController.deleteLast();
    }

    public void saveWindow(Window window){
        currentWindow = windowController.save(window);
    }

    private String getWindowInput(){
        enterWindowColorMessage();
        String colorInput = scanner.next();
        enterWindowParametersMessage();
        String dataInput = scanner.useDelimiter("\n").next();

        return dataInput + " " + colorInput;
    }

    private String getTextWindowInput(){
        enterTextOnWindowMessage();
        scanner.nextLine();
        String textInput = scanner.nextLine();

        enterColorOfTextOnWindowMessage();
        String textColorInput = scanner.next();

        return textInput + "_" + textColorInput;
    }


    private void enterWindowColorMessage() {
        System.out.println("Enter window color: ");
    }

    private void enterWindowParametersMessage() {
        System.out.println("Enter window size parameters separated by space in the following sequence: top right bottom left");
    }

    private void enterTextOnWindowMessage(){
        System.out.println("Enter text on window: ");
    }

    private void enterColorOfTextOnWindowMessage(){
        System.out.println("Enter color of the text on window");
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
        System.out.println("text: " + window.getTextWindow().getText());
        System.out.println("\tcolor: " + window.getTextWindow().getTextColor());
        System.out.println("*************************");
    }



}
