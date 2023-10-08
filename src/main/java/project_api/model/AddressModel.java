package project_api.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "address")
public class AddressModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String city;
    private String state;
    private String postalCode;
}
