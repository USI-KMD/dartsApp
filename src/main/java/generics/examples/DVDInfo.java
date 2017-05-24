package generics.examples;

class DVDInfo implements Comparable<DVDInfo> {
	String title;
	String genre;
	String leadActor;

	DVDInfo(String t, String g, String a) {
		title = t;
		genre = g;
		leadActor = a;
	}

	public String toString() {
		return title + " " + genre + " " + leadActor + "\n";
	}

	public int compareTo(DVDInfo d) {
//	TODO: Make it real
		return -1;
	}

	//TODO: Create some hashcode and equals
	
	public String getTitle() {
		return title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getLeadActor() {
		return leadActor;
	}

	public void setLeadActor(String leadActor) {
		this.leadActor = leadActor;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
