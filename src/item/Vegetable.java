package item;

public class Vegetable implements ItemType {
    @Override
    public ItemType getItemType(){
        return new Vegetable();
    }
}
