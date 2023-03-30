package stack;

import java.util.function.BiFunction;
import java.util.function.Function;

public class PushedObject<E> extends StackNode<E> {
    private final E element;
    private final StackNode<E> previous;

    public PushedObject(E element, StackNode<E> previous) {
        this.element = element;
        this.previous = previous;
    }

    @Override
    public E element() {
        return element;
    }

    @Override
    public StackNode<E> previous() {
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

    @Override
    public <R> Stack<R> mapToStack(Function<E, R> elementMapping) {
        Stack<R> mappedStack = previous.mapToStack(elementMapping);
        mappedStack.push(elementMapping.apply(element));
        return mappedStack;
    }

    @Override
    public <R> R reduce(R initialValue, BiFunction<R, E, R> reducer) {
        return previous.reduce(reducer.apply(initialValue, element), reducer);
    }
}
