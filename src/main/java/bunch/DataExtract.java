package bunch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DataExtract {
    public static void main(String[] args) {
        int lineNumber =1;

        final String currentDirectory = System.getProperty("user.dir");
        Scanner in = new Scanner(System.in);

        try {
            System.out.println("Enter Filename and path to extract range of data in Bunch Directory: ");
            String filepath = in.nextLine();
            File file = new File(currentDirectory+filepath);

            System.out.println("Enter New Filename modified and path in Bunch Directory: ");
            String modifiedFilePath = in.nextLine();
            FileWriter filewriter = new FileWriter(currentDirectory+modifiedFilePath);

            System.out.println("Enter starting line number: ");
            int startingLineNum = Integer.parseInt(in.nextLine());
            System.out.println("Enter ending line number: ");
            int endingLineNum = Integer.parseInt(in.nextLine());
            System.out.println(String.format("Starting line number: %d, Ending line Number: %d", startingLineNum,endingLineNum));

            Scanner scanner =new Scanner(file);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                if(lineNumber>=startingLineNum&&lineNumber<=endingLineNum){
//                    System.out.println(lineNumber+" "+line);
                    filewriter.write(line+"\n");
                }
                lineNumber++;


            }
            scanner.close();
            filewriter.close();
            System.out.println("Finished Extract");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
