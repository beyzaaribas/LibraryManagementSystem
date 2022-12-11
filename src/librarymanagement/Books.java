package librarymanagement;

public class Books {
    private int id;
    private String book_name;
    private String author_name;
    private String type;
    private String book_page_count;
    private String book_publishing_year;
    private String book_publishing_house;
    private String number_of_books;

    public Books(int id, String book_name,String author_name,String type,String book_page_count,String book_publishing_year,String book_publishing_house, String number_of_books)
    {
        this.id = id;
        this.book_name = book_name;
        this.author_name = author_name;
        this.type = type;
        this.book_page_count = book_page_count;
        this.book_publishing_year = book_publishing_year;
        this.book_publishing_house = book_publishing_house;
        this.number_of_books = number_of_books;
    }


    public int getId(){return id;}
    public void setId(int id) { this.id = id;}

    public String getBook_name(){return book_name;}
    public void setBook_name(){this.book_name = book_name;}

    public String getAuthor_name(){return author_name;}
    public void setAuthor_name(){this.author_name = author_name;}

    public String getType(){return type;}
    public void setType(){this.type = type;}

    public String getBook_page_count(){return book_page_count;}
    public void setBook_page_count(){this.book_page_count = book_page_count;}

    public String getBook_publishing_year(){return book_publishing_year;}
    public void setBook_publishing_year(){this.book_publishing_year = book_publishing_year;}

    public String getBook_publishing_house(){return book_publishing_house;}
    public void setBook_publishing_house(){this.book_publishing_house = book_publishing_house;}

    public String getNumber_of_books(){return number_of_books;}
    public void setNumber_of_books(){this.number_of_books = number_of_books;}

}
