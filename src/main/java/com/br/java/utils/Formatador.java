package com.br.java.utils;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Formatador {

	public String FormatCpf(String Cpf) {
		String cpfCompleto = leftPad(Cpf, 11, '0');
		return cpfCompleto.substring(0, 3) + "." + cpfCompleto.substring(3, 6) + "." + cpfCompleto.substring(6, 9) + "-"
				+ cpfCompleto.substring(9, 11);
	}

	public String LimparCpf(String Cpf) {
		return Cpf.replaceAll("[^\\d ]", "");

	}

	public static String leftPad(String texto, Integer tamanho, Character caracter) {
		if (texto.length() < tamanho) {
			StringBuilder sb = new StringBuilder(texto);
			for (int cont = 0; cont < (tamanho - texto.length()); cont++) {
				sb.insert(0, caracter);
			}
			return sb.toString();
		}
		return texto;
	}

}
