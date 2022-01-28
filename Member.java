package library;
import java.io.*;
import java.util.Scanner;

/**
 * @author MaedehGhazanfari
 */
/**
 * This class represents library's member.
 */
class member {

    private long membershipcode;
    private String FirstName;
    private String LastName;
    private int Age;
    private char Gender;
    private String Phonenumber;

    /**
     * The only constructor of class for members.
     * @param FN   FirstName of members.
     * @param LN   LastName of members.
     * @param A    Member's age.
     * @param G    Member's gender.
     * @param Phon Member's phone number.
     */

    public member(long m,String FN, String LN, int A, char G, String Phon) throws IOException {
        setmembershipcode(m);
        setFirstName(FN);
        setLastName(LN);
        setAge(A);
        setGender(G);
        setPhonenumber(Phon);

    }

    public Book borrow[] = new Book[5];
    /**
     * Setting MemberShip codes.
     * @param m
     */
    public void setmembershipcode(long m) {
        this.membershipcode = m;
    }

    /**
     * Get MemberShip codes.
     * @return It returns MemberShip codes.
     */
    public long getmembershipcode() {
        return this.membershipcode;
    }

    /**
     * Setting first name.
     * @param FN
     */
    public void setFirstName(String FN) {
        this.FirstName = FN;
    }

    /**
     * Get first name.
     * @return It returns member's first name.
     */
    public String getFirstName() {
        return this.FirstName;
    }

    /**
     * setting last name.
     * @param LN
     */
    public void setLastName(String LN) {
        this.LastName = LN;
    }

    /**
     * get last name.
     * @return it returns member's last name.
     */
    public String getLastName() {
        return this.LastName;
    }

    /**
     * setting memeber's age.
     * @param A
     */
    public void setAge(int A) {
try{
        this.Age = A;}
catch (Exception e){
    e.printStackTrace();
}
    }

    /**
     * get member's age.
     * @return it returns member's age.
     */
    public int getAge() {
        return this.Age;
    }

    /**
     * setting member's gender only with f or m.
     * @param G
     */
    public void setGender(char G) {
        if (G == 'M' || G == 'F' || G == 'm' || G == 'M')
            this.Gender = G;
    }

    /**
     * get member's gender.
     * @return it returns member's gender.
     */
    public char getGender() {
        return Gender;
    }

    /**
     * setting member's phone number.
     * @param phon
     */
    public void setPhonenumber(String phon) {
        this.Phonenumber = phon;
    }

    /**
     * get member's phone number.
     * @return it returns member's phone number.
     */
    public String getPhonenumber() {
        return Phonenumber;
    }

    /**
     * method to update member's information.
     */
    public void update()  {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new FirstName");
        setFirstName(scanner.nextLine());
        System.out.println("Enter new LastName");
        setLastName(scanner.nextLine());
        System.out.println("Enter new Age");
        setAge(scanner.nextInt());
        System.out.println("Enter new Gender");
        setGender(scanner.next().charAt(0));
        System.out.println("Enter new PhoneNumber");
        scanner.nextLine();
        setPhonenumber(scanner.nextLine());
    }

    /**
     * method to show member's information.
     * @param index index of member in array.
     * @param m     member array.
     */
    void read(int index, member[] m) {
        System.out.println("FirstName is:" + m[index].getFirstName());
        System.out.println("LastName is:" + m[index].getLastName());
        System.out.println("Age is:" +m[index].getAge());
        System.out.println("Gender is:" +m[index].getGender());
        System.out.println("PhoneNumber is:" + m[index].getPhonenumber());
        return;
    }

    /**
     * method to delete member's information.
     * @param indexs index of member in array.
     * @param m      member array.
     * @return
     */
    public member[] delete(int indexs, member[] m) {
        m[indexs] = null;
        int i = indexs + 1;
        while (m[i] != null) {
            m[i - 1] = m[i];
            i++;
        }

        m[i - 1] = null;
        return m;
    }

    /**
     * method to borrow book.
     * @param book
     * @return if member borrowed book successfully it returns true,if not it returns false.
     */
    public boolean getbook(Book book) {
        for (int i = 0; i < 5; i++) {
            if (borrow[i] == null) {
                borrow[i] = book;
                {
                    return true;
                }
            }
        }
        {
            System.out.println("you can not borrow more book!");
        }
        return false;
    }

    /**
     * method to get back borrowed books.
     *
     * @param book
     * @return if member give back book successfully it returns true,if not it returns false.
     */
    public boolean giveback(Book book) {
        for (int i = 0; i < 5; i++) {
            if (borrow[i] == book) {
                borrow[i] = null;
                while (borrow[i] != null) {
                    borrow[i - 1] = borrow[i];
                }

                return true;
            }
        }
        return false;
    }
    }
