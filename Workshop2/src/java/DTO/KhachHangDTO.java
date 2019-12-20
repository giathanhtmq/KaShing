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
public class KhachHangDTO implements Serializable{
    private String maKH;
    private String tenKH;
    private String diachi;
    private String email;
    public KhachHangDTO() {
    }

    public KhachHangDTO(String maKH, String tenKH, String diachi,String email) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.diachi = diachi;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
    
    
}
