package question6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestThread{


    public static void main(String[] args) throws SQLException {
        MyConnection myConnection=new MyConnection();
        ExecutorService executorService = Executors.newFixedThreadPool(200);
        while(true) {
            executorService.submit(new TimerTask() {
                @Override
                public void run() {
                    try {
                        Connection connection = myConnection.acquireConnection();
                        PreparedStatement preparedStatement = connection.prepareStatement("insert into tests (name) values ('test')");
                        preparedStatement.execute();
                        preparedStatement.close();
                        myConnection.releaseConnection(connection);
                    } catch (InterruptedException | SQLException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
