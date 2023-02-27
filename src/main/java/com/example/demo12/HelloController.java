package com.example.demo12;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Line;

public class HelloController {
    public ObservableList<String> items = FXCollections.observableArrayList();

    @FXML
    private Button jedna;
    @FXML
    private Button dva;
    @FXML
    private Button nula;
    @FXML
    private Button tri;
    @FXML
    private Button ctyri;
    @FXML
    private Button pet;
    @FXML
    private Button sest;
    @FXML
    private Button sedm;
    @FXML
    private Button osm;
    @FXML
    private Button devet;
    @FXML
    private Button plus;
    @FXML
    private Button minus;
    @FXML
    private Button carka;
    @FXML
    private Button restart;
    @FXML
    private Button vrat;
    @FXML
    private Line lineDoS1, lineDoS2, lineDoS3, lineDoA1, lineDoA2, lineDoA3, lineDoB1, lineDoB2, lineDoB3,
             lineZBdoB2, lineZBdoB3, lineZAdoA2, lineZAdoA3;
    @FXML
    CubicCurve lineZAdoA1, lineZBdoB1;
    @FXML
    public Circle prvniStav;
    @FXML
    public Circle druhyStav;
    @FXML
    public Circle tretiStav;
    @FXML
    public TextArea vystupTA;
    @FXML
    public TextArea vstupyTA;

    @FXML
    void keyPressed(KeyEvent key){
        KeyCode keyCode = key.getCode();
        if (keyCode == KeyCode.DIGIT0){
            pridejNulu();
        }
        if (keyCode == KeyCode.DIGIT1){
            pridejJednicku();
        }
        if (keyCode == KeyCode.DIGIT2){
            pridejDvojku();
        }
        if (keyCode == KeyCode.DIGIT3){
            pridejTrojku();
        }
        if (keyCode == KeyCode.DIGIT4){
            pridejCtyrku();
        }
        if (keyCode == KeyCode.DIGIT5){
            pridejPetku();
        }
        if (keyCode == KeyCode.DIGIT6){
            pridejSestku();
        }
        if (keyCode == KeyCode.DIGIT7){
            pridejSedmicku();
        }
        if (keyCode == KeyCode.DIGIT8){
            pridejOsmicku();
        }
        if (keyCode == KeyCode.DIGIT9){
            pridejDevitku();
        }
        if (keyCode == KeyCode.COMMA){
            pridejCarku();
        }
        if (keyCode == KeyCode.PLUS){
            pridejPlus();
        }
        if (keyCode == KeyCode.MINUS){
            pridejMinus();
        }


    }

 //Stav stavS = new Stav(1, true, prvniStav);
//    Stav stavA = new Stav(2, false, druhyStav);
//    Stav stavB = new Stav(3, false, tretiStav);
    Stav stavS = new Stav(1, true);
    Stav stavA = new Stav(1, false);
    Stav stavB = new Stav(1, false);


    public void opakujStavB(){
            lineDoB1.setStroke(Color.BLACK);
            lineDoB2.setStroke(Color.BLACK);
            lineDoB3.setStroke(Color.BLACK);
            lineZBdoB1.setStroke(Color.BLUE);
            lineZBdoB2.setStroke(Color.BLUE);
            lineZBdoB3.setStroke(Color.BLUE);
    }

    public void opakujStavA(){
            lineDoA1.setStroke(Color.BLACK);
            lineDoA2.setStroke(Color.BLACK);
            lineDoA3.setStroke(Color.BLACK);
            lineZAdoA1.setStroke(Color.BLUE);
            lineZAdoA2.setStroke(Color.BLUE);
            lineZAdoA3.setStroke(Color.BLUE);
    }

    public void jdiDoStavuA(){
        lineDoS1.setStroke(Color.BLACK);
        lineDoS2.setStroke(Color.BLACK);
        lineDoS3.setStroke(Color.BLACK);
        lineDoA1.setStroke(Color.BLUE);
        lineDoA2.setStroke(Color.BLUE);
        lineDoA3.setStroke(Color.BLUE);
        prvniStav.setStroke(Color.BLACK);
        druhyStav.setStroke(Color.YELLOW);
        stavS.aktulni = false;
        stavA.aktulni = true;
       //stavS.kruh.setStroke(Color.BLACK);
        //stavA.kruh.setStroke(Color.YELLOW);
    }

    public void jdiDoStavuB(){
        lineDoA1.setStroke(Color.BLACK);
        lineDoA2.setStroke(Color.BLACK);
        lineDoA3.setStroke(Color.BLACK);
        lineZAdoA1.setStroke(Color.BLACK);
        lineZAdoA2.setStroke(Color.BLACK);
        lineZAdoA3.setStroke(Color.BLACK);
        lineDoB1.setStroke(Color.BLUE);
        lineDoB2.setStroke(Color.BLUE);
        lineDoB3.setStroke(Color.BLUE);
        druhyStav.setStroke(Color.BLACK);
        tretiStav.setStroke(Color.YELLOW);
        stavA.aktulni = false;
        stavB.aktulni = true;
        //stavA.kruh.setStroke(Color.BLACK);
        //stavB.kruh.setStroke(Color.YELLOW);
    }

    public void zAdoB(){
        if(items.contains(",")){
            jdiDoStavuB();
        }
        else{
            jdiDoStavuA();
        }
    }

    /**
     * Cesta zpět z B do A
     */
    public void zBdoA(){
        lineDoB1.setStroke(Color.RED);
        lineDoB2.setStroke(Color.RED);
        lineDoB3.setStroke(Color.RED);
        lineZBdoB1.setStroke(Color.BLACK);
        lineZBdoB2.setStroke(Color.BLACK);
        lineZBdoB3.setStroke(Color.BLACK);
    }

    /**
     * Chyba pro +, - a ,
     * @return
     */
    public boolean zkontrolujPodminkyB(){
        if(!items.isEmpty() && items.contains(",")){
            return true;
        }
        return false;
    }

    /**
     * Jen pro čárku jako první symbol je false
     * @return
     */
    public boolean zkontrolujPodminkyS() {
        if (items.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * Jen pro + a - je to chyba
     * @return
     */
    public boolean zkontrolujPodminkyA(){
        if (!items.isEmpty()){
            return true;
        }
        return false;
    }

    public void vypis(){
        vypisVysledek();
        String result = "";
        for (int i = 0; i < items.size(); i++) {
            result += " [" + items.get(i) + "],";
        }

        vstupyTA.setText(result);
    }
    public void vypisVysledek(){
        String result = "";
        for (int i = 0; i < items.size(); i++) {
           result += "" + items.get(i);
        }
        vystupTA.setText(result);
    }

    public void restartuj(){
        items.clear();
        vstupyTA.clear();
        vystupTA.clear();
        lineDoA1.setStroke(Color.BLACK);
        lineDoA2.setStroke(Color.BLACK);
        lineDoA3.setStroke(Color.BLACK);
        lineZAdoA1.setStroke(Color.BLACK);
        lineZAdoA2.setStroke(Color.BLACK);
        lineZAdoA3.setStroke(Color.BLACK);
        lineZBdoB1.setStroke(Color.BLACK);
        lineZBdoB2.setStroke(Color.BLACK);
        lineZBdoB3.setStroke(Color.BLACK);
        lineDoB1.setStroke(Color.BLACK);
        lineDoB2.setStroke(Color.BLACK);
        lineDoB3.setStroke(Color.BLACK);
        druhyStav.setStroke(Color.BLACK);
        tretiStav.setStroke(Color.BLACK);
        prvniStav.setStroke(Color.YELLOW);
        lineDoS2.setStroke(Color.BLUE);
        lineDoS1.setStroke(Color.BLUE);
        lineDoS3.setStroke(Color.BLUE);
        // smazat všechny barvy

    }

    public void vratZpet(){
        // pokud odebiráme čárku
        boolean indikator;
        indikator = items.contains(",");
        if(items.size() == 0){
            Alert aler = new Alert(Alert.AlertType.ERROR, "Vstup je prázdný, nelze odebrat žádný prvek");
            aler.showAndWait();
            return;
        }
        items.remove(items.size()-1);
        if(items.contains(",") == false && indikator){
        zBdoA();
        }
        vypis();
    }

    @FXML
    private void pridejNulu(){
        items.add(String.valueOf(0));
        vypis();
        if(stavA.aktulni){
            opakujStavA();
            return;
        }
        if(stavB.aktulni){
            opakujStavB();
            return;
        }
        zAdoB();
    }
    @FXML
    public void pridejJednicku() {
        items.add(String.valueOf(1));
        vypis();
        if(stavA.aktulni){
            opakujStavA();
            return;
        }
        if(stavB.aktulni){
            opakujStavB();
            return;
        }
        zAdoB();
    }
    @FXML
    public void pridejDvojku(){
        items.add(String.valueOf(2));
        vypis();
        if(stavA.aktulni){
            opakujStavA();
            return;
        }
        if(stavB.aktulni){
            opakujStavB();
            return;
        }
        zAdoB();
    }
    @FXML
    private void pridejTrojku(){
        items.add(String.valueOf(3));
        vypis();
        if(stavA.aktulni){
            opakujStavA();
            return;
        }
        if(stavB.aktulni){
            opakujStavB();
            return;
        }
        zAdoB();
    }
    @FXML
    private void pridejCtyrku(){
        items.add(String.valueOf(4));
        vypis();
        if(stavA.aktulni){
            opakujStavA();
            return;
        }
        if(stavB.aktulni){
            opakujStavB();
            return;
        }
        zAdoB();
    }
    @FXML
    private void pridejPetku(){
        items.add(String.valueOf(5));
        vypis();
        if(stavA.aktulni){
            opakujStavA();
            return;
        }
        if(stavB.aktulni){
            opakujStavB();
            return;
        }
        zAdoB();
    }
    @FXML
    private void pridejSestku(){
        items.add(String.valueOf(6));
        vypis();
        if(stavA.aktulni){
            opakujStavA();
            return;
        }
        if(stavB.aktulni){
            opakujStavB();
            return;
        }
        zAdoB();
    }
    @FXML
    private void pridejSedmicku(){
        items.add(String.valueOf(7));
        vypis();
        if(stavA.aktulni){
            opakujStavA();
            return;
        }
        if(stavB.aktulni){
            opakujStavB();
            return;
        }
        zAdoB();
    }
    @FXML
    private void pridejOsmicku(){
        items.add(String.valueOf(8));
        vypis();
        if(stavA.aktulni){
            opakujStavA();
            return;
        }
        if(stavB.aktulni){
            opakujStavB();
            return;
        }
        zAdoB();
    }
    @FXML
    private void pridejDevitku(){
        items.add(String.valueOf(9));
        vypis();
        if(stavA.aktulni){
            opakujStavA();
            return;
        }
        if(stavB.aktulni){
            opakujStavB();
            return;
        }
        zAdoB();
    }
    @FXML
    private void pridejPlus(){
        if(zkontrolujPodminkyA() == true || zkontrolujPodminkyB() == true){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Teď již nelze vložit plus!");
            alert.showAndWait();
            return;
        }
        items.add(String.valueOf("+"));
        vypis();
        zAdoB();
    }
    @FXML
    private void pridejMinus(){
        if(zkontrolujPodminkyA() == true || zkontrolujPodminkyB() == true){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Teď již nelze vložit mínus!");
            alert.showAndWait();
            return;
        }
        items.add(String.valueOf("-"));
        vypis();
        zAdoB();
    }
    @FXML
    private void pridejCarku(){
        if(zkontrolujPodminkyS() == true || zkontrolujPodminkyB() == true){
            Alert alert = new Alert(Alert.AlertType.ERROR, "V tuto chvíli nelze vložit čárku!");
            alert.showAndWait();
            return;
        }
        items.add(String.valueOf(","));
        vypis();
        zAdoB();
    }
}