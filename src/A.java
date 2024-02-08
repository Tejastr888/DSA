class A {
    int i=m1();
    A(){
        System.out.println("Constructor");
    }
    int m1(){
        System.out.println("m1-method");
        return 20;
    }
    {
        System.out.println("instance");
    }
    static {
        System.out.println("static");
    }
    static void change(Integer num){
        num=num*2;
        System.out.println(num);
    }

    public static void main(String[] args) {
        A v=new A();
        System.out.println(23<23);
        Integer num=25;
        change(num);
        System.out.println(num);
    }
}
