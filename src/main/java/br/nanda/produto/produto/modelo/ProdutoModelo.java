package br.nanda.produto.produto.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Entity - Criando tabela ProdutoModelo
@Entity
//Renomeando tabela
@Table(name = "Produtos")
public class ProdutoModelo {
    
    //Variaveis a receber e enviar do banco codigo, nome, valor
    //Column - Renomeando as colunas
    //ID - Idenificando como chave primária "codigo"
    //GenerationType.IDENTITY - Colocando auto incremento

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;

    @Column(name = "nome")
    private String nome;
    
    @Column(name = "valor")
    private double valor;

    //getters e setters
    public int getCodigo(){
        return codigo;
    }
    public void setCodigo (int codigo){
        this.codigo = codigo;
    }
    public String getNome(){
        return nome;
    }
    public void setNome (String nome){
        this.nome = nome;
    }
    public double getValor(){
        return valor;
    }
    public void setValor (double valor){
        this.valor = valor;
    }
}
