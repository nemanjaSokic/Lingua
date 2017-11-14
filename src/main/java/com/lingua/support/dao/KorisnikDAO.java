package com.lingua.support.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.lingua.model.Korisnik;
import com.lingua.model.TipKorisnika;

@Repository
public class KorisnikDAO {
	@Autowired
    private JdbcTemplate jdbcTemplate;
    
    
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public Korisnik getUserInfo(String username){
    	String sql = "SELECT k.korisnicko_ime, k.sifra, k.tip FROM tbl_korisnici k WHERE k.korisnicko_ime = ?";
    	Korisnik userInfo = (Korisnik)jdbcTemplate.queryForObject(sql, new Object[]{username},
    		new RowMapper<Korisnik>() {
	            public Korisnik mapRow(ResultSet rs, int rowNum) throws SQLException {
	            	Korisnik user = new Korisnik();
	                user.setKorisnickoIme(rs.getString("korisnicko_ime"));
	                user.setSifraKorisnika(rs.getString("sifra"));
	                user.setTipKorisnika(TipKorisnika.valueOf(rs.getInt("tip")));
	                return user;
	            }
        });
    	return userInfo;
    }
} 
