package khaoula.services;

import khaoula.dto.ProduitDto;
import khaoula.entitie.Produit;

import java.util.List;

public interface ProduitService {
    List<Produit> getAllProduits();
    Produit addProduit(Produit produit);
    Produit addProduitRandom();
    void loadProduitsFromCSV();

}
