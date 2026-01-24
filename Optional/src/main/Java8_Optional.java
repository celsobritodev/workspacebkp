package main;

import java.util.Optional;
import java.util.stream.Stream;


public class Java8_Optional {

	public static void main(String[] args) {

	//String s = "opt";
	//	String s = "x1";
    //    Integer numero;   
	//	numero = converteEmNumero(s).
	//			orElseThrow(()-> new NullPointerException("Valor vazio"));
	//	System.out.println(numero);
		
		
		Stream.of(1,2,3).findFirst().ifPresent(n->System.out.println(n));
		
		
	}

	public static Optional<Integer> converteEmNumero(String numeroStr) {
		try {
			Integer integer = Integer.valueOf(numeroStr);
			return Optional.of(integer);
		} catch (Exception e) {
			return Optional.empty();
		}

	}

}
