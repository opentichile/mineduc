package cl.mineduc.sismologia.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import javax.ws.rs.core.MediaType;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EarthQuakesTests {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void testEarthquakesIsOK() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		
		this.mockMvc.perform(post("/date/earthquakes")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.param("starttime", "2014-01-01")
				.param("startend", "2014-01-02")
				).andReturn().getResponse().getStatus();
	}

	
	@Test
	public void testEarthquakesIsNotOK() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		
		this.mockMvc.perform(post("/date/earthquakes")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.param("starttime", "2014-01")
				.param("startend", "2014-01")
				).andReturn().getResponse().getStatus();
	}
	
	@Test
	public void testMagnitudesIsOK() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		
		this.mockMvc.perform(post("/magnitude/earthquakes")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.param("minmagnitude", "3")
				.param("maxmagnitude", "7")
				).andReturn().getResponse().getStatus();
	}
	
	
	@Test
	public void testMagnitudesIsNotOK() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		
		this.mockMvc.perform(post("/magnitude/earthquakes")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.param("minmagnitude", "0")
				.param("maxmagnitude", "0")
				).andReturn().getResponse().getStatus();
	}
	
	
	
	
	@Test
	void contextLoads() {
	}

}
