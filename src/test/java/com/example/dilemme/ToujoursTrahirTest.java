package com.example.dilemme;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ToujoursTrahirTest {

    @Test
    public void testChoisirAction() {
        // Création de la stratégie ToujoursTrahir
        ToujoursTrahir strategie = new ToujoursTrahir();
        
        // Appel de la méthode choisirAction (peu importe l'adversaire ici)
        int action = strategie.choisirAction(null);
        
        // Vérification que la méthode retourne toujours 2 (trahir)
        assertEquals(2, action, "La stratégie ToujoursTrahir doit toujours retourner 2 (trahir)");
    }
}
