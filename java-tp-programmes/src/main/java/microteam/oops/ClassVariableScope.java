package microteam.oops;


public class ClassVariableScope {
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
        ClassVariableScope myPuppy = new ClassVariableScope();
        myPuppy.setAge( 2 );
        System.out.println("Puppy Age :" + myPuppy.getAge() );
        // access the class variable
        System.out.println("Breed :" + ClassVariableScope.BREED );
    }
}