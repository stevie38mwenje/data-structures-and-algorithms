package executor;

public class Quote {
    private final Integer price;
    private final String site;

    public Quote(Integer price, String site) {
        this.price = price;
        this.site = site;
    }

    public Integer getPrice() {
        return price;
    }

    public String getSite() {
        return site;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "price='" + price + '\'' +
                ", site='" + site + '\'' +
                '}';
    }
}
