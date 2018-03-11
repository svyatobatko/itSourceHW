package itSourceHW;

enum Bookbinding {SOFT, HARD}

public class Book {
	private long id;
	private String title;
	private String authors;
	private String publisher;
	private int yearOfPublication;
	private int numberOfPage;
	private Bookbinding bookbinding;

	public Book() { 
		super();
	}

	public Book(long id) {
		super(); 
		this.id = id;
	}

	public Book(long id, String title, String authors, String publisher,
			int yearOfPublication, int numberOfPage, Bookbinding bookbinding) {
		super();
		this.id = id;
		this.title = title;
		this.authors = authors;
		this.publisher = publisher;
		this.yearOfPublication = yearOfPublication;
		this.numberOfPage = numberOfPage;
		this.bookbinding = bookbinding;
	}

	public void setAllBookParametres(long id, String title, String authors, String publisher,
			int yearOfPublication, int numberOfPage, Bookbinding bookbinding) {
		this.id = id;
		this.title = title;
		this.authors = authors;
		this.publisher = publisher;
		this.yearOfPublication = yearOfPublication;
		this.numberOfPage = numberOfPage;
		this.bookbinding = bookbinding;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getYearOfPublication() {
		return yearOfPublication;
	}

	public void setYearOfPublication(int yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}

	public int getNumberOfPage() {
		return numberOfPage;
	}

	public void setNumberOfPage(int numberOfPage) {
		this.numberOfPage = numberOfPage;
	}

	public Bookbinding getBookbinding() {
		return bookbinding;
	}

	public void setBookbinding(Bookbinding bookbinding) {
		this.bookbinding = bookbinding;
	}

	public void printAllBookParametres() {
		String soft = "мягкий";
		String hard = "твердый";
		String bookbinding;
		
		if (this.bookbinding == Bookbinding.SOFT) {
			bookbinding = soft;
		} else {
			bookbinding = hard;
		}
		
		System.out.print("|");
		System.out.printf("%9s", this.id + "|");
		System.out.printf("%15s", this.title + "|");
		System.out.printf("%10s", this.authors + "|");
		System.out.printf("%13s", this.publisher + "|");
		System.out.printf("%12s", this.yearOfPublication + "|");
		System.out.printf("%15s", this.numberOfPage + "|");
		System.out.printf("%9s%n", bookbinding + "|");
	}

	public void compareWithAuthor (String inputAuthor) {
		if (inputAuthor.equals(this.getAuthors())) {
			printAllBookParametres();
		} 
	}

	public void compareWithPublisher (String inputPublisher) {
		if (inputPublisher.equals(this.getPublisher())) {
			printAllBookParametres();
		} 
	}

	public void compareWithYear (int inputYear) {
		if (inputYear <= this.getYearOfPublication()) {
			printAllBookParametres();
		} 
	}

}