package optional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {

    private static class Employee {

    }

    public static void main(String[] args) {

        int id = 0;
        Stream<Optional<Employee>> emp = getEmployee(id);
//        Optional stream to employee stream
        Stream empStream = emp.flatMap(Optional::stream);

    }

    private static Stream<Optional<Employee>> getEmployee(int id) {
        return List.of(Optional.of(new Employee())).stream();
    }

}
