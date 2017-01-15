package org.otheralgor.spring;

/**
 * {@code Client} class keep information about client
 * {@code id} field keep id
 * {@code fullName} field keep client fullName
 *
 * @author inoob
 * @see org.otheralgor.spring.Client
 * @since 1.0
 */
public class Client {
    String id;
    String fullName;

    public Client(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public Client() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
