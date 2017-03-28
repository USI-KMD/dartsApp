package zzjp.springboot.configuration;

/**
 * Created by lukasz on 3/27/17.
 */
public class MyBean {

    private String beanName;

    private String beanFunction;

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanFunction() {
        return beanFunction;
    }

    public void setBeanFunction(String beanFunction) {
        this.beanFunction = beanFunction;
    }
}
