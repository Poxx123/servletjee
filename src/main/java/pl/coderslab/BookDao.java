package pl.coderslab;

public class BookDao {

    private static BookDao instance;
    private final String dbName = "jdbc_test";
    private final String URL = "jdbc:mysql://localhost:3306/";
}
