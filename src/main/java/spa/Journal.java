package spa;

import java.util.ArrayList;
import java.util.List;

public class Journal {
    private final List<String> entries = new ArrayList<>();

    public Journal() {
    }

    public List<String> getEntries() {
        return entries;
    }
    int count = 0;

    public void addEntry(String text){
        entries.add("" + count++ +" :" + text);
    }
    public void removeEntry(int index){
        entries.remove(index);
    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator(),entries);
    }

    static class Demo{
        public static void main(String[] args) {
            Journal journal = new Journal();
            journal.addEntry("I read");
            journal.addEntry("I slept");
            System.out.println("Adding to the entry: ");
            System.out.println(journal);
        }

    }
}


