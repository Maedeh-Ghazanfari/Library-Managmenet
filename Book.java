package library;
import java.io.*;
import java.util.Scanner;
/**
 * @author MaedehGhazanfari
 */
/**
 * This class represents library's books.
 */
public class Book {
        protected String callnumber;
        private String bookname;
        private String writer;
        private String translator;
        private String publisher;
        private int publishyear;
        private String genre;
    /**
     * check if book is available to borrow or not.
     */
    private Boolean exist=true;

    public member[] borrowed = new member[50];
    /**
     * The only constructor of class for books.
     * @param number unique number for each book.
     * @param name book's name.
     * @param w writer's name.
     * @param t translator's name.
     * @param p publisher.
     * @param pyear publishYear.
     * @param genre book's genre.
     */
        public  Book(int number, String name , String w , String t , String p , int pyear , String genre)
        {
            setbookname(name);
            setwriter(w);
            setTranslator(t);
            setPublisher(p);
            setPublishyear(pyear);
            setGenre(genre);
            setcallnumber(number);}

    public member MemberBorrowed[] = new member[50];

    /**
     * setting callnumber.
     * @param num
     */
        public void setcallnumber(int num){
            String number =String.valueOf(num);
            String W = getWriter().toUpperCase();
            String callnum= number+"/"+ library.Main.getFirstLetters(W)+"/"+String.valueOf(getPublishyear()).substring(2);
            this.callnumber = callnum;
        }

    /**
     * get book's callNumber.
     * @return it returns book's callNumber.
     */
    public  String getcallnumber(){
            return this.callnumber;
        }

    /**
     * setting book's name.
     * @param name
     */
    public void setbookname(String name){
            this.bookname = name;
        }

    /**
     * get book's name.
     * @return it returns book's name.
     */
        public String getBookname() {
            return this.bookname;
        }

    /**
     * setting writer's name.
     * @param w
     */
        public void setwriter(String w){
            this.writer = w;
        }

    /**
     * get writer's name.
     * @return it returns writer's name.
     */
        public String getWriter() {
            return this.writer;
        }

    /**
     * setting translator's name.
     * @param t
     */
        public void setTranslator(String t) {
            this.translator = t;
        }

    /**
     * get translator's name.
     * @return it returns translator's name.
     */
        public String getTranslator() {
            return this.translator;
        }

    /**
     * setting book's publisher.
     * @param p
     */
        public void setPublisher(String p) {
            this.publisher = p;
        }

    /**
     * get book's publisher.
     * @return it returns book's publisher.
     */
        public String getPublisher() {
            return this.publisher;
        }

    /**
     * setting publish year.
     * @param pyear
     */
        public void setPublishyear(int pyear) {
            this.publishyear = pyear;
        }

    /**
     * get book's publish year.
     * @return it returns book's publish year.
     */
        public int getPublishyear() {
            return this.publishyear;
        }

    /**
     * setting book's existence.
     * @param exist
     */
        public void setExist(boolean exist) {
            this.exist = exist;
        }

    /**
     * get book existence.
     * @return it returns if book exist or not.
     */
    public boolean getexist(){
            return this.exist;
        }

    /**
     * setting book's genre.
     * @param genre
     */
    public void setGenre(String genre) {
            this.genre = genre;
        }

    /**
     * get book's genre.
     * @return it returns book's genre.
     */
    public String getGenre(){
            return this.genre;
        }

    /**
     * method to edit book's information.
     * @param index book's index.
     * @param b
     * @param num book's callNumber.
     * @return
     */
        public Book UpdateBook(int index, Book[] b, int num) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter new bookname");
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
            System.out.println("Enter new Genre");
            scanner.nextLine();
            String NewGenre = scanner.nextLine();
            if(NewGenre.equals("Exquisite")||NewGenre.equals("ChildrenTeens")){
                System.out.println("New genre is not valid.");
                {
                    genre=NewGenre;
                }
            }
            String str =callnumber.substring(0,4);
            System.out.println("call number is:"+str+"/"+library.Main.getFirstLetters(w1)+"/"
                    +String.valueOf(pyear).substring(2));
            Book temp;
            temp = new Book(num, name, w, t, p, pyear, genre);
            return temp;

        }


    /**
     * method to delete book's information.
     * @param index book's index.
     * @param b
     * @return
     */
        public  Book[]  deletebook( int index ,Book[]b){
            b[index] = null;
            int i=index+1;
            while(b[i]!=null){
                b[i-1] = b[i];
                i++;}
            b[i-1] = null;
            return b;
        }

    /**
     *show book's information.
     */
        public void ReadBook (){
            System.out.println("CallNumber is:"+getcallnumber());
            System.out.println("Book name is:"+ getBookname());
            System.out.println("writer is:"+ getWriter());
            System.out.println("translator is:"+getTranslator());
            System.out.println("publisher is:"+getPublisher());
            System.out.println("Publish year is:"+getPublishyear());
            System.out.println("Genre is:" +getGenre());
    }

    /**
     *Method to show information with limited information.
     */

    public void showPartInformation(){
        System.out.println("Book name is: " + this.getBookname());
        System.out.println("Writer is: " + this.getWriter());
        System.out.println("Translator is: " + this.getTranslator());
        System.out.println("Publisher is: " + this.getPublisher());
        System.out.println("Publish Year is: " + this.getPublishyear());
        System.out.println("Genre is: " + this.getGenre());
    }

    public boolean AddMembersToBorrowed(member member){
        for(int i=0; i<50; i++){
            if(MemberBorrowed[i]==null){
                MemberBorrowed[i] = member;
                {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean  BorrowedName(){
    for(int i=0; i<borrowed.length; i++){
        System.out.println("Member's Name:" +borrowed[i].getFirstName()+" "+borrowed[i].getLastName());
    }
    {
    return true;}
    }
}





