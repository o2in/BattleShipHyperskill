enum DangerLevel {
    HIGH(3),
    MEDIUM(2),
    LOW(1);

    private final int levels;

    DangerLevel(int value) {
        this.levels = value;
    }

    public int getLevel() {
        return levels;
    }


}