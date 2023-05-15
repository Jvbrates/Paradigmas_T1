package biblioteca.cliente.console.formularios.exclusao;

import infra.console.formularios.cadastro.FExclusao;
import infra.console.util.Util;
import infra.negocios.Registros;
import biblioteca.entidades.Emprestimo;

public class FEEmprestimo extends FExclusao<Emprestimo> {
    public FEEmprestimo(Registros<Emprestimo> registros) {
        super(registros);
    }

    @Override
    public void ler() throws Exception{
        int id = Util.lerInteiro("ID emprestimo: ", 0, 1000003);
        Emprestimo e = new Emprestimo();
        e.setId(id);
        setRegistroBusca(e);
    }
}
