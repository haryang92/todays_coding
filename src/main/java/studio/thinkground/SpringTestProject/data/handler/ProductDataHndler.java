package studio.thinkground.SpringTestProject.data.handler;

import studio.thinkground.SpringTestProject.data.entity.ProductEntity;

public interface ProductDataHndler {
    ProductEntity saveProductEntity(String productId, String productName, int productPrice, int productStock);

    ProductEntity getProductEntity(String productId);
}
