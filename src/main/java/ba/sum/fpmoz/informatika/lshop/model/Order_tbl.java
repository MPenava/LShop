package ba.sum.fpmoz.informatika.lshop.model;

public class Order_tbl extends Table{
    @Entity(type = "INTEGER", size = 32, primary = true)
    int id;

    @Entity(type="VARCHAR", size=50, isnull = false)
    String date;

    @Entity(type="INTEGER", size=10, isnull = false)
    int total;

    @ForeignKey(table = "User", attribute = "id")
    @Entity(type = "INTEGER", size = 32)
    int userFk;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public User getUserFk() throws Exception {
        return (User)Table.get(User.class, userFk);
    }

    public void setUserFk(int userFk) {
        this.userFk = userFk;
    }
}
