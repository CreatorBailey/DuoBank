package DuoBank.DuoBank.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Address {


    @Id
    @Column(name= "ADDRESS_ID")
    private Long id;

    @Column(name = "Street_Number")
    private String streetNumber;

    @Column(name = "Street_Name")
    private String streetName;

    @Column(name = "City")
    private String city;

    @Column(name = "State")
    private String state;

    @Column(name = "Zip_Code")
    private String zipCode;

    public Address(){

    }


    public Address(@NotEmpty Long id, @NotEmpty String streetNumber, @NotEmpty String streetName, @NotEmpty String city, @NotEmpty String state, @NotEmpty String zipCode){
        this.id= id;
        this.streetNumber= streetNumber;
        this.streetName= streetName;
        this.city= city;
        this.state= state;
        this.zipCode= zipCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", streetNumber='" + streetNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}

