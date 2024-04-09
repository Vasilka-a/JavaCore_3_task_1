import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();

        ArrayList<String> directory = new ArrayList<>();
        directory.add("D://Games/src");
        directory.add("D://Games/res");
        directory.add("D://Games/savegames");
        directory.add("D://Games/temp");
        directory.add("D://Games/src/main");
        directory.add("D://Games/src/test");
        directory.add("D://Games/res/drawables");
        directory.add("D://Games/res/vectors");
        directory.add("D://Games/res/icons");

        createDirectory(directory, sb);

        ArrayList<String> files = new ArrayList<>();
        files.add("D://Games/src/main/Main.java");
        files.add("D://Games/src/main/Utils.java");
        files.add("D://Games/temp/temp.txt");

        createFiles(files, sb);

        createLog(sb);
    }

    public static void createDirectory(ArrayList<String> directory, StringBuilder sb) {
        for (String name : directory) {
            File file = new File(name);
            if (file.mkdir()) {
                sb.append("Директория " + file.getName() + " создана" + '\n');
            } else {
                sb.append("Директория " + file.getName() + " не создана" + '\n');
            }
        }
    }

    public static void createFiles(ArrayList<String> files, StringBuilder sb) {
        for (String name : files) {
            File file = new File(name);
            try {
                if (file.createNewFile()) {
                    sb.append("Файл " + file.getName() + " создан" + '\n');
                } else {
                    sb.append("Файл " + file.getName() + " не создан" + '\n');
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void createLog(StringBuilder sb) {
        String text = sb.toString();
        try (FileWriter writer = new FileWriter("D://Games/temp/temp.txt", false)) {
            writer.write(text);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

