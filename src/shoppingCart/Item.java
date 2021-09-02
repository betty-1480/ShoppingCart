package shoppingCart;

public class Item {
    private String itemId;
    private String itemName;
    private Double price;

    public Item(String itemId, Double price){
        this.itemId=itemId;
        this.price=price;
    }
    public void setItemName(String itemName){
        this.itemName=itemName;
    }
}
