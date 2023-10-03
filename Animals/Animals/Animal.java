package Animals;

import java.util.Date;
import Service.Counter;

public class Animal {
  private int id;
  private String name;
  protected Date birth;
  private String commands;

  public Animal(String name, Date birth, String commands) {
    Counter.setIndex();
    this.id=Counter.getIndex();
    this.name = name;
    this.birth = birth;
    this.commands = commands;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getBirth() {
    return birth;
  }

  public void setBirth(Date birth) {
    this.birth = birth;
  }

  public String getCommands() {
    return commands;
  }

  public void setCommands(String commands) {
    this.commands = commands;
  }

  public int getId() {
    return id;
  }

 
}
