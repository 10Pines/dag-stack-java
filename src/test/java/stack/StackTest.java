/*
 * Developed by 10Pines SRL
 * License:
 * This work is licensed under the
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 Unported License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-sa/3.0/
 * or send a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View,
 * California, 94041, USA.
 *
 */
package stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {
    @Test
    public void newStacksMustBeEmpty() {
        var stack = new Stack();

        assertTrue(stack.isEmpty());
    }

    @Test
    public void pushAddsElementToTheStack() {
        var stack = emptyStack();

        stack.push("Something");

        assertFalse(stack.isEmpty());
    }

    @Test
    public void popRemovesLastPushedElement() {
        var stack = emptyStack();
        stack.push("Something");

        stack.pop();

        assertTrue(stack.isEmpty());
    }

    @Test
    public void popReturnsLastPushedElement() {
        var stack = emptyStack();
        var pushedElement = "Something";
        stack.push(pushedElement);

        var poppedElement = stack.pop();

        assertEquals(pushedElement, poppedElement);
    }

    @Test
    public void canStackMoreThanOneElement() {
        var first = "First";
        var second = "Second";
        var stack = emptyStack();

        stack.push(first);
        stack.push(second);

        assertEquals(second, stack.pop());
    }

    @Test
    public void pushingAndThenPoppingMakesNoChangeToTheStack() {
        var first = "First";
        var second = "Second";
        var third = "Third";
        var stack = emptyStack();
        stack.push(first);
        stack.push(second);

        stack.push(third);
        stack.pop();

        assertEquals(second, stack.pop());
    }

    @Test
    public void stackBehavesLIFO() {
        var first = "First";
        var second = "Second";
        var stack = emptyStack();

        stack.push(first);
        stack.push(second);

        assertEquals(second, stack.pop());
        assertEquals(first, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void aStackBehavesLifoEvenWhenContainingDuplicates() {
        var first = "an object";
        var second = "another object";
        var stack = emptyStack();
        stack.push(first);
        stack.push(second);
        stack.push(first);

        stack.pop();

        assertEquals(second, stack.pop());
    }

    @Test
    public void topReturnsLastPushedElement() {
        var stack = emptyStack();
        var pushedElement = "Something";
        stack.push(pushedElement);

        var topElement = stack.top();

        assertEquals(pushedElement, topElement);
    }

    @Test
    public void topDoesNotRemoveElementFromStack() {
        var stack = emptyStack();
        var anObject = "Something";
        stack.push(anObject);

        stack.top();

        assertFalse(stack.isEmpty());
    }

    @Test
    public void sizeOfAnEmptyStackMustBeZero() {
        var stack = emptyStack();

        assertEquals(0, stack.size());
    }

    @Test
    public void pushIncrementsSizeByOne() {
        var stack = emptyStack();

        stack.push("element one");
        stack.push("element two");

        assertEquals(2, stack.size());
    }

    @Test
    public void popDecrementsSizeByOne() {
        var stack = emptyStack();
        stack.push("element one");
        stack.push("element two");

        stack.pop();

        assertEquals(1, stack.size());
    }

    @Test
    public void anEmptyStackDoesNotContainAnyElements() {
        var stack = emptyStack();

        assertFalse(stack.contains("an object"));
    }

    @Test
    public void stackOnlyContainsPushedElements() {
        var stack = emptyStack();

        stack.push("pushed object");
        stack.push("another pushed object");

        assertTrue(stack.contains("pushed object"));
        assertTrue(stack.contains("another pushed object"));
        assertFalse(stack.contains("not pushed object"));
    }

    @Test
    public void stackCeasesToContainAnElementWhenItsLastOccurrenceIsPopped() {
        var stack = emptyStack();
        stack.push("one");
        stack.push("one");
        stack.push("two");

        stack.pop();
        stack.pop();

        assertFalse(stack.contains("two"));
        assertTrue(stack.contains("one"));
    }

    @Test
    public void cannotPopAnEmptyStack() {
        var stack = emptyStack();

        AssertionsExtension.assertThrowsWithDescription(RuntimeException.class,
                () -> stack.pop(),
                Stack.ERROR_STACK_EMPTY_DESCRIPTION);
    }

    @Test
    public void cannotTopAnEmptyStack() {
        var stack = emptyStack();

        AssertionsExtension.assertThrowsWithDescription(RuntimeException.class,
                () -> stack.top(),
                Stack.ERROR_STACK_EMPTY_DESCRIPTION);
    }

    private Stack emptyStack() {
        return new Stack();
    }
}
