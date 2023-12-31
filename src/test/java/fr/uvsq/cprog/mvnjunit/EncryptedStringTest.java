package fr.uvsq.cprog.mvnjunit;

import junit.framework.TestCase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class EncryptedStringTest extends TestCase {

   
    

    @Test
    public void testEncryptNullString() {
        // Teste le chiffrement d'une chaîne null.
        EncryptedString string = EncryptedString.encrypt(null, 3);
        String encryptedString = string.encrypt();
        assertNull(encryptedString);
    }

    @Test
    public void testEncryptMethod() {
        // Teste la méthode de chiffrement d'une chaîne.
        EncryptedString string = EncryptedString.encrypt("HELLO", 3);
        assertEquals("KHOOR", string.encrypt());
    }


    @Test
    public void testDecryptEmptyStringWithZeroOffset() {
        // Teste le déchiffrement d'une chaîne vide avec un décalage nul.
        EncryptedString string = EncryptedString.decrypt("", 0);
        String decryptedString = string.decrypt();
        assertEquals("", decryptedString);
    }

    @Test
    public void testDecryptStringWithSpecialCharacters() {
        // Teste le déchiffrement d'une chaîne contenant des caractères spéciaux.
        EncryptedString string = EncryptedString.decrypt("B#C&D", 1);
        String decryptedString = string.decrypt();
        assertEquals("A#B&C", decryptedString);
    }

    @Test
    public void testDecryptMethod() {
        // Teste la méthode de déchiffrement d'une chaîne.
        EncryptedString string = EncryptedString.decrypt("EBIIL", 3);
        assertEquals("BYFFI", string.decrypt()); // Le décalage est ajusté à 3 pour obtenir "BYFFI"
    }
    

    @Test
    public void testEncryptEmptyStringWithZeroOffset() {
        // Teste le chiffrement d'une chaîne vide avec un décalage nul.
        EncryptedString string = EncryptedString.encrypt("", 0);
        String encryptedString = string.encrypt();
        assertEquals("", encryptedString);
    }

    
    @Test
public void testEncryptStringWithPositiveOffset() {
    // Teste le chiffrement d'une chaîne avec un décalage positif.
    EncryptedString string = EncryptedString.encrypt("HELLO", 3);
    String encryptedString = string.encrypt();
    assertEquals("KHOOR", encryptedString);
}


@Test
public void testEncryptMethodWithOffsetGreaterThan26() {
    // Teste le chiffrement d'une chaîne avec un décalage supérieur à 26 (mod 26).
    EncryptedString string = EncryptedString.encrypt("HELLO", 30);
    assertEquals("LIPPS", string.encrypt()); // L'offset est ajusté à 4 pour rester dans l'alphabet
}


    @Test
    public void testEncryptNonEmptyStringWithZeroOffset() {
        // Teste le chiffrement d'une chaîne non vide avec un décalage nul.
        EncryptedString string = EncryptedString.encrypt("HELLO", 0);
        String encryptedString = string.encrypt();
        assertEquals("HELLO", encryptedString);
    }

    

    @Test
    public void testEncryptStringWithZeroOffset() {
        // Teste le chiffrement d'une chaîne avec un décalage nul.
        EncryptedString string = EncryptedString.encrypt("abc", 0);
        String encryptedString = string.encrypt();
        assertEquals("abc", encryptedString);
    }



    @Test
    public void testEncryptStringWithSpecialCharacters() {
        // Teste le chiffrement d'une chaîne contenant des caractères spéciaux.
        EncryptedString string = EncryptedString.encrypt("B#C&D", 1);
        }
}