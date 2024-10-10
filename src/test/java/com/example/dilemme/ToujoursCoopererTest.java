package com.example.dilemme;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ToujoursCoopererTest {

    @Test
    public void testChoisirAction() {
        // Création de la stratégie ToujoursCooperer
        ToujoursCooperer strategie = new ToujoursCooperer();
        
        // Appel de la méthode choisirAction (l'adversaire importe peu ici)
        int action = strategie.choisirAction(null);
        
        // Vérification que la méthode retourne toujours 1 (coopérer)
        assertEquals(1, action, "La stratégie ToujoursCooperer doit toujours retourner 1 (coopérer)");
    }
}
