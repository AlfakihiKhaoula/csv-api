package khaoula.controllers;


import io.swagger.annotations.ApiOperation;
import khaoula.entitie.Produit;
import khaoula.services.ProduitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {
    Logger logger = LoggerFactory.getLogger(ProduitController.class);

    @Autowired
    private ProduitService service;

    @GetMapping
    @ApiOperation("Return List de produits")
    public List<Produit> getAllProduits(){
        return service.getAllProduits();
    }

    @PostMapping
    @ApiOperation("pour ajouter un produit")
    public Produit addProduit(@RequestBody Produit produit){
        return service.addProduit(produit);
    }

    @PostMapping("/addRandom")
    public Produit addProduitRandom(){
        return service.addProduitRandom();
    }
}
