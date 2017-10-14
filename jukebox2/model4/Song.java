//package model;

import java.io.File;
import java.time.LocalDate;

import javafx.stage.Stage;


public class Song {
	
	private int songPlays;
	public LocalDate mostRecentPlay;
	public final static int MAXSONGPLAYS =3;
	public String name;
	String filePath;
	
	public Song(String string) {
		filePath=string;
		mostRecentPlay=LocalDate.now();
		songPlays=0;
	}
	
	public boolean canPlay() {
		
		return songPlays<MAXSONGPLAYS;
	}
	
	public int timesPlayed() {
		return songPlays;
	}


/*	
	public void playSong(String filePath) {
		if(!canPlay()) {
			return;
		}
		else {
			LocalDate today=LocalDate.now();
			if(mostRecentPlay.compareTo(today)<0) {
				songPlays=1;
				mostRecentPlay=today;
			}
			else {
				
				
				PlayAnMP3.path=filePath;
				PlayAnMP3 app = new PlayAnMP3();
				app.launch(PlayAnMP3.class);
				songPlays++;
			}         
		}
	}
*/

	@Override
		public String toString() {
		return this.name;
	}
	
}
