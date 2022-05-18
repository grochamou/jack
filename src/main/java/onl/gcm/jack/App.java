package onl.gcm.jack;

import onl.gcm.hermes.client.DistantWorldClient;
import onl.gcm.hermes.client.HermesClient;
import onl.gcm.hermes.client.SpringUtils;

public class App {

    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "development");

        // No Spring? No problem.
        DistantWorldClient client = SpringUtils.getBean(DistantWorldClient.class);
        // Replace this use of System.out or System.err by a logger.
        System.out.println("DistantWorld isAlive: " + client.isAlive());
        // Replace this use of System.out or System.err by a logger.
        System.out.println("DistantWorld getText: " + client.getTest("1"));
        try {
            client.getNoContent();
            System.out.println("DistantWorld getNoContent: ✅");
        } catch (Exception e) {
            // Replace this use of System.out or System.err by a logger.
            System.out.println("DistantWorld getNoContent: " + HermesClient.getErrorMessage(e));
        }
        try {
            client.getNotFound();
        } catch (Exception e) {
            // Replace this use of System.out or System.err by a logger.
            System.out.println("DistantWorld getNotFound: " + HermesClient.getErrorMessage(e));
        }
        try {
            client.getCrash();
        } catch (Exception e) {
            // Replace this use of System.out or System.err by a logger.
            System.out.println("DistantWorld getCrash: " + HermesClient.getErrorMessage(e));
        }
    }

}
