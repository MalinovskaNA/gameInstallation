package ru.netology.lessonN;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        File[] dirs = {new File("D://Games//src"),
                new File("D://Games//res"),
                new File("D://Games//savegames"),
                new File("D://Games//temp"),
                new File("D://Games//src//main"),
                new File("D://Games//src//test"),
                new File("D://Games//res//drawables"),
                new File("D://Games//res//vectors"),
                new File("D://Games//res//icons")};
        File[] files = {new File("D://Games//temp", "temp.txt"),
                new File("D://Games//src//main", "Main.java"),
                new File("D://Games//src//main", "Utils.java")};

        for (File dir : dirs) {
            if (dir.mkdir())
                sb = sb.append(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime())
                        + " Каталог " + dir.getName() + " создан в " + dir.getParent() + '\n');
        }
        for (File file : files) {
            try {
                if (file.createNewFile())
                    sb = sb.append(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime())
                            + " Файл " + file.getName() + " создан в " + file.getParent() + '\n');
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

        try (FileWriter writer = new FileWriter("D://Games//temp//temp.txt", false)) {
            writer.write(sb.toString());
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
