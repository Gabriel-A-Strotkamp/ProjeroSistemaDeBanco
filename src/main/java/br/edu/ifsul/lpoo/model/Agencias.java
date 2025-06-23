/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.lpoo.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 *
 * @author Jennifer Ebertz
 */
@Entity
@Table(name = "tb_agencia")
public class Agencias implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_agencia", sequenceName = "seq_agencia_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_agencia", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name="nomeAgencia",nullable=false, length = 100)
    private String nome;
    
    @Column(name="numero",nullable=false, length = 50)
    private String codigoA;
    
     @Column(name="endereco",nullable=false, length = 50)
    private String endereco;
     
    @OneToMany(mappedBy = "agencia")
    private List<Funcionarios> funcionarios;

    public Agencias() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoA() {
        return codigoA;
    }

    public void setCodigoA(String codigoA) {
        this.codigoA = codigoA;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Funcionarios> getFuncionarios() {
        return funcionarios;
    }

    public void addFuncionarios(Funcionarios f) {
        funcionarios.add(f);
    }
    public void removeFuncionarios(Funcionarios f) {
        funcionarios.remove(f);
    }

    @Override
    public String toString() {
        return "nome=" + nome + ", codigo=" + codigoA;
    }
    
    
}
