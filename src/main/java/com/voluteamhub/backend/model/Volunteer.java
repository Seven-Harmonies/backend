package com.voluteamhub.backend.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Volunteer {
        @Id
        @GeneratedValue
        private Long id;
        private String email;
        private String last_name;
        private String first_name;
        private String phone;
        private String user_name;
        private String photo_url;
        private String password;

        public Volunteer(String email, String last_name, String first_name, String phone, String user_name, String photo_url, String password) {
                this.email = email;
                this.last_name = last_name;
                this.first_name = first_name;
                this.phone = phone;
                this.user_name = user_name;
                this.photo_url = photo_url;
                this.password = password;
        }

        public Volunteer(){}

        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getLast_name() {
                return last_name;
        }

        public void setLast_name(String last_name) {
                this.last_name = last_name;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Volunteer volunteer = (Volunteer) o;
                return id == volunteer.id && Objects.equals(email, volunteer.email) && Objects.equals(last_name, volunteer.last_name) && Objects.equals(first_name, volunteer.first_name) && Objects.equals(phone, volunteer.phone) && Objects.equals(user_name, volunteer.user_name) && Objects.equals(photo_url, volunteer.photo_url) && Objects.equals(password, volunteer.password);
        }

        @Override
        public int hashCode() {
                return Objects.hash(id, email, last_name, first_name, phone, user_name, photo_url, password);
        }

        public String getFirst_name() {
                return first_name;
        }

        public void setFirst_name(String first_name) {
                this.first_name = first_name;
        }

        public String getPhone() {
                return phone;
        }

        public void setPhone(String phone) {
                this.phone = phone;
        }

        public String getUser_name() {
                return user_name;
        }

        public void setUser_name(String user_name) {
                this.user_name = user_name;
        }

        public String getPhoto_url() {
                return photo_url;
        }

        public void setPhoto_url(String photo_url) {
                this.photo_url = photo_url;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }
}
