package com.example.mt2024029_project_1_2.controller;

import com.example.mt2024029_project_1_2.entity.Student;
import com.example.mt2024029_project_1_2.repository.StudentRepository;
import com.example.mt2024029_project_1_2.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/upload")
public class ImageUploadController {


    @Autowired
    private StudentService studentService;
    // Directory where you want to save the uploaded image
    private static final String UPLOAD_DIR = "/Users/ayyanpasha/Desktop/IMAGE";
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping
    public ResponseEntity<String> uploadImage(@RequestParam("image") MultipartFile image, HttpServletRequest request) {
        String rollNumber = studentService.getRollNumber(request);
        Student student = studentRepository.findByRollNumber(rollNumber);
        if (image.isEmpty()) {
            return ResponseEntity.badRequest().body("No file selected");
        }

        // Get the original filename
        String originalFilename = image.getOriginalFilename();

        student.setPhotographPath(originalFilename);

        File dest = new File(UPLOAD_DIR + File.separator + originalFilename);

        try {
            // Save the file to the server
            studentRepository.save(student);
            image.transferTo(dest);
            // Return success response
            return ResponseEntity.ok("Image uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error saving the image");
        }
    }

    @GetMapping("/images/{filename}")
    public ResponseEntity<byte[]> getImage(@PathVariable String filename) throws IOException {
        System.out.println(filename);
        File file = new File(UPLOAD_DIR + File.separator + filename);
        if (file.exists()) {
            byte[] content = java.nio.file.Files.readAllBytes(file.toPath());
            return ResponseEntity.ok()
                    .header("Content-Type", "image/jpeg")
                    .body(content);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }
}

