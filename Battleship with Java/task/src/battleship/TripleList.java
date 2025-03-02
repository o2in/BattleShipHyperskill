package battleship;

import java.util.ArrayList;
import java.util.Objects;

public class TripleList<T> {
    private ArrayList<T> shotList;
    private ArrayList<T> hitList;
    private ArrayList<T> missList;

    public TripleList() {
        shotList = new ArrayList<>();
        hitList = new ArrayList<>();
        missList = new ArrayList<>();
    }


    public T get(String listName, int index) {
        switch (listName) {
            case "shot":
                return shotList.get(index);
            case "hit":
                return hitList.get(index);
            case "miss":
                return missList.get(index);
            default:
                throw new IllegalArgumentException("Invalid list name");
        }
    }

    public ArrayList<T> getHitList() {
        return hitList;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TripleList<?> that = (TripleList<?>) o;
        return Objects.equals(hitList, that.hitList);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(hitList);
    }

    public void add(String listName, T item) {
        switch (listName) {
            case "shot":
                shotList.add(item);
                break;
            case "hit":
                hitList.add(item);
                break;
            case "miss":
                missList.add(item);
                break;
            default:
                throw new IllegalArgumentException("Invalid list number");
        }
    }

    public boolean alreadyShot(Node node){
        return shotList.contains(node);
    }


    public boolean allHit(){
        return hitList.size() == 17;
    }



    public int size() {
        return shotList.size();
    }
}