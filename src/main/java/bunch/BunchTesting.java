package bunch;

import bunch.api.BunchAPI;
import bunch.api.BunchProperties;

import java.sql.SQLOutput;
import java.util.Hashtable;
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


        System.out.println("Input - MDG filepath: "+currentDirectory + mdgFilePath);
        System.out.println("Output - DOT directory path: "+currentDirectory + dotFileOutputPath);
        BunchAPI api = new BunchAPI();
        BunchProperties bp = new BunchProperties();
        bp.setProperty(BunchProperties.MDG_INPUT_FILE_NAME,currentDirectory + mdgFilePath);
        bp.setProperty(BunchProperties.CLUSTERING_ALG,BunchProperties.ALG_HILL_CLIMBING);
        bp.setProperty(BunchProperties.ALG_HC_HC_PCT,"100");
        bp.setProperty(BunchProperties.ALG_HC_RND_PCT,"100");
        bp.setProperty(BunchProperties.OUTPUT_FORMAT,BunchProperties.DOT_OUTPUT_FORMAT);
        bp.setProperty(BunchProperties.OUTPUT_DIRECTORY,currentDirectory + dotFileOutputPath);
        api.setProperties(bp);
        System.out.println("Running....");
        api.run();
        System.out.println("Results: ");
        Hashtable results = api.getResults();
        printResutls(results);
        System.out.println("Finished ");


    }

    public static void printResutls(Hashtable results)
    {
        String rt = (String)results.get(BunchAPI.RUNTIME);
        String evals = (String)results.get(BunchAPI.MQEVALUATIONS);
        String levels = (String)results.get(BunchAPI.TOTAL_CLUSTER_LEVELS);
        String saMovesTaken = (String)results.get(BunchAPI.SA_NEIGHBORS_TAKEN);

        System.out.println("Runtime = " + rt + " ms.");
        System.out.println("Total MQ Evaluations = " + evals);
        System.out.println("Simulated Annealing Moves Taken = " + saMovesTaken);
        System.out.println();
        Hashtable [] resultLevels = (Hashtable[])results.get(BunchAPI.RESULT_CLUSTER_OBJS);

        for(int i = 0; i < resultLevels.length; i++)
        {
            Hashtable lvlResults = resultLevels[i];
            System.out.println("***** LEVEL "+i+"*****");
            String mq = (String)lvlResults.get(BunchAPI.MQVALUE);
            String depth = (String)lvlResults.get(BunchAPI.CLUSTER_DEPTH);
            String numC = (String)lvlResults.get(BunchAPI.NUMBER_CLUSTERS);

            System.out.println("  MQ Value = " + mq);
            System.out.println("  Best Cluster Depth = " + depth);
            System.out.println("  Number of Clusters in Best Partition = " + numC);
            System.out.println();
        }
    }
}
