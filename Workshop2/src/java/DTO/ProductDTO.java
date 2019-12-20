/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class ProductDTO implements Serializable {

    private String proID, proName, Path;
    private int Price;
    private int status;

    public ProductDTO(String proID, String proName, String Path, int Price, int status) {
        this.proID = proID;
        this.proName = proName;
        this.Path = Path;
        this.Price = Price;
        this.status = status;
    }

    public ProductDTO() {
    }

    public ProductDTO(String proID, String proName, String Path, int Price) {
        this.proID = proID;
        this.proName = proName;
        this.Path = Path;
        this.Price = Price;
    }

    public ProductDTO(String proID, String proName, int Price) {
        this.proID = proID;
        this.proName = proName;
        this.Price = Price;
    }

    public String getProID() {
        return proID;
    }

    public void setProID(String proID) {
        this.proID = proID;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getPath() {
        return Path;
    }

    public void setPath(String Path) {
        this.Path = Path;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
