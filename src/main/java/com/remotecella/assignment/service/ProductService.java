package com.remotecella.assignment.service;

import com.remotecella.assignment.repository.ProductRepository;
import com.remotecella.assignment.repository.entity.ProductEntity;
import com.remotecella.assignment.service.dto.ProductDto;
import com.remotecella.assignment.service.dto.ServiceDtoMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final ServiceDtoMapper serviceDtoMapper = ServiceDtoMapper.INSTANCE;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<ProductDto> getProducts(String name, String[] sortBy, String sortDirection,
                                        Integer pageIndex, Integer size){
        Specification<ProductEntity> specification = (Specification<ProductEntity>) (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if(name!=null && !name.trim().isEmpty())
                predicates.add(criteriaBuilder.like(root.get("name"),"%"+name+"%"));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        PageRequest page = PageRequest.of(pageIndex, size);
        if(sortBy!=null)
           page = PageRequest.of(pageIndex, size, Sort.by(Sort.Direction.valueOf(sortDirection.toUpperCase()), sortBy));
        return repository.findAll(specification, page).stream().map(serviceDtoMapper::toDto).collect(Collectors.toList());
    }

    public ProductDto getProduct(Integer id){
        return repository.findById(id).map(serviceDtoMapper::toDto).orElseThrow(
                ()->new NoSuchElementException("no such product found: "+id));
    }

    public ProductDto addProduct(ProductDto product){
        return serviceDtoMapper.toDto(repository.save(serviceDtoMapper.toEntity(product)));
    }

    public ProductDto updateProduct(ProductDto product) throws NoSuchElementException {
        if(!repository.findById(product.getId()).isPresent())
            throw new NoSuchElementException("no such product found:"+product.getId());
        return serviceDtoMapper.toDto(repository.save(serviceDtoMapper.toEntity(product)));
    }

    public ProductDto deleteProduct(Integer id) throws NoSuchElementException {
        Optional<ProductEntity> productOpt = repository.findById(id);
        if(!productOpt.isPresent())
            throw new NoSuchElementException("no such product found:"+id);
        repository.delete(productOpt.get());
        return serviceDtoMapper.toDto(productOpt.get());
    }

}
