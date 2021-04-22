package dao.connection;

public enum ConnectionEnum {

    URL("jdbc:mysql://localhost:3306/sakila?useSSL=false"),
    USERNAME("root"),
    PASSWORD("Password");

    private String value;

    private ConnectionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
