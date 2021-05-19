package se.kth.IV1350.Intergration;

/**
 * exception thrown when invalid item is
 * not identified in the item register
 */

public class ItemNotInRegisterException extends Exception {

    public String itemNotIdentified;

    /**
     * creating an instance representing an item that is not in the register
     * with a message to notify that the item is invalid
     * @param itemNotIdentified the invalid item
     */

    public ItemNotInRegisterException(String itemNotIdentified){

        super("The Item " + itemNotIdentified + "could not be found in the register. Please enter a valid item or " +
                " add searched item to the register");
        this.itemNotIdentified = itemNotIdentified;
    }

    /**
     * get the invalid item
     * @return the invalid item
     */

    public String getItemNotIdentified(){
        return this.itemNotIdentified;
    }


}
