package com.example.dilemme;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ToujoursCoopererTest {

    @Test
    public void testChoisirAction() {
        // Cr�ation de la strat�gie ToujoursCooperer
        ToujoursCooperer strategie = new ToujoursCooperer();
        
        // Appel de la m�thode choisirAction (l'adversaire importe peu ici)
        int action = strategie.choisirAction(null);
        
        // V�rification que la m�thode retourne toujours 1 (coop�rer)
        assertEquals(1, action, "La strat�gie ToujoursCooperer doit toujours retourner 1 (coop�rer)");
    }
}
