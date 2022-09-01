package queues;

public class PriorityQueues {
    private int [] items = new int[5];
    int count;

    public void insert(int item){
        int i;
        //shifting elements
        for(i = count-1;i>=0;i--){
            if(items[i]>item){
                items[i+1] = items[i];
            }
            break;
        }
        items[i+1] = item;
    }


}
