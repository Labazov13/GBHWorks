package MVP;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import Animals.Animal;
import MVP.AnimalFactory.AnimalClass;
import Service.Config;
import Service.Counter;

public class Model {

    ArrayList<Animal> animals;

    public Model() {
        animals = new ArrayList<>();
        new Counter();
        // currentIndex = 0;
    }

    // добавление животного
    public boolean add(Animal animal) {
        // boolean flag = false;
        if (!animals.contains(animal)) {
            animals.add(animal);
            return true;
        } else {

            return false;
        }
    }

    // чтение животного
    public Animal getAnimal(int index) {
        return contains(index) ? animals.get(index) : null;
    }

    // проверка индекса
    private boolean contains(int index) {
        return animals != null
                && animals.size() > index;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    // количество всех животных
    public int count() {
        return animals.size();
    }

    public void load() {
        try {
            File file = new File(Config.pathDB);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String currLine = reader.readLine();
            while (currLine != null) {
                String[] line = currLine.split(",");
                String id = line[0];
                String name = line[1];
                AnimalClass classname = loadClassAnimal(line[2]);
                String birth = line[3];
                String commands = line[4];
                this.animals.add(AnimalFactory.createAnimal(classname, name, birth, commands));
                currLine = reader.readLine();
            }
            reader.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //
    public AnimalClass loadClassAnimal(String fileClass) {
        AnimalClass res;

        switch (fileClass.trim()) {
            case "кошка":
                res = AnimalClass.CAT;
                break;
            case "собака":
                res = AnimalClass.DOG;
                break;
            case "хомяк":
                res = AnimalClass.HAMSTER;
                break;
            case "лошадь":
                res = AnimalClass.HORSE;
                break;
            case "верблюд":
                res = AnimalClass.CAMEL;
                break;
            case "осёл":
                res = AnimalClass.DONKEY;
                break;
            default:
                res = AnimalClass.NONE;
                break;
        }
        return res;
    }

    public void clear() {

        this.animals = new ArrayList<Animal>();
        new Counter();
    }

    public ArrayList<Animal> Animals() {
        return this.animals;
    }

}