package ma.dsbd.banqueservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Collection;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @XmlTransient @JsonIgnore
    @OneToMany(mappedBy = "client")
    private Collection<Compte> comptes;
}
