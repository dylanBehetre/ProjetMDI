package memento;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento state){
        mementoList.add(state);
    }

    public void removeAfterModification(int index){
        while(mementoList.size()-1 > index){
            mementoList.remove(mementoList.size()-1);
        }
    }

    public Memento get(int index){
        return mementoList.get(index);
    }

    public int getSize(){ return mementoList.size();}
}
