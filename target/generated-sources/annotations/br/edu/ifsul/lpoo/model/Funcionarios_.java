package br.edu.ifsul.lpoo.model;

import br.edu.ifsul.lpoo.model.Agencias;
import br.edu.ifsul.lpoo.model.Contas;
import br.edu.ifsul.lpoo.model.Tipo_Funcionarios;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-06-23T07:12:12", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Funcionarios.class)
public class Funcionarios_ extends Pessoas_ {

    public static volatile SingularAttribute<Funcionarios, Tipo_Funcionarios> tipoFuncionario;
    public static volatile SingularAttribute<Funcionarios, String> senhaF;
    public static volatile ListAttribute<Funcionarios, Contas> contas;
    public static volatile SingularAttribute<Funcionarios, String> nCracha;
    public static volatile SingularAttribute<Funcionarios, Agencias> agencia;

}