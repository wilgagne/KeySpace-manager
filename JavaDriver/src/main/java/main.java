import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {
    public static void main(String[] args) throws IOException {
        // Initialization
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Please enter the node cluster IP address");
        String ip = reader.readLine();
        System.out.println("Please enter the node cluster PORT");
        int port = Integer.parseInt(reader.readLine());

        // Connect to the server
        CassandraConnector client = new CassandraConnector();
        client.connect(ip, port);
        System.out.println("\n -Successful connection to Cassandra server- \n");
        boolean start = true;

        // Take input for user
        while (start){
            System.out.println("\nTo create a table type -> CREATE \n" +
                    "To see all available key spaces type -> DESCRIBE \n" +
                    "To drop a keyspace type -> DROP \n" +
                    "To exit type -> EXIT \n"+
                    "--------------------------------------------------\n");
            String input = reader.readLine();

            // EXIT
            switch (input) {
                case "EXIT":
                    client.close();
                    start = false;
                    break;

                // CREATE
                case "CREATE":
                    System.out.println("Please chose a name for the key space");
                    String key = reader.readLine();
                    interactorCREATE create = new interactorCREATE(client);
                    create.createKeyspace(key, "SimpleStrategy", 1);
                    System.out.println("Your key Space called " + key + " has been created :)");
                    break;

                // DESCRIBE
                case "DESCRIBE":
                    interactorDESCRIBE describe = new interactorDESCRIBE(client);
                    describe.executeDESCRIBE();
                    break;

                // DELETE
                case "DROP":
                    interactorDROP drop = new interactorDROP(client);
                    drop.executeDROP();
                    break;

                // Incorrect
                default:
                    System.out.println("Incorrect input");
                    break;
            }
        }
    }
}
