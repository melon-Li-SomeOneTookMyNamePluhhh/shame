import java.util.ArrayList;
import java.util.List;

public class room {

    private List<item> items;
    private String description;

    public room(String description) {
        this.items = new ArrayList();
        this.description = description;


    }

    public void Enter(){
        System.out.println(this.description);
        ViewRoom();
    }

    public void AddItem(Item item){
        this.items.add(item);
    }
    public void ViewRoom(){
        for (Item item: items){
            item.print();
        }
    }
}
