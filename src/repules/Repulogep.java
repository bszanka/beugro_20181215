package repules;

import java.util.Objects;

public class Repulogep {
    private String gyarto;
    private String tipus;
    private double hossz;
    private boolean sugarhajtasu;

    public Repulogep(String gyarto, String tipus, double hossz, boolean sugarhajtasu) throws IllegalArgumentException {
        if(hossz < 0)   // lehet nem így kell kivételt dobni neki
            System.err.println("A hossz csak pozitív lehet!");
        this.gyarto = gyarto;
        this.tipus = tipus;
        this.hossz = hossz;
        this.sugarhajtasu = sugarhajtasu;
    }



    public String getGyarto() {
        return gyarto;
    }

    public boolean isSugarhajtasu() {
        return sugarhajtasu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Repulogep)) return false;
        Repulogep repulogep = (Repulogep) o;
        return Objects.equals(gyarto, repulogep.gyarto) &&
                Objects.equals(tipus, repulogep.tipus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gyarto, tipus);
    }
}
