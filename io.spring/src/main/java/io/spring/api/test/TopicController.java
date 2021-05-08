package io.spring.api.test;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	@Autowired
	private Services service;
	
	@RequestMapping("/topics")
	public List<Topics> getAllTopics() {
		return service.getAllTopics();
	}

	@RequestMapping("/topics/{id}")
	public Topics getTopics(@PathVariable String id) {
		return service.getTopic(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public void addTopic(@RequestBody Topics topic) {
		service.addTopic(topic);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	public void updateTopic(@RequestBody Topics topic, @PathVariable String id) {
		service.updateTopic(id, topic);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")

	public void deleteTopic(@PathVariable String id) {
		service.deleteTopic(id);
	}
	
	
	}