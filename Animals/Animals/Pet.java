package Animals;

import java.util.Date;
import MVP.AnimalFactory.AnimalType;

public class Pet extends Animal {

  private AnimalType type;

  public Pet(String name, Date date, String commands) {
    super(name, date, commands);
    this.type = AnimalType.PETS;
  }

  public AnimalType getType() {
    return type;
  }

  public void setType(AnimalType type) {
    this.type = type;
  }

}
