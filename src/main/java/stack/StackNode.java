package stack;

import java.util.function.BiFunction;
import java.util.function.Function;

public abstract class StackNode<E> {
    public abstract E element();

    public abstract StackNode<E> previous();

    public abstract Boolean deepContains(Object anObject);

    public abstract Integer deepSize();

    public abstract Boolean isEmpty();

    public abstract <R> Stack<R> mapToStack(Function<E, R> elementMapping);

    public abstract <R> R reduce(R initialValue, BiFunction<R, E, R> reducer);
}
