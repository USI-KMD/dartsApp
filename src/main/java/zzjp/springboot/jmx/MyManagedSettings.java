package zzjp.springboot.jmx;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

/**
 * Created by lukasz on 4/26/17.
 */
@Component
@ManagedResource(objectName = "external.jmx:type=MyManagedSettings")
public class MyManagedSettings {

    private int maxThreads = -1;

    private int maxPoolSize = -1;

    @ManagedAttribute(description = "some very iteresting description of this endpoint")
    public int getMaxThreads() {
        return maxThreads;
    }

    @ManagedAttribute(description = "some very iteresting description of this endpoint")
    public void setMaxThreads(int maxThreads) {
        this.maxThreads = maxThreads;
    }

    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }
}
