package taller2_v1;

import static org.junit.Assert.*;

import org.junit.Test;

public class RationalTest {

	public RationalTest() {
		// TODO Auto-generated constructor stub
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructorTest() {
		Rational r = new Rational(3, 0);
	}

	@Test
	public void toStringTest() {
		Rational r = new Rational(1, 2);
		assertEquals("Se espera: ", "1/2", r.toString());
	}
	
	Rational r1 = new Rational(1, 4);
	Rational r2 = new Rational(3, 4);
	
	@Test
	public void isLessThanTest() {
		assertEquals("1/4 = 0.25 es menor que 3/4 = 0.75  : ", true, r1.isLessThan(r2));
	}	
	
	@Test
	public void getGreaterTest() {
		assertEquals("el mayor entre 1/4 y 3/4 es: ", "3/4", r1.getGreater(r2).toString());
	}
	
	@Test
	public void plusTest() {
		assertEquals("la suma debe dar el numerador: ", 1, r1.plus(r2).getNumerator());
		assertEquals("la suma debe dar el denominador: ", 1, r1.plus(r2).getDenominator());
	}
	
	@Test
	public void minusTest() {
		assertEquals("la resta debe dar el numerador: ", 1, r1.minus(r2).getNumerator());
		assertEquals("la resta debe dar el denominador: ", -2, r1.minus(r2).getDenominator());
	}
	
	@Test
	public void timesTest() {
		assertEquals("la multiplicacion entre 1/4 y 3/4 es: ", "3/16", r1.times(r2).toString());
	}
	
	@Test
	public void dividesTest() {
		assertEquals("la division entre 1/4 y 3/4 es: ", "1/3", r1.divides(r2).toString());
	}
}
