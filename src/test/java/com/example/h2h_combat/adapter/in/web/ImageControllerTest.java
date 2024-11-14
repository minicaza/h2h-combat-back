package com.example.h2h_combat.adapter.in.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ImageController.class)
public class ImageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private ImageController imageController;

    @BeforeEach
    void setUp() {
        Path imagesDirectory = Paths.get("src/main/resources/static/img");

        if (!Files.exists(imagesDirectory)) {
            try {
                Files.createDirectories(imagesDirectory);
                Resource resource = new ClassPathResource("static/img/app.png");
                Path destination = imagesDirectory.resolve("app.png");
                Files.copy(resource.getInputStream(), destination);
            } catch (Exception e) {
                throw new RuntimeException("Could not set up test image directory", e);
            }
        }
    }

    @Test
    public void testGetImage() throws Exception {
        this.mockMvc.perform(get("/h2h-combat/images/app.png"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.IMAGE_PNG));
    }
}
