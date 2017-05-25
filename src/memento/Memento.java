package memento;

import zoneDeTravail.ZoneDeTravail;

public class Memento {
    private ZoneDeTravail zdt;

    public Memento(ZoneDeTravail z){
        zdt = z.clone();
    }

    public ZoneDeTravail getState(){
        return zdt;
    }
}
