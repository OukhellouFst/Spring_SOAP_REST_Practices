package ma.dsbd.banqueservice.web;

import ma.dsbd.banqueservice.entities.Compte;
import ma.dsbd.banqueservice.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@WebService(serviceName = "BanqueWS")
public class CompteSoapService {
    @Autowired
    private CompteRepository compteRepository;

    @WebMethod
    public List<Compte> compteList() {
        return compteRepository.findAll();
    }

    @WebMethod
    public  Compte getCompte(@WebParam(name = "id") Long id) {
        return compteRepository.findById(id).get();
    }
}
