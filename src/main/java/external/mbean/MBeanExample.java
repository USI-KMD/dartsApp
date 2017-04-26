package external.mbean;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

/**
 * Created by lukasz on 4/26/17.
 */
public class MBeanExample {

    public static void main(String[] args) throws Exception {

        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("external.mbean:type=MyManagedMXBean");
        MyManaged bean1 = new MyManaged();
        bean1.setSomeIntValue(123);
        mbs.registerMBean(bean1, name);

        Thread.sleep(Long.MAX_VALUE);
    }

}
