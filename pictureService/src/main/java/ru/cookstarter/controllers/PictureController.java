package ru.cookstarter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.cookstarter.model.Picture;
import ru.cookstarter.repo.PictureRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Controller
public class PictureController {
    private final PictureRepository pictureRepository;

    @Autowired
    public PictureController(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @GetMapping("/picture/{pictureId}")
    public void getPicturesById(@PathVariable("pictureId") Long pictureId, HttpServletResponse response) throws IOException {
        Optional<Picture> picture = pictureRepository.findById(pictureId);
        if (picture.isPresent()) {
            Path image = Paths.get(picture.get().getImageSrc());
            byte[] bytes = Files.readAllBytes(image);
            response.setContentType(picture.get().getDescription());
            response.getOutputStream().write(bytes);
        }
    }
}
