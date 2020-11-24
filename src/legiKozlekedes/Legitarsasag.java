package legiKozlekedes;

import repules.Flotta;
import repules.Repulogep;
import repules.Utasszallito;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Legitarsasag implements Flotta {

    private String legitarsasag;
    // MINDIG INICIALIZÁLNI KELL A LISTÁT! (new ...)
    private List<Repulogep> flotta = new ArrayList<>();

    public Legitarsasag(String legitarsasag, Repulogep[] tomb) {
        this.legitarsasag = legitarsasag;
        this.flotta.addAll(Arrays.asList(tomb));
    }

    @Override
    public void felvesz(Repulogep repulo) {
        this.flotta.add(repulo);
    }

    @Override
    public List<Utasszallito> megfeleloGepek(int utasszam) {
        List<Utasszallito> megfeleloek = new ArrayList<>();
        for (Repulogep r : flotta) {
            if(r instanceof Utasszallito && ((Utasszallito) r).getFerohely() >= utasszam)
                megfeleloek.add((Utasszallito) r);
        }
        Collections.sort(megfeleloek);
        return megfeleloek;
    }

    @Override
    public void kiir(String fajlnev) {
//        File fajl = new File(fajlnev); // kell-e?
        StringBuilder sb = new StringBuilder(legitarsasag + "\n\n");
        for (Repulogep r : flotta)
            sb.append(r + "\n");
        try {
            FileWriter fw = new FileWriter(fajlnev);
            fw.write(sb.toString());
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
