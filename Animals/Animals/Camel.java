package Animals;

import java.util.Date;
import MVP.AnimalFactory.AnimalClass;
import Service.Config;

public class Camel extends Pet {
    AnimalClass classAnimal;

    public Camel(String name, Date date, String commands) {
        super(name, date, commands);
        this.classAnimal = AnimalClass.CAMEL;
    }

    public AnimalClass getClassAnimal() {
        return classAnimal;
    }
    public void setClassAnimal(AnimalClass classAnimal) {
        this.classAnimal = classAnimal;
    }
  
    @Override
    public String toString() {
        return "Верблюд {" +
                "Имя = '" + super.getName() + '\'' +
                ", тип = '"+ super.getType()+ '\''+", класс = '"+ getClassAnimal()+ '\'' + ", команды = " + super.getCommands() + '\'' +
                ", дата рождения = '" + Config.dateFormat. format(super.getBirth()) + '\'' +
                '}';
    }
  
}
