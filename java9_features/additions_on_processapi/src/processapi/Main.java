package processapi;

public class Main {

    public static void main(String[] args) {
        ProcessHandle currentProcess = ProcessHandle.current();
        System.out.println(currentProcess.pid());
    }

}
