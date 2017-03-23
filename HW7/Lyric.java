import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Lyric {
	private String titleInfo;
	private String albumInfo;
	private String singerInfo;
	private ArrayList<Double> timeList = new ArrayList<>();
	private ArrayList<String> wordsList = new ArrayList<>();
	private File source = new File("");
	public Lyric(File source){
		this.source = source;
	}
	
	//Parses the songs information and sets the titleInfo, albumInfo, singerInfo variables
	private void parseInfo(Scanner input){
		String tempString;
		while(input.hasNextLine()){
			tempString = input.nextLine();
			if(tempString.contains("[ar:") || tempString.contains("[al:") || tempString.contains("[ti:")){
				tempString = tempString.substring(1, tempString.length()-1);
				if(tempString.contains("ar:")){
					this.singerInfo = tempString.substring(tempString.indexOf(':')+1);
					if(this.singerInfo.charAt(0) == ' '){
						this.singerInfo = this.singerInfo.substring(1);
					}
				}
				else if(tempString.contains("al:")){
					this.albumInfo = tempString.substring(tempString.indexOf(':')+1);
					if(this.albumInfo.charAt(0) == ' '){
						this.albumInfo = this.albumInfo.substring(1);
					}
				}
				else if(tempString.contains("ti:")){
					this.titleInfo = tempString.substring(tempString.indexOf(':')+1);
					if(this.titleInfo.charAt(0) == ' '){
						this.titleInfo = this.titleInfo.substring(1);
					}
				}
			}
		}
	}
	
	//Parses the lyrics and fills ArrayLists with the lyrics and their respective times
	private void parseLyrics(Scanner input){
		String tempString;
		while(input.hasNextLine()){
			tempString = input.nextLine();
			if(!(tempString.contains("[ar:") || tempString.contains("[al:") || tempString.contains("[ti:")) && !tempString.isEmpty()){
				tempString = tempString.substring(1) + " ";
				String[] parts = tempString.split("]");
				int timeMin = Integer.parseInt(parts[0].substring(0, parts[0].indexOf(':')));
				double timeSec = Double.parseDouble(parts[0].substring(parts[0].indexOf(':')+1));
				timeSec = timeSec + (timeMin*60);
				timeList.add(timeSec);
				wordsList.add(parts[1]);
			}
		}
	}
	
	//Retrieve artist name
	public String getArtist() throws FileNotFoundException{
		this.parseInfo(new Scanner(source));
		return singerInfo;
	}
	
	//Retrieve album name
	public String getAlbum() throws FileNotFoundException{
		this.parseInfo(new Scanner(source));
		return albumInfo;
	}
	
	//Retrieve title name
	public String getTitle() throws FileNotFoundException{
		this.parseInfo(new Scanner(source));
		return titleInfo;
	}
	
	//Retrieve times and lyrics for specific song lines
	public String getLine(int line) throws FileNotFoundException{
		this.parseLyrics(new Scanner(source));
		String lyricLine = "" + timeList.get(line-1) + " seconds - " + wordsList.get(line-1);
		return lyricLine;
	}
	
	//Retrieve the time for a specific song line
	public double getTime(int line) throws FileNotFoundException{
		this.parseLyrics(new Scanner(source));
		return timeList.get(line-1);
	}
	
	//Retrieve the lyrics for a specific song line
	public String getLineLyrics(int line) throws FileNotFoundException{
		this.parseLyrics(new Scanner(source));
		return wordsList.get(line-1);
	}
	
	//Retrieve the lyrics at a certain time in seconds
	public String getLineAtTime(double seconds) throws FileNotFoundException{
		this.parseLyrics(new Scanner(source));
		int counter = 1;
		while(!(seconds>=this.getTime(counter) && seconds<this.getTime(counter+1))){
			counter++;
		}
		return this.getLineLyrics(counter);
	}
}
