package studio.thinkground.SpringTestProject.data.handler.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studio.thinkground.SpringTestProject.data.dao.ProductDAO;
import studio.thinkground.SpringTestProject.data.entity.ProductEntity;
import studio.thinkground.SpringTestProject.data.handler.ProductDataHndler;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductDataHndlerimpl implements ProductDataHndler {

    ProductDAO productDAO;

    @Autowired
    public ProductDataHndlerimpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public ProductEntity saveProductEntity(String productId, String productName, int productPrice, int productStock) {
        ProductEntity productEntity = new ProductEntity(productId, productName, productPrice, productStock);

        return productDAO.saveProduct(productEntity);
    }

    @Override
    public ProductEntity getProductEntity(String productId){
        return productDAO.getProduct(productId);
    }



}
