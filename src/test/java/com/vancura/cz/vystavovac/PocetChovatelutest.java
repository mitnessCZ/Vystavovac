package com.vancura.cz.vystavovac;

import com.vancura.cz.vystavovac.model.Chovatel;
import com.vancura.cz.vystavovac.model.Vystava;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PocetChovatelutest {
    @Test
    public void PocetChovateluIsNull(){
        Vystava vystava = new Vystava();
        vystava.setChovatele(null);
        assertEquals(0,vystava.getPocetChovatelu(),"pocet chovatelu je null");
    }
    @Test
    public void PocetChovateluIsEmpty(){
        Vystava vystava = new Vystava();
        vystava.setChovatele(Collections.emptyList());
        assertEquals(0,vystava.getPocetPosuzovatelu(),"seznam je prazdny = 0");
    }
    @Test
    public void PocetChovateluIsTwo(){
        Vystava vystava = new Vystava();
        Chovatel chovatel1 = new Chovatel();
        Chovatel chovatel2 = new Chovatel();
        vystava.setChovatele(Arrays.asList(chovatel1, chovatel2));
        assertEquals(2, vystava.getPocetChovatelu(), "Pocet chovatelu by mel odpovidat velikosti seznamu chovatelu.");
    }
}
