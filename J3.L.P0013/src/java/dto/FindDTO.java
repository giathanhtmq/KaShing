/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;

/**
 *
 * @author giath
 */
public class FindDTO implements Serializable{
    private int id; // id of the address
    private String address, telephone,email,imagePath,openingHours; //address, telephone,email,image,openingHours of restaurant

    public FindDTO() {
    }

    public FindDTO(int id, String address, String telephone, String email, String imagePath,String openingHours) {
        this.id = id;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
        this.imagePath = imagePath;
        this.openingHours = openingHours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }
    
    

    
    
     
}
