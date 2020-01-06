public class MP3 {

  String artist;
  String songTitle;
  double duration;
  int bitRate;

  public MP3() {
    artist = "La Salle Choir";
    songTitle = "Somewhere Over the Rainbow";
    duration = 2.5;
    bitRate = 128;
  }

  public MP3(String art, String title, double dur, int rate) {
    artist = art;
    songTitle = title;
    duration = dur;
    bitRate = rate;
  }

  public String toString() {
    return songTitle + " by " + artist + ": " + duration + " minutes at " + bitRate + " bps";
  }

}
