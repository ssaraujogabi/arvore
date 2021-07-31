package Estrutura_2;

import java.io.Serializable;

public class Arvore<T> implements InterfaceArvoreBinaria<T>, Serializable {
    private No raiz;
    private int totalElementos;
    private int aux = -1;

    @Override
    public int tamanho() {
        return this.totalElementos;
    }

    @Override
    public boolean estaVazia() {
        return raiz==null;
    }

    @Override
    public boolean eInterno(No no) throws InvalidPositionException {
        if (!temDireita(no)||!temEsquerda(no)){
            return true;
        }
        return false;
    }

    public boolean isRaiz(No no){
        if(no.equals(this.raiz)){
            return true;
        }
        return false;
    }
    public boolean temEsquerda(No no) {
        if (no.getEsq()!=null){
            return true;
        }
        return false;
    }
    public boolean temDireita(No no) {
        if (no.getDir()!=null){
            return true;
        }
        return false;
    }

    public No raiz() throws ArvoreVaziaException {
        if (this.raiz!=null){
            return this.raiz;
        }
        throw new ArvoreVaziaException("Árvore vazia!");
    }

    public No noEsquerda(No no) throws BoundaryViolationException {
        if(!temEsquerda(no)){
            return no.getEsq();
        }
        throw new BoundaryViolationException("Não tem filho esquerdo!");
    }
    public No noDireito(No no) throws BoundaryViolationException {
        if(!temDireita(no)){
            return no.getDir();
        }
        throw new BoundaryViolationException("Não tem filho esquerdo!");
    }
//    public Estrutura_2.No noPai(Estrutura_2.No no) throws Estrutura_2.BoundaryViolationException{
//        if (!isRaiz(no)){
//            return no.getPai();
//        }
//        throw new Estrutura_2.BoundaryViolationException("Raiz");
//    }

    public void emOrdem(ArvorePrint aPrint){
        emOrdem(raiz, aPrint);
    }
    private void emOrdem(No no, ArvorePrint aPrint){
        if(no!= null){
            emOrdem(no.getEsq(), aPrint);
            //System.out.println(no.getInfo());
            if (aPrint.print(no.getInfo())) {
                emOrdem(no.getDir(), aPrint);
            }
        }
    }

    public void inserir(T i){
        if(estaVazia()){
            raiz= new No();
            raiz.setInfo((Comparable) i);
            totalElementos++;
        } else {
            inserir(raiz, i);
        }
    }
    private No inserir(No no, T i){
        if (no.getInfo().compareTo(i) < 0){
            if (no.getDir() == null){
                No novo = new No((Comparable) i);
                no.setDir(novo);
//                novo.setPai(no);
                this.totalElementos++;
            } else {
                inserir(no.getDir(), i);
            }
        } else {
            if (no.getEsq() == null) {
                No novo = new No((Comparable) i);
                no.setEsq(novo);
//                novo.setPai(no);
                this.totalElementos++;
            } else {
                inserir(no.getEsq(), i);
            }
        }
        return no;
    }

    public void inserirEsq(No no, T i){
        No novo = new No((Comparable) i);
        no.setEsq(novo);
//        novo.setPai(no);
        this.totalElementos++;
    }

    public void inserirDir(No no, T i){
        No novo = new No((Comparable) i);
        no.setDir(novo);
//        novo.setPai(no);
        this.totalElementos++;
    }

    public void inserirEsqTroca(No no, T i){
        No novoPergunta = new No((Comparable) i);
        inserirEsq(no, (T) no.getInfo());
        no.setInfo(novoPergunta.getInfo());
        this.totalElementos++;
    }

    public boolean contem(T i){
        if (raiz.getInfo().equals(i)){
            return true;
        } else {
            aux = -1;
            contem(raiz, i).equals(i);
            if(aux==0){
                return true;
            }
            return false;
        }
    }
    private No contem(No no, T i){
        if(no!=null){
            if(no.getInfo().compareTo(i) < 0) {
                if (no.getInfo().equals(i)) {
                    aux=0;
                } else {
                    contem(no.getDir(), i);
                }
            } else {
                if (no.getInfo().equals(i)) {
                    aux=0;
                } else {
                    contem(no.getEsq(), i);
                }
            }
        }
        return no;
    }

//    StringBuilder builder = new StringBuilder();
//    public void exibir(){
//        if (this.totalElementos == 0){
//            builder.append("()");
//            System.out.println(builder);
//        } else {
//            exibir(raiz);
//            System.out.println(builder);
//        }
//    }
//    private void exibir(Estrutura_2.No no){
//        if(no!= null){
//            builder.append(no.getInfo()+"");
//            builder.append("(");
//            exibir(no.getEsq());
//            exibir(no.getDir());
//            builder.append(")");
//        }
//    }

    public String exibirAtual(No no){
        return no.toString();
    }

}
