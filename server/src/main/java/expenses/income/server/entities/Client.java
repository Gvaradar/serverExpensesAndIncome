package expenses.income.server.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name_client;
    String loginClient;
    String password_client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_client() {
        return name_client;
    }

    public void setName_client(String name_client) {
        this.name_client = name_client;
    }

    public String getLoginClient() {
        return loginClient;
    }

    public void setLoginClient(String login_client) {
        this.loginClient = login_client;
    }

    public String getPassword_client() {
        return password_client;
    }

    public void setPassword_client(String password_client) {
        this.password_client = password_client;
    }
}

