import java.util.ArrayList;


public class MerkleThread implements Runnable{


    private String threadName = "MerkleThread";
    public static volatile ArrayList<String> lstWords;
    private int iMerkleTreeInputs = 4;

    public void run() {

        Util util = new Util();
        lstWords = new ArrayList<>();
        while (true)
        {
            util.sleepRandomTime(threadName);
            String word = MerkleManager.grabWord();

            if (word != null)
            {
                System.out.println("Merkle grabbed a word.");
                lstWords.add(word);
                if (lstWords.size() == iMerkleTreeInputs)
                {
                    MerkleManager.userMerkleRoot = util.getMerkleRoot(lstWords);
                }
            }
        }

    }
}
