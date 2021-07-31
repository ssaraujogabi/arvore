package Estrutura_2;

public interface InterfaceArvoreBinaria <T>{
    int tamanho();

    boolean estaVazia();

    boolean eInterno(No no) throws InvalidPositionException;
}
