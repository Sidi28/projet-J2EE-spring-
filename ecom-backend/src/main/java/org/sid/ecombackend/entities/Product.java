package org.sid.ecombackend.entities;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Product  implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String Description;
    private double  currentPrice;
    private boolean promotion;
    private boolean selected;
    private boolean available;
    private String photoName;
    @ManyToOne
    private Category category;
    @Transient
    private int quantity=1;


}

