package com.nokos.assignment;

import java.io.IOException;
import java.util.List;

import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;

public class GoogleDriveHelper implements FileHandler {

	static Drive service = null;

	public void UploadFiles(java.io.File file, String filePath) {
		// TODO Auto-generated method stub

	}

	public List<File> getFiles() throws IOException {
		if (service == null)
			service = GoogleAuthentication.getDriveService();

		FileList result = service.files().list().setPageSize(10).setFields("nextPageToken, files(id, name)").execute();
		List<File> files = result.getFiles();
		return files;
	}
}