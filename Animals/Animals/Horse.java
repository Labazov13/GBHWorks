package Animals;

import java.util.Date;

import MVP.AnimalFactory.AnimalClass;
import Service.Config;

public class Horse extends Pet {
    AnimalClass classAnimal;

    public Horse(String name, Date date, String commands) {
        super(name, date, commands);
        this.classAnimal = AnimalClass.HORSE;
    }

    public AnimalClass getClassAnimal() {
        return classAnimal;
    }
    public void setClassAnimal(AnimalClass classAnimal) {
        this.classAnimal = classAnimal;
    }
  
    @Override
    public String toString() {
        return "Лошадь {" +
                "Имя = '" + super.getName() + '\'' +
                ", тип = '"+ super.getType()+ '\''+", класс = '"+ getClassAnimal()+ '\'' + ", команды = " + super.getCommands() + '\'' +
                ", дата рождения = '" + Config.dateFormat.format(super.getBirth()) + '\'' +
                '}';
    }
  
}
