package Animals;

import java.util.Date;
import MVP.AnimalFactory.AnimalType;

public class PackAnimal extends Animal {

  private AnimalType type;

  public PackAnimal(String name, Date date, String commands) {
    super(name, date, commands);
    this.type = AnimalType.PACKANIMALS;
  }

  public AnimalType getType() {
    return type;
  }

  public void setType(AnimalType type) {
    this.type = type;
  }

}
