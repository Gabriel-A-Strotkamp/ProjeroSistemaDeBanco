/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.lpoo.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Jennifer Ebertz
 */
@Entity
@Table(name = "tb_funcionario")
@PrimaryKeyJoinColumn(name = "pessoa_id")
public class Funcionarios extends Pessoas{
    
    @Column(nullable=false, length = 8)
    private String senhaF;
    
    @Column(name="nCracha",nullable=false, length = 10)
    private String nCracha;
     
    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private Tipo_Funcionarios tipoFuncionario;
    
    
    @OneToMany(mappedBy = "gerente")
    private List<Contas> contas;
    
    @ManyToOne
    @JoinColumn(name = "agencia_id")
    private Agencias agencia;
    
    public Funcionarios() {
    }

    
    public String getSenha() {
        return senhaF;
    }

    public void setSenha(String senha) {
        this.senhaF = senha;
    }

    public String getnCracha() {
        return nCracha;
    }

    public void setnCracha(String nCracha) {
        this.nCracha = nCracha;
    }

    public Tipo_Funcionarios getTipoFuncionario() {
        return tipoFuncionario;
    }

    public void setTipoFuncionario(Tipo_Funcionarios tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
    }

    public List<Contas> getContas() {
        return contas;
    }

    public void addContas(Contas c) {
        contas.add(c);
    }
    
     public void removeContas(Contas c) {
        contas.remove(c);
    }

    @Override
    public String toString() {
        return super.toString() + ", Cracha=" + nCracha + ", Cargo=" + tipoFuncionario;
    }
    
}
