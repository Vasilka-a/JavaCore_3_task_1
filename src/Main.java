import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();

        File src = new File("D://Games/src");
        File res = new File("D://Games/res");
        File savegames = new File("D://Games/savegames");
        File temp = new File("D://Games/temp");
        File main = new File("D://Games/src/main");
        File test = new File("D://Games/src/test");
        File drawables = new File("D://Games/res/drawables");
        File vectors = new File("D://Games/res/vectors");
        File icons = new File("D://Games/res/icons");

        ArrayList<File> directors = new ArrayList<>();
        directors.add(src);
        directors.add(res);
        directors.add(savegames);
        directors.add(temp);
        directors.add(main);
        directors.add(test);
        directors.add(drawables);
        directors.add(vectors);
        directors.add(icons);

        for (File file : directors) {
            if (file.mkdir()) {
                sb.append("Директория " + file.getName() + " создана" + '\n');
            } else {
                sb.append("Директория " + file.getName() + " не создана" + '\n');
            }
        }

        File mainGame = new File("D://Games/src/main/Main.java");
        File utils = new File("D://Games/src/main/Utils.java");
        File info = new File("D://Games/temp/temp.txt");

        ArrayList<File> files = new ArrayList<>();
        files.add(mainGame);
        files.add(utils);
        files.add(info);

        for (File file : files) {
            try {
                if (file.createNewFile()) {
                    sb.append("Файл " + file.getName() + " создан" + '\n');
                } else {
                    sb.append("Файл " + file.getName() + " создан" + '\n');
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

            String text = sb.toString();

            try (FileWriter writer = new FileWriter("D://Games/temp/temp.txt", false)) {
                writer.write(text);
                writer.flush();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}