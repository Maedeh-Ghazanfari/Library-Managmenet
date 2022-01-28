package library;

import java.util.Scanner;
/**
 * @author MaedehGhazanfari
 */
/**
 * This class represents books for children and teenagers.
 */
public class ChildrenTeens extends Book{
    private char AgeRated;

    /**
     * The only constructor of class.
     * @param num book's callNumber.
     * @param name book's name.
     * @param w writer's name.
     * @param t translator.
     * @param p publisher.
     * @param pyear publish year.
     * @param ChildrenTeens book's genre.
     * @param AR age rated.
     */
    public ChildrenTeens(int num, String name, String w, String t, String p, int pyear, String ChildrenTeens,char AR)
    {
        super(num, name, w, t, p, pyear, ChildrenTeens);
        setAgeRated(AR);
    }

    /**
     * setting AgeRated for books.
     * @param AR
     */
    public void setAgeRated(char AR) {
        if( AR == 'A' || AR == 'B' || AR =='C' || AR=='D' || AR =='E'||
                AR == 'a'|| AR=='b'||AR=='c'|| AR =='d'|| AR=='e')
            this.AgeRated = AR;
    }

    /**
     * get AgeRated.
     * @return it returns book's AgeRated.
     */
    public char getAgeRated() {
        return this.AgeRated;
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
        System.out.println("Enter new bookName");
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
        String NewGenre = scanner.nextLine();
        scanner.nextLine();
        if(NewGenre.equals("Exquisite")||NewGenre.equals("ChildrenTeens")){
            System.out.println("New genre is not valid.");
            {
                String genre=NewGenre;
            }
        }
        return null;
    }

    /**
     * show book's information.
     */
    public void ReadBook() {
        super.ReadBook();
        System.out.println("Age Rated is: "+this.getAgeRated());
    }
    public void ShowPartInformation(){
        super.showPartInformation();
        System.out.println("Age Rated is:" + this.getAgeRated());
    }
    }
