package com.mybahmni.appointments.appointment.apis;

import com.mybahmni.appointments.appointment.model.DoctorResource;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

/**
 * The {@link HystrixCommand} works since Spring makes a proxy to intercept the
 * request and call the fallback method if the method errs.<br>
 * <br>
 * 
 * Hence the {@link HystrixCommand} needs to be in separate {@link Component} or
 * {@link Service} stereotypes so that Spring can proxy them.
 * 
 * @author anilallewar
 *
 */
@Service
public class DoctorsService {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getFallbackCommentsForTask", commandProperties = {
			@HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE"),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "1000") })
	public DoctorResource getDoctorForAppointment(String doctorId) {
		String url = String.format("http://doctor-webservice/doctors/%s", doctorId);
		return restTemplate.getForObject(url, DoctorResource.class);

	}

	@SuppressWarnings("unused")
	private DoctorResource getFallbackCommentsForTask(String taskId) {

		return new DoctorResource("default", "default doctor", new Date());
	}
}
