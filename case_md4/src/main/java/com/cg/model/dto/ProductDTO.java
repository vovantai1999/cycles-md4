package com.cg.model.dto;


import com.cg.model.Category;
import com.cg.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ProductDTO {

    private Long id;

    @Size(min = 5, max = 50, message = "Tên sản phẩm có độ dài 5-50 kí tự!")
    @NotBlank(message = "Tên không được để trống!")
    private String name;

    @NotBlank(message = "Đường dẫn không được để trống!")
    private String image;

    @NotBlank(message = "Số lượng không được để trống!")
    private String quantity;

    @NotBlank(message = "Giá tiền không được để trống!")
    private String price;

    private Category category;

    public ProductDTO(Long id, String name, String image, int quantity, BigDecimal price, Category category) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.quantity = String.valueOf(quantity);
        this.price = String.valueOf(price);
        this.category = category;
    }

    public Product toProduct() {
        return new Product()
                .setName(name)
                .setImage(image)
                .setQuantity(Integer.parseInt(quantity))
                .setPrice(new BigDecimal(price))
                .setCategory(category);
    }
}

