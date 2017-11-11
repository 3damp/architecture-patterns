package p4.student_record_system;

public interface StudentApplicationLayerInterface {
	/**
	 * Adds a new Student to the underlying Data Layer
	 * 
	 * @param matric
	 *            The Student's matric number
	 * @param name
	 *            The Student's name
	 * @param programme
	 *            The Student's programme
	 * @return Message indicating outcome of adding Student
	 */
	public String addStudent(String matric, String name, String programme);

	/**
	 * Updates an existing Student record
	 * 
	 * @param matric
	 *            The Student's matric number
	 * @param name
	 *            The Student's updated name
	 * @param programme
	 *            The Student's updated programme
	 * @return Message indicating outcome of updating the Student
	 */
	public String updateStudent(String matric, String name, String programme);

	/**
	 * Gets a Student record
	 * 
	 * @param matric
	 *            The matric number of the Student to get
	 * @return Message indicating the outcome of getting the Student
	 */
	public String getStudent(String matric);

	/**
	 * Removes a Student record
	 * 
	 * @param matric
	 *            The matric number of the Student to remove
	 * @return Message indicating the oucome of removing the Student
	 */
	public String removeStudent(String matric);
}
