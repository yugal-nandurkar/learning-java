package microteam.oops;


public class InheritanceAccessModifier {
    private int age;
    String name;

    public InheritanceAccessModifier() {
    }

    public void setAge( int age ) {
        this.age = age;
    }

    public int getAge( ) {
        return age;
    }

    public static void main(String []args) {
        InheritanceAccessModifier myPuppy = new InheritanceAccessModifier();

        // update age variable using method call
        myPuppy.setAge( 2 );

        // update name directly
        myPuppy.name = "Tommy";
        System.out.println("Age: " + myPuppy.getAge() +", name: " + myPuppy.name );
    }
}