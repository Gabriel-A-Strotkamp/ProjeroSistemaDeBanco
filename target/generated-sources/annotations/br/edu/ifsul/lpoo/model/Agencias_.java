package br.edu.ifsul.lpoo.model;

import br.edu.ifsul.lpoo.model.Funcionarios;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-06-27T11:33:51", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Agencias.class)
public class Agencias_ { 

    public static volatile SingularAttribute<Agencias, String> endereco;
    public static volatile SingularAttribute<Agencias, String> nome;
    public static volatile SingularAttribute<Agencias, Integer> id;
    public static volatile ListAttribute<Agencias, Funcionarios> funcionarios;
    public static volatile SingularAttribute<Agencias, String> codigoA;

}