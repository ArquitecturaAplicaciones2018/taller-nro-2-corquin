package taller2_v1;

import java.util.List;

public class Resolucion {
	public static void main(String[] args) {
		final Rational ZERO = new Rational(0, 1);

		/*
		 * conjunto de datos racionales
		 */
		var rationals = List.of(new Rational(1, 4), new Rational(1, 8), new Rational(3, 4), new Rational(7, 8));

		/*
		 * Racionales menor que 1/2
		 */
		var unMedio = new Rational(1, 2);
		System.out.println("Numeros racionales menor que 1/2:");
		for (Rational r : rationals) {
			if (r.isLessThan(unMedio)) {
				System.out.println(r);
			}
		}
		System.out.println("*****");
		rationals.stream().filter(r -> r.isLessThan(unMedio)).forEach(System.out::println);

		/*
		 * Sumar todos los racionales
		 */
		System.out.println("\nSuma de los racionales:");
		var suma = ZERO;
		for (Rational r : rationals) {
			suma = r.plus(suma);
		}
		System.out.println(suma);
		System.out.println("*****");
		suma = rationals.stream().reduce(ZERO, (x, y) -> x.plus(y));
		System.out.println(suma);

		/*
		 * Obtener el número racional mayor
		 */
		System.out.println("\nEl número racional mayor:");
		var mayor = ZERO;
		for (Rational r : rationals) {
			mayor = r.getGreater(mayor);
		}
		System.out.println(mayor);
		System.out.println("*****");
		mayor = rationals.stream().reduce(ZERO, (x, y) -> x.getGreater(y));
		System.out.println(mayor);

		/*
		 * Sumar todos numeradores y obtener los siguientes datos: número de elementos,
		 * la suma de los numeradores, el numerador menor, el mayor y el promedio
		 */
		var elem = 0;
		System.out.println("\nNumero de elementos:");
		elem = rationals.size();
		System.out.println(elem);
		System.out.println("*****");
		elem = (int) rationals.stream().count();
		System.out.println(elem);

		System.out.println("\nSuma de numeradores:");
		var sumaNum = 0;
		for (Rational r : rationals) {
			sumaNum = sumaNum + r.getNumerator();
		}
		System.out.println(sumaNum);
		System.out.println("*****");
		sumaNum = 0;
		sumaNum = rationals.stream().map(r -> r.getNumerator()).reduce(sumaNum, Integer::sum);
		// sumaNum = rationals.stream().collect(summingInt(r -> r.getNumerator()));
		System.out.println(sumaNum);

		System.out.println("\nNumerador menor:");
		var menorNum = 99999;
		for (Rational r : rationals) {
			var temp = r.getNumerator();
			if (temp < menorNum) {
				menorNum = temp;
			}
		}
		System.out.println(menorNum);
		System.out.println("*****");
		menorNum = rationals.stream().mapToInt(Rational::getNumerator).min().getAsInt();
		System.out.println(menorNum);

		System.out.println("\nNumerador mayor:");
		var mayorNum = -99999;
		for (Rational r : rationals) {
			var temp = r.getNumerator();
			if (temp > mayorNum) {
				mayorNum = temp;
			}
		}
		System.out.println(mayorNum);
		System.out.println("*****");
		mayorNum = rationals.stream().mapToInt(Rational::getNumerator).max().getAsInt();
		System.out.println(mayorNum);

		System.out.print("\nPromedio de los numerador:\t");
		System.out.println(sumaNum / elem);
	}
}
