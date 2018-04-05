package com.nokos.assignment;

import java.io.IOException;
import java.util.List;

import com.google.api.services.drive.model.File;

public interface FileHandler {

	File UploadFile(java.io.File file, String contentType) throws IOException;

	List<File> getFiles() throws IOException;
}
