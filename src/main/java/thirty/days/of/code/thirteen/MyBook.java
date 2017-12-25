package thirty.days.of.code.thirteen;

public class MyBook extends Book{

    int price;

    public MyBook(String title, String author, int price){
        super(title, author);
        this.price = price;
    }

    @Override
    public void display(){
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
}
