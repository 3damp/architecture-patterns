package webservice;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
 
//Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.RPC)
//@SOAPBinding(style = Style.DOCUMENT)

public interface IGreetings{
	@WebMethod String getGreetings(String name);
	
	public int getNum();
	
	public void stopWS();
 
}