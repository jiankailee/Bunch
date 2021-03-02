package bunch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DataCleaning {
    public static void main(String[] args) {

        final String currentDirectory = System.getProperty("user.dir");
        Scanner in = new Scanner(System.in);

        try {
            System.out.println("File to clean: ");
            String filepath = in.nextLine();
            File file = new File(currentDirectory+filepath);
            System.out.println("New Filename modified: ");
            String modifiedFilePath = in.nextLine();
            FileWriter filewriter = new FileWriter(currentDirectory+modifiedFilePath);
            Scanner scanner =new Scanner(file);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                //System.out.println(line);
                String[] sep = line.split("    ");
                if(sep.length>1){
                    System.out.println(sep[0]+" "+sep[1]);
                    filewriter.write(sep[0]+" "+sep[1]+"\n");
                    //System.out.println(scanner.nextLine());
                }

            }
            scanner.close();
            filewriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
