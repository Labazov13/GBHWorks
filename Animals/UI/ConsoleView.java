package UI;

import java.nio.charset.Charset;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import Animals.Animal;
import MVP.AnimalFactory;
import MVP.View;
import MVP.AnimalFactory.AnimalClass;
import Service.Config;

public class ConsoleView implements View {
    Scanner in;

    // инициализация сканнера
    public ConsoleView() {
        in = scanClass();

    }

    // ввод имени
    @Override
    public String getName() {
        System.out.printf("Имя животного: ");
        return in.nextLine();
    }

    // ввод даты рождения
    @Override
    public String getBirth() {
        System.out.printf("Дата рождения формат(01.01.1900):  ");
        return in.nextLine();
    }

    // ввод команд животного
    @Override
    public String getCommands() {
        System.out.printf("Введите через пробел команды животного: ");
        return in.nextLine();
    }

    // ввод класса животного
    @Override
    public AnimalClass getClassAnimal() {
        Scanner in;

        // инициализация сканнера

        in = scanClass();

        AnimalClass res = AnimalFactory.AnimalClass.NONE;
        System.out.printf(
                "Введите класс животного (1 - кошка, 2 - собака, 3 - хомяк, 4 - лошадь,5 - верблюд, 6 - осёл): ");
        String key = in.next();
        int intkey = tryParseClassAnimal(key);
        if (intkey != -1) {

            switch (intkey) {
                case 1:
                    res = AnimalFactory.AnimalClass.CAT;
                    break;
                case 2:
                    res = AnimalFactory.AnimalClass.DOG;
                    break;
                case 3:
                    res = AnimalFactory.AnimalClass.HAMSTER;
                    break;
                case 4:
                    res = AnimalFactory.AnimalClass.HORSE;
                    break;
                case 5:
                    res = AnimalFactory.AnimalClass.CAMEL;
                    break;
                case 6:
                    res = AnimalFactory.AnimalClass.DONKEY;
                    break;
                default:
                    res = AnimalFactory.AnimalClass.NONE;
                    break;
            }

        }
        return res;
    }

    private Scanner scanClass() {
        return new Scanner(System.in, Charset.forName(Config.charSet));
    }

    // печать животного
    @Override
    public void printAnimal(Animal animal) {
        System.out.println(animal.toString());

    }

    // печать животных
    public void print(ArrayList<Animal> animals) {
        System.out.printf("%s\t%s\t%s\t%s\t%s\n", "Номер", "Класс", "Имя", "Дата рождения", "Комманды");
        System.out.println("-------------------------------------------------------");
        for (var animal : animals) {
            System.out.printf("%d\t%s\t%s\t%s\t%s\n", animal.getId(), animal.getClass().getSimpleName(),
                    animal.getName(), Config.dateFormat.format(animal.getBirth()), animal.getCommands());
        }
    }

    // парсинг даты
    public int tryParseDate(String string) {
        try {
            Config.dateFormat.parse(string);
            return 1;
        } catch (ParseException e) {
            System.out.println("Неправильный формат даты");
        }
        return -1;

    }

    // парсинг класса
    public int tryParseClassAnimal(String string) {
        int animalClass;
        try {
            animalClass = Integer.parseInt(string);
            return animalClass;
        } catch (NumberFormatException e) {
            System.out.println("Ошибка класса животного - класс не создан");
            return -1;
        }

    }

}