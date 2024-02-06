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
public class ProductDto {

    private Long id;

    private String name;

    private String price;

    private String description;

    @Lob
    @Column(columnDefinition = "longblob")
    private byte[] returnedImg;

    private MultipartFile img;

    private Long categoryId;

    private String categoryName;
}
