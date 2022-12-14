import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class FileReadWrite {
    public static HashMap<String, Integer> readFile(String fileName) {
        HashMap<String, Integer> rows = new HashMap<String, Integer>();
        try {
            File file = new File(fileName);
            Scanner sc = new Scanner(file);
            String[] tempRow;
            while (sc.hasNextLine()) {
                tempRow = sc.nextLine().split(":");
                rows.put(tempRow[0], Integer.parseInt(tempRow[1]));
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            e.printStackTrace();
        }
        return(rows);
    }

    public static void writeFile(String fileName, HashMap<String, Integer> data) {
        HashMap<String, Integer> file = readFile(fileName);
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            file.put(entry.getKey(), entry.getValue());
        }
        try {
            FileWriter writer = new FileWriter(fileName);
            BufferedWriter output = new BufferedWriter(writer);
            for (Map.Entry<String, Integer> entry : file.entrySet()) {
                output.write(entry.getKey()+":"+Integer.toString(entry.getValue()));
                output.newLine();
            }
            output.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void deleteItem(String fileName, String key) {
        HashMap<String, Integer> file = readFile(fileName);
        file.remove(key);
        try {
            FileWriter writer = new FileWriter(fileName);
            BufferedWriter output = new BufferedWriter(writer);
            for (Map.Entry<String, Integer> entry : file.entrySet()) {
                output.write(entry.getKey()+":"+Integer.toString(entry.getValue()));
                output.newLine();
            }
            output.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> parseTextFile(String fileName) throws FileNotFoundException 
    {
        Scanner s = new Scanner(new File(fileName));
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNext()){
            list.add(s.next());
        }
        s.close();
        return list;
    }
}
