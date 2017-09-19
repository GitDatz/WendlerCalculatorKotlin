package com.vdthai.wendlercalculator;

import android.util.Log;

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
        assertTrue(calc.getUnit().equals(" kg"));
        calc.updateUnit();
        assertFalse(calc.getUnit().equals(" kg"));
        assertTrue(calc.getUnit().equals(" lbs"));
        calc.updateUnit();
        assertTrue(calc.getUnit().equals(" kg"));
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
        calc.updateResult();
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

    @Test
    public void week_two_test_normal() throws Exception {
        Calculator calc = new Calculator();
        double[] m_week_weights = calc.calculateWeekTwo(100.0);
        assertTrue(m_week_weights[0] == 70.0);
        assertTrue(m_week_weights[1] == 80.0);
        assertTrue(m_week_weights[2] == 90.0);
    }

    @Test
    public void week_two_test_not_rounded() throws Exception {
        Calculator calc = new Calculator();
        calc.updateResult();
        double[] m_week_weights = calc.calculateWeekTwo(78.0);
        assertTrue(m_week_weights[0] == 54.599999999999994);
        assertTrue(m_week_weights[1] == 62.400000000000006);
        assertTrue(m_week_weights[2] == 70.2);
    }

    @Test
    public void week_two_test_rounded() throws Exception {
        Calculator calc = new Calculator();
        double[] m_week_weights = calc.calculateWeekTwo(78.0);
        assertTrue(m_week_weights[0] == 55.0);
        assertTrue(m_week_weights[1] == 62.5);
        assertTrue(m_week_weights[2] == 70.0);
    }

    @Test
    public void week_three_test_normal() throws Exception {
        Calculator calc = new Calculator();
        double[] m_week_weights = calc.calculateWeekThree(100.0);
        assertTrue(m_week_weights[0] == 75.0);
        assertTrue(m_week_weights[1] == 85.0);
        assertTrue(m_week_weights[2] == 95.0);
    }

    @Test
    public void week_three_test_not_rounded() throws Exception {
        Calculator calc = new Calculator();
        calc.updateResult();
        double[] m_week_weights = calc.calculateWeekThree(89.0);
        assertTrue(m_week_weights[0] == 66.75);
        assertTrue(m_week_weights[1] == 75.64999999999999);
        assertTrue(m_week_weights[2] == 84.55);
    }

    @Test
    public void week_three_test_rounded() throws Exception {
        Calculator calc = new Calculator();
        double[] m_week_weights = calc.calculateWeekThree(89.0);
        assertTrue(m_week_weights[0] == 67.5);
        assertTrue(m_week_weights[1] == 75.0);
        assertTrue(m_week_weights[2] == 85.0);
    }
}