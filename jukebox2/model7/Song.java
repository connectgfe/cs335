//package model;

import java.io.*;
import java.time.LocalDate;

import javafx.stage.Stage;


public class Song implements Serializable{
	
//	private int songPlays;
//	public LocalDate mostRecentPlay;
//	public final static int MAXSONGPLAYS =3;
//	public String name;
	public String filePath;
        public int plays;
        public LocalDate firstPlay;

	
	public Song(String string) {
		filePath=string;
//		mostRecentPlay=LocalDate.now();
//		songPlays=0;

                firstPlay=LocalDate.now();
                plays=0;
	}
	
/*
	public boolean canPlay() {
		
		return plays<MAXSONGPLAYS;
	}
*/
/*	
	public int timesPlayed() {
		return songPlays;
	}
*/
        public void resetSongPlays(){

          plays = 0;

        }

        public void setPlays(LocalDate firstPlay){

          this.firstPlay = firstPlay;
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
/*
	@Override
		public String toString() {
		return this.name;
	}
	
*/

}
