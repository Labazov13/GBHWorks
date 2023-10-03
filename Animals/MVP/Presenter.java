package MVP;

import java.text.ParseException;
import java.util.Scanner;

import MVP.AnimalFactory.AnimalClass;
import UI.App;

public class Presenter {

    private Model model;
    private View view;

    public Presenter(View view, String pathDb) {
        this.view = view;
        model = new Model();
    }

    // загрузка из файла
    public void loadFromFile() {
        model.clear(); // очищаем текущую книгу, иначе она дополняется точно такими же записями
        model.load();
    }

    public void showAllAnimals() {
        if (model.count() > 0) {
            view.print(model.getAnimals());
        } else {
            System.out.println("Нет ни одного животного");
        }
    }

    public void addCommands() throws ParseException {
        pickAnimal();

    }

    public void pickAnimal() throws ParseException {

        if (model.getAnimals().size() != 0) {
            try (Scanner in = new Scanner(System.in)) {

                while (true) {

                    view.print(model.getAnimals());
                    System.out.println("Для ввода команд выберите номер животного  0 - выход");

                    String key = in.next();
                    switch (key) {
                        case "0":
                            App.buttonClick();
                        default:
                            if (Integer.parseInt(key) <= model.getAnimals().size()) {

                                view.printAnimal(model.getAnimal(Integer.parseInt(key) - 1));
                                var currentCommands = model.getAnimal(Integer.parseInt(key) - 1).getCommands();
                                model.getAnimal(Integer.parseInt(key) - 1)
                                        .setCommands(currentCommands + " " + view.getCommands());
                            } else {
                                System.out.println("Животного с таким номером нет");
                            }
                            break;
                    }
                }
            }
        }
        System.out.println("Пока нет ни одного животного");

    }

    public void addAnimal() throws ParseException {
        String name = view.getName();
        AnimalClass classname = view.getClassAnimal();
        String commands = view.getCommands();
        String birth = view.getBirth();
        model.animals.add(AnimalFactory.createAnimal(classname, name, birth, commands));
    }

}