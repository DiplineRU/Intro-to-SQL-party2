package com.example.Intro_to_SQL_party2.controller;

import com.example.Intro_to_SQL_party2.model.Avatar;
import com.example.Intro_to_SQL_party2.service.AvatarService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
@RequestMapping("/avatar")
public class AvatarController {

    private final AvatarService avatarService;

    @Value("${avatar.cover.dir.path}") // Добавленная аннотация
    private String avatarDir; // Объявление переменной


    public AvatarController(AvatarService avatarService) {
        this.avatarService = avatarService;
    }

    @PostMapping(value = "/{studentId}/cover", consumes = MediaType.MULTIPART_FORM_DATA_VALUE) // Путь для добавления обложки к студенту
    public ResponseEntity<String> addCover(@PathVariable Long studentId, @RequestParam MultipartFile file) {
        try {
            avatarService.addCover(studentId, file); // Вызов метода добавления обложки
            return ResponseEntity.ok("Обложка добавлена.");
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Ошибка при добавлении обложки: " + e.getMessage());
        }
    }
    @GetMapping(value = "/{studentId}/cover")
    public ResponseEntity<byte[]> getCover(@PathVariable Long studentId) {
        try {
            Avatar avatar = avatarService.findAvatar(studentId);    // Находим объект Avatar по studentId
            Path filePath = Path.of(avatarDir, studentId + "." + getExtension(avatar.getFilePath()));

            byte[] image = Files.readAllBytes(filePath);   // Читаем содержимое файла в байтовый массив

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType(avatar.getMediaType()));
            headers.setContentLength(image.length);

            return ResponseEntity.ok().headers(headers).body(image);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(("Ошибка при загрузке обложки: " + e.getMessage()).getBytes());
        }
    }

    private String getExtension(String filePath) {
        return filePath.substring(filePath.lastIndexOf(".") + 1);
    }


    @GetMapping(value = "/{id}/avatar/preview")
    public ResponseEntity<byte[]> downloadAvatar(@PathVariable Long id) {
        Avatar avatar = avatarService.findAvatar(id);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(avatar.getMediaType()));
        headers.setContentLength(avatar.getData().length);

        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(avatar.getData());
    }
}
