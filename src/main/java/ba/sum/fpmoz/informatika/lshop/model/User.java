package ba.sum.fpmoz.informatika.lshop.model;

public class User extends Table{
    @Entity(type = "INTEGER", size = 32, primary = true)
    int id;

    @Entity(type="VARCHAR", size=50, isnull = false)
    String firstname;

    @Entity(type = "VARCHAR", size=50, isnull = false)
    String surname;


    @Entity(type="VARCHAR", size = 150, isnull = false)
    String email;

    @Entity(type = "VARCHAR", size = 256, isnull = false)
    String password;

    @Entity(type = "VARCHAR", size = 256, isnull = false)
    String role;

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
