package com.nokos.assignment;

import java.io.IOException;
import java.util.List;

import com.google.api.services.drive.model.File;

public interface FileHandler {

	void UploadFiles(java.io.File file, String filePath);

	List<File> getFiles() throws IOException;
}
