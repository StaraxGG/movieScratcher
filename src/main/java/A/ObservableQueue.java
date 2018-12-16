package A;
import java.util.LinkedList;

/**
 * An implementation of ObservableQueue
 * in movieScratcher
 *
 * This class is used to display 5 items
 * in a Horizontalbar. It's implemented
 * with a fullList and a portion List of 5
 * items. With each iterate in either
 * direction the next item in the
 * order of the fullList gets added
 * either at the beginning or end
 * of the List.
 *
 * This class is used in the class
 * HorizontalBar
 *
 * @author Nicolas
 * @version 1.0
 * @since 2018-Dez-15
 */
public class ObservableQueue {

    /* ---------------------------------------- Main ---------------------------------------------------------------- */



    /* ---------------------------------------- Attributes ---------------------------------------------------------- */

    private LinkedList<GridItem> fullList;
    private LinkedList<GridItem> displayedList;

    private int size;

    private int pushIndex;
    private int popIndex;


    /* ---------------------------------------- Constants ----------------------------------------------------------- */



    /* ---------------------------------------- Constructors -------------------------------------------------------- */

    /**
     * Creates a new ObservableQueue from a LinkedList that contains GridItems.
     * @param fullList  List of GridItems
     */

    public ObservableQueue(LinkedList<GridItem> fullList){
        this.fullList = fullList;
        this.size = fullList.size();

        if(size >= 5){
            displayedList = new LinkedList<>(fullList.subList(0,5));
            pushIndex = 4;
            popIndex = 0;
        }
        else{
            displayedList = new LinkedList<>(fullList);
            pushIndex = -1;
            popIndex = -1;
        }
    }

    /* ---------------------------------------- Methods ------------------------------------------------------------- */

    /**
     * Returns a List with 5 items retrieved from the fullList.
     * With each call the first items gets deleted and the next
     * from fullList added.
     *
     * @return List containing 5 elements from the fullList
     */
    LinkedList<GridItem> push(){
        if(pushIndex+1 < size && pushIndex != -1) {

            ++popIndex;
            ++pushIndex;

            displayedList.removeFirst();
            displayedList.addLast(fullList.get(pushIndex));
        }
        return displayedList;
    }

    /**
     * Returns a List with 5 items retrieved from the fullList.
     * With each call the the last items gets removed and
     * the next item from fulList added at the beginning.
     *
     * @return List containing 5 elements from the fullList
     */
    LinkedList<GridItem> pop(){
        if(popIndex-1 >= 0 && popIndex != -1){
            --popIndex;
            --pushIndex;

            displayedList.removeLast();
            displayedList.addFirst(fullList.get(popIndex));
        }
        return displayedList;
    }


    /* ---------------------------------------- S/Getters ----------------------------------------------------------- */

    public LinkedList<GridItem> getFullList() {
        return fullList;
    }

    public void setFullList(LinkedList<GridItem> fullList) {
        this.fullList = fullList;
    }

    public LinkedList<GridItem> getDisplayedList() {
        return displayedList;
    }

    public void setDisplayedList(LinkedList<GridItem> displayedList) {
        this.displayedList = displayedList;
    }
}
