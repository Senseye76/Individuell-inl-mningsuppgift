package automation.Vehicle.ObjektOP;

public class Dog extends Animal{
    Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void behavior(){
        System.out.println("bark");
    }
}
