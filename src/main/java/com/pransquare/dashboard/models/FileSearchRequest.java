package com.pransquare.dashboard.models;

public class FileSearchRequest {
    private String releaseName;
    private String fileName;
    private int page;
    private int size;

    public FileSearchRequest() {
        this.page = 0;
        this.size = 10; 
    }

	public String getReleaseName() {
		return releaseName;
	}

	public void setReleaseName(String releaseName) {
		this.releaseName = releaseName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

    
    
}
