package DuoBank.DuoBank.domains.response;

public class ResponseReturn {

    private int code;
    private String customMessage;
    private Object data;

    public ResponseReturn(){

    }
    public ResponseReturn(int code, String customMessage, Object data){
        this.code=code;
        this.customMessage=customMessage;
        this.data=data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getCustomMessage() {
        return customMessage;
    }

    public void setCustomMessage(String customMessage) {
        this.customMessage = customMessage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
