package bunch;

import bunch.api.BunchAPI;
import bunch.api.BunchProperties;

import java.util.Scanner;

public class BunchTesting {
    public static void main(String[] args) {

        final String currentDirectory = System.getProperty("user.dir");
        System.out.println("Starting Bunch....");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter mdg filepath in Bunch Directory:");
        String mdgFilePath = in.nextLine();

        System.out.println("Enter a output directory for DOT file:");
        String dotFileOutputPath = in.nextLine();


        //System.out.println(currentDirectory + mdgFilePath);
        BunchAPI api = new BunchAPI();
        BunchProperties bp = new BunchProperties();
        bp.setProperty(BunchProperties.MDG_INPUT_FILE_NAME,currentDirectory + mdgFilePath);
        bp.setProperty(BunchProperties.CLUSTERING_ALG,BunchProperties.ALG_HILL_CLIMBING);
        bp.setProperty(BunchProperties.ALG_HC_HC_PCT,"100");
        bp.setProperty(BunchProperties.ALG_HC_RND_PCT,"0");
//        bp.setProperty(BunchProperties.ALG_HC_SA_CLASS,"bunch.SASimpleTechnique");
//        bp.setProperty(BunchProperties.ALG_HC_SA_CONFIG,"InitialTemp=100.0,Alpha=0.95");
        bp.setProperty(BunchProperties.OUTPUT_FORMAT,BunchProperties.DOT_OUTPUT_FORMAT);
        bp.setProperty(BunchProperties.OUTPUT_DIRECTORY,currentDirectory + dotFileOutputPath);
        api.setProperties(bp);
        System.out.println("Running....");
        api.run();

        System.out.println("Finished ");


    }
}
