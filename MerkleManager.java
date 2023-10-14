import java.util.ArrayList;

public class MerkleManager {
    public static volatile String userWord;
    public static String userMerkleRoot;
    public static String realMerkleRoot;
    public static int strikes = 0;

    public void manage()
    {
        Util util = new Util();

        MerkleThread thread1 = new MerkleThread();
        RogueThread thread2 = new RogueThread();
        MonitorThread thread3 = new MonitorThread();

        Thread merkleThread = new Thread(thread1);
        Thread rogueThread = new Thread(thread2);
        Thread monitorThread = new Thread(thread3);
        merkleThread.start();
        //rogueThread.start();
        monitorThread.start();




            realMerkleRoot = util.promptUser("Enter Expected Merkle Root");

            while(true)
            {
                userWord = util.promptUser("Enter Word");
            }




    }

    public static synchronized String grabWord()
    {
        String tempString = userWord;
        userWord = null;
        return tempString;
    }

}
