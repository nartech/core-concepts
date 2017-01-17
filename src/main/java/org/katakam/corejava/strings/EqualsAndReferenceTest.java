package org.katakam.corejava.strings;

/**
 * @author Narasimha
 * @since 17-Jan-17.
 */
/*
    This question tests String concepts. Java String has a String pool. Whenever a new string is created using quotes
    first its checked in the String pool and if its already present, then a new reference to it is created and returned.

    But if you use new String() constructor, two objects will be created in heap. One String() object and the
    other for the value passed in constructor. Any object created with new operator will point to a new object always, so
     == check fails for that case always

     When the intern method is invoked, if the pool already contains a string equal to this String object as determined by the equals(Object) method, then the string from the pool is returned. Otherwise, this String object is added to the pool and a reference to this String object is returned.
It follows that for any two strings s and t, s.intern() == t.intern() is true if and only if s.equals(t) is true.
 */
public class EqualsAndReferenceTest {

    public static void main(String[] args) {
        String s1="abc";
        String s2="abc";
        String s3=s1;

        String s4=new String("abc");
        String s5=new String("abc");

        String s6 = new String("abc".intern());
        String s7 = new String("abc").intern();
        String s8 = new String("abc").intern();

        String s9 = new String("abc").intern();

        //== check
        System.out.println("s1==s2 "+(s1==s2));

        System.out.println("s1==s3 "+(s1==s3));

        System.out.println("s1==s4 "+(s1==s4));

        System.out.println("s4==s5 "+(s4==s5));

        System.out.println("s4==s6 "+(s4==s6));
        System.out.println("s6==s7 "+(s6==s7));

        System.out.println("s7==s8 "+(s7==s8));

        System.out.println("s1==s9 "+(s1==s9));

        //equals

        System.out.println("s1.equals(s2) "+s1.equals(s2));

        System.out.println("s1.equals(s3) "+s1.equals(s3));
        System.out.println("s1.equals(s4) "+s1.equals(s4));
        System.out.println("s4.equals(s5) "+s4.equals(s5));
    }

}
