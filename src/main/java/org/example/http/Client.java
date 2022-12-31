package org.example.http;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Client {
    private int id;
    private int age;
    @JsonProperty("name")
    private String firstName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (getId() != client.getId()) return false;
        if (getAge() != client.getAge()) return false;
        return getFirstName() != null ? getFirstName().equals(client.getFirstName()) : client.getFirstName() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getAge();
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        return result;
    }
}
