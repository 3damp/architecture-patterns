package webservice;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
 
public class WebServClient{
 	public static void main(String[] args) throws Exception {
 	URL url = new URL("http://localhost:7779/ws/hello?wsdl");
 
        //1st argument service URI, refer to wsdl document above
	    //2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://webservice/", "GreetingsHelloService");
 
        Service service = Service.create(url, qname);
        IGreetings hello = service.getPort(IGreetings.class);
 
        System.out.println(hello.getGreetings("escarelo"));
        
        System.out.println("Num: " + hello.getNum());
        System.out.println("Num: " + hello.getNum());
        
        
        // Stop web service remotely 
        try {
        	hello.stopWS();
		} catch (Exception e) {
			System.out.println("Closed!");
		}
        
    }
 
}