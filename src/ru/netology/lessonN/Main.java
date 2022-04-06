package ru.netology.lessonN;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main {

    public static void main(String[] args) {

        File dirGames = new File("D://Games");
        File dirSrc = new File("D://Games//src");
        StringBuilder sb = new StringBuilder();

        if (dirSrc.mkdir())
            sb = sb.append(sbAppend(dirSrc.getName(), String.valueOf(dirGames)));
        File dirRes = new File("D://Games//res");
        if (dirRes.mkdir())
            sb = sb.append(sbAppend(dirRes.getName(), String.valueOf(dirGames)));
        File dirSvegames = new File("D://Games//savegames");
        if (dirSvegames.mkdir())
            sb = sb.append(sbAppend(dirSvegames.getName(), String.valueOf(dirGames)));
        File dirTemp = new File("D://Games//temp");
        if (dirTemp.mkdir())
            sb = sb.append(sbAppend(dirTemp.getName(), String.valueOf(dirGames)));
        File fileTemp = new File(dirTemp, "temp.txt");
        try {
            if (fileTemp.createNewFile())
                sb = sb.append(sbAppend(fileTemp.getName(), String.valueOf(dirTemp)));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        File dirMain = new File("D://Games//src//main");
        if (dirMain.mkdir())
            sb = sb.append(sbAppend(dirMain.getName(), String.valueOf(dirSrc)));
        File dirTest = new File("D://Games//src//test");
        if (dirTest.mkdir())
            sb = sb.append(sbAppend(dirTest.getName(), String.valueOf(dirSrc)));
        File fileMain = new File(dirMain, "Main.java");
        try {
            if (fileMain.createNewFile())
                sb = sb.append(sbAppend(fileMain.getName(), String.valueOf(dirMain)));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        File fileUtils = new File(dirMain, "Utils.java");
        try {
            if (fileUtils.createNewFile())
                sb = sb.append(sbAppend(fileUtils.getName(), String.valueOf(dirMain)));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        File dirDrawables = new File("D://Games//res//drawables");
        if (dirDrawables.mkdir())
            sb = sb.append(sbAppend(dirDrawables.getName(), String.valueOf(dirRes)));

        File dirVectors = new File("D://Games//res//vectors");
        if (dirVectors.mkdir())
            sb = sb.append(sbAppend(dirVectors.getName(), String.valueOf(dirRes)));

        File dirIcons = new File("D://Games//res//icons");
        if (dirIcons.mkdir())
            sb = sb.append(sbAppend(dirIcons.getName(), String.valueOf(dirRes)));

        try (FileWriter writer = new FileWriter("D://Games//temp//temp.txt", false)) {
            writer.write(sb.toString());
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static StringBuilder sbAppend(String file, String dir) {
        return new StringBuilder(
                new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime())
                        + " Каталог " + file + " создан в каталоге " + dir + '\n');

    }
}
