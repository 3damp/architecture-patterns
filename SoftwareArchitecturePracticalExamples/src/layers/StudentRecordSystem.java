package layers;

public class StudentRecordSystem 
{
	public static void main(String[] args)
	{
		// Change this layer to your database connected data layer
		StudentDataLayer dataLayer = new StudentDataLayer();
		StudentApplicationLayer appLayer = new StudentApplicationLayer(dataLayer);
		StudentGUI gui = new StudentGUI(appLayer);
	}
}
