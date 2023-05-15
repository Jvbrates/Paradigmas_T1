package biblioteca.negocio;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import biblioteca.entidades.Emprestimo;
import biblioteca.entidades.Exemplar;
import infra.console.util.Util;

import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.concurrent.TimeUnit;

public class teste {
    public static <LocalDateTime> void main(String[] args) throws Exception {
        /*java.util.Date b = new java.util.Date();
        Date a = new Date(b.getTime());
        System.out.println(a.getClass().getTypeName());

        Emprestimos emprestimos = new Emprestimos();
        Emprestimo emp = new Emprestimo();
        emp.setId_user(3);


        emp.setId_exemplar(4);
        emp.setData_devolucao(a);
        emprestimos.inserir(emp);

        emp.setId(0);

        emp.setId_exemplar(2);
        emp.setData_devolucao(a);
        emprestimos.inserir(emp);
        emp.setId(0);

        emp.setId_exemplar(5);
        emp.setData_devolucao(a);
        emprestimos.inserir(emp);
*/
        String dataString = "22/08/2022";
        java.text.DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date data22 = new java.sql.Date(fmt.parse(dataString).getTime());
        java.sql.Date data23 = new java.sql.Date(fmt.parse("23/08/2022").getTime());


        System.out.println(Util.diffDays(data22, data23));
        System.out.println(Util.diffDays(data23, data22));

    }
}
