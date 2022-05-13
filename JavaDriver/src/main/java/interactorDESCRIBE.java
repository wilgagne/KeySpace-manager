import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;

public class interactorDESCRIBE {
    CassandraConnector client;

    public interactorDESCRIBE(CassandraConnector client) {
        this.client = client;
    }

    public void executeDESCRIBE() {
        String query = "DESCRIBE KEYSPACES";
        ResultSet resultSet = client.getSession().execute(query);

        for (Row x : resultSet){
            System.out.println(x.getString(2));
        }
    }
}
