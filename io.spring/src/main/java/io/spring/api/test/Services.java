package io.spring.api.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import ch.qos.logback.core.filter.Filter;

@Service
public class Services {
	
	private List<Topics> topics=new ArrayList<>(Arrays.asList(new Topics("101","dhanda"),
			new Topics("102","nakshatra")));
	
	public List<Topics> getAllTopics()
	{
		return topics;
	}
	
	public Topics getTopic(String id)
	{
		return topics.stream().filter(t-> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topics topic) {
		// TODO Auto-generated method stub
		topics.add(topic);
	}

	public void updateTopic(String id, Topics topic) {
		// TODO Auto-generated method stub
		for(int i=0;i<topics.size();i++)
		{
			Topics t=topics.get(i);
			if(t.getId().equals(id))
			{
				topics.set(i, topic);
				return;
			}

		}
		
		
	}

	public void deleteTopic(String id)
	{
		topics.removeIf(t-> t.getId().equals(id));
	}
	
	
}