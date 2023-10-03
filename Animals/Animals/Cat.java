package Animals;

import java.util.Date;
import MVP.AnimalFactory.AnimalClass;
import Service.Config;

public class Cat extends Pet {
    AnimalClass classAnimal;

    public Cat(String name, Date date, String commands) {
        super(name, date, commands);
        this.classAnimal = AnimalClass.CAT;
        
    }

    public AnimalClass getClassAnimal() {
        return classAnimal;
    }
    public void setClassAnimal(AnimalClass classAnimal) {
        this.classAnimal = classAnimal;
    }
  
    @Override
    public String toString() {
        return "Кошка {" +
                "Имя = '" + super.getName() + '\'' +
                ", тип = '"+ super.getType()+ '\''+", класс = '"+ getClassAnimal()+ '\'' + ", команды = " + super.getCommands() + '\'' +
                ", дата рождения = '" + Config.dateFormat.format(super.getBirth()) + '\'' +
                '}';
    }
   
}