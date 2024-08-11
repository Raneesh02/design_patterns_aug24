package testdata;

public class Product {

    String name, category;
    int qty;

    public Product(ProductBuilder productBuilder) {
        this.name = productBuilder.name;
        this.category = productBuilder.category;
        this.qty = productBuilder.qty;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getQty() {
        return qty;
    }

    public static class ProductBuilder{

        String name, category;
        int qty;


        public ProductBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder setCategory(String category) {
            this.category = category;
            return this;
        }

        public ProductBuilder setQty(int qty) {
            this.qty = qty;
            return this;
        }

        public Product build(){
            //do api calls here
            return new Product(this);
        }

    }

}
