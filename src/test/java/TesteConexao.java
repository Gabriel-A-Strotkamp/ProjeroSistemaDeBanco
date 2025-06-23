/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import br.edu.ifsul.lpoo.control.PersistenciaJPA;
import br.edu.ifsul.lpoo.model.Agencias;
import br.edu.ifsul.lpoo.model.Funcionarios;
import br.edu.ifsul.lpoo.model.Tipo_Funcionarios;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 20221PF.CC0008
 */
public class TesteConexao {
    
    public TesteConexao() {
    }
    
   private PersistenciaJPA jpa;
@Before
public void setUp() {
	jpa = new PersistenciaJPA();
	System.out.println("Iniciando teste de conexão...");
}

@After
public void tearDown() {
	if (jpa != null && jpa.conexaoAberta()) {
		jpa.fecharConexao();
		System.out.println("Conexão fechada com sucesso.");
	}
}

@Test
public void testeConexaoAberta() {
	assertNotNull("Instância JPA não pode ser nula", jpa);
	assertTrue("A conexão deveria estar aberta", jpa.conexaoAberta());
	System.out.println("Conexão aberta com sucesso!");
}

@Test
    public void cadastroFuncionario(){
        try {
            Funcionarios f = new Funcionarios();
            f.setCpf("04242596057");
            f.setEndereco("Rua das oliveiras, nº 04");
            f.setNome("Gabriel");
            f.setSenha("0011");
            f.setTelefone("54996692902");
            f.setTipoFuncionario(Tipo_Funcionarios.Supervisor);
            f.setnCracha("007");
            jpa.persist(f);
            System.out.println("Bem Sucedido");
        } catch (Exception ex) {
            System.err.println("Erro ao persistir Funcionário: "+ex);   
        }
       
    }

}
