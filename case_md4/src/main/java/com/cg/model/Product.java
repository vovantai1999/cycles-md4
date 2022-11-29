package com.cg.model;

import com.cg.model.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
@Accessors(chain = true)
public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String image;

    private int quantity;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private Category category;

    private boolean deleted;

    public Product(Long id, String name, String image, int quantity, BigDecimal price, Category category) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
    }

    public ProductDTO toProductDTO() {
        return new ProductDTO()
                .setId(this.id)
                .setName(this.name)
                .setImage(this.image)
                .setQuantity(String.valueOf(this.quantity))
                .setPrice(String.valueOf(this.price))
                .setCategory(this.category);
    }
}
