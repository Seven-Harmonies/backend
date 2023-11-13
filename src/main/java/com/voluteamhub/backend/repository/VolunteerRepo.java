package com.voluteamhub.backend.repository;

import com.voluteamhub.backend.model.Volunteer;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class VolunteerRepo {
    private final List<Volunteer> volunteers = new ArrayList<>();

    private final DataSourceProperties db;

    public VolunteerRepo(){
        this.db = new DataSourceProperties();
    }
    public VolunteerRepo(DataSourceProperties db){
        this.db = db;
    }

    public List<Volunteer> handleRequest() {
        String jdbcURL = "jdbc:postgresql://seven-harmonies.ccll3k2ugiuj.us-east-1.rds.amazonaws.com:5432/volunteamhub";

        try(Connection conn = DriverManager.getConnection(jdbcURL, "postgres", "7harmonies")){
            if(!conn.isValid(0)){
                System.out.println("Unable to connect to: " + jdbcURL);
                System.exit(0);
            }
            PreparedStatement selectStatement = conn.prepareStatement("select * from volunteer");
            ResultSet rs = selectStatement.executeQuery();
            while(rs.next()){
                String email = rs.getString("email");
                String lastName = rs.getString("lastName");
                String firstName = rs.getString("firstName");
                String phone = rs.getString("phone");
                String userName = rs.getString("userName");
                String photoUrl = rs.getString("photo");
                String password = rs.getString("password");
                Volunteer v = new Volunteer();
                v.setEmail(email);
                v.setLastName(lastName);
                v.setFirstName(firstName);
                v.setUserName(userName);
                v.setPhotoUrl(photoUrl);
                v.setPassword(password);
                v.setPhone(phone);

                volunteers.add(v);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return volunteers;
    }

}
