package memento;

public class MementoCaretaker {
    private InteriorMemento memento;

    public InteriorMemento getMemento() {
        return memento;
    }

    public void setMemento(InteriorMemento memento) {
        this.memento = memento;
    }
}