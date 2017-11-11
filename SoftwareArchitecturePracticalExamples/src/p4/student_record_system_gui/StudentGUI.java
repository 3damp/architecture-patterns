package p4.student_record_system_gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StudentGUI {
	// First set up the panel with the labels and text boxes
	private JPanel inputPanel = new JPanel();
	private JLabel matricLabel = new JLabel("Matric No.");
	private JTextField matricTxt = new JTextField(30);
	private JLabel nameLabel = new JLabel("Name");
	private JTextField nameTxt = new JTextField(30);
	private JLabel programmeLabel = new JLabel("Programme");
	private JTextField programmeTxt = new JTextField(30);
	{
		// Initialise the panel
		inputPanel.setLayout(new GridLayout(3, 2));
		inputPanel.add(matricLabel);
		inputPanel.add(matricTxt);
		inputPanel.add(nameLabel);
		inputPanel.add(nameTxt);
		inputPanel.add(programmeLabel);
		inputPanel.add(programmeTxt);
	}

	// Next the panel with the buttons
	private JPanel buttonPanel = new JPanel();
	private JButton addButton = new JButton("Add Student");
	private JButton getButton = new JButton("Get Student");
	private JButton updateButton = new JButton("Update Student");
	private JButton removeButton = new JButton("Remove Student");
	{
		// Initialise the panel
		buttonPanel.setLayout(new GridLayout(4, 1));
		buttonPanel.add(addButton);
		buttonPanel.add(getButton);
		buttonPanel.add(updateButton);
		buttonPanel.add(removeButton);
	}

	// Now create a panel with the input and button panels in. This is the top panel
	private JPanel topPanel = new JPanel();
	{
		topPanel.setLayout(new FlowLayout());
		topPanel.add(inputPanel);
		topPanel.add(buttonPanel);
	}

	// Create the panel which will display the feedback text
	private JPanel feedbackPanel = new JPanel();
	private JTextArea feedbackArea = new JTextArea(10, 40);
	{
		feedbackArea.setEditable(false);
		feedbackPanel.setLayout(new GridLayout(1, 1));
		feedbackPanel.add(feedbackArea);
	}

	// Finally create the window to display the panels
	private JFrame window = new JFrame();
	{
		window.setLayout(new GridLayout(2, 1));
		window.add(topPanel);
		window.add(feedbackPanel);
		window.pack();
	}

	// The application layer that the GUI layer will talk to
	private StudentApplicationLayerInterface appLayer;

	/**
	 * Default constructor. Requires only the application layer to connect to
	 * 
	 * @param appLayer
	 *            The application layer that the GUI is connected to
	 */
	public StudentGUI(StudentApplicationLayerInterface appLayer) {
		this.appLayer = appLayer;

		// Add your custom action listeners here
		addButton.addActionListener(new AddButtonListener());
		
		// Add your custom action listeners here
		getButton.addActionListener(new GetButtonListener());

		// Add your custom action listeners here
		//addButton.addActionListener(new AddButtonListener());
				
		// The default close action
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}

	// The action listener on the Add button.
	private class AddButtonListener implements ActionListener {
		// Called when the Add button is clicked
		public void actionPerformed(ActionEvent arg0) {
			// Get the required values from the text fields
			String matric = matricTxt.getText();
			String name = nameTxt.getText();
			String programme = programmeTxt.getText();
			// Try and add the student record. Get the result from the operation
			String result = appLayer.addStudent(matric, name, programme);
			// Set the text in the feedback area to the result
			feedbackArea.setText(result);
			matricTxt.setText("");
			nameTxt.setText("");
			programmeTxt.setText("");
		}
	}
	// The action listener on the Add button.
	private class GetButtonListener implements ActionListener {
		// Called when the Add button is clicked
		public void actionPerformed(ActionEvent arg0) {
			// Get the required values from the text fields
			String matric = matricTxt.getText();
			// Try and add the student record. Get the result from the operation
			String result = appLayer.getStudent(matric);
			// Set the text in the feedback area to the result
			
			nameTxt.setText("");
			programmeTxt.setText("");
			
			feedbackArea.setText(result);
		}
	}
}
