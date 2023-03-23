import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Task3Test {
    public static void main(String[] args) {
        Map<String, Integer> value = new HashMap<>();

        try (InputStream fis = new FileInputStream("src/words.txt");
             Scanner scanner = new Scanner(fis)) {
            String[] splitLine = new String[0];
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                splitLine = line.split(" ");
            }

            for (String s : splitLine) {
                if (value.containsKey(s)) {
                    value.put(s, value.get(s) + 1);
                } else {
                    value.put(s, 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return value.get(o1).compareTo(value.get(o2)) > 0 ? 1 : -1;
            }
        };
        Map<String, Integer> result = new TreeMap<>(comparator.reversed());
            result.putAll(value);
        System.out.println(result);

    }
}
