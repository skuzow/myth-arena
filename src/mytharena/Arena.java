package mytharena;

import mytharena.command.*;
import mytharena.data.Data;
import mytharena.data.character.ability.Discipline;
import mytharena.data.character.ability.Gift;
import mytharena.data.character.ability.Talent;
import mytharena.data.character.factory.character.Character;
import mytharena.data.character.factory.character.hunter.Hunter;
import mytharena.data.character.factory.character.vampire.Vampire;
import mytharena.data.character.factory.character.werewolf.Werewolf;
import mytharena.data.character.factory.minion.Minion;
import mytharena.data.character.factory.minion.demon.Demon;
import mytharena.data.character.inventory.equipment.Armor;
import mytharena.data.character.inventory.equipment.Weapon;
import mytharena.data.character.modifier.Modifier;
import mytharena.data.combat.Combat;
import mytharena.data.combat.Round;
import mytharena.data.notification.GeneralNotification;
import mytharena.data.user.Admin;
import mytharena.data.user.Player;
import mytharena.data.user.User;
import mytharena.gui.MythArenaGui;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

/**
 * Arena class
 */
public class Arena {

    /**
     * MythArenaGui mythArenaGui
     */
    private final MythArenaGui mythArenaGui = new MythArenaGui();

    /**
     * Data data
     */
    private Data data;

    /**
     * String serializablePath
     */
    private final String serializablePath = "./src/resources/serializable/data.bin";

    /**
     * HashMap String Command commandMap
     */
    private final HashMap<String, Command> commandMap = new HashMap<>();

    /**
     * User activeUser
     */
    private User activeUser;

    /**
     * Starts all, and have main loop of the application
     */
    public void start() {
        try {
            // retrieves data if serializable file exists
            File file = new File(this.serializablePath);
            if (file.exists()) {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(this.serializablePath));
                this.data = (Data) in.readObject();
            } else {
                this.data = new Data();
                // add Armor pool
                data.getArmorPool().add(new Armor("Platemail",0,2));
                data.getArmorPool().add(new Armor("Chainmail",0,1));
                data.getArmorPool().add(new Armor("Blademail",3,2));
                data.getArmorPool().add(new Armor("Cuirass", 0,3));

                // add Weapon pool
                data.getWeaponPool().add(new Weapon("Broadsword",1,0,false));
                data.getWeaponPool().add(new Weapon("Claymore",1,1,false));
                data.getWeaponPool().add(new Weapon("Katana",2,0,false));
                data.getWeaponPool().add(new Weapon("Axe",2,2,true));
                data.getWeaponPool().add(new Weapon("Rapier",3,0,false));

                // default admin account
                this.data.getUserArrayList().add(new Admin("admin", "admin", this.data));
                this.serializeData();
            }
            // create commands and insert them into commandMap with respective key
            this.commandMap.put("AdminMenu", new AdminMenu(this, this.data, this.mythArenaGui));
            this.commandMap.put("StartMenu", new StartMenu(this, this.data, this.mythArenaGui));
            this.commandMap.put("PlayerMenu", new PlayerMenu(this, this.data, this.mythArenaGui));
            this.commandMap.put("CharacterCreationMenu", new CharacterCreationMenu(this, this.data, this.mythArenaGui));
            // main loop
            while (true) {
                this.commandMap.get("StartMenu").execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Serializes Data
     */
    public void serializeData() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(this.serializablePath));
        out.writeObject(this.data);
        out.flush();
        out.close();
    }

    /**
     * Delete active user menu
     */
    public void deleteActiveUserMenu() {
        this.mythArenaGui.setMessageMode();
        this.mythArenaGui.setTitle("One step of deleting your account");
        this.mythArenaGui.setDescription("Be sure about this, there is no roll back!");
        this.mythArenaGui.setImage(0, "/resources/images/warning.png");
        this.mythArenaGui.setOption(0, "I don't want to delete my account");
        this.mythArenaGui.setOption(1, "Im sure about deleting my account");
        // account deletion
        if (this.mythArenaGui.waitEvent(30) == 'B') {
            try {
                this.data.getUserArrayList().remove(this.activeUser);
                this.serializeData();
                // for exiting to start menu
                this.setActiveUser(null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

   public void combat(Player player1, Player player2, int bet) {
        Character character1 = player1.getCharacter().clone();
        Character character2 = player2.getCharacter().clone();

        // Get weapon offense for both characters
        int weaponOffense1 = 0;
        int weaponOffense2 = 0;
        for(int i = 1; i  < 2; i++) {
            if (character1.getEquippedWeaponArrayList().get(i) != null) {
                weaponOffense1 = character1.getEquippedWeaponArrayList().get(i).getAttackModification();
            }
            if (character2.getEquippedWeaponArrayList().get(i) != null) {
                weaponOffense2 = character2.getEquippedWeaponArrayList().get(i).getAttackModification();
            }
        }

       // Calculate minions total health
       int minionTotalHealth1 = calculateMinionsTotalHealth(character1.getMinionArrayList());
       int minionTotalHealth2 = calculateMinionsTotalHealth(character2.getMinionArrayList());

        while (character1.getHealth() > 0 && character2.getHealth() > 0) {

            // Calculate character 1 ability, weaknesses and strengths
            int[] values1 = calculateCharacterModifiers(character1);
            int abilityOffense1 = values1[0];
            int abilityDefense1 = values1[1];
            int modifier1 = values1[2];

            // Calculate character 2 ability, weaknesses and strengths
            int[] values2 = calculateCharacterModifiers(character2);
            int abilityOffense2 = values2[0];
            int abilityDefense2 = values2[1];
            int modifier2 = values2[2];


            // Calculate attack and block potential of character 1
            int attackPotential1 = character1.getPower() + weaponOffense1 + abilityOffense1 + modifier1;
            int blockPotential1 = character1.getArmor().getDefenseModification() + abilityDefense1 + modifier2;

            // Calculate attack and block potential of character 2
            int attackPotential2 = character2.getPower() + weaponOffense2 + abilityOffense2 + modifier2;
            int blockPotential2 = character2.getArmor().getDefenseModification() + abilityDefense2 + modifier2;

            // Calculate attack and block value for player 1
            int attackValue1 = calculateValue(attackPotential1);
            int blockValue1 = calculateValue(blockPotential1);

            // Calculate attack and block value for player 2
            int attackValue2 = calculateValue(attackPotential2);
            int blockValue2 = calculateValue(blockPotential2);

            int character1AttackResult = blockValue2 - attackValue1;
            int character2AttackResult = blockValue1 - attackValue2;

            if (character1AttackResult > 0) {
                if (minionTotalHealth2 > 0) {
                    minionTotalHealth2 -= attackValue1;
                }else {
                    character2.setHealth(character2.getHealth() - attackValue1);
                }
            }

            if (character2AttackResult > 0) {
                if (minionTotalHealth1 > 0) {
                    minionTotalHealth1 -= attackValue2;
                }else {
                    character1.setHealth(character1.getHealth() - attackValue2);
                }
            }
            Round round = new Round();
        }
    }

    /**
     * Gets specific Command command in commandMap with String key
     * @param key String key
     * @return Command command
     */
    public Command getCommand(String key) {
        return this.commandMap.get(key);
    }

    /**
     * Gets User activeUser
     * @return User activeUser
     */
    public User getActiveUser() {
        return this.activeUser;
    }

    /**
     * Sets User activeUser
     * @param activeUser User activeUser
     */
    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    public  boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    private int calculateMinionsTotalHealth(ArrayList<Minion> minionArrayList) {
        for(Minion minion : minionArrayList) {
            if (minion instanceof Demon) {
                calculateMinionsTotalHealth(((Demon) minion).getMinionArrayList());
            }
            return minion.getHealth();
        }
        return 0;
    }

    private int calculateValue(int potential) {
        Random rand = new Random();
        int numberSuccess = 0;
        for(int i = 0; i < potential; i++) {
            int roll = rand.nextInt(6)+1;
            if (roll > 4) {
                numberSuccess += 1;
            }
        }
        return numberSuccess;
    }

    private int[] calculateCharacterModifiers(Character character) {

        int[] values = new int[3];

        //Get date
        SimpleDateFormat localDateFormat = new SimpleDateFormat("HH");
        int hour = Integer.parseInt(localDateFormat.format(new Date()));

        int abilityOffense = 0;
        int abilityDefense = 0;
        int modifier = 0;

        if (character instanceof Vampire vampire) {
            Discipline vampireDiscipline = (Discipline) vampire.getAbility();
            if (vampireDiscipline.getCost() <= vampire.getBloodPoints()) {
                abilityOffense += vampireDiscipline.getAttackModifier();
                abilityDefense += vampireDiscipline.getDefenseModifier();
                if (vampire.getBloodPoints() >= 5) {
                    abilityOffense += 2;
                }

                vampire.setBloodPoints(vampire.getBloodPoints() - vampireDiscipline.getCost());
                // Calculate modifiers for Vampire during daytime
                if (hour >= 7 && hour < 21) {
                    for (Modifier weakness : vampire.getWeaknessArrayList()) {
                        switch (weakness.getSensibility()) {
                            case 1 -> modifier -= 1;
                            case 2 -> modifier -= 2;
                            case 3 -> modifier -= 3;
                            case 4 -> modifier -= 4;
                            case 5 -> modifier -= 5;
                        }
                    }
                }
            }
        } else if (character instanceof Werewolf werewolf) {
            Gift ability = (Gift) werewolf.getAbility();
            if (werewolf.getRage() >= ability.getRageMin()) {
                abilityOffense += ability.getAttackModifier();
                abilityDefense += ability.getDefenseModifier();
            }
            // Calculate modifiers for werewolves during nighttime
            if (hour < 7 || hour >= 21) {
                for (Modifier strength : werewolf.getWeaknessArrayList()) {
                    switch (strength.getSensibility()) {
                        case 1 -> modifier += 1;
                        case 2 -> modifier += 2;
                        case 3 -> modifier += 3;
                        case 4 -> modifier += 4;
                        case 5 -> modifier += 5;
                    }
                }
            }
        }else {
            Talent ability = (Talent) character.getAbility();
            abilityOffense += ability.getAttackModifier();
            abilityDefense += ability.getDefenseModifier();
        }
        values[0] = abilityOffense;
        values[1] = abilityDefense;
        values[2] = modifier;
        return values;
    }

}
