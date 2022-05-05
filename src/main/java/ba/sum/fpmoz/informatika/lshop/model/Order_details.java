package ba.sum.fpmoz.informatika.lshop.model;

public class Order_details extends Table{
    @Entity(type = "INTEGER", size = 32, primary = true)
    int id;

    @Entity(type="INTEGER", size=10, isnull = false)
    int qty;

    @Entity(type="INTEGER", size=10, isnull = false)
    int price;

    @Entity(type="INTEGER", size=10, isnull = false)
    int subtotal;

    @ForeignKey(table = "Product", attribute = "id")
    @Entity(type = "INTEGER", size = 32)
    int productFk;

    @ForeignKey(table = "Order_tbl", attribute = "id")
    @Entity(type = "INTEGER", size = 32)
    int orderFk;

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public Order_tbl getOrderFk() throws Exception {
        return (Order_tbl)Table.get(Order_tbl.class, orderFk);
    }

    public void setOrderFk(int orderFk) {
        this.orderFk = orderFk;
    }

    public Product getProductFk() throws Exception {
        return (Product)Table.get(Product.class, productFk);
    }

    public void setProductFk(int productFk) {
        this.productFk = productFk;
    }
}
