package legiKozlekedes;

import repules.Flotta;
import repules.Repulogep;
import repules.Utasszallito;
import java.util.List;

public class Legitarsasag implements Flotta {

    private String legitarsasag;
    private List<Repulogep> flotta;

    public Legitarsasag(String legitarsasag, List<Repulogep> flotta) {
        this.legitarsasag = legitarsasag;
        this.flotta.addAll(flotta); // ?
    }

    @Override
    public void felvesz(Repulogep repulo) {
        this.flotta.add(repulo); // ?
    }

    @Override
    public List<Utasszallito> megfeleloGepek(int utasszam) {
        return null;
    }

    @Override
    public void kiir(String fajlnev) {

    }
}
