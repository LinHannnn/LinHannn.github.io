package two;

import java.util.Scanner;

public class demo3 {
    static String[] usernames = {"kunkun", "ikun", "xiaheizi", "gg", "admin"};/*用户名*/
    static String[] userpassword = {"110120", "998", "888888", "119", "000"};/*用户密码*/
    static int[] nums = {1, 2, 3, 4, 5};/*书本编号*/
    static String[] books = {"从java入坑到粪坑", "HTML从上网到404", "信息技术从开机到蓝屏", "网络工程从接网线到接电线", "python从爬虫到踩缝纫机"};/*书本名*/
    static double[] prices = {9999, 888, 29.9, 9.9, 0.0000008};/*价格*/
    static Scanner scan = new Scanner(System.in);

    /*判断是密码否正确*/
    public static boolean login(String name, String password) { /*1.登录系统*/
        int i = 0;
        for (i = 0; i < usernames.length; i++) {
            if (name.equals(usernames)) {/*如果输入的账号和原用户名中的一样，那么就跳出循环*/
                break;
            }
            if (i == userpassword.length) {/*如果它走完了全部的长度，那就说明没找到，拐了*/
                return false;
            }
            if (userpassword[i].equals(password)) {   /*如果输入的密码和原来的密码有相同的，那么就是找到了*/
                return true;
            }
        }
        return false;
    }

    public static void mainMenu() {  /*2.显示主菜单*/
        System.out.println("1,查询所有图书信息");
        System.out.println("2,新增图书信息");
        System.out.println("3,修改图书信息");
        System.out.println("4,删除图书信息");
        System.out.println("5,查询最便宜的图书");
        System.out.println("6,退出系统");
    }

    public static int getitem() {
        int item = 0;            /*3.实现编号操控功能*/
        System.out.println("请输入编号执行操作");
        item = scan.nextInt();

        return item;
    }

    public static void displayallbooks() {/*1.展示所有书籍*/
        System.out.println("编号" + "\t" + "书名" + "\t\t" + "\t\t" + "价格");
        int i = 0;
        for (i = 0; i < nums.length; i++) {
            System.out.println(nums[i] + "\t" + String.format("%-14s", books[i]) + "\t" + String.format("%.2f", prices[i]));
        }
    }

    public static int isEasitc(String bname) {/*判断输入的书名是否与原有的书名相同*/
        int i = 0;
        for (i = 0; i < books.length; i++) {
            if (bname.equals(books[i])) {
                return i;/*如果相同返回下标*/
            }
        }
        return -1;/*不相同就返回-1*/
    }

    public static int insertbook(String bookname, double pricess) {     /*2.添加书本*/
        int i = 0;
        String[] newbook = new String[books.length + 1];/*新建书本的数组，在老数组的基础上加1*/
        double[] newprice = new double[prices.length + 1];/*新建新的价格数组，在老数组上加1*/
        int[] newnums = new int[nums.length + 1];/*新建新的编号数组，在老数组上加1*/
        for (i = 0; i < books.length; i++) {
            newbook[i] = books[i];      /*赋值老数组*/
            newprice[i] = prices[i];
            newnums[i] = nums[i];
        }

        newbook[books.length] = bookname;/*书名数组在末尾加上输入的书名*/
        newprice[prices.length] = pricess;/*价格数组末尾加上输入的价格*/
        newnums[nums.length] = nums[nums.length - 1] + 1;/*在原有的编号上的长度-1+1*/

        books = newbook;/*最后数据交换，新的代替旧的*/
        prices = newprice;
        nums = newnums;
        return 1;
    }

    public static int dd(int Index) {
        int i = 0;
        for (i = 0; i < books.length; i++) {
            if (Index == books.length) {
                return -1;
            }
        }
        return 1;
    }

    public static int updateBook(String old, String name, double price) {   /*修改书本名和价格*/
        int Index = isEasitc(old);
        books[Index] = name;
        prices[Index] = price;
        return -1;
    }

    public static int deleteBook(int Index) {       /*删除书本*/
        int i = 0;
        String[] newbooks = new String[books.length - 1];
        int[] newnums = new int[nums.length - 1];
        double[] newprice = new double[prices.length - 1];
        for (i = 0; i < Index; i++) {
            newbooks[i] = books[i];
            newnums[i] = nums[i];
            newprice[i] = prices[i];
        }
        for (i = Index + 1; i < books.length; i++) {
            newbooks[i - 1] = books[i];
            newnums[i - 1] = nums[i];
            newprice[i - 1] = prices[i];
        }
        books = newbooks;
        nums = newnums;
        prices = newprice;
        return 0;
    }

    public static double lower() {      /*找出最便宜的书籍的价格*/
        double lower = prices[0];
        int i = 0;
        for (i = 0; i < prices.length; i++) {
            if (prices[i] < lower) {
                lower = prices[i];
            }
        }
        return lower;
    }

    public static void displaylowerbooks() { /*查找出价格最低的书本*/
        double lowers = lower();

        int i = 0;
        for (i = 0; i < books.length; i++) {
            if (prices[i] == lowers) {
                lowers = prices[i];
                System.out.println("价格最低的书本是"+books[i] +"价格是"+ prices[i]);
            }
        }
    }

    public static void main(String[] args) {

        int i = 0;
        int item = 4;
        boolean flag = true;
        String name = null;
        String password = null;
        for (i = item; i > 0; i--) {
            System.out.println("请输入账号");
            name = scan.next();
            System.out.println("请输入密码");
            password = scan.next();     /*功能实现区域，输入账号密码*/

            if (login(name, password) == true) {      /*如果条件符合则输出下面的语句*/
                System.out.println("登陆成功欢迎" + name + "来到ikun之家");
                break;
            } else {              /*如果条件不符合，则输出下面语句*/
                System.out.println("账号密码错误，你还有" + (i - 1) + "次机会");
            }
        }
        while (flag) {
            mainMenu();/*调用方法*/
            switch (getitem()) {
                case 1:     /*如果输入1，就调用dispalyallbook方法*/
                    displayallbooks();
                    break;
                case 2:     /*如果输入2，就执行添加书本名和价格的语句*/
                    System.out.println("请输入你要添加的书本名");
                    String bname = scan.next();
                    System.out.println("请输入书本的价格");
                    int price = scan.nextInt();
                    if (isEasitc(name) == -1) {      /*如果负责判定书本是否存在的方法通过了，那就调用下面两个方法，意思就是新增完方法就展示所有书籍*/
                        insertbook(bname, price);
                        displayallbooks();
                    }
                    break;
                case 3:
                    System.out.println("请输入你要修改的书名");
                    String newname = scan.next();
                    if (isEasitc(newname) == -1) {
                        System.out.println("此图书不存在");
                        break;
                    }
                    System.out.println("请输入新书名");
                    String bkname = scan.next();
                    System.out.println("请输入你要修改的价格");
                    double pricess = scan.nextByte();
                    updateBook(newname, bkname, pricess);
                    displayallbooks();
                    break;
                case 4:
                    System.out.println("请输入要删除的书本");
                    String dename = scan.next();
                    int deIndex = isEasitc(dename);
                    deleteBook(deIndex);
                    displayallbooks();
                    break;
                case 5:
                    displaylowerbooks();
                    break;
                default:
                    break;
                case 6:
                    System.exit(0);
                    break;

            }
            System.out.println("还需要继续吗？(y/n)");
            String con = scan.next();
            if (con.equals("y")){
                flag = true;
            }else{
                flag = false;
            }
        }
    }
}
