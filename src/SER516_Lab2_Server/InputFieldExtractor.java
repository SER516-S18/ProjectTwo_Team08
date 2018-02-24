package SER516_Lab2_Server;

import javax.swing.JTextPane;
import java.util.HashMap;
import java.util.Map;


/**
* Validates/formats the input entered through the UI
* @author Jason Rice
* @version 1.0
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
		int high, low;
		
		high = validateInputFromField(highInput, defualtHigh);
		low = validateInputFromField(lowInput, defualtLow);

		if(low > high){
			values.put("high", low);
			values.put("low", high);
		} else if(low == high){
			values.put("high", high - 1);
			values.put("low", low);
		} else{
			values.put("high", high);
			values.put("low", low);
		}

		values.put("frequency", validateInputFromField(frequencyInput, defualtFrequency));

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
				returnValue = Integer.parseInt(inputField.getText());
			} catch(Exception e){
				String errorMessage = "non-integer value entered for Highest, default used.";
				ServerUtils.displayConsoleMessage(errorMessage);
			}
		}
		return returnValue;
	}
}