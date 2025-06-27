/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.lpoo.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Jennifer Ebertz
 */
@Entity
@Table(name = "tb_conta")
public class Contas implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_canta", sequenceName = "seq_canta_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_canta", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
     @Column(name="numero",nullable=false, length = 50)
    private String numero;
     
    @JoinColumn(name = "saldo_credito")
    private float saldoCredito;
    
    @JoinColumn(name = "saldo_debito")
    private float saldoDebito;
    
     @Column(name="senha",nullable=false, length = 4)
    private String senha;
     
    @OneToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Clientes proprietario;
    
    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private Tipo_Contas tipoConta;
    
    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionarios gerente;
    
    
    private Agencias Agencia;
    

    public Contas() {
        saldoCredito = 0;
        saldoDebito = 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public float getSaldoCredito() {
        return saldoCredito;
    }

    public void setSaldoCredito(float saldoCredito) {
        this.saldoCredito = saldoCredito;
    }

    public float getSaldoDebito() {
        return saldoDebito;
    }

    public void setSaldoDebito(float saldoDebito) {
        this.saldoDebito = saldoDebito;
    }

    

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Clientes getProprietario() {
        return proprietario;
    }

    public void setProprietario(Clientes proprietario) {
        this.proprietario = proprietario;
    }

    public Tipo_Contas getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(Tipo_Contas tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getGerente() {
        return gerente.getNome();
    }

    public void setGerente(Funcionarios gerente) {
        this.gerente = gerente;
    }

    public String getAgencia() {
        return Agencia.getCodigoA();
    }

    public void setAgencia(Agencias Agencia) {
        this.Agencia = Agencia;
    }

    @Override
    public String toString() {
        return "numero=" + numero + ", Saldo Crédito=" + saldoCredito
                +"Saldo Debito=" + saldoDebito+
                ", proprietario=" + proprietario.getId()+ ", tipo da conta="+tipoConta;
    }
    
    
    
}
