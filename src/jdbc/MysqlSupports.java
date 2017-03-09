package jdbc;

import java.sql.*;

/**
 * Created by guoyangqiao on 08/03/2017.
 */
public class MysqlSupports {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://dbi01.sho.shuyun.com/comm_channel?useUnicode=true&characterEncoding=utf8&autoReconnect=true&allowMultiQueries=true&noAccessToProcedureBodies=true&rewriteBatchedStatements=true", "channel", "channel");
        DatabaseMetaData metaData = connection.getMetaData();
        //HOLD_CURSORS_OVER_COMMIT
        System.out.println(metaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY));
        System.out.println(metaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE));
        System.out.println(metaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY));
        System.out.println(metaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE));
        System.out.println(metaData.supportsTransactionIsolationLevel(Connection.TRANSACTION_READ_UNCOMMITTED));
        System.out.println(metaData.supportsTransactionIsolationLevel(Connection.TRANSACTION_READ_COMMITTED));
        System.out.println(metaData.supportsTransactionIsolationLevel(Connection.TRANSACTION_REPEATABLE_READ));
        System.out.println(metaData.supportsTransactionIsolationLevel(Connection.TRANSACTION_SERIALIZABLE));
        System.out.println(metaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE));
        System.out.println(metaData.supportsResultSetHoldability(ResultSet.HOLD_CURSORS_OVER_COMMIT));
        System.out.println("===================");
        System.out.println(metaData.supportsResultSetHoldability(ResultSet.CLOSE_CURSORS_AT_COMMIT));
        System.out.println(metaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY));
        System.out.println(metaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE));
        System.out.println(metaData.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY));
        System.out.println(metaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE));
        System.out.println(metaData.supportsTransactionIsolationLevel(Connection.TRANSACTION_NONE));
        /*
        TYPE             TYPE_SCROLL_INSENSITIVE(TYPE_FORWARD_ONLY是TYPE_SCROLL_INSENSITIVE的伪子集,官方声明仅支持TYPE_SCROLL_INSENSITIVE,自然也支持了TYPE_FORWARD_ONLY)
        CONCUR           CONCUR_UPDATABLE CONCUR_UPDATABLE
        CURSORS          HOLD_CURSORS_OVER_COMMIT
        TRANSACTION      TRANSACTION_READ_UNCOMMITTED TRANSACTION_READ_COMMITTED TRANSACTION_REPEATABLE_READ TRANSACTION_SERIALIZABLE
         */
    }
}