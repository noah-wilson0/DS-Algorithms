package stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Stack {
    public static void main(String[] args) {
        //stack 생성
        java.util.Stack<String> stack = new java.util.Stack<>();

        System.out.println("Arrays.toString(stack) = " + stack.toString());
        stack.push("A");
        stack.push("B");
        stack.push("C");

        // 1. push() : 데이터 삽입
        System.out.println("push 후 stack: "+stack);

        // 2. peek() : 최상단 원소 확인 (삭제 안 됨)
        System.out.println("peek(): " + stack.peek());
        System.out.println("peek 후 stack: " + stack);

        // 3. get() : 인덱스 기반 전체 원소 조회
        for (int i = 0; i < stack.size(); i++) {
            System.out.println("stack.get(i) = " + stack.get(i));
        }


        // 4. pop() : 최상단 원소 꺼내기
        System.out.println("pop(): " + stack.pop());
        System.out.println("pop 후 stack: " + stack);

        //5. 성능 측정 테스트
        runBenchmark();


    }

    /**
     * 2. Stack vs Deque 성능 비교 메서드
     */
    private static void runBenchmark() {
        System.out.println("\n=== Stack vs Deque 성능 비교 ===");
        for (int n = 1; n <= 1_000_000; n *= 10) {
            long stackTime = benchmarkStack(n);
            long dequeTime = benchmarkDeque(n);

            System.out.printf("[N=%d] Stack: %.3f ms | Deque: %.3f ms%n",
                    n, stackTime / 1_000_000.0, dequeTime / 1_000_000.0);
        }
    }

    /**
     *  Stack 성능 측정
     */
    private static long benchmarkStack(int n) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) stack.push(i);
        for (int i = 0; i < n; i++) stack.pop();
        return System.nanoTime() - start;
    }

    /**
     *  Deque 성능 측정
     */
    private static long benchmarkDeque(int n) {
        Deque<Integer> deque = new ArrayDeque<>();
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) deque.push(i);
        for (int i = 0; i < n; i++) deque.pop();
        return System.nanoTime() - start;
    }
}
