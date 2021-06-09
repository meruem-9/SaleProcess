package se.kth.IV1350.Intergration;

/**
 * SystemStartup is an object that starts the external accounting
 * system and inventory system.
 *
 */


public class SystemStartUp {

    private AccountingSystem accountingSystem;
    private InventorySystem inventorySystem;

    /**
     * creating an instance of System start up
     */

    public SystemStartUp(){
        accountingSystem = new AccountingSystem();
        inventorySystem = new InventorySystem();

    }

    /**
     *  get the value of the accounting system
     * @return accountingSystem
     */

    public AccountingSystem getAccountingSystem(){
        return accountingSystem;
    }

    /**
     *  get the value of inventory system
     * @return inventorySystem
     */

    public InventorySystem getInventorySystem(){
        return inventorySystem;
    }


}
