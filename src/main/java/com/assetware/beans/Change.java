package com.assetware.beans;

import java.util.List;

import org.javatuples.Triplet;

public class Change {
	private String id;
	private String by;
	private String on;
	
	List<Triplet<String, String, String>> changes;
	
	public Change(String by, String on) {
		super();
		this.by = by;
		this.on = on;
	}
	
	public Change(String by, String on, List<Triplet<String, String, String>> changes) {
		super();
		this.by = by;
		this.on = on;
		this.changes = changes;
	}
	
	public String getBy() {
		return by;
	}
	public void setBy(String by) {
		this.by = by;
	}
	public String getOn() {
		return on;
	}
	public void setOn(String on) {
		this.on = on;
	}
	public List<Triplet<String, String, String>> getChanges() {
		return changes;
	}
	public void setChanges(List<Triplet<String, String, String>> changes) {
		this.changes = changes;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Change [by=" + by + ", on=" + on + ", changes=" + changes + "]";
	}
	
	
}
