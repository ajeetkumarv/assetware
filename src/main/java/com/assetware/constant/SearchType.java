package com.assetware.constant;

public enum SearchType {

	SIMPLE("simple"), ADVANCE("advance");
	
	private String searchType;
	
	private SearchType(String searchType) {
		this.searchType = searchType;
	}
	
	public String getSearchType() {
		return searchType;
	}
	
}
