package MVP;

import java.text.ParseException;

import Animals.Animal;
import Animals.Camel;
import Animals.Cat;
import Animals.Dog;
import Animals.Donkey;
import Animals.Hamster;
import Animals.Horse;
import Service.Config;

public class AnimalFactory {
  public static Animal createAnimal(AnimalClass className, String name, String date, String commands) throws ParseException {
    Animal animal;
      switch (className) {
        case CAT :
          animal = new Cat(name, Config.dateFormat.parse(date), commands);
          break;
        case DOG:
          animal = new Dog(name, Config.dateFormat.parse(date), commands);
          break;
        case HAMSTER:
          animal = new Hamster(name, Config.dateFormat.parse(date), commands);
          break;
        case HORSE:
          animal = new Horse(name, Config.dateFormat.parse(date), commands);
          break;
        case CAMEL:
          animal = new Camel(name, Config.dateFormat.parse(date), commands);
          break;
        case DONKEY:
          animal = new Donkey(name, Config.dateFormat.parse(date), commands);
          break;
          default:
          animal = null;

      }

    return animal;
  }

  // типы животных
  public enum AnimalType {
    PETS,
    PACKANIMALS
  }

  // классы домашних животных
  public enum AnimalClass {
    CAT,
    DOG,
    HAMSTER,
    HORSE,
    CAMEL,
    DONKEY,
    NONE
  }



}