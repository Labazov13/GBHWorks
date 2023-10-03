package MVP;

import java.util.ArrayList;
import Animals.Animal;

public interface View {

  // печать всех животных
  void print(ArrayList<Animal> list);

  // вывод животного
  void printAnimal(Animal animal);

  String getName();

  String getBirth();

  String getCommands();

  MVP.AnimalFactory.AnimalClass getClassAnimal();

}