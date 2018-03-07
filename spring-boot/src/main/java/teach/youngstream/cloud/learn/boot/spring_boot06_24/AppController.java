package teach.youngstream.cloud.learn.boot.spring_boot06_24;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AppController {

    @Autowired
    private RandomProperties randomProperties;

    @GetMapping("/app")
    public String app() {
        return randomProperties.toString();
    }

    @GetMapping("/rest")
    public RandomProperties rest(String id) {
        if(StringUtils.isEmpty(id)) { throw new IllegalArgumentException("没有参数！");
        }
        return randomProperties;
    }

    @GetMapping("/go")
    public ModelAndView go() {
        return new ModelAndView("go");
    }
}
