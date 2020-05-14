package com.bortnichuk.view;

import com.bortnichuk.controller.WindowController;
import com.bortnichuk.controller.command.CopyWindowCommand;
import com.bortnichuk.controller.command.CutWindowCommand;
import com.bortnichuk.controller.command.PasteWindowCommand;
import com.bortnichuk.model.entity.IWindow;
import com.bortnichuk.model.exception.IncorrectInputException;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Scanner;

public class WindowView {

    private WindowController windowController;

    public WindowView(WindowController windowController){
        this.windowController = windowController;
    }

    private Scanner scanner = new Scanner(System.in);

    @Getter
    @Setter
    private IWindow windowBackUp;

    @Getter
    @Setter
    private IWindow currentWindow;

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
                    } catch (IncorrectInputException e) {
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
        List<IWindow> windowList = windowController.getWindows();
        if (windowList.isEmpty()) {
            System.out.println("There is no windows!");
        } else {
            windowList.forEach(this::showWindow);
        }
    }

    private void saveWindowFromInput() {

        int number;
        do {
            shapeMenu();
            number = scanner.nextInt();
            if(number == 0) break;

            try {
                saveWindow(number);
            }
            catch (IncorrectInputException e){
                System.out.println(e.getMessage());
                break;
            }

        } while (number != 1 && number != 2);

    }

    private void saveWindow(int number){
        IWindow window = windowController.createWindow(getWindowInput(number), getTextWindowInput(), number);
        saveWindow(window);

        showWindow(window);
    }

    private void shapeMenu() {
        System.out.println("Enter shape of window:\n" +
                "1. Rectangle\n" +
                "2. Circle\n" +
                "0. back");
    }


    public void deleteLastWindow() {
        windowController.deleteLast();
    }

    public void saveWindow(IWindow window) {
        currentWindow = windowController.save(window);
    }

    private String getWindowInput(int number) {
        enterWindowColorMessage();
        String colorInput = scanner.next();
        if(number == 1) {
            enterRectangleWindowParametersMessage();
        }
        else if(number == 2){
            enterCircleWindowParametersMessage();
        }
        else
            throw new IncorrectInputException("Wrong input!");

        String dataInput = scanner.useDelimiter("\n").next();

        return dataInput + " " + colorInput;
    }

    private String getTextWindowInput() {
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

    private void enterRectangleWindowParametersMessage() {
        System.out.println("Enter window size parameters separated by space in the following sequence: top right bottom left");
    }

    private void enterCircleWindowParametersMessage() {
        System.out.println("Enter window radius:");
    }

    private void enterTextOnWindowMessage() {
        System.out.println("Enter text on window: ");
    }

    private void enterColorOfTextOnWindowMessage() {
        System.out.println("Enter color of the text on window");
    }


    private void showWindow(IWindow window) {
        window.show();
    }


}
