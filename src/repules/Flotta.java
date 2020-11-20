package repules;

public interface Flotta {
    // új repülőgépet vesz fel a flottába
     public void felvesz(Repulogep repulo);
    // visszaadja azoknak az utasszállítóknak a rendezett listáját (a természetes
    // rendezettség sorrendjében), amelyek legalább a paraméterben megkapott számú
    // férőhellyel rendelkeznek
     public java.util.List<Utasszallito> megfeleloGepek(int utasszam);
    // kiírja a megadott állományba a repülőgépek listáját (mindegyiket külön sorba)
    public void kiir(String fajlnev);
}
