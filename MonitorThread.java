import java.sql.SQLOutput;

public class MonitorThread implements Runnable{


    public void run() {

        Util util = new Util();

        while(true)
        {
            if (MerkleManager.userMerkleRoot != null)
            {
                if (MerkleManager.userMerkleRoot.equals(MerkleManager.realMerkleRoot))
                {
                    System.out.println("You Win: " + MerkleManager.realMerkleRoot);
                    System.exit(0);
                }
                else {
                    System.out.println("You Lost: " + MerkleManager.realMerkleRoot);
                    System.exit(0);
                }
            }
            else if (MerkleManager.strikes >= 3)
            {
                System.out.println("3 Strikes: You Lost...");
                System.exit(0);
            }
            util.sleep(1);
        }
    }
}
