package SER516_Lab2_Client;

public class Stats {

    private static int maxValue = Integer.MIN_VALUE;
    private static int minValue = Integer.MAX_VALUE;
    private static float runningAverage = 0;
    private static int packetCount = 0;

    /** 
     * Function computeMax computes the maximum of inputs across all channels  
     * @author Aashita Priya
     * @param inputVals : input array value intercepted by the client
     */
    public static int computeMax(int[] inputVals) {

        for(int i = 0; i < inputVals.length; i++){
            if(inputVals[i] > maxValue){
                maxValue = inputVals[i];
            }
        }

        return maxValue;
    }

    /** 
     * Function computeMin computes the minimum of inputs across all channels
     * @author Aashita Priya
     * @param inputVals : input array value intercepted by the client
     */
    public static int computeMin(int[] inputVals) {

        for(int i = 0; i < inputVals.length; i++){
            if(inputVals[i] < minValue){
                minValue = inputVals[i];
            }
        }

        return minValue ;
    }

    /** 
     * Function computeAverage computes the running average of inputs across all channels
     * @author Aashita Priya
     * @param inputVals : input array value intercepted by the client
     */
    public static float computeAverage(int[] inputVals) {

        float localSum = 0;
        for(int i = 0; i < inputVals.length; i++){
            localSum += inputVals[i];
            packetCount++;
        }

        runningAverage = (runningAverage * (packetCount - inputVals.length))/packetCount + (localSum/packetCount);

        return runningAverage;
    }
}
