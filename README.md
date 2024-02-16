# java-mariadb-jdbc
Java connect to MariaDB using JDBC Drivers

`mvn clean package`


`colima start --cpu 4 --memory 8`
`cd ~/dev/repository/git/docker27/mariadb/src/v1`
`docker-compose up -d`
`docker-compose down -v`

http://marco27.net/
http://marco27.net/index.php
http://marco27.net:8000
mariadb
root:root123
http://marco27.net:8000/index.php?route=/database/structure&db=db


```
<bean id="dataSource" class="org.apache.commons.dbcp2.BasicDataSource">
    <property name="driverClassName" value="com.mysql.cj.jdbc.Driver"/>
    <property name="url" value="jdbc:mysql://172.17.0.3:3306/mydatabase"/>
    <property name="username" value="myusername"/>
    <property name="password" value="mypassword"/>
</bean>

@Autowired
private DataSource dataSource;

public void test() {
    try (Connection connection = dataSource.getConnection()) {
        System.out.println("Connected successfully");
    } catch (SQLException e) {
        System.err.println(e.getMessage());
    }
}
```