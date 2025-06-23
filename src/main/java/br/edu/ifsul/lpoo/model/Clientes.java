/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.lpoo.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Jennifer Ebertz
 */
@Entity
@Table(name = "tb_cliente")
@PrimaryKeyJoinColumn(name = "pessoa_id") 
public class Clientes extends Pessoas{
    
    @Column(nullable=false, length = 50)
    private String Login;
    
    @Column(nullable=false, length = 8)
    private String senhaC;

    public Clientes() {
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getSenha() {
        return senhaC;
    }

    public void setSenha(String senha) {
        this.senhaC = senha;
    }

    @Override
    public String toString() {
        return super.toString() + ", Login=" + Login + '}';
    }
    
    
}
