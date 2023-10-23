package fr.uvsq.cprog.mvnjunit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EncryptedString {
    private final String encryptedString;  // Chaîne chiffrée
    private final int offset;  // Décalage

    private EncryptedString(String encryptedString, int offset) {
        this.encryptedString = encryptedString;
        this.offset = offset;
    }

    // Fonction statique pour décrypter une chaîne
    public static EncryptedString decrypt(String encryptedString, int offset) {
        return new EncryptedString(encryptedString, -offset);
    }

    // Fonction statique pour chiffrer une chaîne
    public static EncryptedString encrypt(String plainText, int offset) {
        String encryptedString = encryptString(plainText, offset);
        return new EncryptedString(encryptedString, offset);
    }

    // Fonction pour décrypter la chaîne
    public String decrypt() {
        if (encryptedString == null) {
            return null;
        }
        return encryptString(encryptedString, offset);
    }

    // Fonction pour chiffrer la chaîne
    public String encrypt() {
        return encryptedString;
    }

    // Fonction pour chiffrer une chaîne de caractères
    private static String encryptString(String text, int offset) {
        if (text == null) {
            return null;
        }
        StringBuilder encryptedText = new StringBuilder();
        for (char c : text.toCharArray()) {
            encryptedText.append(shiftCharacter(c, offset));
        }
        return encryptedText.toString();
    }

    // Fonction pour décaler un caractère
    private static char shiftCharacter(char c, int offset) {
        if (Character.isUpperCase(c)) {
            return (char) (((c - 'A' + offset) % 26 + 26) % 26 + 'A');
        } else if (Character.isLowerCase(c)) {
            return (char) (((c - 'a' + offset) % 26 + 26) % 26 + 'a');
        } else {
            return c;
        }
    }

    // MAIN
    private static final Logger logger = LoggerFactory.getLogger(EncryptedString.class);
    public static void main(String[] args) {
        // Exemple d'utilisation de la classe EncryptedString
        EncryptedString string = EncryptedString.encrypt("Hello", 3);
        System.out.println("Texte en clair : HELLO");
        System.out.println("Texte chiffré : " + string.encrypt());

        String decryptedString = string.encrypt();
        EncryptedString string2 = EncryptedString.decrypt(decryptedString, 3);
        System.out.println("Texte décrypté : " + string2.decrypt());

        logger.info("Exemple de log d'information.");
        logger.error("Exemple de log d'erreur.");
    }
}
