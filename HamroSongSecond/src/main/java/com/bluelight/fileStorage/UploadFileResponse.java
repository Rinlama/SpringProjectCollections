package com.bluelight.fileStorage;
public class UploadFileResponse {
    private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;
    private String fileViewUri;

    public UploadFileResponse(String fileName, String fileViewUri, String fileDownloadUri, String fileType, long size) {
        this.fileViewUri=fileViewUri;
    	this.fileName = fileName;
        this.fileDownloadUri = fileDownloadUri;
        this.fileType = fileType;
        this.size = size;
    }

	public String getFileViewUri() {
		return fileViewUri;
	}

	public void setFileViewUri(String fileViewUri) {
		this.fileViewUri = fileViewUri;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileDownloadUri() {
		return fileDownloadUri;
	}

	public void setFileDownloadUri(String fileDownloadUri) {
		this.fileDownloadUri = fileDownloadUri;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	// Getters and Setters (Omitted for brevity)
}
