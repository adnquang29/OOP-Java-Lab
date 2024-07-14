
public class Expense {
    
    int id;
    String date;
    double quantity;
    String content;

    public Expense() {
        id = 0;
        date = "";
        quantity = 0;
        content = "";
    }

    public Expense(int id, String date, double quantity, String content) {
        this.id = id;
        this.date = date;
        this.quantity = quantity;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getContent() {
        return content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return String.format(" %-6d %-14s %-10.0f %-21s\n",
                getId(),
                getDate(),
                getQuantity(),
                getContent());
    }   
}
