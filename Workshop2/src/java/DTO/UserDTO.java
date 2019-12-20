/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
//Vì object cần dẫy đi giữ các trang trên mỗi trường mạng nên cần nhờ máy ảo java 
//chuyển đổi thành hệ nhị phân tự động
public class UserDTO implements Serializable{
    private String username;
    private String password;
    private String fullname;

    //phải có contructor tối thiểu và truyền tham số
    public UserDTO(String username, String password, String fullname) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
    }
    
    public UserDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    
    
    
}
