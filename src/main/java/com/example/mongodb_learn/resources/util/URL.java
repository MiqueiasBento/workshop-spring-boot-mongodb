package com.example.mongodb_learn.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

// Classe para decodificar parametro da URL
public class URL {
	
	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {	// Caso o text nao estja no padrao suportado
			return "";
		}
	}
}
