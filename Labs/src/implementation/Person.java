/*
 * Daniel Kozlovsky
 * 214874879
 * Sept.27th 2017
 * Lab 2 
 * Person implementation for BMICalculator 
 * 
 */

package implementation;

/**
 * Person -- Person info pertaining to BMI
 * 
 * @author Daniel Kozlovsky
 * 
 * 
 */
public class Person {

	private final String UNDERWEIGHT = "underweight";
	private final String NORMAL = "normal";
	private final String OVERWEIGHT = "overweight";
	private final String OBESE = "obese";

	private String name;
	private double height;
	private double weight;
	private double bmi;

	/**
	 * Person with a name
	 * 
	 * @param name
	 *            name of person
	 */
	public Person(String name) {
		this.name = name;
		height = 0;
		weight = 0;
		bmi = 0;
	}

	/**
	 * Set the person's weight
	 * 
	 * @param weight
	 *            Weight of the person
	 * @throws IllegalArgumentException
	 *             thrown if weight is negative
	 */
	public void setWeight(double weight) throws IllegalArgumentException {
		if (weight <= 0) {
			throw new IllegalArgumentException("Cannot have a negative weight");
		} else {
			this.weight = weight;
		}
	}

	/**
	 * Set the person's height
	 * 
	 * @param height
	 *            Height of the person
	 * @throws IllegalArgumentException
	 *             thrown if height is negative
	 */
	public void setHeight(double height) throws IllegalArgumentException {
		if (height <= 0) {
			throw new IllegalArgumentException("Cannot have a negative height");
		} else {
			this.height = height;
		}
	}

	/**
	 * Returns person's weight
	 * 
	 * @return current weight of the person
	 */
	public double getWeight() {
		return this.weight;
	}

	/**
	 * Returns person's weight
	 * 
	 * @return current height of the person
	 */
	public double getHeight() {
		return this.height;
	}

	/**
	 * Gets the person's name
	 * 
	 * @return the person's name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Returns the current BMI
	 * 
	 * @return person's BMI
	 */
	public double getBMI() {
		return bmi = Math.round((weight / Math.pow(height, 2)) * 10.0) / 10.0;
	}

	/**
	 * Gets BMI classification of current BMI
	 * 
	 * @return The string definition of current BMI range
	 */
	public String getInterpretationOfBMI() {
		if (bmi < 18.5) {
			return this.UNDERWEIGHT;
		} else if (bmi < 25.0) {
			return this.NORMAL;
		} else if (bmi < 30.0) {
			return this.OVERWEIGHT;
		} else if (bmi > 30.0) {
			return this.OBESE;
		}
		return "";
	}

	

}
