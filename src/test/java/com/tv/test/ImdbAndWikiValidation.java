package com.tv.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tv.baseclass.BaseClass;
import com.tv.pages.IMDB;
import com.tv.pages.WIKI;


public class ImdbAndWikiValidation {
	
	@Test
	public void validation() {
		
		IMDB imdb = new IMDB(BaseClass.driver);
		imdb.selMethod.getURL(BaseClass.prop.getProperty("IMDB"));
		imdb.searchMovie(BaseClass.prop.getProperty("MovieName"));
		imdb.selectMovie(BaseClass.prop.getProperty("MovieName"));
		String imdbReleaseDate = imdb.getMovieReleaseDate();
		String imdbMovieCountry = imdb.getMovieCountry();
		
		System.out.println("Movie release date in IMDB : "+imdbReleaseDate);
		System.out.println("Movie release country in IMDB : "+imdbMovieCountry);
		
		WIKI wiki = new WIKI(BaseClass.driver);
		wiki.selMethod.getURL(BaseClass.prop.getProperty("WIKI"));
		wiki.searchMovie(BaseClass.prop.getProperty("MovieName"));
		String wikiReleaseDate = wiki.getMovieReleaseDate();
		String wikiMovieCountry = wiki.getMovieCountry();
		
		System.out.println("Movie release date in WIKI : "+wikiReleaseDate);
		System.out.println("Movie release country in WIKI : "+wikiMovieCountry);
		
		wiki.selMethod.quit();
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(wikiReleaseDate,imdbReleaseDate,"Movie release date is not same in IMDB and WIKI");
		softAssert.assertEquals(wikiMovieCountry,imdbMovieCountry,"Movie release country is not same in IMDB and WIKI");
		softAssert.assertAll();
		
	}

}

