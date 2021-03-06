package br.fpu.tcc.hotelaria.controller.funcionario;

import br.fpu.tcc.hotelaria.controller.BaseController;
import br.fpu.tcc.hotelaria.model.bo.FuncionarioBo;
import br.fpu.tcc.hotelaria.model.bo.exception.BoException;
import br.fpu.tcc.hotelaria.pojo.Funcionario;
import br.fpu.tcc.hotelaria.web.BundleConstants;

public class FuncionarioCreateController extends BaseController {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private FuncionarioBo funcionarioBo;

	private Funcionario funcionario = new Funcionario();

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

	public String showCreate() {

		funcionario = new Funcionario();
		return "/funcionarioCreate?faces-redirect=true";
	}

	public void save() {
		Long id;
		try {
			id = funcionarioBo.save(funcionario);
			System.out.println("id: " + id);
			funcionario = new Funcionario();
			super.addGlobalMessage(BundleConstants.FUNCIONARIO_CADASTRO_SUCESSO);
		} catch (BoException e) {
			super.treatErrorMessage(e, BundleConstants.FUNCIONARIO_CADASTRO_ERRO);
		}
	}

}
