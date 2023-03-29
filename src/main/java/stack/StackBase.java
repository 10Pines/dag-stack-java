package stack;

public class StackBase extends StackNode {
    @Override
    public Object element() {
        throw new RuntimeException(Stack.ERROR_STACK_EMPTY_DESCRIPTION);
    }

    @Override
    public StackNode previous() {
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
}
