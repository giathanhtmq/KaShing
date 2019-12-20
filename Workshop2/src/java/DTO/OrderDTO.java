/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author DELL
 */
public class OrderDTO implements Serializable{
    private String maDDH;
    private String maKH;
    private int totalPrice;
    private Date dateSale;

    public OrderDTO(String maDDH, String maKH, int totalPrice, Date dateSale) {
        this.maDDH = maDDH;
        this.maKH = maKH;
        this.totalPrice = totalPrice;
        this.dateSale = dateSale;
    }

    public String getMaDDH() {
        return maDDH;
    }

    public void setMaDDH(String maDDH) {
        this.maDDH = maDDH;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getDateSale() {
        return dateSale;
    }

    public void setDateSale(Date dateSale) {
        this.dateSale = dateSale;
    }
    
    
}
