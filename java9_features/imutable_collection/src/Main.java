import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void before() {
        List<String> list = new ArrayList<>();
        Collection<String> unmodifiableCollection = Collections.unmodifiableCollection(list);
    }

    public static void after() {
        List<String> immutableList = List.of();
    }

}
