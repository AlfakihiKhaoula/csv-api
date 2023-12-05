package khaoula.services.Impl;

import khaoula.dto.ProduitDto;
import khaoula.entitie.Produit;
import khaoula.repositories.ProduitRepository;
import khaoula.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;

@Service
public class ProduitServiceImpl implements ProduitService {
    @Autowired
    private ProduitRepository repository;
    @Override
    public List<Produit> getAllProduits() {
        return repository.findAll();
    }

    @Override
    public Produit addProduit(Produit produit) {
        return repository.save(produit);
    }

    @Override
    public Produit addProduitRandom() {
        Random random = new Random();
       ProduitDto dto = new ProduitDto("Produit "+ random.nextInt(1000), "Description aléatoire", "");
        Produit produit = new Produit(
                dto.getNom(),
                dto.getDescription(),
                dto.getPrix()
        );
        return  repository.save(produit);
    }

    @Override
    @PostConstruct
    public void loadProduitsFromCSV() {
        try {
            InputStream input = getClass().getResourceAsStream("/produit.csv" );
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            reader.lines().forEach(line->{
                String[] elements = line.split(",");
                if(elements.length>=3){
                    Produit produit = new Produit(elements[0],elements[1],elements[2]);
                    repository.save(produit);
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
