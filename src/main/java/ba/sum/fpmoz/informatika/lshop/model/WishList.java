package ba.sum.fpmoz.informatika.lshop.model;

public class WishList extends Table{
    @Entity(type = "INTEGER", size = 32, primary = true)
    int id;

    @ForeignKey(table = "User", attribute = "id")
    @Entity(type = "INTEGER", size = 32)
    int userFk;

    @ForeignKey(table = "Product", attribute = "id")
    @Entity(type = "INTEGER", size = 32)
    int productFk;

    public User getUserFk() throws Exception {
        return (User)Table.get(User.class, userFk);
    }

    public void setUserFk(int userFk) {
        this.userFk = userFk;
    }

    public Product getProductFk() throws Exception {
        return (Product)Table.get(Product.class, productFk);
    }

    public void setProductFk(int productFk) {
        this.productFk = productFk;
    }
}
