package mytharena.data.notification;

import mytharena.data.combat.Combat;

public class CombatResultsNotification extends Notification{

    private final Combat combat;
    /**
     * Notification abstract class constructor
     *  @param title String title
     * @param body  String body
     * @param combat Combat combat
     */
    public CombatResultsNotification(String title, String body, Combat combat) {
        super(title, body);
        this.combat = combat;
    }

    public Combat getCombat() {
        return combat;
    }
}
