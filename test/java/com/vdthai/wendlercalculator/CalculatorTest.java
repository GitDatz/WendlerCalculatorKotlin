package com.vdthai.wendlercalculator;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Calculator class unit tests.
 */

/**
 * Tests to add:
 * Negative
 */
public class CalculatorTest {
    @Test
    public void change_units_test() throws Exception {
        Calculator calc = new Calculator();
        assertTrue(calc.getUnit() == Unit.KILOGRAMS);
        calc.updateUnit();
        assertFalse(calc.getUnit() == Unit.KILOGRAMS);
        assertTrue(calc.getUnit() == Unit.POUNDS);
        calc.updateUnit();
        assertTrue(calc.getUnit() == Unit.KILOGRAMS);
    }

    @Test
    public void week_one_test_normal() throws Exception {
        Calculator calc = new Calculator();
        double[] m_week_weights = calc.calculateWeekOne(100.0);
        assertTrue(m_week_weights[0] == 65.0);
        assertTrue(m_week_weights[1] == 75.0);
        assertTrue(m_week_weights[2] == 85.0);
    }

    @Test
    public void week_one_test_not_rounded() throws Exception {
        Calculator calc = new Calculator();
        calc.updateUnit();
        double[] m_week_weights = calc.calculateWeekOne(64.0);
        assertTrue(m_week_weights[0] == 41.6);
        assertTrue(m_week_weights[1] == 48.0);
        assertTrue(m_week_weights[2] == 54.4);
    }

    @Test
    public void week_one_test_rounded() throws Exception {
        Calculator calc = new Calculator();
        double[] m_week_weights = calc.calculateWeekOne(64.0);
        assertTrue(m_week_weights[0] == 42.5);
        assertTrue(m_week_weights[1] == 47.5);
        assertTrue(m_week_weights[2] == 55.0);
    }
}