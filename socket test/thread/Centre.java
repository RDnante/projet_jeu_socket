package centre;

import td.Thread1;

public class Centre {
    public static void main(String[] args) {
        try {
            Thread test = new Thread(new Thread1(),"jean");
            test.start();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}