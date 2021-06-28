package br.edu.univas.main;

import java.util.ArrayList;
import java.util.List;

public class No {
    private String nome;
    private float valor;
    private int quantidade;
    private List<No> filhos = new ArrayList<>();
    public static float soma;
    public static List<No> folhas = new ArrayList<>();
    public static List<No> componentes = new ArrayList<>();

    public No(String n, float v, int q, List<No> f) {
        this.filhos = f;
        this.nome = n;
        this.valor = v;
        this.quantidade = q;
    }

    public No(String n) {
        this.nome = n;
    }

    public No(String n, float v, int q) {
        this.nome = n;
        this.valor = v;
        this.quantidade = q;
    }

    public No(String n, int q) {
        this.nome = n;
        this.quantidade = q;
    }

    public No(String n, List<No> f) {
        this.filhos = new ArrayList<>();
        this.nome = n;
    }

    public void acrescentarFilho(No filho) {
        filhos.add(filho);
    }

    public String getNome() {
        return nome;
    }

    public List<No> getFilhos() {
        return filhos;
    }

    public float getValor() {
        return valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public No buscar(String procurado) {
        if (procurado.equals(this.nome))
            return this;
        for (No filho : filhos) {
            No achou = filho.buscar(procurado);
            if (achou != null)
                return achou;
        }
        return null;
    }

    public void valorArvore() {
        if(filhos.size() == 0){
            soma = soma + (quantidade * valor);
        }else {
            for(No filho : filhos){
                if(quantidade > 1 && quantidade != 0){
                    filho.valorArvore(quantidade);
                }else {
                    filho.valorArvore();
                }
            }
        }
    }

    public void valorArvore(int param) {
        if(filhos.size() == 0){
            soma = soma + (quantidade * valor * param);
        }else {
            for(No filho : filhos){
                if(quantidade > 1 && quantidade != 0){
                    filho.valorArvore(quantidade);
                }else {
                    filho.valorArvore();
                }
            }
        }
    }


    public void folhas() {
        if (filhos.size() == 0) {
            if (this != null) {
                folhas.add(this);
            }
        } else {
            for (No filho : filhos) {
                filho.folhas();
            }
        }
    }

    public void componentes(){
        for(No filho : filhos){
            componentes.add(filho);
            if(filho.filhos.size() != 0){
                filho.componentes();
            }
        }
    }
}
