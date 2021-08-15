package com.remotecella.assignment.controller;

import com.remotecella.assignment.controller.dto.*;
import com.remotecella.assignment.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static com.remotecella.assignment.controller.dto.CommonResponseDto.success;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final ResponseDtoMapper RESPONSE_MAPPER = ResponseDtoMapper.INSTANCE;
    private final RequestDtoMapper REQUEST_MAPPER = RequestDtoMapper.INSTANCE;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public CommonResponseDto<List<ProductResponseDto>> getProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String[] sortBy,
            @RequestParam(required = false, defaultValue = "ASC") String sortDirection,
            @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
            @RequestParam(required = false, defaultValue = "10") Integer size){
        return success(productService.getProducts(name, sortBy, sortDirection, pageIndex, size).stream()
                        .map(RESPONSE_MAPPER::toResponse)
                        .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public CommonResponseDto<ProductResponseDto> getProduct(@PathVariable("id") Integer id) {
        return success(RESPONSE_MAPPER.toResponse(productService.getProduct(id)));
    }

    @PostMapping
    public CommonResponseDto<ProductResponseDto> addProduct(@RequestBody @Valid ProductRequestDto request){
        return success(RESPONSE_MAPPER.toResponse(productService.addProduct(REQUEST_MAPPER.toServiceDto(request))));
    }

    @PutMapping("/{id}")
    public CommonResponseDto<ProductResponseDto> updateProduct(@PathVariable("id") Integer id, @RequestBody @Valid ProductRequestDto request) {
        return success(RESPONSE_MAPPER.toResponse(productService.updateProduct(
                        REQUEST_MAPPER.toServiceDto(request.setId(id)))));
    }

    @DeleteMapping("/{id}")
    public CommonResponseDto<ProductResponseDto> deleteProduct(@PathVariable("id") Integer id) {
       return success(RESPONSE_MAPPER.toResponse(productService.deleteProduct(id)));
    }

}
