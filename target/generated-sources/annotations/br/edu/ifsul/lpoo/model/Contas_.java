package br.edu.ifsul.lpoo.model;

import br.edu.ifsul.lpoo.model.Agencias;
import br.edu.ifsul.lpoo.model.Clientes;
import br.edu.ifsul.lpoo.model.Funcionarios;
import br.edu.ifsul.lpoo.model.Tipo_Contas;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-06-23T07:12:12", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Contas.class)
public class Contas_ { 

    public static volatile SingularAttribute<Contas, String> senha;
    public static volatile SingularAttribute<Contas, Float> saldoDebito;
    public static volatile SingularAttribute<Contas, String> numero;
    public static volatile SingularAttribute<Contas, Clientes> proprietario;
    public static volatile SingularAttribute<Contas, Agencias> Agencia;
    public static volatile SingularAttribute<Contas, Integer> id;
    public static volatile SingularAttribute<Contas, Float> saldoCredito;
    public static volatile SingularAttribute<Contas, Tipo_Contas> tipoConta;
    public static volatile SingularAttribute<Contas, Funcionarios> gerente;

}