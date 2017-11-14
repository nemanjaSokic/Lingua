package com.lingua.model;

import java.util.HashMap;
import java.util.Map;

public enum TipKorisnika {
	NASTAVNIK(0), UCENIK(1), ADMIN(2);
	
	 private int value;
	    private static Map map = new HashMap<>();

	    private TipKorisnika(int value) {
	        this.value = value;
	    }

	    static {
	        for (TipKorisnika tipKorisnika : TipKorisnika.values()) {
	            map.put(tipKorisnika.value, tipKorisnika);
	        }
	    }

	    public static TipKorisnika valueOf(int tipKorisnika) {
	        return (TipKorisnika) map.get(tipKorisnika);
	    }

	    public int getValue() {
	        return value;
	    }
}
