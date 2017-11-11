package p4.student_record_system;

public interface StudentDataLayerInterface {
	/**
	 * Adds a new Student to the data store
	 * 
	 * @param student
	 *            Student to add to the data store
	 * @return True if Student added, false otherwise
	 */
	public boolean addStudent(Student student);

	/**
	 * Returns a Student record from the data store
	 * 
	 * @param matric
	 *            The matric number of the Student to get
	 * @return The Student record if it exists, null otherwise
	 */
	public Student getStudent(String matric);

	/**
	 * Removes a Student record from the data store
	 * 
	 * @param matric
	 *            The matric number of the Student record to remove
	 * @return True if the Student was removed, false otherwise
	 */
	public boolean removeStudent(String matric);

	/**
	 * Updates a Student record in the data store
	 * 
	 * @param matric
	 *            The matric number of the Student record to update
	 * @param student
	 *            The new Student record
	 * @return True if the record was updated, false otherwise
	 */
	public boolean updateStudent(String matric, Student student);
}
