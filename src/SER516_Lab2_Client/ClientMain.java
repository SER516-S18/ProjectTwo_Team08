package SER516_Lab2_Client;


class ClientMain {

	public static int maxValue = Integer.MAX_VALUE;
	public static int minValue = Integer.MIN_VALUE;
	public static int globalSum = 0;
	public static int packetCount = 0;

	public static void main(String[] args){

		System.out.println("This client is running on Port: " + Consts.PORT_NUMBER + ".");

	}

	/** owner : Aashita Priya
	 * computeMax computes the maximum of inputs across all channels
	 * @param inputString : input string value intercepted by the client (comma separated)
	 */
	public static int computeMax(String inputString) {
		String[] inputVals = null;
		int iteratorVal = 0;
		if(!"".equals(inputString)){
			inputVals = inputString.split(",");
		}
		if(maxValue == Integer.MAX_VALUE){
			maxValue = Integer.parseInt (inputVals[0]);
			iteratorVal ++;
		}

		for(int i = iteratorVal; i < inputVals.length; i++){
			if(Integer.parseInt (inputVals[i]) > maxValue){
				maxValue = Integer.parseInt (inputVals[i]);
			}
		}

		return maxValue;
	}

	/** owner : Aashita Priya
	 * computeMin computes the minimum of inputs across all channels
	 * @param inputString : input string value intercepted by the client (comma separated)
	 */
	public static int computeMin(String inputString) {
		String[] inputVals = null;
		int iteratorVal = 0;
		if(!"".equals(inputString)){
			inputVals = inputString.split(",");
		}
		if(minValue == Integer.MIN_VALUE){
			minValue = Integer.parseInt (inputVals[0]);
			iteratorVal ++;
		}

		for(int i = iteratorVal; i < inputVals.length; i++){
			if(Integer.parseInt (inputVals[i]) < minValue){
				minValue = Integer.parseInt (inputVals[i]);
			}
		}

		return minValue;
	}

	/** owner : Aashita Priya
	 * computeAverage computes the running average of inputs across all channels
	 * @param inputString : input string value intercepted by the client (comma separated)
	 */
	public static float computeAverage(String inputString) {
		String[] inputVals = null;
		float runningAverage;

		if(!"".equals(inputString)){
			inputVals = inputString.split(",");
			packetCount += 1;
		}

		for(int i = 0; i < inputVals.length; i++){
			globalSum += Integer.parseInt (inputVals[i]);
		}

		runningAverage = (float) globalSum / (packetCount * inputVals.length);

		return runningAverage;
	}
}