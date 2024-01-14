package vn.com.bvb.support;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class CorsFilter implements ContainerResponseFilter {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		logger.info("Calling the ContainerResponseFilter !!!!!");
		responseContext.getHeaders().putSingle("Access-Control-Allow-Origin", "*");
		responseContext.getHeaders().putSingle("Access-Control-Allow-Credentials", "true");
		responseContext.getHeaders().putSingle("Access-Control-Max-Age", "1209600");
		responseContext.getHeaders().putSingle("Access-Control-Allow-Headers", "Origin, Content-Type, Content-Length, Accept, Authorization");
		responseContext.getHeaders().putSingle("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
	}

}
