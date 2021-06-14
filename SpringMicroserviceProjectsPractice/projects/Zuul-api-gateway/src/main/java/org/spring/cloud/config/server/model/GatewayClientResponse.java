package org.spring.cloud.config.server.model;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;

public class GatewayClientResponse implements ClientHttpResponse{

	private HttpStatus status;
	private String message;
	
	public GatewayClientResponse() {
		super();
	}

	public GatewayClientResponse(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	@Override
	public InputStream getBody() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpHeaders getHeaders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpStatus getStatusCode() throws IOException {
		// TODO Auto-generated method stub
		return status;
	}

	@Override
	public int getRawStatusCode() throws IOException {
		// TODO Auto-generated method stub
		return status.value();
	}

	@Override
	public String getStatusText() throws IOException {
		// TODO Auto-generated method stub
		return message;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}
}
