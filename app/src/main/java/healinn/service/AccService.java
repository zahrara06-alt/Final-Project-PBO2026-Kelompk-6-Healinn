package healinn.service;

import healinn.model.User;
import healinn.model.Admin;
import healinn.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//mengelola akun dan validasi inputan, register (customer), login (admin dan customer), cek role (admin atau customer)

public class AccService {
    private final Connection connection;
    
    public AccService() {
        this.connection = Database.getInstance().getConnection();
    }
    
    //login
    public User login(String username, String password){
        if (username == null || password == null) return null;

        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, username.trim());
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (!rs.next()) return null;
             String role = rs.getString("role");
            String uname = rs.getString("username");
            String pass = rs.getString("password");
            String email = rs.getString("email");

            if ("ADMIN".equals(role)) {
                return new Admin(uname, pass);
            } else {
                return new Customer(uname, pass, email);
            }

        } catch (SQLException e) {
            System.err.println("ACCOUNT SERVICE: Login error " + e.getMessage());
            return null;
        }
    } 

    //register customer
    public String register(String username, String email, String password){
        if(username == null || username.isBlank()){
            return "Username tidak boleh kosong.";}
        
        if(email == null || email.isBlank()){
            return "Email tidak boleh kosong.";}

        if(!email.contains("@") || !email.contains(".")){
            return "Format email tidak valid.";}
       
        if(password == null || password.length() < 6){
            return "Password tidak boleh kosong dan harus memiliki minimal 6 karakter.";}

        if(usernameExists(username.trim())){
            return "Username sudah digunakan, silakan pilih yang lain.";}

        //insert data ke database
        String sql = "INSERT INTO users (username, password, email, role) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, username.trim());
            ps.setString(2, password);
            ps.setString(3, email.trim());
            ps.setString(4, "CUSTOMER");
            ps.executeUpdate();
            return null; // null = sukses

        } catch (SQLException e) {
            System.err.println("ACCOUNT SERVICE: Register error " + e.getMessage());
            return "Terjadi kesalahan saat mendaftar.";
        }
    }

    //method helper untuk cek username 
    private boolean usernameExists(String username) {
        String sql = "SELECT 1 FROM users WHERE username = ? LIMIT 1";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, username);
            return ps.executeQuery().next();
        } catch (SQLException e) {
            return false;
        }
    }
} //akhir
