/* Below is the DrivableMap class, which is a map that contains a
 * HashMap mapping Strings to Drivable objects.
 * (Think of Python dictionaries as a comparison -- the concept is
 * similar!)
 *
 * Implement the requested methods as stated in the TODOs. We've
 * created the constructor for you already.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class DrivableMap {
    HashMap<String, Drivable> drivable_map;

    /**
     * A generic constructor that initializes car_map
     * as an empty HashMap.
     */
    public DrivableMap() {
        drivable_map = new HashMap<>();
    }

    /* TODO: Write a method named addDrivable that takes a String (the ID)
     *       and a Drivable object. If the ID string does not appear as a key
     *       in drivable_map, then add the pair to drivable_map.
     *       Return true if the Drivable was added to drivable_map.
     */

    /**
     * Return boolean whether a drivable object has been added
     * to the map. A drivable object is added if the id associated with
     * the object does not appear as a key in the map.
     *
     * @param id key associated with the object
     * @param object to be added to the map
     * @return boolean of whether the object was added to the map
     */
    public boolean addDrivable(String id, Drivable object) {
        if (!drivable_map.containsKey(id)) {
            drivable_map.put(id, object);
            return true;
        }
        return false;
    }

    /* TODO: Write a method named hasFasterThan that takes an int (a speed)
     *       and returns true iff there is at least one item in drivable_map
     *       that has a maxSpeed >= the speed given.
     * You may want to use drivable_map.keys() or drivable_map.values() to
     * iterate through drivable_map.
     */

    /**
     * Return a boolean whether a Drivable object has a maxSpeed faster than
     * a speed inputted.
     *
     * @param speed to compare to
     * @return true if there is at least one item in drivable_map that has a
     * maxSpeed greater than or equal to the speed given
     */
    public boolean hasFasterThan(int speed) {
        for (Drivable value : drivable_map.values()) {
            if (value.getMaxSpeed() >= speed) {
                return true;
            }
        }
        return false;
    }

    /* TODO: Write a method named getTradable that takes no arguments and
     *       returns a List containing all of the Tradable items in
     *       drivable_map.
     */

    /**
     * Takes no arguments and returns a list of all the Tradable items in
     * the map.
     *
     * @return list of all the Tradable items in drivable_map
     */
    public List<Tradable> getTradable() {
        List<Tradable> tradableItems = new ArrayList<Tradable>();
        for (Drivable value : drivable_map.values()) {
            if (value instanceof Tradable) {
                tradableItems.add((Tradable) value);
            }
        }
        return tradableItems;
    }
}