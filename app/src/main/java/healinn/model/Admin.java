package healinn.model;


public class Admin extends User {

    public Admin(String username, String password) {
        super(username, password,"admin@healinn.id");
    }

    @Override
    public String getRole() {
        return "ADMIN";
    }
}
