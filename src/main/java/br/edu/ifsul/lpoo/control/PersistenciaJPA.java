package br.edu.ifsul.lpoo.control;

import br.edu.ifsul.lpoo.model.Agencias;
import br.edu.ifsul.lpoo.model.Clientes;
import br.edu.ifsul.lpoo.model.Contas;
import br.edu.ifsul.lpoo.model.Funcionarios;
import java.util.List; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

// Assumindo que InterfaceBD existe e define os métodos implementados
public class PersistenciaJPA implements InterfaceBD {

    private EntityManagerFactory factory;
    private EntityManager entity; // Renomeado para 'entity' para clareza

    public PersistenciaJPA() {
        // O nome da unidade de persistência deve ser o mesmo que você configurou no seu persistence.xml
        factory = Persistence.createEntityManagerFactory("pu_Sistema_Banco_lpoo2025");
        entity = factory.createEntityManager(); // Inicializa o EntityManager aqui
    }

    // Método para verificar se a conexão está aberta
    @Override
    public Boolean conexaoAberta() {
        // Usa o getter para garantir que o EntityManager está válido
        return getEntityManager() != null && getEntityManager().isOpen();
    }

    // Método para fechar a conexão com o banco de dados
    @Override
    public void fecharConexao() {
        // Fecha o EntityManager e o EntityManagerFactory
        if (entity != null && entity.isOpen()) {
            entity.close();
        }
        if (factory != null && factory.isOpen()) {
            factory.close();
        }
    }

    // Método para buscar uma entidade pelo tipo e ID
    @Override
    public Object find(Class c, Object id) throws Exception {
        EntityManager currentEntity = getEntityManager(); // Obtém o EntityManager atual
        return currentEntity.find(c, id);
    }

    /**
     * Método para persistir (salvar ou atualizar) um objeto no banco de dados.
     * Inclui gerenciamento de transação (begin, commit, rollback).
     * Usa 'merge' para lidar com entidades novas e desanexadas.
     * @param o O objeto a ser persistido ou atualizado.
     * @throws Exception Se ocorrer um erro durante a persistência.
     */
    @Override
    public void persist(Object o) throws Exception {
        EntityManager currentEntity = getEntityManager(); // Obtém o EntityManager atual para a operação
        try {
            currentEntity.getTransaction().begin(); // Inicia a transação
            // Usa merge para persistir novos objetos ou atualizar objetos desanexados.
            // merge retorna a instância gerenciada, que é a que estará no contexto de persistência.
            currentEntity.merge(o);
            currentEntity.getTransaction().commit(); // Comita a transação (salva as alterações)
            Logger.getLogger(PersistenciaJPA.class.getName()).log(Level.INFO, "Objeto persistido com sucesso: {0}", o.getClass().getSimpleName());
        } catch (Exception e) {
            // Se houver um erro e a transação estiver ativa, faz rollback
            if (currentEntity.getTransaction().isActive()) {
                currentEntity.getTransaction().rollback();
            }
            Logger.getLogger(PersistenciaJPA.class.getName()).log(Level.SEVERE, "Erro ao persistir: " + o.getClass().getSimpleName(), e);
            throw e; // Relança a exceção para que quem chamou possa tratá-la
        }
    }

    /**
     * Método para remover um objeto do banco de dados.
     * Inclui gerenciamento de transação (begin, commit, rollback).
     * @param o O objeto a ser removido.
     * @throws Exception Se ocorrer um erro durante a remoção.
     */
    @Override
    public void remover(Object o) throws Exception {
        EntityManager currentEntity = getEntityManager(); // Obtém o EntityManager atual
        try {
            currentEntity.getTransaction().begin(); // Inicia a transação
            // Garante que a entidade está gerenciada antes de tentar remover
            if (!currentEntity.contains(o)) {
                o = currentEntity.merge(o); // Se não estiver gerenciada, mescla para torná-la gerenciada
            }
            currentEntity.remove(o); // Remove a entidade gerenciada
            currentEntity.getTransaction().commit(); // Comita a transação
            Logger.getLogger(PersistenciaJPA.class.getName()).log(Level.INFO, "Objeto removido com sucesso: {0}", o.getClass().getSimpleName());
        } catch (Exception e) {
            if (currentEntity.getTransaction().isActive()) {
                currentEntity.getTransaction().rollback(); // Em caso de erro, faz rollback
            }
            Logger.getLogger(PersistenciaJPA.class.getName()).log(Level.SEVERE, "Erro ao remover: " + o.getClass().getSimpleName(), e);
            throw e;
        }
    }

    /**
     * Getter para o EntityManager. Garante que um EntityManager esteja sempre aberto.
     * Cria um novo EntityManager se o existente for nulo ou estiver fechado.
     * @return O EntityManager atual.
     */
    public EntityManager getEntityManager() {
        if (entity == null || !entity.isOpen()) {
            entity = factory.createEntityManager(); // Cria um novo EntityManager se necessário
        }
        return entity;
    }
    
    /**
     * Método para buscar funcionários no banco de dados.
     * Garante que a consulta seja do tipo Funcionarios.
     * @return Uma lista de objetos Funcionarios ou null em caso de erro.
     */
    public List<Funcionarios> getFuncionarios() {
        EntityManager currentEntity = getEntityManager();
        try {
            TypedQuery<Funcionarios> query = currentEntity.createQuery("SELECT f FROM Funcionarios f", Funcionarios.class);
            return query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(PersistenciaJPA.class.getName()).log(Level.SEVERE, "Erro ao buscar Funcionarios", e);
            return null;
        }
    }
    
        public List<Clientes> getClientes() {
        EntityManager currentEntity = getEntityManager();
        try {
            TypedQuery<Clientes> query = currentEntity.createQuery("SELECT c FROM Clientes c", Clientes.class);
            return query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(PersistenciaJPA.class.getName()).log(Level.SEVERE, "Erro ao buscar Cliente", e);
            return null; 
        }
    }
        
           public List<Contas> getContas() {
        EntityManager currentEntity = getEntityManager(); 
        try {
            
            TypedQuery<Contas> query = currentEntity.createQuery("SELECT c FROM Contas c", Contas.class);
            return query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(PersistenciaJPA.class.getName()).log(Level.SEVERE, "Erro ao buscar Conta", e);
            return null; 
        }
       
    }
           
       public List<Funcionarios> getFuncionarios(String nome) {
        entity = getEntityManager();

        try {
            TypedQuery<Funcionarios> query
                    = entity.createQuery("Select f from Funcionarios f where lower(f.nome) LIKE :n",
                            Funcionarios.class);
            query.setParameter("n", "%" + nome.toLowerCase() + "%");
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar Funcionario: " + e);
            return null;
        }

    }
       
       public List<Agencias> getAgencias() {
        EntityManager currentEntity = getEntityManager();
        try {
            TypedQuery<Agencias> query = currentEntity.createQuery("SELECT a FROM Agencias a", Agencias.class);
            return query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(PersistenciaJPA.class.getName()).log(Level.SEVERE, "Erro ao buscar Agencia", e);
            return null; 
        }
    }
}