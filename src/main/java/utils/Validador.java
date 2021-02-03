package utils;

import java.util.HashMap;
import java.util.InputMismatchException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.cadastro.model.Cliente;
import com.teste.cadastro.repository.ClienteRepository;

@Service
public class Validador {
	
	@Autowired
	static
	ClienteRepository clienteRepository;

	@SuppressWarnings("deprecation")
	public static HashMap<String, String> IsValido(Cliente cliente) {
		HashMap<String, String> aceito = new HashMap<String, String>();
		if (cliente.getNome().length() > 10)
			aceito.put("nome_valid", "");
		else
			aceito.put("nome_valid", "O nome deve ter mais que dez caracteres");

		if (ValidaCPF(cliente.getCpf()))
//			if (clienteRepository.findCPF(cliente.getCpf()).size() == 0)
				aceito.put("cpf_valid", "");
//			else
//				aceito.put("cpf_valid", "CPF Já cadastrado");
		else
			aceito.put("cpf_valid", "CPF Informado é invalido");

		if (!(cliente.getDta_nasc() == null)) {
			if (cliente.getDta_nasc().getDate() == 0)
				aceito.put("dta_nasc_valid", "Data informada invalida");
			else
				aceito.put("dta_nasc_valid", "");
		} else
			aceito.put("dta_nasc_valid", "Erro na validação da data, informe novamente");

		if (cliente.getEmail().contains("@"))
			aceito.put("email_valid", "");
		else
			aceito.put("email_valid", "Email informado invalido");

		if ((aceito.get("nome_valid").length() == 0) && (aceito.get("cpf_valid").length() == 0)
				&& (aceito.get("dta_nasc_valid").length() == 0) && (aceito.get("email_valid").length() == 0))
			aceito.put("valido", "1");
		else
			aceito.put("valido", "0");

		return aceito;
	}

	private static boolean ValidaCPF(String CPF) {

		CPF = CPF.replace(".", "");
		CPF = CPF.replace("-", "");

		if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222")
				|| CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555")
				|| CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888")
				|| CPF.equals("99999999999") || (CPF.length() != 11))
			return (false);

		char dig10, dig11;
		int sm, i, r, num, peso;

		try {
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48);

			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
				return (true);
			else
				return (false);
		} catch (InputMismatchException erro) {
			return (false);
		}
	}

}
