package item;

public class Fruit implements ItemType {

    @Override
   public ItemType getItemType(){
        return new Fruit();
    }
}
