package me.Gru2303.BlockTest.BlockHole;

public enum BlockHoleType {

    HORIZONTAL(0),

    VERTICAL(1),

    VERTICAL_X(1),

    VERTICAL_Z(3);

    private final int slot;

    private BlockHoleType(int slot) {
        this.slot = slot;
    }

    public int getSlot() {
        return slot;
    }
}
