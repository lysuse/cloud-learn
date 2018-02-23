package teach.youngstream.cloud.learn.boot.spring_boot03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by YoungStream on 2017/3/21.
 */
@Service
public class DatabaseAccountService implements AccountService {


    private final RiskAsserssor riskAsserssor;

    @Autowired
    //该注解可以删除，会自动注解在启用@EnableAutoConfigration注解时
    public DatabaseAccountService(RiskAsserssor riskAsserssor) {
        this.riskAsserssor = riskAsserssor;
    }
}
