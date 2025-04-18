//Main.java

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Pokémon Battle Simulator ===");

        String[] pikachuMoves = {"Thunderbolt", "Wild Charge", "Iron Tail", "Quick Attack"};
        int[] pikachuDamage = {8, 10, 6, 4};

        String[] snivyMoves = {"Leaf Storm", "Vine Whip", "Tackle", "Magical Leaf"};
        int[] snivyDamage = {10, 6, 5, 7};

        Pokemon pikachu = new Pokemon("Pikachu", "Electric", pikachuMoves, pikachuDamage);
        Pokemon snivy = new Pokemon("Snivy", "Grass", snivyMoves, snivyDamage);

        PokemonThread pikachuThread = new PokemonThread(pikachu);
        PokemonThread snivyThread = new PokemonThread(snivy);

        pikachuThread.setOpponent(snivy);
        snivyThread.setOpponent(pikachu);

        Thread t1 = new Thread(pikachuThread);
        Thread t2 = new Thread(snivyThread);

        t1.start();
        t2.start();

        for (int i = 1; i <= 10; i++) {
            if (pikachu.getHp() == 0 || snivy.getHp() == 0) {
                break;
            }

            System.out.println("\n--- Round " + i + " ---");

            try {
                Thread.sleep(1000); // Wait for actions to play out
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted.");
            }
        }
    }
}
