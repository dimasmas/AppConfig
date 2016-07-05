package com.opus.configurations;

public enum e_avaliableClasses {
	mitaller("miTaller", "baseClass");
	
	private String jsonPath;
	private String baseClassName;
	
	e_avaliableClasses(String _jsonPath, String _BaseClassName){
		this.jsonPath=_jsonPath;
		this.baseClassName=_BaseClassName;
	}
	
	public String getJsonPath(){ return jsonPath; }
	public String getBaseClassName(){return baseClassName;}
}
