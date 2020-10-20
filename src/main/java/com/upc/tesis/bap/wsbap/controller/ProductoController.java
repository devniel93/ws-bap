package com.upc.tesis.bap.wsbap.controller;

import com.upc.tesis.bap.wsbap.entity.Producto;
import com.upc.tesis.bap.wsbap.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @GetMapping("productos")
    public List<Producto> findProductos() {
        return  productoService.getProductos();
    }

}
