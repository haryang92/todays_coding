package studio.thinkground.SpringTestProject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studio.thinkground.SpringTestProject.data.dto.ProductDto;
import studio.thinkground.SpringTestProject.data.entity.ProductEntity;
import studio.thinkground.SpringTestProject.data.handler.ProductDataHndler;
import studio.thinkground.SpringTestProject.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    ProductDataHndler productDataHndler;

    @Autowired
    public ProductServiceImpl(ProductDataHndler productDataHndler){
        this.productDataHndler = productDataHndler;
    }

    @Override
    public ProductDto saveProduct(String productId, String productName, int productPrice, int productStock) {
        ProductEntity productEntity = productDataHndler.saveProductEntity(productId, productName, productPrice, productStock);

        ProductDto productDto = new ProductDto(productEntity.getProductId(), productEntity.getProductName(),
                productEntity.getProductPrice(), productEntity.getProductStock());

        return productDto;
    }

    @Override
    public ProductDto getProduct(String productId) {
        ProductEntity productEntity = productDataHndler.getProductEntity(productId);

        ProductDto productDto = new ProductDto(productEntity.getProductId(),
                productEntity.getProductName(), productEntity.getProductPrice(), productEntity.getProductStock());

        return productDto;
    }
}
