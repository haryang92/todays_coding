package studio.thinkground.SpringTestProject.data.dao;

import studio.thinkground.SpringTestProject.data.entity.ProductEntity;

public interface ProductDAO {

    ProductEntity saveProduct(ProductEntity productEntity);

    ProductEntity getProduct(String productId);
}
