public class RogueThread implements Runnable{

    private String threadName = "RogueThread";
    public void run() {
        Util util = new Util();
        while (true)
        {
            util.sleepRandomTime(threadName);
            String word = MerkleManager.grabWord();
            if (word != null)
            {
                System.out.println("STRIKE!");
                MerkleManager.strikes += 1;
            }
        }
    }
}
