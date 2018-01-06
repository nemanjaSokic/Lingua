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
import com.lingua.model.Ocena;
import com.lingua.model.Skola;
import com.lingua.model.Test;
import com.lingua.model.TipKorisnika;
import com.lingua.model.TipKursa;
import com.lingua.model.Ucenik;
import com.lingua.model.Uplata;
import com.lingua.service.JezikService;
import com.lingua.service.KorisnikService;
import com.lingua.service.KursService;
import com.lingua.service.NastavnikService;
import com.lingua.service.NivoService;
import com.lingua.service.OcenaService;
import com.lingua.service.SkolaService;
import com.lingua.service.TestService;
import com.lingua.service.TipKursaService;
import com.lingua.service.UcenikService;
import com.lingua.service.UplataService;

@Component
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
	@Autowired
	private TipKursaService tipKursaService;
	@Autowired
	private TestService testService;
	@Autowired
	private OcenaService ocenaService;
	
	@PostConstruct
	public void init(){
		Jezik jEng = new Jezik("english");
		Jezik jNor = new Jezik("norwegian");
		Jezik jIta = new Jezik("italian");
		
		Nivo n11 = new Nivo("beginner");
		Nivo n12 = new Nivo("A1");
		Nivo n13 = new Nivo("A2");
		Nivo n21 = new Nivo("B1");
		Nivo n22 = new Nivo("B21");
		Nivo n23 = new Nivo("B22");
		Nivo n24 = new Nivo("B3");
		
		Korisnik admin = new Korisnik(TipKorisnika.ADMIN, "admin", "admin");
		admin.setRegistrovan(true);		
		
		Nastavnik nast1 = new Nastavnik("Milos","Crnjanski", TipKorisnika.NASTAVNIK,"nast1","123",164572183L,"sasas@dfdfd.com",true,"napomena", jEng);
		Nastavnik nast2 = new Nastavnik("Dositej","Obradovic",TipKorisnika.NASTAVNIK, "nast2", "123", 381644894979L, "nast2@example.com",true, "", jIta);
		Nastavnik nast3 = new Nastavnik("Rastko","Nemanjic", TipKorisnika.NASTAVNIK, "nast3", "123", 381644894974L, "nast3@example.com",true,"ludak", jNor);
		
		TipKursa tip1 = new TipKursa(200,jEng,n12);
		TipKursa tip2 = new TipKursa(200,jNor,n24);
		TipKursa tip3 = new TipKursa(200,jIta,n23);
		TipKursa tip4 = new TipKursa(200,jEng,n13);
		
		Kurs k1 = new Kurs(nast1,tip1);
		Kurs k2 = new Kurs(nast2,tip3);
		
		long time = System.currentTimeMillis();
		Test test1 = new Test("First chapter", "link1",k1, new Date(time));
		Test test2 = new Test("Secont chapter", "link1",k1, new Date(time));
		Test test3 = new Test("First chapter", "link2",k2, new Date(time));
		Test test4 = new Test("Second chapter", "link2",k2, new Date(time));
		
		k1.addTest(test1);
		k1.addTest(test2);
		k2.addTest(test3);
		k2.addTest(test4);
		
		Ucenik u1 = new Ucenik("Nemanja", "Sokic",TipKorisnika.UCENIK, "stud1", "123",164572183L,"nemskc@gmail.com",false,"napomena",false,k1);
		Ucenik u2 = new Ucenik("Pero","Antić", TipKorisnika.UCENIK, "stud2", "123", 381644894972L, "stud2@example.com", true, "", false, k1);
		Ucenik u3 = new Ucenik("Nikola","Jokić",TipKorisnika.UCENIK, "stud3", "123", 381644894977L, "stud3@example.com", true, "", true, k2);
		Ucenik u4 = new Ucenik("Miloš","Teodosić", TipKorisnika.UCENIK, "stud4", "123", 381644894973L, "stud4@example.com", true, "", true, k2);

		Ocena o11 = new Ocena(6,test1,u1,"kom");
		Ocena o12 = new Ocena(7,test2,u1,"kom");
		Ocena o13 = new Ocena(7,test1,u2,"kom");
		Ocena o14 = new Ocena(8,test2,u2,"kom");
		Ocena o21 = new Ocena(8,test3,u3,"kom");
		Ocena o22 = new Ocena(9,test4,u3,"kom");
		Ocena o23 = new Ocena(9,test3,u4,"kom");
		Ocena o24 = new Ocena(10,test4,u4,"kom");
		
		u1.addOcena(o11);
		u1.addOcena(o12);
		u2.addOcena(o13);
		u2.addOcena(o14);
		u3.addOcena(o21);
		u3.addOcena(o22);
		u4.addOcena(o23);
		u4.addOcena(o24);
		
		k1.addUcenik(u1);
		k1.addUcenik(u2);
		k2.addUcenik(u3);
		k2.addUcenik(u4);
		
		Skola s = new Skola("Lingua d.o.o.","Branka Bajića 23, Novi Sad","lingua@office.rs","www.lingua.com","233-223111-65",381214778,123,111222333);
		skolaService.save(s);

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
				
		nivoService.save(n11);
		nivoService.save(n12);
		nivoService.save(n13);
		nivoService.save(n21);
		nivoService.save(n22);
		nivoService.save(n23);
		nivoService.save(n24);

		
		jezikService.save(jEng);
		jezikService.save(jIta);
		jezikService.save(jNor);
		
		
		korisnikService.save(admin);
		nastavnikService.save(nast1);
		nastavnikService.save(nast2);
		nastavnikService.save(nast3);
		
		tipKursaService.save(tip1);
		tipKursaService.save(tip2);
		tipKursaService.save(tip3);
		tipKursaService.save(tip4);
		
		kursService.save(k1);
		kursService.save(k2);
		
		testService.save(test1);
		testService.save(test2);
		testService.save(test3);
		testService.save(test4);
		
		
		
		korisnikService.save(u1);
		korisnikService.save(u2);
		korisnikService.save(u3);
		korisnikService.save(u4);
		
		uplataService.save(upl1);
		uplataService.save(upl2);
		uplataService.save(upl3);
		uplataService.save(upl4);
		uplataService.save(upl5);
		uplataService.save(upl6);
		uplataService.save(upl7);
		
		ocenaService.save(o11);
		ocenaService.save(o12);
		ocenaService.save(o13);
		ocenaService.save(o14);
		ocenaService.save(o21);
		ocenaService.save(o22);
		ocenaService.save(o23);
		ocenaService.save(o24);
		
		
	}

}
