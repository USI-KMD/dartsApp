package external.mbean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by lukasz on 4/26/17.
 */
public class MyManaged implements MyManagedMXBean {

    private int someIntValue;

    private ComplexOperationResult complexOperationResult =
            new ComplexOperationResult(3434, "code1");

    @Override
    public int getSomeIntValue() {
        return someIntValue;
    }

    @Override
    public void setSomeIntValue(int someIntValue) {
        this.someIntValue = someIntValue;
    }

    @Override
    public String getSystemTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ISO_DATE);
    }

    @Override
    public void setSystemTime(String systemTime) {
        System.out.println(".....");
    }

    public ComplexOperationResult getComplexOperationResult() {
        return complexOperationResult;
    }

    public void setComplexOperationResult(ComplexOperationResult complexOperationResult) {
        this.complexOperationResult = complexOperationResult;
    }

    @Override
    public void performSomeAction(String param1) {
        System.out.println("param1 = [" + param1 + "]");
    }
}
