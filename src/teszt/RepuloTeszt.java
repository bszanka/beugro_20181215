package teszt;

import legiKozlekedes.Legitarsasag;
import repules.Repulogep;
import repules.Utasszallito;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class RepuloTeszt {
    public static void teszt(List<Repulogep> rep, String gyarto){
        for (Repulogep r : rep) {
            if(r.getGyarto().equalsIgnoreCase(gyarto.trim()))
            System.out.println(r.toString());
        }
    }

    public static void main(String[] args) {
        if(args[0].length() == 0)
            System.err.println("Nincs megadva parancssori argumentum!");
        try {
            List<Repulogep> repgepek = new ArrayList<>();
            Scanner fajl = new Scanner(new File(args[0]));
            while(fajl.hasNextLine()){
                // NAGYON FONTOS! A SORNAK ÚJ SCANNER!
                Scanner sor = new Scanner(fajl.nextLine());
                sor.useDelimiter(";");
                boolean utasszallito = false;
                if(sor.next().trim().equals("U"))
                    utasszallito = true;
                String gyarto = sor.next();
                String tipus = sor.next();
                // A PARSEDOUBLE NEM ESZI MEG, HA NEM PONT A TIZEDESVESSZŐ!
                String hossz = sor.next().replaceAll(",",".");
                boolean sugarhajtasu = false;
                if (sor.next().trim().equals("S"))
                        sugarhajtasu = true;
                String ferohely = "0";
                if(utasszallito)
                    ferohely = sor.next().trim();
                try {
                    if(utasszallito)
                        repgepek.add(new Utasszallito(gyarto, tipus, Double.parseDouble(hossz), sugarhajtasu, Integer.parseInt(ferohely)));
                    else
                        repgepek.add(new Repulogep(gyarto, tipus, Double.parseDouble(hossz), sugarhajtasu));
                }
                catch (IllegalArgumentException e) {
                    System.err.println("debug: " + e.getMessage());
                }
            }
//            if(repgepek.isEmpty())
//                System.out.println("Üres a repgépek lista.");
//            for (Repulogep r : repgepek) {
//                System.out.println(r);
//            }
//            7. feladat
            Legitarsasag lt = new Legitarsasag(args[1].length() > 0 ? args[1] : "Unideb Airlines",
                    repgepek.toArray(new Repulogep[repgepek.size()]));
            for (Repulogep r : repgepek) {
                lt.felvesz(r);
            }
            Scanner stdin = new Scanner(System.in);
            System.out.println("Adjon meg egy férőhelyet: ");
            int input = stdin.nextInt();
            for (int i = 0; i < repgepek.size(); i++) {
                if(repgepek.get(i) instanceof Utasszallito && ((Utasszallito)repgepek.get(i)).getFerohely() >= input)
                    System.out.println(repgepek.get(i));
            }

//            8. feladat
            System.out.println("Adjon meg egy gyártót: ");
            String input2 = stdin.next();
            teszt(repgepek,input2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("Nem található ilyen nevű fájl!");
        } catch (IllegalArgumentException e) {
            e.getMessage();
        }
    }
}
