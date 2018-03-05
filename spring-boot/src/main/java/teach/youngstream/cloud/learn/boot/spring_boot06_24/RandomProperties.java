package teach.youngstream.cloud.learn.boot.spring_boot06_24;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RandomProperties {

    @Value("${github.name}")
    private String name;
    @Value("${github.title}")
    private String title;
    @Value("${app.run.mode}")
    private String mode;

    @Value("${my.secret}")
    private String secret;
    @Value("${my.number}")
    private Integer number;
    @Value("${my.bignumber}")
    private Long bignumber;
    @Value("${my.uuid}")
    private String uuid;
    @Value("${my.number.less.than.ten}")
    private Integer numberLess10;
    @Value("${my.number.in.range}")
    private Integer numberInRange;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Long getBignumber() {
        return bignumber;
    }

    public void setBignumber(Long bignumber) {
        this.bignumber = bignumber;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getNumberLess10() {
        return numberLess10;
    }

    public void setNumberLess10(Integer numberLess10) {
        this.numberLess10 = numberLess10;
    }

    public Integer getNumberInRange() {
        return numberInRange;
    }

    public void setNumberInRange(Integer numberInRange) {
        this.numberInRange = numberInRange;
    }

    @Override
    public String toString() {
        return "RandomProperties{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", mode='" + mode + '\'' +
                ", secret='" + secret + '\'' +
                ", number=" + number +
                ", bignumber=" + bignumber +
                ", uuid='" + uuid + '\'' +
                ", numberLess10=" + numberLess10 +
                ", numberInRange=" + numberInRange +
                '}';
    }
}
