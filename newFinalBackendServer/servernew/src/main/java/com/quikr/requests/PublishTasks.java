package com.quikr.requests;

import java.util.ArrayList;

public class PublishTasks {
	ArrayList<Integer> taskids;
	public PublishTasks() {
		this.taskids=null;
	}

	public PublishTasks(ArrayList<Integer> taskids) {
		super();
		this.taskids = taskids;
	}

	public ArrayList<Integer> getTaskids() {
		return taskids;
	}

	public void setTaskids(ArrayList<Integer> taskids) {
		this.taskids = taskids;
	}

}
