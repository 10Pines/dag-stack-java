package stack;

public class Stack {
    public static final String ERROR_STACK_EMPTY_DESCRIPTION = "Stack is empty";
    private StackNode topNode = new StackBase();

    public Boolean isEmpty() {
        return topNode.isEmpty();
    }

    public void push(Object anObject) {
        topNode = new PushedObject(anObject, topNode);
    }

    public Object pop() {
        var elementToPop = top();
        topNode = topNode.previous();
        return elementToPop;
    }

    public Object top() {
        return topNode.element();
    }

    public Integer size() {
        return topNode.deepSize();
    }

    public Boolean contains(Object anObject) {
        return topNode.deepContains(anObject);
    }
}
