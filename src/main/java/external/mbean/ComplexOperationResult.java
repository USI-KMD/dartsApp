package external.mbean;

import java.beans.ConstructorProperties;

/**
 * Created by lukasz on 4/26/17.
 */
public class ComplexOperationResult {

    private int resultCode;

    private String resultMessage;

    @ConstructorProperties({"resultCode", "resultMessage"})
    public ComplexOperationResult(int resultCode, String resultMessage) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }
}
