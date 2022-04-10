package mytharena.data.character.inventory.equipment;

import java.io.Serializable;

/**
 * Armor class extends Equipment implements Serializable
 */
public class Armor extends Equipment implements Serializable {

    /**
     * Armor abstract class builder
     * @param name String name
     * @param attackModification int attackModification
     * @param defenseModification int defenseModification
     */
    public Armor(String name, int attackModification, int defenseModification) {
        super(name, attackModification, defenseModification);
    }

}
