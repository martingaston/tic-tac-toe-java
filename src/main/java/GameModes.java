public enum GameModes {
    MODE_HVH(1),
    MODE_HVC_EASY(2),
    MODE_HVC_HARD(3),
    MODE_CVC_EASY(4);

    private final Integer id;

    GameModes(Integer id) {
        this.id = id;
    }

    public static GameModes nameOf(int id) {
        for (GameModes option : values()) {
            if(option.id == id) {
                return option;
            }
        }

        return GameModes.MODE_HVH;
    }
}
