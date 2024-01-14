package vn.com.bvb.config;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Path;

import org.camunda.bpm.spring.boot.starter.rest.CamundaJerseyResourceConfig;
import org.springframework.stereotype.Component;

import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import vn.com.bvb.support.CorsFilter;

@Component
@ApplicationPath("/api")
@Path("/")
public class JerseyConfig extends CamundaJerseyResourceConfig {

	@Override
	protected void registerAdditionalResources() {
		packages("vn.com.bvb.controller");
		packages("vn.com.bvb.support");
		register(OpenApiResource.class);
		register(CorsFilter.class);
	}

}