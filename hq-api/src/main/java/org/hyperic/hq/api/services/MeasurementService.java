package org.hyperic.hq.api.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.hyperic.hq.api.model.measurements.MeasurementRequest;
import org.hyperic.hq.api.model.measurements.MeasurementResponse;
import org.hyperic.hq.auth.shared.SessionNotFoundException;
import org.hyperic.hq.auth.shared.SessionTimeoutException;
import org.hyperic.hq.authz.shared.PermissionException;


@Path("/") 
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) 
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public interface MeasurementService {
	
	@POST
//	@GET
	@Path("/metrics/{rscId}")
	MeasurementResponse getMetrics(/*@QueryParam("measurementRequest")*/ final MeasurementRequest measurementRequest,
	        @PathParam("rscId") final String rscId,
	        @QueryParam("begin") final String begin,
			@QueryParam("end") final String end) 
			        throws PermissionException, SessionNotFoundException, SessionTimeoutException;
}