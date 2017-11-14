package layers;

public class StudentApplicationLayer implements StudentApplicationLayerInterface
{
	// The underlying data layer this application layer sits upon
	private StudentDataLayerInterface dataLayer;
	
	/**
	 * Default constructor
	 * 
	 * @param dataLayer The data layer that this layer sits upon
	 */
	public StudentApplicationLayer(StudentDataLayerInterface dataLayer)
	{
		this.dataLayer = dataLayer;
	}
	
	public String addStudent(String matric, String name, String programme) 
	{
		// First create a Student record object
		Student student = new Student(matric, name, programme);
		// Try and add the record to the data layer
		boolean success = dataLayer.addStudent(student);
		// Either the record was added or not.  Return an appropriate message
		if (success)
		{
			return "Student " + matric + " added";
		}
		else
		{
			return "Failed to add Student: " + matric;
		}
	}

	public String getStudent(String matric) 
	{
		// Try and get the Student record object from the data layer
		Student student = dataLayer.getStudent(matric);
		// If the Student record does not exist, the data layer will return null
		if (student != null)
		{
			// Return textual representation of the Student record
			return "Matriculation number: "+ student.getMatric() + "\nName: " + student.getName() + "\nProgramme: " + student.getProgramme();
		}
		else
		{
			// Return fail message
			return "Student " + matric + " does not exist";
		}
	}

	public String removeStudent(String matric) 
	{
		// Try and remove the Student from the data layer
		boolean success = dataLayer.removeStudent(matric);
		// Either we were successful or not.  Return appropriate message
		if (success)
		{
			return "Student " + matric + " removed";
		}
		else
		{
			return "Failed to remove Student " + matric;
		}
	}

	public String updateStudent(String matric, String name, String programme) 
	{
		// Create a new Student record object
		Student student = new Student(matric, name, programme);
		// Try and update the Student record with the data layer
		boolean success = dataLayer.updateStudent(matric, student);
		// Either we were successful or not.  Return appropriate message.
		if (success)
		{
			return "Student " + matric + " successfully updated";
		}
		else
		{
			return "Student " + matric + " not updated";
		}
	}

}
