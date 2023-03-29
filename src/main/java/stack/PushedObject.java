package stack;

public class PushedObject extends StackNode {
    private final Object element;
    private final StackNode previous;

    public PushedObject(Object element, StackNode previous) {
        this.element = element;
        this.previous = previous;
    }

    @Override
    public Object element() {
        return element;
    }

    @Override
    public StackNode previous() {
        return previous;
    }

    @Override
    public Boolean deepContains(Object anObject) {
        return contains(anObject) || previous.deepContains(anObject);
    }

    @Override
    public Integer deepSize() {
        return size() + previous.deepSize();
    }

    private int size() {
        return 1;
    }

    private boolean contains(Object anObject) {
        return element.equals(anObject);
    }

    @Override
    public Boolean isEmpty() {
        return false;
    }
}
