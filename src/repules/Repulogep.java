package repules;

import java.util.Objects;

public class Repulogep implements Comparable<Repulogep>{
    private String gyarto;
    private String tipus;
    private double hossz;
    private boolean sugarhajtasu;

    public Repulogep(String gyarto, String tipus, double hossz, boolean sugarhajtasu){
//        A konstruktor dobjon IllegalArgumentExceptionkivételt
//        „A hossz csak pozitív lehet!” üzenettel, ha a paramétereként megkapott hossz nem pozitív!
        if(hossz < 0)
            throw new IllegalArgumentException("A hossz csak pozitív lehet!");
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
        //Egy repülőgépbármelyik másik repülőgéppel (akár Utasszállítótípusúval is) legyen összehasonlítható.
        //Ehhez visszatérünk ^^^
        if (this == o) return true;
        if (o == null || !(o instanceof Repulogep)) return false;
        Repulogep repulogep = (Repulogep) o;
        return gyarto.equalsIgnoreCase(repulogep.gyarto)
                && tipus.equalsIgnoreCase(repulogep.gyarto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gyarto, tipus);
    }

    @Override
    public String toString() {
        return gyarto + " " + tipus + (isSugarhajtasu() ? " sugárhajtású repülőgép, hossza: "
                : " repülőgép, hossza: ") + hossz + " m";
    }


    @Override
    public int compareTo(Repulogep o) {
        int kulonbseg = gyarto.compareToIgnoreCase(o.gyarto);
        if(kulonbseg != 0)
            return kulonbseg;
        return tipus.compareToIgnoreCase(o.tipus);
    }
}
