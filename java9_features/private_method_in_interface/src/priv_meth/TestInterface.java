package priv_meth;

public interface TestInterface {

    private void print() {
        System.out.println("This private method in interface");
    }

    private static void staticPrint() {
        System.out.println("This private method in interface");
    }

}
