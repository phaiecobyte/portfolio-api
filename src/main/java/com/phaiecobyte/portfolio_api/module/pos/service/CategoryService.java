package com.phaiecobyte.portfolio_api.module.pos.service;

import com.phaiecobyte.portfolio_api.exception.AppException;
import com.phaiecobyte.portfolio_api.module.pos.dto.CategoryDto;
import com.phaiecobyte.portfolio_api.module.pos.dto.res.CategoryRes;
import com.phaiecobyte.portfolio_api.module.pos.mapper.CategoryMapper;
import com.phaiecobyte.portfolio_api.module.pos.model.Category;
import com.phaiecobyte.portfolio_api.module.pos.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryDto create(CategoryDto dto){
        Category entity = categoryMapper.toEntity(dto);
        return categoryMapper.toDto(categoryRepository.save(entity));
    }

    public Page<CategoryRes> list(String status, Pageable pageable){
        Page<Category> categories ;
        if(status != null){
            categories = categoryRepository.findByStatus(status,pageable);
        }else{
            categories = categoryRepository.findAll(pageable);
        }
        return categories.map(categoryMapper::toRes);
    }

    public CategoryDto update(long id,CategoryDto dto){
        Category category = categoryRepository.findById(id)
                .orElseThrow(()-> new AppException("Category not found with id:"+id));

        categoryMapper.updateEntity(category,dto);

        return categoryMapper.toDto(categoryRepository.save(category));
    }

    public CategoryDto getById(long id){
        Category category = categoryRepository.findById(id)
                .orElseThrow(()-> new AppException("Category not found with id:"+id));

        return categoryMapper.toDto(category);
    }

    public void delete(long id){
        Category category = categoryRepository.findById(id)
                .orElseThrow(()->new AppException("Category not found with id:"+id));

        categoryRepository.delete(category);
    }
}
