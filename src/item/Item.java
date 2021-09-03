package item;

public class Item {
    private String itemId;
    private Double price;
    private ItemType itemType;

    public Item(String itemId, Double price){
        this.itemId=itemId;
        this.price=price;
    }

    public void setItemType(ItemType itemType){
        this.itemType=itemType;
    }

}
