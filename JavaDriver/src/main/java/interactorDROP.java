import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class interactorDROP {
    CassandraConnector client;

    public interactorDROP(CassandraConnector client) {
        this.client = client;
    }

    public void executeDROP() throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Please enter the name of the keyspace you wish to drop");
        String keyspaceName = reader.readLine();

        String query = "DROP KEYSPACE "+ keyspaceName;
        client.getSession().execute(query);
    }
}