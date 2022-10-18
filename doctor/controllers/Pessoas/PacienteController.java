package controllers.Pessoas;

import utils.functionSQL;

public class PacienteController {
  public void gerenciarCadastro() {

    functionSQL fSql = new functionSQL();

    fSql.crudTexts("paciente");
  }
}
