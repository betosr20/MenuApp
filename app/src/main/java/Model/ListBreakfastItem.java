package Model;

public class ListBreakfastItem {
    private String tittle;
    private String description;
    private String price;

    public ListBreakfastItem(String tittle, String description, String price) {

        this.tittle = tittle;
        this.description = description;
        this.price = price;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
