package test.test.services;

import com.github.tools.annotations.ServiceDefinition;
import com.github.webfrk.core.HttpBodyHandler;

@ServiceDefinition
public class HelloworldService extends HttpBodyHandler {

	public String listWho(String name) {
		return "hello, " + name;
	}
}