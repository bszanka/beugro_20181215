package teszt;

import repules.Repulogep;
import repules.Utasszallito;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RepuloTeszt {

    public static void main(String[] args) {
        if(args[0].length() == 0)
            System.err.println("Nincs megadva parancssori argumentum!");
        List<Repulogep> repgepek = new ArrayList<>();
        try {
            Scanner fajl = new Scanner(new File(args[0]));
            while(fajl.hasNextLine()){
                fajl.useDelimiter(";");
                boolean utasszallito = false;
                if(fajl.next().trim().endsWith("U"))
                    utasszallito = true;
                if(utasszallito)
                    System.out.println("Utasszállító gép:");
                else
                    System.out.println("Repülőgép: ");
                String gyarto = fajl.next();
                System.out.println(gyarto);
                String tipus = fajl.next();
                System.out.println(tipus);
                String  hossz = fajl.next();
                System.out.println(hossz);
                boolean sugarhajtasu = false;
                if(fajl.next().trim().endsWith("S"))
                    sugarhajtasu = true;
                if (sugarhajtasu)
                    System.out.println("S");
                else
                    System.out.println("N");
                String ferohely = "0";
                if(utasszallito) {
                    ferohely = fajl.next().trim();
                    System.out.println("férőhely " + ferohely);
                    repgepek.add(new Utasszallito(gyarto, tipus, Double.parseDouble(hossz), sugarhajtasu, Integer.parseInt(ferohely)));
                    System.out.println("Új utasszállító létrehozva");
                }else{
                    repgepek.add(new Repulogep(gyarto, tipus, Double.parseDouble(hossz), sugarhajtasu));
                    System.out.println("Új repülőgép létrehozva");
                }
            }
            if(repgepek.isEmpty())
                System.out.println("Üres a repgépek lista.");
            for (Repulogep r : repgepek) {
                System.out.println(r);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("Nem található ilyen nevű fájl!");
        } catch (IllegalArgumentException e)
        {
            e.getMessage();
        }


    }
}
