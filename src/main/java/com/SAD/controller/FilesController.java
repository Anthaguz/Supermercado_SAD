package com.SAD.controller;

import com.SAD.domain.FileInfo;
import com.SAD.domain.Producto;
import com.SAD.domain.ResponseMessage;
import com.SAD.service.FilesStorageService;
import com.SAD.service.ProductoService;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

@Controller
@CrossOrigin("http://localhost:8081")
public class FilesController {
    @Autowired
    ProductoService productoService;
    @Autowired
    FilesStorageService storageService;
    
    @GetMapping("/uploadtest")
    public String uploadtest(){
        return "/uploadtest";
    }
    
    @PostMapping("/producto/upload")
    public String uploadFile(Producto producto) {
//        try {
            storageService.save(producto);
            String location="\\imagenes\\uploads\\" + producto.nombre+".jpg";
            producto.setImagen(location);
            productoService.save(producto);
            return "redirect:/producto/lista";
    }
}
