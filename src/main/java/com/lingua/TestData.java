package com.lingua;

import java.sql.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lingua.model.Jezik;
import com.lingua.model.Korisnik;
import com.lingua.model.Kurs;
import com.lingua.model.Nastavnik;
import com.lingua.model.Nivo;
import com.lingua.model.Skola;
import com.lingua.model.TipKorisnika;
import com.lingua.model.Ucenik;
import com.lingua.model.Uplata;
import com.lingua.service.JezikService;
import com.lingua.service.KorisnikService;
import com.lingua.service.KursService;
import com.lingua.service.NastavnikService;
import com.lingua.service.NivoService;
import com.lingua.service.SkolaService;
import com.lingua.service.UcenikService;
import com.lingua.service.UplataService;

//@Component
public class TestData {

	@Autowired
	private JezikService jezikService;
	@Autowired
	private KursService kursService;
	@Autowired
	private NastavnikService nastavnikService;
	@Autowired
	private NivoService nivoService;
	@Autowired
	private SkolaService skolaService;
	@Autowired
	private UcenikService ucenikService;
	@Autowired
	private UplataService uplataService;
	@Autowired
	private KorisnikService korisnikService;	
	private TipKorisnika tip;
	
	@PostConstruct
	public void init(){
		Korisnik kor1 = new Korisnik(TipKorisnika.UCENIK, "stud1", "123", false, 381645721843L, "stud1@example.com");
		Korisnik kor2 = new Korisnik(TipKorisnika.ADMIN, "admin", "admin", true, 381641228766L, "hutu.power@gmail.com");
		Korisnik kor3 = new Korisnik(TipKorisnika.NASTAVNIK, "nast1", "123", true, 381605305599L, "nast1@example.com");
		Korisnik kor4 = new Korisnik(TipKorisnika.UCENIK, "stud2", "123", true, 381644894972L, "stud2@example.com");
		Korisnik kor5 = new Korisnik(TipKorisnika.NASTAVNIK, "nast2", "123", true, 381644894979L, "nast2@example.com");
		Korisnik kor6 = new Korisnik(TipKorisnika.NASTAVNIK, "nast3", "123", true, 381644894974L, "nast3@example.com");
		Korisnik kor7 = new Korisnik(TipKorisnika.UCENIK, "stud3", "123", true, 381644894977L, "stud3@example.com");
		Korisnik kor8 = new Korisnik(TipKorisnika.UCENIK, "stud4", "123", true, 381644894973L, "stud4@example.com");
		korisnikService.save(kor1);
		korisnikService.save(kor4);
		korisnikService.save(kor3);
		korisnikService.save(kor2);
		korisnikService.save(kor5);
		korisnikService.save(kor6);
		korisnikService.save(kor7);
		korisnikService.save(kor8);
		
		Jezik jEng = new Jezik("english");
		Jezik jNor = new Jezik("norwegian");
		Jezik jIta = new Jezik("italian");
		jezikService.save(jEng);
		jezikService.save(jIta);
		jezikService.save(jNor);
		
		Nivo n11 = new Nivo("beginner");
		Nivo n12 = new Nivo("A1");
		Nivo n13 = new Nivo("A2");
		Nivo n21 = new Nivo("B1");
		Nivo n22 = new Nivo("B21");
		Nivo n23 = new Nivo("B22");
		Nivo n24 = new Nivo("B3");
		nivoService.save(n11);
		nivoService.save(n12);
		nivoService.save(n13);
		nivoService.save(n21);
		nivoService.save(n22);
		nivoService.save(n23);
		nivoService.save(n24);
		
		Nastavnik nast1 = new Nastavnik("Milos","Crnjanski",jEng,kor3);
		Nastavnik nast2 = new Nastavnik("Dositej","Obradovic",jIta,kor5);
		Nastavnik nast3 = new Nastavnik("Rastko","Nemanjic",jNor,kor6);
		nastavnikService.save(nast1);
		nastavnikService.save(nast2);
		nastavnikService.save(nast3);
		
		
		
		Skola s = new Skola("Lingua d.o.o.","Branka Bajića 23, Novi Sad","lingua@office.rs","www.lingua.com","233-223111-65",381214778,123,111222333);
		skolaService.save(s);
		
		Ucenik u1 = new Ucenik("Nemanja","Sokić",true,kor1);
		Ucenik u2 = new Ucenik("Pero","Antić",true,kor4);
		Kurs k1 = new Kurs(500,nast1,n12);
		k1.addUcenik(u1);
		k1.addUcenik(u2);
		
		
		
		
		
		Ucenik u3 = new Ucenik("Nikola","Jokić",true,kor7);
		Ucenik u4 = new Ucenik("Miloš","Teodosić",true,kor8);
		Kurs k2 = new Kurs(400,nast2,n23);
		
		k2.addUcenik(u3);
		k2.addUcenik(u4);
		
		
		
		
		
		
		
		Uplata upl1 = new Uplata(100,new Date(1467713837),u1);
		Uplata upl2 = new Uplata(100,new Date(1467713837),u1);
		Uplata upl3 = new Uplata(100,new Date(1467713837),u2);
		Uplata upl4 = new Uplata(100,new Date(1467713837),u2);
		Uplata upl5 = new Uplata(100,new Date(1467713837),u3);
		Uplata upl6 = new Uplata(100,new Date(1467713837),u3);
		Uplata upl7 = new Uplata(100,new Date(1467713837),u4);
		
		u1.addUplata(upl1);
		u1.addUplata(upl2);
		u2.addUplata(upl3);
		u2.addUplata(upl4);
		u3.addUplata(upl5);
		u3.addUplata(upl6);
		u4.addUplata(upl7);
		
		
		
		kursService.save(k1);
		kursService.save(k2);
		ucenikService.save(u1);
		ucenikService.save(u2);
		ucenikService.save(u3);
		ucenikService.save(u4);
		uplataService.save(upl1);
		uplataService.save(upl2);
		uplataService.save(upl3);
		uplataService.save(upl4);
		uplataService.save(upl5);
		uplataService.save(upl6);
		uplataService.save(upl7);
		
		
		
		
	}

}
