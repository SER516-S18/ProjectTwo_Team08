package SER516_Lab2_Server;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;


/**
* Validates/formats the input entered through the UI
* @author Jason Rice
* @version 1
*/
public class InputFieldExtractor{
	final int defualtHigh = 10;
	final int defualtLow = 1;
	final int defualtFrequency = 1;

	/**
	* Takes the input fields for high, low and the frequency and sends them to be validated
	* then returns a map of the data if valid, else returns defualt values.
	* @param highInput
	* @param lowInput
	* @param frequencyInput
	* @return Map<String, Integer>
	*/
	public Map<String, Integer> getInputValues(JTextPane highInput, 
		JTextPane lowInput, JTextPane frequencyInput){

		Map<String, Integer> values = new HashMap<String, Integer>();
		int high, low, frequency;
		
		high = validateInputFromField(highInput, defualtHigh);
		low = validateInputFromField(lowInput, defualtLow);
		frequency = validateInputFromField(frequencyInput, defualtFrequency);

		if(low > high){
			values.put("high", low);
			values.put("low", high);
			highInput.setText("" + low);
			lowInput.setText("" + high);
			ServerUtils.displayConsoleMessage(
				"Highest and Lowest values switched.");
		} else if(low == high){
			values.put("high", high - 1);
			values.put("low", low);
		} else{
			values.put("high", high);
			values.put("low", low);
		}

		if(frequency < 0){
			ServerUtils.displayConsoleMessage(
				"Frequency entered was converted to a positive value.");
			values.put("frequency", -1 * frequency);
			frequencyInput.setText("" + (-1 * frequency));
		} else{
			values.put("frequency", frequency);
		}
		
		return values;
	}

	/**
	* Takes the input field and a default value and validates if the input
	* is a valid integer, if not it returns the default value.
	* @param inputField
	* @param defaultVal
	*/
	private int validateInputFromField(JTextPane inputField, int defaultVal){
		int returnValue = defaultVal;
		if(inputField.getText() != ""){
			try{
				returnValue = Integer.parseInt(inputField.getText().trim());
			} catch(Exception exception){
				String errorMessage = "non-integer value entered for Highest, default used.";
				ServerUtils.displayConsoleMessage(errorMessage);
				inputField.setText("" + defaultVal);
			}
		}
		return returnValue;
	}
}