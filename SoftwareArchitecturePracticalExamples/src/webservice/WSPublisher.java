package webservice;

import javax.xml.ws.Endpoint;

public class WSPublisher {
	
	Endpoint ep = null;
	
	public WSPublisher() {
		ep = Endpoint.publish("http://localhost:7779/ws/hello", new GreetingsHello(this));
	}
	
	public void stop() {
		System.out.println("Stopping...");
		Long t = System.currentTimeMillis();
		while(System.currentTimeMillis()-t < 2000) {
			
		}
		ep.stop();
		System.out.println("Stopped!");
	}

}
