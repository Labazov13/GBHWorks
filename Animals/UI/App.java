package UI;

import java.text.ParseException;
import java.util.Scanner;

import MVP.Presenter;
import MVP.View;
import Service.Config;

public class App {
    public static void buttonClick() throws ParseException {
        System.out.print("\033[H\033[J"); // очистить консоль
        View view = new ConsoleView();
        Presenter presenter = new Presenter(view, Config.pathDB);
        presenter.loadFromFile();

        try (Scanner in = new Scanner(System.in)) {

            while (true) {
                System.out.println(
                        " 1 - все животные  2 - добавить комманды животному  3 - добавить животное  4 - выход");
                String key = in.next();
                System.out.print("\033[H\033[J");
                switch (key) {
                    case "1":
                        presenter.showAllAnimals();
                        break;
                    case "2":
                        presenter.addCommands();
                        break;
                    case "3":
                        presenter.addAnimal();
                        break;
                    case "4":
                        System.exit(0);
                    default:
                        System.out.println("Такой команды нет");

                        break;
                }
            }
        }

    }

}
