public enum Grad {
    TRAVNIK(s:"030") ,ORASJE(s:"031"),ZENICA(s:"032"),SARAJEVO(s,"033"),LIVNO(s,"034"),MOSTAR(s,"035");

    private String s;

    Grad(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return s;
    }
}
