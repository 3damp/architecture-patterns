package p4.student_record_system_gui;

import java.util.*;

public class StudentDataLayer implements StudentDataLayerInterface
{
	// The data store holding the Student details.  We use a HashMap for simplicity
	private HashMap<String, Student> students = new HashMap<String, Student>();
	
	/**
	 * Default constructor
	 */
	public StudentDataLayer()
	{
	}
	
	public boolean addStudent(Student student) 
	{
		// First check that no student with the same matric number exists
		if (students.containsKey(student.getMatric()))
		{
			// Student with that matric number exists.  Return false
			return false;
		}
		else
		{
			// No Student with that matric number exists.  Add Student to data store
			students.put(student.getMatric(), student);
			// Return true
			return true;
		}
	}

	public Student getStudent(String matric) 
	{
		// Retrieve the Student from the data store
		Student student = (Student)students.get(matric);
		// If no Student with that matric number is stored in the data store, then 
		// the previous operation will have returned null.  Therefore we simply return
		// whatever the outcome of the previous call was
		return student;
	}

	public boolean removeStudent(String matric) 
	{
		// First check if a Student with that matric number exists
		if (students.containsKey(matric))
		{
			// Student exists.  Remove Student record from data store
			students.remove(matric);
			// Return true
			return true;
		}
		else
		{
			// Student does not exist.  Return false
			return false;
		}
	}

	public boolean updateStudent(String matric, Student student) 
	{
		// First check if the Student record exists
		if (students.containsKey(matric))
		{
			// The Student record exists, therefore we can update it.
			// First retrieve the Student record from the data store
			Student toUpdate = (Student)students.get(matric);
			// Now update the Student record with the new name and programme
			toUpdate.setName(student.getName());
			toUpdate.setProgramme(student.getProgramme());
			// Return true
			return true;
		}
		else
		{
			// Student does not exist.  Return false.
			return false;
		}
	}
	
}
