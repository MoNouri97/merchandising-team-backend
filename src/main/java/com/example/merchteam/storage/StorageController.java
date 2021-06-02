package com.example.merchteam.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;

@RestController
@RequestMapping(path = "api/v1/storage")
public class StorageController {
	Path RESOURCES_DIR = Path.of("src", "main", "resources", "static", "upload").toAbsolutePath();

	@PostMapping(path = "/image")
	public void image(@RequestParam("file") MultipartFile file) {
		System.out.println("RESOURCES_DIR: " + RESOURCES_DIR);
		try {
			file.transferTo(new java.io.File(RESOURCES_DIR + "/" + new Date().getTime() + ".png"));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@PostMapping(path = "/images")
	public Set<FilePath> images(@RequestParam Map<String, MultipartFile> files)
		throws IllegalStateException,
		IOException {
		Set<FilePath> filePaths = new HashSet<>();
		System.out.println("files: " + files.toString());

		for (Map.Entry<String, MultipartFile> file : files.entrySet()) {
			String path = new Date().getTime() + ".png";
			file.getValue().transferTo(new java.io.File(RESOURCES_DIR + "/" + path));
			filePaths.add(new FilePath("upload/" + path, file.getValue().getName()));
		}
		return filePaths;
	}

	/**
	 * FilePath
	 */
	@Data
	@AllArgsConstructor
	public class FilePath {
		private String path;
		private String name;
	}
}
