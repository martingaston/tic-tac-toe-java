public class Symbol {
    private final String symbol;

    public Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public boolean equals(Object obj) {
        return obj.getClass() == this.getClass() && ((Symbol) obj).symbol.equals(this.symbol);
    }
}
