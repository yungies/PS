package sg.edu.rp.c364.id22037903.ps;

public class Song {
    private String title;
    private String singers;
    private int year;

    public Song(String title, String singers, int year) {
        this.title = title;
        this.singers = singers;
        this.year = year;
    }

    @Override
    public String toString() {
        return title + " - " + singers + " (" + year + ")";
    }
}
