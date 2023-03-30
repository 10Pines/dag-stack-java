package stack;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Stack<E> {
    public static final String ERROR_STACK_EMPTY_DESCRIPTION = "Stack is empty";
    private StackNode<E> topNode = new StackBase<>();

    public Boolean isEmpty() {
        return topNode.isEmpty();
    }

    public void push(E anObject) {
        topNode = new PushedObject<>(anObject, topNode);
    }

    public Object pop() {
        var elementToPop = top();
        topNode = topNode.previous();
        return elementToPop;
    }

    public E top() {
        return topNode.element();
    }

    public Integer size() {
        return topNode.deepSize();
    }

    public Boolean contains(Object anObject) {
        return topNode.deepContains(anObject);
    }

    public <R> Stack<R> map(Function<E, R> elementMapping) {
        return topNode.mapToStack(elementMapping);
    }

    public <R> R reduce(R initialValue, BiFunction<R, E, R> reducer) {
        if (isEmpty())
            return initialValue;

        return reducer.apply(initialValue, top());
    }
}
