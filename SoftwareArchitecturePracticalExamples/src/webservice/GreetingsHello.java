package webservice;

import java.lang.reflect.Constructor;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService(endpointInterface = "webservice.IGreetings")
public class GreetingsHello implements IGreetings{
	private int i = 0;	
	private WSPublisher publisher;

	public GreetingsHello(WSPublisher wsPublisher) {
		this.publisher = wsPublisher;
	}

	@Override
	public String getGreetings(String name) {
		return "Hello " + name + "!";
	}

	@Override
	public int getNum() {
		i++;
		return i;
	}

	@Override
	public void stopWS() {
		publisher.stop();
	}

}