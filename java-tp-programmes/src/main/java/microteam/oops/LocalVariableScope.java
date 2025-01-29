package microteam.oops;


public class LocalVariableScope {
    private int puppyAge;
    public static String BREED="Bulldog";

    public void setAge( int age ) {
        // access the instance variable and modify it
        puppyAge = age;
    }

    public int getAge( ) {
        // access the instance variable
        return puppyAge;
    }

    public static void main(String []args) {
        LocalVariableScope myPuppy = new LocalVariableScope();
        myPuppy.setAge( 2 );
        System.out.println("Puppy Age :" + myPuppy.getAge() );
        // access the class variable
        System.out.println("Breed :" + LocalVariableScope.BREED );

        // local variables
        int a = 10;
        int b = 20;

        int c = a + b;

        System.out.println("c: " + c);
    }
}
