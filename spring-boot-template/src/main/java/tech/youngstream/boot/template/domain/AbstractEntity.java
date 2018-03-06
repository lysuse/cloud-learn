package tech.youngstream.boot.template.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public class AbstractEntity {
    @Id
    @GeneratedValue
    protected Long id;

    @CreatedDate
    protected LocalDateTime createdDate;
    @LastModifiedDate
    protected LocalDateTime modifiedDate;
}
