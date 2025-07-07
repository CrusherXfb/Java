package Strings;

import java.io.File;

public class Strings58 {

    public static void main(String[] args) {
        String fullPath = "C:\\Users\\admin\\AppData\\Roaming\\Minecraft\\Minecraft.exe";
        String fileNameWithoutExtension = getFileNameWithoutExtension(fullPath);
        System.out.println("Полный путь: " + fullPath);
        System.out.println("Имя файла без расширения: " + fileNameWithoutExtension);
    }

    public static String getFileNameWithoutExtension(String fullPath) {
        File file = new File(fullPath);
        String fileName = file.getName();
        int lastDotIndex = fileName.lastIndexOf('.');

        if (lastDotIndex > 0) {
            return fileName.substring(0, lastDotIndex);
        } else {
            return fileName;
        }
    }
}
