//Pokemon.java

import java.util.Random;

public class Pokemon {
    private String name;
    private String type;
    private int hp;
    private String[] moves;
    private int[] damageValues;
    private Random rand = new Random();

    public Pokemon(String name, String type, String[] moves, int[] damageValues) {
        this.name = name;
        this.type = type;
        this.hp = 30;
        this.moves = moves;
        this.damageValues = damageValues;
    }

    public void attack(Pokemon opponent) {
        if (hp == 0) {
            System.out.println(name + " has fainted and cannot attack.");
            return;
        }

        int index = rand.nextInt(moves.length);
        String selectedMove = moves[index];
        int damage = damageValues[index];

        System.out.println(name + " uses " + selectedMove + "!");
        opponent.takeDamage(damage);
    }

    public void takeDamage(int damage) {
        if (hp == 0) return;

        hp -= damage;
        if (hp < 0) hp = 0;

        System.out.println(name + " takes " + damage + " damage! [HP: " + hp + "]");

        if (hp == 0) {
            System.out.println(name + " has fainted!");
        }
    }

    public void defend() {
        if (hp > 0)
            System.out.println(name + " defends against the attack!");
    }

    public void run() {
        if (hp > 0)
            System.out.println(name + " dodges and runs to safety!");
    }

    public int getHp() {
        return hp;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
