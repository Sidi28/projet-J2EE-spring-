package org.sid.ecombackend.web;


import org.sid.ecombackend.dao.ProductRepository;
import org.sid.ecombackend.entities.Product;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;

@ CrossOrigin("*")
@RestController
public class   CatalogueRestController {
    private ProductRepository productrepository;

    public CatalogueRestController(ProductRepository productrepository) {
        this.productrepository = productrepository;
    }

    @GetMapping(path="/photoProduct/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] Photo(@PathVariable("id")  Long id) throws Exception{
          Product p= productrepository.findById(id).get();
          return Files.readAllBytes(Paths.get(System.getProperty("user.home")+("/ecom/products/")+p.getPhotoName()));
    }

    @PostMapping(path="/uploadPhoto/{id}")
    public void uploadPhoto(MultipartFile file , @PathVariable("id")  Long id) throws Exception{
        Product p= productrepository.findById(id).get();
        p.setPhotoName(id+".png");
        Files.write(Paths.get(System.getProperty("user.home")+("/ecom/products/")+p.getPhotoName()),file.getBytes());
        productrepository.save(p);
    }

}


