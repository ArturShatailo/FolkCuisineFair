public class Ingredient {

    private String name;

    private double price;

    public Ingredient(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int hashCode() {
        return 31 * name.hashCode() + (int) price;
    }

    @Override
    public boolean equals(Object o) {

        if(this == o) return true;

        if(o == null || this.getClass() != o.getClass()) return false;

        Ingredient i = (Ingredient) o;

        return name.equals(i.name) && price == i.price;

    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
