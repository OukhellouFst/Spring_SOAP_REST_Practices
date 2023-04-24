package ma.dsbd.banqueservice.web;

import ma.dsbd.banqueservice.entities.Compte;
import ma.dsbd.banqueservice.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path("/banque")
public class CompteRestJaxRSAPI {
    @Autowired
    private CompteRepository compteRepository;

    @Path("/comptes")
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Compte> compteList() {
        return compteRepository.findAll();
    }

    @Path("/comptes/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public  Compte getCompte(@PathParam(value = "id") Long id) {
        return compteRepository.findById(id).get();
    }

    @Path("/comptes")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public  Compte saveCompte(Compte compte) {
        return compteRepository.save(compte);
    }

    @Path("/comptes/{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public  Compte updateCompte(Compte compte,@PathParam(value = "id") Long id) {
        compte.setId(id);
        return compteRepository.save(compte);
    }

    @Path("/comptes/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public  void deleteCompte(@PathParam(value = "id") Long id) {
        compteRepository.deleteById(id);
    }
}
