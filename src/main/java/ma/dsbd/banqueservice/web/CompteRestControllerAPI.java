package ma.dsbd.banqueservice.web;

import ma.dsbd.banqueservice.entities.Compte;
import ma.dsbd.banqueservice.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@RestController
@RequestMapping("/banque")
public class CompteRestControllerAPI {
    @Autowired
    private CompteRepository compteRepository;

    @GetMapping(path = "/comptes",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public List<Compte> compteList() {
        return compteRepository.findAll();
    }

    @GetMapping(path = "/comptes/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public  Compte getCompte(@PathVariable Long id) {
        return compteRepository.findById(id).get();
    }

    @PostMapping(path = "/comptes")
    public  Compte saveCompte(@RequestBody Compte compte) {
        return compteRepository.save(compte);
    }

    @PutMapping("/comptes/{id}")
    public  Compte updateCompte(@RequestBody Compte compte,@PathVariable Long id) {
        compte.setId(id);
        return compteRepository.save(compte);
    }

    @DeleteMapping("/comptes/{id}")
    public  void deleteCompte(@PathVariable Long id) {
        compteRepository.deleteById(id);
    }
}
