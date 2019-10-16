public enum Colours {

    ANSI_RESET("\u001B[0m"), ANSI_RED ("\u001B[31m"), ANSI_BLUE ("\u001B[34m");

    private String colour;

    Colours (String colour){
        this.colour = colour;
    }

    public String toString(){
        return colour;
    }
}
