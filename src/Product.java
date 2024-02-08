import java.util.Objects;

public class Product {
    String name;
    String category;
    public Product(String name, String category) {
        this.name = name;
        this.category = category;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null)return false;
        if(!(obj instanceof Product))return false;
        Product other=(Product) obj;
        if(other.name.equals(this.name) && other.category.equals(this.category)) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,category);
    }

    @Override
    public String toString() {
        return "\nProduct{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
