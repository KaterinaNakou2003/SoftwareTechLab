class Book {

	private String title;
	private String writer;
	private int yearPublished;
	private String summary;

	public Book(String title, String writer, int yearPublished, String summary) {
		this.title = title;
		this.writer = writer;
		this.summary = summary;
		this.yearPublished = yearPublished;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getYearPublished() {
		return yearPublished;
	}
	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}

}