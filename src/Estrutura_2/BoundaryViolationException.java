package Estrutura_2;

public class BoundaryViolationException extends Exception{
    private String msg;

    public BoundaryViolationException(String msg){
        super(msg);
        this.msg = msg;
    }
}
