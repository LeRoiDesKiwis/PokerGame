package fr.leroideskiwis.poker.game.io;

import fr.leroideskiwis.poker.Hand;

public interface GameInput {
    Action getAction(int toCall, int pot, Hand communityCards);
    class Action {
        public Action(Type type, int amount) {
            this.type = type;
            this.amount = amount;
        }

        public enum Type { FOLD, CALL, RAISE }
        public final Type type;
        public final int amount; // pour un raise, sinon 0

        @Override
        public String toString() {
            return "Action{" +
                    "type=" + type +
                    ", amount=" + amount +
                    '}';
        }
    }
}
