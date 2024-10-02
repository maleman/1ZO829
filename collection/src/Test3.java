import java.util.*;

public class Test3{

     public void pushPopPeekTest(){
        Deque<Boolean> deque = new ArrayDeque<>();
        // * Represente el inicio de la pila
        deque.push(Boolean.valueOf("abc")); //{*false}
        deque.push(Boolean.valueOf("tRuE"));//{*true, false}
        deque.push(Boolean.valueOf("FALSE"));//{*false, true, false}
        deque.push(true); //{*true, false, true, false}

        //deque.pop() return true, {*false, true, false}
        //deque.peek() return false, {*false, true, false}
        //deque.size() 3
        System.out.println(deque.pop() + ":" + deque.peek() + ":" + deque.size());
     }


     public void testRemove(){
        // * Represente el inicio de la pila
        Deque<Character> chars = new ArrayDeque<>();
        chars.add('A'); //{*A}
        chars.add('B'); //{*A, B}
        chars.remove(); //{*B}
        chars.add('C'); //{*B, C}
        chars.remove(); //{*C}

        System.out.println(chars); //Prints C
     }
}