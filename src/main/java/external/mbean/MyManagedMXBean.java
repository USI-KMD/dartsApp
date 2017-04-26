package external.mbean;

/**
 * Created by lukasz on 4/26/17.
 */
public interface MyManagedMXBean {

    void setSomeIntValue(int someIntValue);

    int getSomeIntValue();

    String getSystemTime();

    void setSystemTime(String systemTime);

    void performSomeAction(String param1);

    public ComplexOperationResult getComplexOperationResult();

    public void setComplexOperationResult(ComplexOperationResult complexOperationResult);

}
