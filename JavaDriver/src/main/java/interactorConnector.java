import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

class CassandraConnector {
        Cluster cluster;

        Session session;

    public CassandraConnector() {
    }

    public void connect (String node, Integer port){
            Cluster.Builder b = Cluster.builder().addContactPoint(node);
            if (port != null) {
                b.withPort(port);
            }
            cluster = b.build();

            session = cluster.connect();
        }

        public Session getSession () {
            return this.session;
        }

        public void close () {
            session.close();
            cluster.close();
        }

    }
