package com.phaiecobyte.portfolio_api.module.pos.service;

import com.phaiecobyte.portfolio_api.exception.AppException;
import com.phaiecobyte.portfolio_api.module.pos.dto.req.ProductReq;
import com.phaiecobyte.portfolio_api.module.pos.dto.res.ProductRes;
import com.phaiecobyte.portfolio_api.module.pos.mapper.ProductMapper;
import com.phaiecobyte.portfolio_api.module.pos.model.Product;
import com.phaiecobyte.portfolio_api.module.pos.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public Page<ProductRes> list(String status, Pageable pageable){
        Page<Product> products;
        if(status != null){
            products = productRepository.findByStatus(status,pageable);
        }else {
            products = productRepository.findAll(pageable);
        }
        return products.map(productMapper::toRes);
    }

    public Optional<ProductRes> getById(long id){
        Product product = productRepository.findById(id)
                .orElseThrow(()->new AppException("Product with id:{} not found...!"+id));
        return Optional.ofNullable(productMapper.toRes(product));
    }

    public ProductRes create(ProductReq dto){
        Product product = productMapper.toEntity(dto);
        Product save = productRepository.save(product);
        return productMapper.toRes(save);
    }

    public ProductRes update(long id, ProductReq dto){
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new AppException("Product not found with id:"+id));

        productMapper.updateEntity(product,dto);

        return productMapper.toRes(productRepository.save(product));
    }

    public void delete(long id){
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new AppException("Product with id{} is not found!"+id));
        productRepository.delete(product);
    }
}
