package by.it._classwork_.calc;

public class Runner {

    private static class OneThread extends Thread {
        OneThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            Logger.getInstanceLogger().log(this.getName());
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new OneThread("th" + i).start();
        }
    }
}
