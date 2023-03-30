package stack;

import java.util.function.BiFunction;
import java.util.function.Function;

public class StackBase<E> extends StackNode<E> {
    @Override
    public E element() {
        throw new RuntimeException(Stack.ERROR_STACK_EMPTY_DESCRIPTION);
    }

    @Override
    public StackNode<E> previous() {
        throw new RuntimeException(Stack.ERROR_STACK_EMPTY_DESCRIPTION);
    }

    @Override
    public Boolean deepContains(Object anObject) {
        return false;
    }

    @Override
    public Integer deepSize() {
        return 0;
    }

    @Override
    public Boolean isEmpty() {
        return true;
    }

    @Override
    public <R> Stack<R> mapToStack(Function<E, R> elementMapping) {
        return new Stack<>();
    }

    @Override
    public <R> R reduce(R initialValue, BiFunction<R, E, R> reducer) {
        return initialValue;
    }
}
