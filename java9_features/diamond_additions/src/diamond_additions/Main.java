package diamond_additions;

import java.util.Arrays;
import java.util.List;

/**
 * Addition directed on anonymous classes
 * */
public class Main <T> {

    public Main(T tObject) {

    }

    public static <T> Main<T> before(T tObject) {
        return new Main<>(tObject) {
        };
    }

    public static <T> Main<T> now(T tObject) {
//        don't use T
        return new Main<>(tObject){};
    }

    public static Main<?> diamond(Object object) {
        List<?> list = Arrays.asList(object);
//        This type isn't returned, because it isn't designate
//        return new Box<>(innerList) { };
        return new Main<List<?>>(list) {};
    }
}
