package com.sfbl.javaext.tuple;

public class Tuple {
    public static <T> _1 create(T item1) { return new _1<>(item1); }
    public static <T1, T2> _2 create(T1 item1, T2 item2) { return new _2<>(item1, item2); }
    public static <T1, T2, T3> _3 crreate(T1 item1, T2 item2, T3 item3) { return new _3<>(item1, item2, item3); }
    public static <T1, T2, T3, T4> _4 crreate(T1 item1, T2 item2, T3 item3, T4 item4) { return new _4<>(item1, item2, item3, item4); }
    public static <T1, T2, T3, T4, T5> _5 crreate(T1 item1, T2 item2, T3 item3, T4 item4, T5 item5) { return new _5<>(item1, item2, item3, item4, item5); }
    public static <T1, T2, T3, T4, T5, T6> _6 crreate(T1 item1, T2 item2, T3 item3, T4 item4, T5 item5, T6 item6) { return new _6<>(item1, item2, item3, item4, item5, item6); }
    public static <T1, T2, T3, T4, T5, T6, T7> _7 crreate(T1 item1, T2 item2, T3 item3, T4 item4, T5 item5, T6 item6, T7 item7) { return new _7<>(item1, item2, item3, item4, item5, item6, item7); }

    public static class _1<T> {
        public T item1;
        public _1(T p1) { item1 = p1; }
    }
    public static class _2<T1, T2> {
        public T1 item1;
        public T2 item2;
        public _2(T1 p1, T2 p2) {
            item1 = p1;
            item2 = p2;
        }
    }
    public static class _3<T1, T2, T3> {
        public T1 item1;
        public T2 item2;
        public T3 item3;
        public _3(T1 p1, T2 p2, T3 p3) {
            item1 = p1;
            item2 = p2;
            item3 = p3;
        }
    }
    public static class _4<T1, T2, T3, T4> {
        public T1 item1;
        public T2 item2;
        public T3 item3;
        public T4 item4;
        public _4(T1 p1, T2 p2, T3 p3, T4 p4) {
            item1 = p1;
            item2 = p2;
            item3 = p3;
            item4 = p4;
        }
    }
    public static class _5<T1, T2, T3, T4, T5> {
        public T1 item1;
        public T2 item2;
        public T3 item3;
        public T4 item4;
        public T5 item5;
        public _5(T1 p1, T2 p2, T3 p3, T4 p4, T5 p5) {
            item1 = p1;
            item2 = p2;
            item3 = p3;
            item4 = p4;
            item5 = p5;
        }
    }
    public static class _6<T1, T2, T3, T4, T5, T6> {
        public T1 item1;
        public T2 item2;
        public T3 item3;
        public T4 item4;
        public T5 item5;
        public T6 item6;
        public _6(T1 p1, T2 p2, T3 p3, T4 p4, T5 p5, T6 p6) {
            item1 = p1;
            item2 = p2;
            item3 = p3;
            item4 = p4;
            item5 = p5;
            item6 = p6;
        }
    }
    public static class _7<T1, T2, T3, T4, T5, T6, T7> {
        public T1 item1;
        public T2 item2;
        public T3 item3;
        public T4 item4;
        public T5 item5;
        public T6 item6;
        public T7 item7;
        public _7(T1 p1, T2 p2, T3 p3, T4 p4, T5 p5, T6 p6, T7 p7) {
            item1 = p1;
            item2 = p2;
            item3 = p3;
            item4 = p4;
            item5 = p5;
            item6 = p6;
            item7 = p7;
        }
    }
}
