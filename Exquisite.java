package library;

import java.util.Scanner;
/**
 * @author MaedehGhazanfari
 */
/**
 *This class represents books with exquisite genres.
 */
public class Exquisite extends Book {

    private String BookType;

    /**
     * The only constructor of class.
     * @param num unique number for each book.
     * @param name book's name.
     * @param w writer's name.
     * @param t writer's name.
     * @param p publisher.
     * @param pyear publisher.
     * @param Exquisite book's genre.
     * @param BT book type.
     */

    public Exquisite(int num, String name, String w, String t, String p, int pyear,String Exquisite, String BT)
    {
        super(num,name,w,t,p,pyear,Exquisite);
        setBookType(BT);

    }


    /**
     * setting book type.
     * @param BT
     */
    public void setBookType(String BT) {
        if(  BT.equals("Handwritten")  || BT.equals("Aromatic")
                || BT.equals("Leathery") || BT.equals("leathery") ||BT.equals("handwritten")||BT.equals("aromatic"))
        {this.BookType = BT;}

    }

    /**
     * get book type
     * @return it returns book type.
     */
    public String getBookType() {
        return this.BookType;
    }

    /**
     * method to edit book's information.
     * @param index book's index.
     * @param b
     * @param num book's callNumber.
     * @return
     */
    @Override
    public Book UpdateBook(int index, Book[] b, int num) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new book name");
        String Newname = scanner.nextLine();
        String name = Newname;
        System.out.println("Enter new writer");
        String Newwriter = scanner.nextLine();
        String w = Newwriter;
        String w1 = w.toUpperCase();
        System.out.println("Enter new translator");
        String Newtranslator = scanner.nextLine();
        String t = Newtranslator;
        System.out.println("Enter new publisher");
        String Newpublisher = scanner.nextLine();
        String p = Newpublisher;
        System.out.println("Enter new Publish year");
        int Newpublishyear = scanner.nextInt();
        int pyear = Newpublishyear;
        System.out.println("Enter new genre");
        scanner.nextLine();
        String NewGenre = scanner.nextLine();
        if(NewGenre.equals("Exquisite")||NewGenre.equals("ChildrenTeens")){
            System.out.println("New genre is not valid.");
            {
                String genre=NewGenre;
            }
        }

        return null;
    }


    public void ReadBook (){
        super.ReadBook();
        System.out.println("Book Type is:"+this.getBookType());
    }
    public void showPartInformation(){
        super.showPartInformation();
        System.out.println("Book Type is:"+this.getBookType());
    }
}


