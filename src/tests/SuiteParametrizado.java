package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * El runner que vamos a utilizar es Suite.
 */
@RunWith(value = Suite.class)
/**
 * Como parametro vamos a pasar todas la pruebas que vamos a ejecutar.
 */
@Suite.SuiteClasses({
        SecretarioTestParametrizado.class
       
})
/**
 * Nos va a permitir ejecutar varias prubas a la vez.
 */

public class SuiteParametrizado {

}
