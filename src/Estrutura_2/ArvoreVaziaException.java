package Estrutura_2;

public class ArvoreVaziaException extends Exception{
    private String msg;

    public ArvoreVaziaException(String msg){
        super(msg);
        this.msg = msg;
    }
}
