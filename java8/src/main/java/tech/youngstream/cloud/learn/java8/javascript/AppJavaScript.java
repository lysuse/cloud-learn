package tech.youngstream.cloud.learn.java8.javascript;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class AppJavaScript {

    public static void main(String[] args) {

        // === 以下演示java调用javascript

        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");

        Double r = null;

        String name = "youngs";

        try {
            nashorn.eval("print('"+name+"')");

            r = (Double) nashorn.eval("0.1 + 0.2");

        } catch (ScriptException e) {
            e.printStackTrace();
            System.out.println("脚本执行错误："+ e.getMessage());
        }

        System.out.println(r);
    }

}
