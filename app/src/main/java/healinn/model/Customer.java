package healinn.model;

public class Customer extends User {

    private String fullName;
    private String phone;

    public Customer(String username, String password, String email) {
        super(username, password, email);
        this.fullName = username;
        this.phone = "-";
    }

    public Customer(String username, String password, String email, String fullName, String phone) {
        super(username, password, email);
        this.fullName = fullName;
        this.phone = phone;
    }

    @Override
    public String getRole() {
        return "CUSTOMER";
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }    
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
