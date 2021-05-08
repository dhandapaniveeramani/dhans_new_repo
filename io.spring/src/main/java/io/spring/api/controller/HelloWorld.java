package io.spring.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.util.*;



@RestController
public class HelloWorld {

	HashMap<String, String> hm=new HashMap<String,String>();

	 @RequestMapping("/hello")
	public String hi()
	{
		return "hello world";
	}

	/*
	 * When you run the above class and hit the service with below url
	 * http://localhost:8080/hello , you will get the response.
	 *//*
	*/
	@Autowired
	private RestTemplate restTemplate;
	@RequestMapping("/test")
	public List<Object> getResponse()
	{

		String resourceUrl
				= "https://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=569a551df8f0ed25a9be5403a803e4d4";
		Object[] response
				= restTemplate.getForObject(resourceUrl, Object[].class);
		//assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

	//	System.out.prinln(response.asString());
		return Arrays.asList(response);
	}

	@GetMapping("/getWeather/{city}")
	public Object getWeather(@PathVariable("city")String city)
	{
		String[] cityCountry=city.split(",");
		String countryName=cityCountry[1];
		String cityName=cityCountry[0];

		String resourceUrl
				= "https://api.openweathermap.org/data/2.5/weather?q="+cityName+","+countryName+"&APPID=569a551df8f0ed25a9be5403a803e4d4";
		Object response
				= restTemplate.getForObject(resourceUrl, Object.class);
		//assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

		//	System.out.prinln(response.asString());
		return response;
	}


	/*@PostMapping("/postweather/{weather}")
	public void postTemp(@RequestBody Weather weather)
	{

		*//*weather.setMinTemp("25");
		//hm.put("minTemp",weather.getMinTemp());
        weather.setMaxTemp("35");
       // hm.put("maxTemp",weather.getMaxTemp());
        weather.setLocation("Chennai,IN");
      //  hm.put("location",weather.getLocation());
*//*
	}*/
	@Autowired
	Weather weather;
	@RequestMapping("/getweatherforlocation/{location}")
	public Weather getWeatherForLocation(@PathVariable String location)
	{
		try {
			String[] cityCountry = location.split(",");
			String countryName = cityCountry[1];
			String cityName = cityCountry[0];

			String resourceUrl
					= "https://api.openweathermap.org/data/2.5/weather?q=" + cityName + "," + countryName + "&APPID=569a551df8f0ed25a9be5403a803e4d4";
			weather
					= restTemplate.getForObject(resourceUrl, Weather.class);
			//assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

			ObjectMapper objectMapper = new ObjectMapper();


		}
catch(Exception e)
			{
				e.printStackTrace();

			}

	return weather;

	}
}


