public enum BoardModes {
    BOARD_3X3(1),
    BOARD_4X4(2);

    private final Integer id;

    BoardModes(Integer id) {
        this.id = id;
    }

    public static BoardModes nameOf(int id) {
        for (BoardModes option : values()) {
            if(option.id == id) {
                return option;
            }
        }

        return BoardModes.BOARD_3X3;
    }
}
