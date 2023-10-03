package Service;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class Config {
  // кодировка вывода в консоль
  public static String charSet = "Cp866";
  // путь файла csv
  public static String pathDB = "Animals/data.csv";
  public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());

}
