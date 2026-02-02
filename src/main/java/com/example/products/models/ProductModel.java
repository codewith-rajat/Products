package com.example.products.models;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Products")
public class ProductModel {
    @Id
    private String id;
    @NotBlank(message = "Name can't be null/empty")
    private String name;
    @Max(100000)
    @Min(500)
    private int cost;
}
