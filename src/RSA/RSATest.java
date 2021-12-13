package RSA;
import java.security.Key;
import java.security.KeyPair;
import java.util.Arrays;
import java.util.Scanner;

public class RSATest {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter a Username: ");
        String string1= sc.nextLine();
        System.out.print("Enter password: ");
        String pwd= sc.nextLine();
        String string2 = new String("CNAS");
        System.out.println("Comparing " + string1 + " and " + string2
                + " : " + string1.equals(string2));

        if(string1.equals(string2)) {
            System.out.println("Enter a string: ");
            String password= sc.nextLine();
            KeyPair keyPair = RSAKeyPair.keyPairRSA();
            Key publicKey = keyPair.getPublic();
            Key privateKey = keyPair.getPrivate();

            System.out.println("Encrypt Start");
            System.out.println("Original: " + password);
            byte[] encrypted = RSAEncryptDecrypt.encrypt(password, privateKey);
            System.out.println("Encrypted: " + new String(encrypted));
            System.out.println("Encrypt End");

            System.out.println();

            System.out.println("Decrypt Start");
            byte[] decrypted = RSAEncryptDecrypt.decrypt(encrypted, publicKey);
            System.out.println("Decrypted: " + new String(decrypted));
            System.out.println("Decrypted matches Original: " + Arrays.equals(decrypted, password.getBytes()));
            System.out.println("Decrypt End");
        }
        else{
            System.out.println("Can't be proceed further");
        }
    }

}
