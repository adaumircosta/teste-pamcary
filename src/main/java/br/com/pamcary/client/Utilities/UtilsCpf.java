package br.com.pamcary.client.Utilities;

import java.util.InputMismatchException;

public final class UtilsCpf {

	private UtilsCpf() {
	}

	public static class PessoaValidator {

		private static boolean validateCpf(String cpf) {
			if (cpf == null || cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222")
					|| cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555")
					|| cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888")
					|| cpf.equals("99999999999") || (cpf.length() != 11))
				return (false);

			char dig10, dig11;
			int sm, i, r, num, peso;

			try {
				// Calculo do 1o. Digito Verificador
				sm = 0;
				peso = 10;
				for (i = 0; i < 9; i++) {

					num = (int) (cpf.charAt(i) - 48);
					sm = sm + (num * peso);
					peso = peso - 1;
				}

				r = 11 - (sm % 11);
				if ((r == 10) || (r == 11))
					dig10 = '0';
				else
					dig10 = (char) (r + 48);

				// Calculo do 2o. Digito Verificador
				sm = 0;
				peso = 11;
				for (i = 0; i < 10; i++) {
					num = (int) (cpf.charAt(i) - 48);
					sm = sm + (num * peso);
					peso = peso - 1;
				}

				r = 11 - (sm % 11);
				if ((r == 10) || (r == 11))
					dig11 = '0';
				else
					dig11 = (char) (r + 48);

				// Verifica se os digitos calculados conferem com os digitos informados.
				if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10)))
					return (true);
				else
					return (false);
			} catch (InputMismatchException erro) {
				return (false);
			}
		}

		public final static String ValidatePessoaCpf(String cpf){
			if (!validateCpf(cpf))
				return "invalido";

			return "ok";
		}
	}

}