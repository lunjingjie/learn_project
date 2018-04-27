public class Constructor {
    public static void main(String[] args) {
        User u = new User();
        u.test();
    }
}

class User {

    private String a;
    static {
        System.out.println("静态代码块");
    }

    {
        System.out.println("构造代码块");
    }

    public User (){
        System.out.println("构造函数");
    }

    public User(String s) {
        this.a = s;
    }

    public void test() {
        System.out.println("test function");
    }
}
