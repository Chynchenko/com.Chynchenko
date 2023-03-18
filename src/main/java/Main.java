import java.util.function.Predicate;
public class Main {
    public static void main(String[] args) {
        Predicate<String> predicate1 = String::isEmpty;
        predicateExample(predicate1);
        System.out.println(predicate1);
        Predicate<Integer> predicate2 = value -> value > 0;
        //        predicateExample(predicate2);
        Predicate<String> predicate3 = value -> value.length() > 1;
        predicateExample(predicate3);
    }
    private static void predicateExample(final Predicate<String> predicate) {
        String lineForTest = "word";
        System.out.println("predicate " + predicate.test(lineForTest));
    }
}