package studio.thinkground.SpringTestProject.data.entity;

import lombok.*;
import studio.thinkground.SpringTestProject.data.dto.ProductDto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "product")
public class ProductEntity {
// 테이블과 직접적으로 매핑이 되는 class를 의미한다.
    @Id
    String productId;

    String productName;

    Integer productPrice;

    Integer productStock;

    public ProductDto toDto(){
        return ProductDto.builder()
                .productId(productId)
                .productName(productName)
                .productPrice(productPrice)
                .productStock(productStock)
                .build();
    }
}
