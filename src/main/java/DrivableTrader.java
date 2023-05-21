/* TODO: Create a subclass of Trader named DrivableTrader
 * This class should be identical to Trader, except that it takes
 * only Drivable objects in its inventory, wishlist, etc.
 *
 * The sellingPrice returned should also be overridden. The selling price
 * should be equal to the:
 *     Object's price + Object's max speed
 * If the object is Tradable (and Tradable.MISSING_PRICE otherwise.)
 *
 * Look at DomesticatableTrader.java for an example.
 */

import java.util.ArrayList;
import java.util.List;

public class DrivableTrader extends Trader<Drivable> {

    /**
     * Construct a DrivableTrader, giving them the given inventory,
     * wishlist, and money.
     *
     * @param inventory Objects in this Trader's inventory
     * @param wishlist  Objects in this Trader's wishlist
     * @param money     The Trader's money
     */
    public DrivableTrader(List<Drivable> inventory,
                          List<Drivable> wishlist,
                          int money) {
        super(inventory, wishlist, money);
    }

    /**
     * Construct a DrivableTrader, giving them the
     * given money and an empty wishlist and inventory.
     *
     * @param money     The Trader's money
     */
    public DrivableTrader(int money) {
        super(money);
    }

    /**
     * Return the selling price of an object if it is Tradeable.
     * The selling price is given by the price of the object plus
     * the maxSpeed of the object.
     *
     * @param object the object whose price is wanted.
     * @return integer with the selling price of the object.
     */
    @Override
    public int getSellingPrice(Drivable object) {
        if (object instanceof Tradable) {
            int price = ((Tradable) object).getPrice();
            int maxSpeed = object.getMaxSpeed();
            return price + maxSpeed;
        } else {
            return Tradable.MISSING_PRICE;
        }
    }
}