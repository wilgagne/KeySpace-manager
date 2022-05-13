public class interactorCREATE {
    CassandraConnector client;

    public interactorCREATE(CassandraConnector client) {
        this.client = client;
    }

    public void createKeyspace(String keyspaceName, String replicationStrategy, int replicationFactor) {
        String query = "CREATE KEYSPACE IF NOT EXISTS " +
                keyspaceName + " WITH replication = {" +
                "'class':'" + replicationStrategy +
                "','replication_factor':" + replicationFactor +
                "};";
        client.getSession().execute(query);
    }
}
