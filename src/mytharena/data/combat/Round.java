package mytharena.data.combat;

import java.io.Serializable;

public class Round implements Serializable {

    private final int character1Health;
    private final int character2Health;
    private final int character1MinionTotalHealth;
    private final int character2MinionTotalHealth;
    private final int character1AttackResult;
    private final int character2AttackResult;

    public Round(int character1Health, int character2Health, int character1MinionTotalHealth, int character2MinionTotalHealth, int character1AttackResult, int character2AttackResult) {
        this.character1Health = character1Health;
        this.character2Health = character2Health;
        this.character1MinionTotalHealth = character1MinionTotalHealth;
        this.character2MinionTotalHealth = character2MinionTotalHealth;
        this.character1AttackResult = character1AttackResult;
        this.character2AttackResult = character2AttackResult;
    }

    public int getCharacter1Health() {
        return character1Health;
    }

    public int getCharacter2Health() {
        return character2Health;
    }

    public int getCharacter1MinionTotalHealth() {
        return character1MinionTotalHealth;
    }

    public int getCharacter2MinionTotalHealth() {
        return character2MinionTotalHealth;
    }

    public int getCharacter1AttackResult() {
        return character1AttackResult;
    }

    public int getCharacter2AttackResult() {
        return character2AttackResult;
    }
}
