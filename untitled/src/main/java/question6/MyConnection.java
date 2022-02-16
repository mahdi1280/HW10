package question6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class MyConnection {
    private Semaphore semaphore=new Semaphore(4);

    private List<Connection> s=new ArrayList<>();

    public MyConnection() throws SQLException {
        this.s.add(DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","root"));
        this.s.add(DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","root"));
        this.s.add(DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","root"));
        this.s.add(DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","root"));
    }

    public Connection acquireConnection() throws InterruptedException {
        semaphore.acquire();
        System.out.println("acquireConnection: "+ Thread.currentThread().getName());
        return s.remove(0);
    }

    public void releaseConnection(Connection connection){
        s.add(connection);
        System.out.println("releaseConnection: "+ Thread.currentThread().getName());
        semaphore.release();
    }
}
