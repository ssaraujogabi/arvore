package Estrutura_2;

public class InvalidPositionException extends Exception {
    private String msg;

    public InvalidPositionException(String msg){
        super(msg);
        this.msg = msg;
    }
}
