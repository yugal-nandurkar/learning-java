package microteam.oops;


public class InstanceVariableScope {
    private int puppyAge;

    public void setAge( int age ) {
        // access the instance variable and modify it
        puppyAge = age;
    }

    public int getAge( ) {
        // access the instance variable
        return puppyAge;
    }

    public static void main(String []args) {
        InstanceVariableScope myPuppy = new InstanceVariableScope();
        myPuppy.setAge( 2 );
        System.out.println("Puppy Age :" + myPuppy.getAge() );
    }
}