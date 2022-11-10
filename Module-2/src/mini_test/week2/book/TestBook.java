package mini_test.week2.book;

public class TestBook {
    public static void main(String[] args) {
        Book book1 = new ProgrammingBook("PR01","Head First Java",100,"Micheal A","Java","FW1");
        Book book2 = new ProgrammingBook("PR02","Introduction to Java Programming",70,"Micheal B","Java","FW2");
        Book book3 = new ProgrammingBook("PR03","Head First Python",50,"Micheal C","Python","FW3");
        Book book4 = new ProgrammingBook("PR04","Javascript the definition",80,"Micheal D","Javascript","FW4");
        Book book5 = new ProgrammingBook("PR05","Effective C",120,"Micheal E","C","FW5");
        Book book6 = new FictionBook("F01", "Name 1", 80, "Thomas A", "Fiction 1");
        Book book7 = new FictionBook("F02", "Name 2", 110, "Thomas B", "Fiction 1");
        Book book8 = new FictionBook("F03", "Name 3", 90, "Thomas C", "Fiction 2");
        Book book9 = new FictionBook("F04", "Name 4", 70, "Thomas D", "Fiction 2");
        Book book10 = new FictionBook("F05", "Name 5", 120, "Thomas E", "Fiction 1");
        Book[] books = {book1, book2, book3, book4, book5, book6, book7, book8, book9, book10};
        int sumPrice = 0;
        for (Book book : books) {
            sumPrice += book.getPrice();
        }
        System.out.println("Sum price is: " + sumPrice);
        int countJava = 0;
        for (Book book : books) {
            if (book instanceof ProgrammingBook) {
                if (((ProgrammingBook) book).getLanguage().equals("Java")) {
                    countJava++;
                }
            }
        }
        System.out.println("There are " + countJava + " programming book language of Java");
        int countFiction1 = 0;
        for (Book book : books) {
            if (book instanceof FictionBook) {
                if (((FictionBook) book).getCategory().equals("Fiction 1")) {
                    countFiction1++;
                }
            }
        }
        System.out.println("There are " + countFiction1 + " Fiction book category of Fiction 1");
        int countPrice = 0;
        for (Book book : books) {
            if (book.getPrice() < 100) {
                countPrice++;
            }
        }
        System.out.println("There are " + countPrice + " book has price less than 100");
    }
}
