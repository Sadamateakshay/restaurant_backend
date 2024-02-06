package com.restaurant.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Data
@Setter
@Getter
public class CategoryDto {

    private Long id;

    private String name;

    private String description;

    private MultipartFile img;

    private byte[] returnedImg;
}
