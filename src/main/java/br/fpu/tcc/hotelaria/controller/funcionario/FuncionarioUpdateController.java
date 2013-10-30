package br.fpu.tcc.hotelaria.controller.funcionario;

import br.fpu.tcc.hotelaria.controller.BaseController;
import br.fpu.tcc.hotelaria.model.bo.FuncionarioBo;
import br.fpu.tcc.hotelaria.model.bo.exception.BoException;
import br.fpu.tcc.hotelaria.pojo.Funcionario;
import br.fpu.tcc.hotelaria.web.BundleConstants;
import br.fpu.tcc.hotelaria.web.QueryStringConstants;

public class FuncionarioUpdateController extends BaseController {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private FuncionarioBo funcionarioBo;

	private Funcionario funcionario = new Funcionario();

	private boolean hasNoError = true;

	public FuncionarioBo getFuncionarioBo() {
		return funcionarioBo;
	}

	public void setFuncionarioBo(FuncionarioBo funcionarioBo) {
		this.funcionarioBo = funcionarioBo;
	}

	public Funcionario getFuncionario() {

		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {

		this.funcionario = funcionario;
	}

	public boolean isHasNoError() {
		return hasNoError;
	}

	public void loadFuncionario() {

		if (funcionario == null || funcionario.getId() == null) {

			try {
				Long idFuncionario = Long.parseLong(super.getQueryStringParam(QueryStringConstants.ID_FUNCIONARIO));
				funcionario = funcionarioBo.findByPrimarykey(idFuncionario);

				if (funcionario == null) {
					throw new BoException("Funcionário não encontrado.");
				}

				hasNoError = true;
			} catch (BoException e) {
				super.treatErrorMessage(e, BundleConstants.FORMULARIO_EDICAO_ERRO);
				hasNoError = false;
			}
		}
	}

	public String update() {

		try {
			funcionarioBo.update(funcionario);
			super.addGlobalMessage(BundleConstants.FUNCIONARIO_CADASTRO_SUCESSO);
			return "/funcionarioSearch?faces-redirect=true";
		} catch (BoException e) {
			super.treatErrorMessage(e, BundleConstants.FUNCIONARIO_CADASTRO_ERRO);
		}

		return null;
	}

	public void changePassword() {

	}
}
