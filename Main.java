package library;
/**
 * @author MaedehGhazanfari
 */
import java.io.*;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class contains main activities in library.
 * This class has the main menu of library.
 * Methods of this class are:create members and books,search for them,borrow and return back books.
 */
public class Main {


    /**
     * Main method contains the menu.
     * @param args
     */
    public static void main(String[] args) throws IOException {
        /**
         * Make an array for members and books.
         * declare member's and book's counter.
         */
        member[] m = new member[50];
        int counter = 0;
        long membershipcode = 1000003;
        Book[] b = new Book[100];
        int count = 0;
        int number = 1003;
        ChildrenTeens[] childrenTeens = new ChildrenTeens[50];
        int childrenTeensCounter = 0;
        Scanner scanner = new Scanner(System.in);

        member m1= new member(1000001,"First","Member",19,'F',"4587459");
        member m2 = new member(1000002,"Second","Member",20,'M',"55556985");
        member m3 = new member(1000003,"Third","Member",19,'M',"45879658");

        m[0]=m1;
        m[1]=m2;
        m[2]=m3;


        Book b1 = new Book(1001,"Book1","Writer","Translator1","Publisher1",1400,"History") ;
        Book b2 = new Book(1002,"Book2","Writer2","Translator2","Publisher2",1400,"Novel");
        Book b3 = new Book(1003,"Book3","Writer3","Translator3","Publisher3",1400,"Poetry");

        b[0]=b1;
        b[1]=b2;
        b[2]=b3;

        /**
         * library menu.
         */
        int press = 100;
        while (press != -1) {
            System.out.println("------------------------");
            System.out.println("(1:Create a new member)");
            System.out.println("(2:Read members information)");
            System.out.println("(3:Update members information)");
            System.out.println("(4:Delete members information)");
            System.out.println("(5:Search members index)");
            System.out.println("(6:Create a new book)");
            System.out.println("(7:Read books information)");
            System.out.println("(8:Update books information)");
            System.out.println("(9:Delete books information)");
            System.out.println("(10:Search books index)");
            System.out.println("(11:search with part of books name)");
            System.out.println("(12:Borrow book)");
            System.out.println("(13:borrow children and teens book)");
            System.out.println("(14:List of members that borrowed specific book)");
            System.out.println("(15:Give back book)");
            System.out.println("(-1:Exist the menu)");
            System.out.println("(press the one you want)");
            System.out.println("------------------------");
            press = scanner.nextInt();
            switch (press){
            case(1):
                    membershipcode++;
                    counter=3;

                    try{
                    member member = create(membershipcode);
                    m[counter] = member;
                    counter++;}
                    catch (Exception e) {
                        e.printStackTrace();
                    }

                    File file = new File("Members.txt");
                    try{
                        FileWriter fileWriter = new FileWriter(file, true);
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                        PrintWriter printWriter = new PrintWriter(bufferedWriter);


                        if(file.exists() == false)
                        {
                            file.createNewFile();
                            System.out.println("The file has been created!");
                        }
                        {
                            System.out.println("File is already exists!");
                        }
                        for(int i=0; i<m.length ;i++)
                        if(m[i]!= null){
                        printWriter.println("FirstName:  "+m[i].getFirstName());
                        printWriter.println("LastName:  "+m[i].getLastName());
                        printWriter.println("Age:  "+m[i].getAge());
                        printWriter.println("Gender:  "+m[i].getGender());
                        printWriter.println("PhoneNumber:  "+m[i].getPhonenumber());
                        printWriter.println("MemberShip code:  "+m[i].getmembershipcode());
                        printWriter.println("**************");}
                        printWriter.close();
                        printWriter.flush();}
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("your membership code is:" + membershipcode);
                    break;

                case (2):

                    System.out.println("what membership you want to check its information?");
                    try{
                    long code = scanner.nextLong();
                    int indx = search(code, m);
                    System.out.println("MemberShip information:");
                    m[indx].read(indx, m);}
                    catch(Exception e)
                    {
                        System.out.println("Something went wrong!Try again.");}

                    break;

                case (3):
                    System.out.println("what membership you want to edit its information?");
                    try{
                    long Membershipcodes = scanner.nextLong();
                    int iindex = search(Membershipcodes, m);
                    m[iindex].update();}
                    catch(Exception e)
                    {
                        System.out.println("Something went wrong!Try again.");}

                    File file2 = new File("Members.txt");
                    try{
                        FileWriter fileWriter = new FileWriter(file2, true);
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                        PrintWriter printWriter = new PrintWriter(bufferedWriter);


                        if(file2.exists() == false)
                        {
                            file2.createNewFile();
                            System.out.println("The file has been created!");
                        }
                        {
                            System.out.println("File is already exists!");
                        }
                        for(int i=0; i<m.length ;i++)
                            if(m[i]!= null){
                                printWriter.println("FirstName:  "+m[i].getFirstName());
                                printWriter.println("LastName:  "+m[i].getLastName());
                                printWriter.println("Age:  "+m[i].getAge());
                                printWriter.println("Gender:  "+m[i].getGender());
                                printWriter.println("PhoneNumber:  "+m[i].getPhonenumber());
                                printWriter.println("MemberShip code:  "+m[i].getmembershipcode());
                                printWriter.println("**************");}
                        printWriter.close();
                        printWriter.flush();}
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case (4):
                    System.out.println("what membership you want to delete its information?");
                    try{
                    long codes = scanner.nextLong();
                    int indexs = search(codes, m);
                    m[indexs].delete(indexs, m);
                    counter--;}
                    catch(Exception e){
                        System.out.println("Something went wrong!Try again.");
                    }
                    File file3 = new File("Members.txt");
                    try{
                        FileWriter fileWriter = new FileWriter(file3, true);
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                        PrintWriter printWriter = new PrintWriter(bufferedWriter);


                        if(file3.exists() == false)
                        {
                            file3.createNewFile();
                            System.out.println("The file has been created!");
                        }
                        {
                            System.out.println("File is already exists!");
                        }
                        for(int i=0; i<m.length ;i++)
                            if(m[i]!= null){
                                printWriter.println("FirstName:  "+m[i].getFirstName());
                                printWriter.println("LastName:  "+m[i].getLastName());
                                printWriter.println("Age:  "+m[i].getAge());
                                printWriter.println("Gender:  "+m[i].getGender());
                                printWriter.println("PhoneNumber:  "+m[i].getPhonenumber());
                                printWriter.println("MemberShip code:  "+m[i].getmembershipcode());
                                printWriter.println("**************");}
                        printWriter.close();
                        printWriter.flush();}
                    catch (Exception e) {
                        e.printStackTrace();
                    }

                    break;

                case (5):
                    System.out.println("what MemberShip code you want to check its index?");
                    long Membershipcode = scanner.nextLong();
                    int index = search(Membershipcode, m);
                    System.out.println("the index is:" + index);
                    break;

                case (6):

                    count =3;
                    number++;

                    try{
                    Book book = createbook(number);
                    b[count] = book;
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }

                    File File = new File("Books.txt");

                    try {
                        FileWriter fileWriter = new FileWriter(File, true);


                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                        PrintWriter printWriter = new PrintWriter(bufferedWriter);


                        if (File.exists() == false) {

                            File.createNewFile();

                            System.out.println("The file has been created!");
                        }
                        {
                            System.out.println("File is already exists!");
                        }
                        for(int j = 0; j<b.length; j++)
                            if(b[j]!= null){
                        printWriter.println("CallNumber:  "+b[j].getcallnumber());
                        printWriter.println("BookName:  "+b[j].getBookname());
                        printWriter.println("Writer is:  "+b[j].getWriter());
                        printWriter.println("Translator:  "+b[j].getTranslator());
                        printWriter.println("Publisher:  "+b[j].getPublisher());
                        printWriter.println("PublishYear:  "+b[j].getPublishyear());
                        printWriter.println("Genre:  "+b[j].getGenre());
                        printWriter.println("************");}
                        printWriter.flush();
                        printWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    String c = b[count].getcallnumber();
                    System.out.println("call number is:" + c);
                    count++;
                    break;

                case (7):
                    System.out.println("what book you want to check its information?Enter CallNumber!");
                    scanner.nextLine();
                    try{
                    String calls = scanner.nextLine();
                    String calls1 = calls.toUpperCase();
                    int i = searchbook(calls1, b);
                    System.out.println("book information:");
                    b[i].ReadBook();}
                    catch(Exception e){
                        System.out.println("Something went wrong!Try again.");
                    }

                    break;
                case (8):
                    System.out.println("what book you want to update its information?Enter CallNumber!");
                    scanner.nextLine();
                    try{
                    String cc = scanner.nextLine();
                    String c1 = cc.toUpperCase();
                    int index1 = searchbook(c1, b);
                    b[index1].UpdateBook(index1, b, number);}
                    catch(Exception e){
                        System.out.println("Something went wrong!Try again.");
                    }

                    File File2= new File("Books.txt");

                    try {
                        FileWriter fileWriter = new FileWriter(File2, true);


                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                        PrintWriter printWriter = new PrintWriter(bufferedWriter);


                        if (File2.exists() == false) {

                            File2.createNewFile();

                            System.out.println("The file has been created!");
                        }
                        {
                            System.out.println("File is already exists!");
                        }
                        for(int j = 0; j<b.length; j++)
                            if(b[j]!= null){
                                printWriter.println("CallNumber:  "+b[j].getcallnumber());
                                printWriter.println("BookName:  "+b[j].getBookname());
                                printWriter.println("Writer is:  "+b[j].getWriter());
                                printWriter.println("Translator:  "+b[j].getTranslator());
                                printWriter.println("Publisher:  "+b[j].getPublisher());
                                printWriter.println("PublishYear:  "+b[j].getPublishyear());
                                printWriter.println("Genre:  "+b[j].getGenre());
                                printWriter.println("************");}
                                printWriter.flush();
                                printWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    break;
                case (9):
                    System.out.println("what book you want to delete its information?Enter CallNumber!");
                    scanner.nextLine();
                    try{
                    String callnum = scanner.nextLine();
                    String callnum1 = callnum.toUpperCase();
                    int ind = searchbook(callnum1, b);
                    b[ind].deletebook(ind, b);
                    count--;}
                    catch(Exception e){
                        System.out.println("Something went wrong!Try again.");
                    }

                    File File3 = new File("Books.txt");

                    try {
                        FileWriter fileWriter = new FileWriter(File3, true);


                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                        PrintWriter printWriter = new PrintWriter(bufferedWriter);


                        if (File3.exists() == false) {

                            File3.createNewFile();

                            System.out.println("The file has been created!");
                        }
                        {
                            System.out.println("File is already exists!");
                        }
                        for(int j = 0; j<b.length; j++)
                            if(b[j]!= null){
                                printWriter.println("CallNumber:  "+b[j].getcallnumber());
                                printWriter.println("BookName:  "+b[j].getBookname());
                                printWriter.println("Writer is:  "+b[j].getWriter());
                                printWriter.println("Translator:  "+b[j].getTranslator());
                                printWriter.println("Publisher:  "+b[j].getPublisher());
                                printWriter.println("PublishYear:  "+b[j].getPublishyear());
                                printWriter.println("Genre:  "+b[j].getGenre());
                                printWriter.println("************");}
                                printWriter.flush();
                                printWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    break;

                case (10):
                    System.out.println("what book you want to check its index?Enter CallNumber!");
                    scanner.nextLine();
                    String calln = scanner.nextLine();
                    String calln1 = calln.toUpperCase();
                    int in = searchbook(calln1, b);
                    System.out.println("the index is:" + in);
                    break;
                case (11):
                    System.out.println("Enter name of the book or the part of the book you want");
                    scanner.nextLine();
                    try{
                    String name2 = scanner.nextLine();
                    searchpart(name2, b, count);}
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case (12):
                    System.out.println("Enter your MemberShipCode!");
                    scanner.nextLine();
                    long members = scanner.nextLong();
                    int iindex1 = search(members, m);
                    if (iindex1 == -1) {
                        System.out.println("This MemberShipCode dose not exist! ");
                        break;
                    }
                {
                    System.out.println("Enter book CallNumber!");
                    scanner.nextLine();
                    String call1 = scanner.nextLine();
                    String call2 = call1.toUpperCase();
                    int ind1 = searchbook(call2, b);
                    if (ind1 == -1) {
                        System.out.println("This book dose not exist!");
                    }
                    {
                        {
                            if (b[ind1].getGenre().equals("Exquisite")) {
                                System.out.println("Forbidden to borrow book with this genre!");
                            }
                            {
                                if (b[ind1].getexist() == true) {
                                    m[iindex1].getbook(b[ind1]);
                                    if (m[iindex1].getbook(b[ind1]) == true) {
                                        b[ind1].setExist(false);
                                    }
                                  b[ind1].AddMembersToBorrowed(m[iindex1]);
                                } else {
                                    System.out.println("sorry!This book is not available right now!");
                                }
                            }
                        }
                    }
                }
                break;
                case (13):
                    ChildBorrow(childrenTeens, m, childrenTeensCounter, counter);
                    break;
                case (14):
                    System.out.println("Enter your MemberShipCode!");
                    scanner.nextLine();
                    long memberscode = scanner.nextLong();
                    int iindex2 = search(memberscode, m);
                    if (iindex2 == -1) {
                        System.out.println("This MemberShipCode dose not exist!");
                    }
                {
                    System.out.println("Enter book CallNumber!");
                    scanner.nextLine();
                    String call1 = scanner.nextLine();
                    String call2 = call1.toUpperCase();
                    int ind2 = searchbook(call2, b);
                    if (ind2 == -1) {
                        System.out.println("This book dose not exist!");
                    }
                    {
                        if (b[ind2].getexist() == false) {
                            m[iindex2].giveback(b[ind2]);
                            {
                                if (m[iindex2].giveback(b[ind2]) == true) {
                                    b[ind2].setExist(true);
                                }
                            }
                        }
                    }
                }
                break;
                case(15):
                    System.out.println("Enter  book's CallNumber");
                    Scanner Scanner = new Scanner(System.in);
                    String BookCall =scanner.nextLine();
                    b[searchbook(BookCall,b)].BorrowedName();
            }
        }
    }

    /**
     * create a new member.
     * @param m
     * @return it returns the new member.
     */
    public static member create(long m) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your first name");
        String FN = scanner.nextLine();
        System.out.println("enter your last name");
        String LN = scanner.nextLine();
        System.out.println("enter your age");
        short A = scanner.nextShort();
            System.out.println("enter your gender by F or M");
            char G = scanner.next().charAt(0);
            System.out.println("enter your phone number");
            scanner.nextLine();
            String phon = scanner.nextLine();
            member member = null;
            try {
                member = new member(m, FN, LN, A, G, phon);


            } catch (IOException e) {
                e.printStackTrace();
            }
            return member;

    }

    /**
     * Create a new book.
     *
     * @param num
     */
    public static Book createbook(int num) {
        Scanner Scanner = new Scanner(System.in);
        System.out.println("Enter  Book Name");
        String name = Scanner.nextLine();
        System.out.println("Enter writer name");
        String w = Scanner.nextLine();
        System.out.println("Enter translator name");
        String t = Scanner.nextLine();
        System.out.println("Enter the publisher");
        String p = Scanner.nextLine();
        System.out.println("Enter the publish year");
        int pyear = Scanner.nextInt();
        System.out.println("Enter the Genre");
        Scanner.nextLine();
        String genre = Scanner.nextLine();
        Book temp ;
        if (genre.equals("Exquisite")) {
            System.out.println("Enter book type:\nHandwritten\nAromatic\nLeathery");
            String BT = Scanner.nextLine();
            temp= new Exquisite(num, name, w, t, p, pyear, genre, BT);
        } else if (genre.equals(("ChildrenTeens"))) {
            System.out.println("Enter Age Rate");
            System.out.println("A:age<6\nB:age=6-7\nC:age=8-9\nD:age=10-11\nE:age=12-15");
            char AR = Scanner.next().charAt(0);
            temp = new ChildrenTeens(num, name, w, t, p, pyear, genre, AR);
        } else {
            temp = new Book(num, name, w, t, p, pyear, genre);
        }
        return temp;
    }

    /**
     * This method search for book with limited information and print the full information.
     * @param name The input name which can be full name or just part of that.
     * @param book array of our existence books.
     * @param c
     */
    public static void searchpart(String name, Book[] book, int c) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("This is the list of books with your input information:");
        for (int i = 0; i < c; i++) {
            if (book[i].getBookname().contains(name)) {
                System.out.println("Bookname is:" + book[i].getBookname());
                System.out.println("Writer is:" + book[i].getWriter());
                System.out.println("Translator is:" + book[i].getTranslator());
                System.out.println("publisher is:" + book[i].getPublisher());
                System.out.println("Publishyear is:" + book[i].getPublishyear());
                System.out.println("Index of book is:" + i);
                System.out.println("******************");
            }
        }
        System.out.println("Enter index of the book you want to get CallNumber!");
        int j = scanner.nextInt();
        System.out.println("This is the CallNumber you want:" + book[j].getcallnumber());

    }

    /**
     * Search for member's index in member's array.
     * @param Code MemberShip code.
     * @param m    Array of our existence members.
     * @return It returns the index of member we search for.
     */
    public static int search(Long Code, member[] m) {
        for (int i = 0; i < 15; i++) {
            if (m[i] != null) {
                if (Code.equals(m[i].getmembershipcode())) {

                    return i;
                }
            }
        }

        return -1;

    }

    /**
     * search for book's index in book's array.
     * @param number Book's CallNumber.
     * @param b  Array of our existence books.
     * @return It returns the index of book we want.
     */
    public static int searchbook(String number, Book[] b) {
        for (int i = 0; i < 100; i++) {
            if (b[i] != null) {
                if (number.equals(b[i].getcallnumber())) {

                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Get first letter of each word for callNumber.
     * @param text our chosen word.
     * @return It returns first letters.
     */
    public static String getFirstLetters(String text) {
        String firstLetters = "";
        text = text.replaceAll("[.,]", "");
        for (String s : text.split(" ")) {
            firstLetters += s.charAt(0);
        }
        return firstLetters;
    }

    /**
     * Books to borrow for children and teenagers.
     * @param b
     * @param m
     * @param ChildrenTeensCounter
     * @param memberCounter
     */
    public static void ChildBorrow(ChildrenTeens[] b, member[] m, int ChildrenTeensCounter, int memberCounter) {
        Scanner scanner = new Scanner(System.in);
        ChildrenTeens[] temp = new ChildrenTeens[50];
        int num=1;
        System.out.println("enter your memberShip code");
        long membership = scanner.nextLong();
        int iindex1 = search(membership, m);
        if (iindex1 == -1) {
            System.out.println("This MemberShipCode dose not exist! ");
        } else {
            int age = m[iindex1].getAge();
            char agerated = 'M';
            if (age < 15) {
                if (age < 6) {
                 agerated = 'A';
                } else if (age < 8) {
                    agerated = 'B';
                }   else if (age < 10) {
                    agerated = 'C';
                }else if(age < 12) {
                    agerated = 'D';
                }
                {
                    agerated = 'E';
                }
                for (int i = 0; i < ChildrenTeensCounter; i++) {
                    if (b[i].getAgeRated() == agerated) {
                        System.out.println(num+"/");
                        b[i].showPartInformation();
                        System.out.println("*********");
                        num++;
                    }
                }
                System.out.print("Enter the Number ");
                int n = scanner.nextInt();
                scanner.nextLine();
                if(b[n-1].getexist()==true) {
                    boolean check = m[iindex1].getbook(b[n-1]);
                    if(check==true) {
                        b[n-1].setExist(false);
                    } else {
                        System.out.println("You can't borrow more book!");
                    }
                } else {
                    System.out.println("The Book is not available right now!");
                }

            } else {
                System.out.println("You can't borrow book with this genre!");
            }
        }
        {
            System.out.println("Your Membership code is Wrong!");
        }
            }
        }

