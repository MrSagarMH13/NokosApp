package com.nokos.assignment;

import java.io.IOException;
import java.util.List;

import com.google.api.services.drive.model.File;

public interface FileHandler {

	java.io.File UploadFiles(java.io.File file, String filePath, String fileType);

	List<File> getFiles() throws IOException;
}
