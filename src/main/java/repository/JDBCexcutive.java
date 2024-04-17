package repository;

import java.sql.Connection;
import java.sql.SQLException;


@FunctionalInterface
public interface JDBCexcutive<T> {

    public  T process(Connection connection) throws SQLException;

}
