package ba.sum.fpmoz.informatika.lshop.model;

public class Product extends Table{
    @Entity(type = "INTEGER", size = 32, primary = true)
    int id;

    @Entity(type="VARCHAR", size=50, isnull = false)
    String brand;

    @Entity(type="VARCHAR", size=50, isnull = false)
    String model;

    @Entity(type="VARCHAR", size=50, isnull = false)
    String price;

    @Entity(type="VARCHAR", size=50, isnull = false)
    String screen;

    @Entity(type="VARCHAR", size=50, isnull = false)
    String ram;

    @Entity(type="VARCHAR", size=50, isnull = false)
    String processor;

    @Entity(type="VARCHAR", size=50, isnull = false)
    String image;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
