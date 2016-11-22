package net.mybluemix.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyImagesOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualClassification;

@RestController
public class HelloController {

	@RequestMapping(value = "/up", method = RequestMethod.POST)
	public VisualClassification post(@RequestParam MultipartFile multipartFile) throws IOException {

		
		if (multipartFile.isEmpty()) {
			
			return null;
		} else {
			VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20);
			service.setApiKey("168fcf18a5c7026396d6c046bce150873265e1ac");

			System.out.println("Classify an image");
			ClassifyImagesOptions options = new ClassifyImagesOptions.Builder().images(convert(multipartFile)).build();
			VisualClassification result = service.classify(options).execute();

			System.out.println(result);
			return result;
		}

	}

	public File convert(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		convFile.createNewFile();
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}
	
	@RequestMapping("/Watson")
	public VisualClassification watson() {

		VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20);
		service.setApiKey("168fcf18a5c7026396d6c046bce150873265e1ac");

		System.out.println("Classify an image");
		ClassifyImagesOptions options = new ClassifyImagesOptions.Builder().images(new File("src/dog.jpg")).build();
		VisualClassification result = service.classify(options).execute();
		System.out.println(result);

		return result;
	}
}
