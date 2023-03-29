package stack;

public abstract class StackNode {
    public abstract Object element();

    public abstract StackNode previous();

    public abstract Boolean deepContains(Object anObject);

    public abstract Integer deepSize();

    public abstract Boolean isEmpty();
}
