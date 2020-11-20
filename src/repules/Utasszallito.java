package repules;

public class Utasszallito extends Repulogep{
    private int ferohely;

    public Utasszallito
            (String gyarto, String tipus, double hossz, boolean sugarhajtasu, int ferohely)
            throws IllegalArgumentException {
        super(gyarto, tipus, hossz, sugarhajtasu);
        this.ferohely = ferohely;
    }

    public int getFerohely() {
        return ferohely;
    }

    public void setFerohely(int ferohely) {
        this.ferohely = ferohely;
    }

    @Override
    public String toString() {
        return super.toString() + " " + ferohely + " férőhelyes";
    }


}
