package io.spring.api.test;

import java.util.Arrays;
import java.util.List;

public class Topics {
	
	private String id="";
	private String name="";

	
	
public Topics(String id,String name)
{
	super();
	this.id=id;
	this.name=name;
	
}

public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}

public String getName()
{
	return name;
}

public void setName(String name)
{
	this.name=name;
}



}
