package com.example.demo12;

import javafx.scene.shape.Circle;

public class Stav {

    public int cislo;
    public boolean aktulni;
    public Circle kruh;

    public Stav(int cislo, boolean aktualni, Circle kruh){
        this.cislo = cislo;
        this.aktulni = aktualni;
        this.kruh = kruh;
    }
    public Stav(int cislo, boolean aktulni){
        this(cislo, aktulni, null);
    }
}
