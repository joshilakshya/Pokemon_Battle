//PokemonThread.java

public class PokemonThread implements Runnable {
    private Pokemon pokemon;
    private Pokemon opponent;

    public PokemonThread(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void setOpponent(Pokemon opponent) {
        this.opponent = opponent;
    }

    @Override
    public void run() {
        System.out.println(pokemon.getName() + " (" + pokemon.getType() + " type) enters the battle!");

        for (int round = 1; round <= 10; round++) {
            if (pokemon.getHp() == 0 || opponent.getHp() == 0) {
                break;
            }

            performRound();
        }

        // Final HP summary
        System.out.println("\n== Battle Summary for " + pokemon.getName() + " ==");
        System.out.println(pokemon.getName() + " Final HP: " + pokemon.getHp());
    }

    private void performRound() {
        try {
            pokemon.attack(opponent);
            Thread.sleep(400);

            if (opponent.getHp() > 0) {
                pokemon.defend();
                Thread.sleep(300);

                pokemon.run();
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            System.out.println(pokemon.getName() + "'s round was interrupted.");
        }
    }
}
