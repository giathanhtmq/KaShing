/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class DonDatHangDTO implements Serializable{
    private int maDDH=1;
    private String maKH;
    private int totalPrice;
    private Date date;

    public DonDatHangDTO() {
    }

    public DonDatHangDTO(String maKH, int totalPrice, Date date) {
        this.maKH = maKH;
        this.totalPrice = totalPrice;
        this.date = date;
    }

    public int getMaDDH() {
        return maDDH;
    }

    public void setMaDDH(int maDDH) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
