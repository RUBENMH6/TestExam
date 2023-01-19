import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReadGame {


    public static void main(String[] args) throws IOException {
        System.out.println("Enter a file: ");
        Scanner in = new Scanner(System.in);
        String file = in.nextLine();

        BufferedReader input = null;

        try {
            input = new BufferedReader(new FileReader(file));
            String line;
            Map<String, List<Card>> map = new HashMap<>();

            while ((line = input.readLine() )!= null) {
                String[] items = line.split(",");
                String name = items [0];
                List<Card> list = new ArrayList<>();
                for (int i = 1; i < items.length ; i += 2) {
                    int number = Integer.parseInt(items[i]);
                    int suit = Integer.parseInt(items[i+1]);
                    Card card = new Card (number,suit);
                    list.add(card);
                }
                map.put(name,list);
                KeyAndList<String,Card> keyAndList = new KeyAndList<>(name,list)  ;
                System.out.println(keyAndList);
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found");
            System.exit(1);
        }catch (IOException e) {
            System.err.println("Error reading file");
            System.exit(1);
        } finally {
            if (input != null ) {
                input.close();
            }
        }

    }
}
