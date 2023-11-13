package com.voluteamhub.backend.repository;

import com.voluteamhub.backend.model.Association;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AssociationRepo {
    private final List<Association> associations = new ArrayList<>();
    private final DataSourceProperties db;

    public AssociationRepo(){
        this.db = new DataSourceProperties();
    }
    public AssociationRepo(DataSourceProperties db){
        this.db = db;
    }
    public List<Association> handleRequest() {
        String jdbcURL = "jdbc:postgresql://seven-harmonies.ccll3k2ugiuj.us-east-1.rds.amazonaws.com:5432/volunteamhub";

        try(Connection conn = DriverManager.getConnection(jdbcURL, "postgres", "7harmonies")){
            if(!conn.isValid(0)){
                System.out.println("Unable to connect to: " + jdbcURL);
                System.exit(0);
            }
            PreparedStatement selectStatement = conn.prepareStatement("select * from association");
            ResultSet rs = selectStatement.executeQuery();
            while(rs.next()){
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                String name = rs.getString("name");
                Association a = new Association();
                a.setEmail(email);
                a.setPhone(phone);
                a.setUserName(userName);
                a.setPassword(password);
                a.setPhotoUrl(name);

                associations.add(a);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return associations;
    }
}
