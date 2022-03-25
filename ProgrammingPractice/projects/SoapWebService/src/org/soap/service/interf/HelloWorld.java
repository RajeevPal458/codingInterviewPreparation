package org.soap.service.interf;

@WebService  
@SOAPBinding(style = Style.RPC)
public interface HelloWorld {
	
	 @WebMethod String getHelloWorldAsString(String name);  

}
