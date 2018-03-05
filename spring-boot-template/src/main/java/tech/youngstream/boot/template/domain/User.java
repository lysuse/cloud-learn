package tech.youngstream.boot.template.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

@Data
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class User extends AbstractEntity {

    private String username;

    private String password;

    public User() {
    }
}
