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

	/**
	 * Returns the comments for the task; note that this applies a circuit
	 * breaker that would return the default value if the comments-webservice
	 * was down.
	 * 
	 * Discussion on HystrixProperty
	 * <ol>
	 * <li><b>execution.isolation.strategy:</b> The value of "SEMAPHORE" enables
	 * Hystrix to use the current thread for executing this command. Since we
	 * need to use the parent HttpRequest to pass the OAuth2 access token, we
	 * are constrained in using the calling thread. The number of concurrent
	 * requests that can be made to the command is limited by the semaphore(or
	 * counter) value; default is 10.In a normal scenario, you would use
	 * isolation strategy of "THREAD" that executes the Hystrix command in a
	 * separate thread pool. This is desirable because it doesn't block the
	 * calling thread and lets us handle faulty client libraries, client
	 * performance considerations etc.</li>
	 * <li><b>circuitBreaker.requestVolumeThreshold:</b>This property sets the
	 * minimum number of requests in a rolling window that will trip the
	 * circuit. For example, if the value is 20, then if only 19 requests are
	 * received in the rolling window (say a window of 10 seconds) the circuit
	 * will not trip open even if all 19 failed. We have a lower value in this
	 * sample application so as to trip early.</li>
	 * <li><b>circuitBreaker.sleepWindowInMilliseconds:</b>This property sets
	 * the amount of time, after tripping the circuit, to reject requests before
	 * allowing attempts again to determine if the circuit should again be
	 * closed. We again have a lower value so that Hystrix tries to pass single
	 * request to the called service quickly.</li>
	 * </ol>
	 * 
	 * @param doctorId
	 * @return
	 */
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
