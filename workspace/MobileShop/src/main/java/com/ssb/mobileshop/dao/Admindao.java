package com.ssb.mobileshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssb.mobileshop.model.Admin;
import com.ssb.mobileshop.util.*;

public class Admindao {
    private static Admindao adminDao;
    public static Admindao getInstance(){
        if(adminDao == null){
            //creating Admindao object if not present
            adminDao=new Admindao();
        }
        return adminDao;
    }
    public Admin getAdminDetails(Admin admin) throws Exception {
        Admin login = new Admin();
     
        String sql = "SELECT * FROM admin WHERE NAME = '"+ admin.getAdminName()+"'";
        Connection con = JdbcConnection.getConnection();
        try {
        	PreparedStatement preparedstatement = con.prepareStatement(sql);
            ResultSet result = preparedstatement.executeQuery();
            while (result.next()) {
               
                login.setAdminName(result.getString("name"));
                login.setAdminPaswd(result.getString("password"));
               
            }
        } catch(SQLException exception) {
        	throw new Exception(exception);
        
        } finally {
        	 con.close();
        }
        return login;
    }
}
