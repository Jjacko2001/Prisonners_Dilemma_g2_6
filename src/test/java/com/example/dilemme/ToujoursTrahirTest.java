package com.example.dilemme;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ToujoursTrahirTest {

    @Test
    public void testChoisirAction() {
        // Cr�ation de la strat�gie ToujoursTrahir
        ToujoursTrahir strategie = new ToujoursTrahir();
        
        // Appel de la m�thode choisirAction (peu importe l'adversaire ici)
        int action = strategie.choisirAction(null);
        
        // V�rification que la m�thode retourne toujours 2 (trahir)
        assertEquals(2, action, "La strat�gie ToujoursTrahir doit toujours retourner 2 (trahir)");
    }
}
