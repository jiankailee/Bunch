package bunch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class DataCleaning {
    public static void main(String[] args) {

        final String currentDirectory = System.getProperty("user.dir");
        Scanner in = new Scanner(System.in);

        try {
            System.out.println("Enter Filename and path to clean in Bunch Directory: ");
            String filepath = in.nextLine();
            File file = new File(currentDirectory+filepath);
            System.out.println("Enter New Filename modified and: path in Bunch Directory ");
            String modifiedFilePath = in.nextLine();
            FileWriter filewriter = new FileWriter(currentDirectory+modifiedFilePath);
            Scanner scanner =new Scanner(file);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();

                String[] sep = line.split("    ");
                if(sep.length>1){
                    filewriter.write(sep[0]+" "+sep[1]+"\n");
                }

            }
            scanner.close();
            filewriter.close();
            System.out.println("Finished Clean");
            System.out.println("File located at "+currentDirectory+modifiedFilePath);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
