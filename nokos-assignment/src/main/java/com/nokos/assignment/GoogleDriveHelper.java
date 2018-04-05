package com.nokos.assignment;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import com.google.api.client.http.FileContent;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.Drive.Files;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;

public class GoogleDriveHelper implements FileHandler {

	static Drive service = null;

	String folderId = "1-2L0b0QBjYJ5e-0tpW0TpIfGv4xY5YDM"; // folder id for
															// nokos tech

	public File UploadFile(java.io.File file, String contentType) throws IOException {
		createServiceInstance();

		File fileMetadata = new File();
		fileMetadata.setName(file.getName());
		fileMetadata.setParents(Collections.singletonList(folderId));
		FileContent mediaContent = new FileContent(
				"application/vnd.openxmlformats-officedocument.wordprocessingml.document", file);
		File uploadedFile = null;
		try {
			uploadedFile = service.files().create(fileMetadata, mediaContent).setFields("id, parents").execute();
			System.out.println("File ID: " + uploadedFile.getId());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return uploadedFile;

	}

	public List<File> getFiles() throws IOException {
		createServiceInstance();
		Files.List request = service.files().list().setQ("'" + folderId + "'" + " in parents and trashed = false");
		FileList result = request.execute();
		List<File> files = result.getFiles();
		return files;
	}

	private void createServiceInstance() throws IOException {
		if (service == null)
			service = GoogleAuthentication.getDriveService();

	}
}