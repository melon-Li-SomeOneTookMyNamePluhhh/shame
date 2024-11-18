public class Equipment extends Item {
    int damage;
    String element;
    @Override
    public void Interact() {
        System.out.println("This is a piece of equipment.");
    }
}
