package memento;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
    private List<Memento> mementoList = new ArrayList<Memento>();
    private int pointeur = 0;
    private boolean undo = false;

    public void setUndo(Boolean b){
        undo = b;
    }

    public void add(Memento state){
        if(undo){
            removeAfterModification();
            undo = false;
        }
        mementoList.add(state);
        pointeur++;
    }

    public void removeAfterModification(){
        while(mementoList.size()-1 > pointeur){
            mementoList.remove(mementoList.size()-1);
            System.out.println("effecer");
        }
    }

    public Memento previous(){
        if(pointeur > 0){
            pointeur --;
        }
        return mementoList.get(pointeur);
    }

    public Memento next(){
        if(pointeur < mementoList.size()-1){
            pointeur ++;
        }
        return mementoList.get(pointeur);
    }

    public Memento get(int index){
        return mementoList.get(index);
    }

    public Memento getCurrent(){
        return mementoList.get(pointeur);
    }

    public int getSize(){ return mementoList.size();}
}
