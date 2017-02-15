package com.lingua;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lingua.model.Jezik;
import com.lingua.model.Kurs;
import com.lingua.model.Nastavnik;
import com.lingua.model.Nivo;
import com.lingua.model.Skola;
import com.lingua.model.Ucenik;
import com.lingua.service.JezikService;
import com.lingua.service.KursService;
import com.lingua.service.NastavnikService;
import com.lingua.service.NivoService;
import com.lingua.service.SkolaService;
import com.lingua.service.UcenikService;

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
	
	@PostConstruct
	public void init(){
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
		
		Nastavnik nast1 = new Nastavnik("Milos","Crnjanski",111222,jEng);
		Nastavnik nast2 = new Nastavnik("Dositej","Obradovic",222333,jIta);
		Nastavnik nast3 = new Nastavnik("Rastko","Nemanjic",333444,jNor);
		nastavnikService.save(nast1);
		nastavnikService.save(nast2);
		nastavnikService.save(nast3);
		
		Skola s = new Skola("Lingua d.o.o.","Branka Bajića 23, Novi Sad","lingua@office.rs","www.lingua.com","233-223111-65",381214778,123,111222333);
		skolaService.save(s);
		
		Ucenik u1 = new Ucenik("Nemanja","Sokić",152499,"AB123");
		Ucenik u2 = new Ucenik("Pero","Antić",678744,"CD586");
		Kurs k1 = new Kurs(500,nast1,n12);
		k1.addUcenik(u1);
		k1.addUcenik(u2);
		
		kursService.save(k1);
		ucenikService.save(u1);
		ucenikService.save(u2);
		
		
		Ucenik u3 = new Ucenik("Nikola","Jokić",75166,"FG454");
		Ucenik u4 = new Ucenik("Miloš","Teodosić",17521,"KL68");
		Kurs k2 = new Kurs(400,nast2,n23);
		
		k2.addUcenik(u3);
		k2.addUcenik(u4);
		
		
		
		kursService.save(k2);
		
		ucenikService.save(u3);
		ucenikService.save(u4);
		
		
		
		
		
		
		
		
		
	}

}
