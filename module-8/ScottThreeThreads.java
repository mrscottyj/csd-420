// CSD-420
// Scott Johnson
 
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import java.util.Random;
 
public class ScottThreeThreads {
 
    // How many characters each thread writes
    static final int COUNT = 10000;
 
    public static void main(String[] args) throws Exception {
 
        // Window with a text area
        JTextArea textArea = new JTextArea(20, 50);
        textArea.setLineWrap(true);
 
        JFrame frame = new JFrame("Three Threads");
        frame.add(new JScrollPane(textArea));
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
 
        // Each thread gets its own set of characters
        Thread letterThread = new Thread(new CharWriter(textArea, "abcdefghijklmnopqrstuvwxyz"));
        Thread digitThread = new Thread(new CharWriter(textArea, "0123456789"));
        Thread symbolThread = new Thread(new CharWriter(textArea, "!@#$%^&*"));
 
        letterThread.start();
        digitThread.start();
        symbolThread.start();
 
        // Wait for the threads to finish, then for the text area to catch up
        letterThread.join();
        digitThread.join();
        symbolThread.join();
        SwingUtilities.invokeAndWait(() -> { });
 
        // TEST CODE
        String text = textArea.getText();
        int letters = 0;
        int digits = 0;
        int lettersInFirst100 = 0;
 
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {
                letters++;
                if (i < 100) {
                    lettersInFirst100++;
                }
            } else if (Character.isDigit(c)) {
                digits++;
            }
        }
        int symbols = text.length() - letters - digits;
 
        System.out.println("Letters: " + letters);
        System.out.println("Digits: " + digits);
        System.out.println("Symbols: " + symbols);
 
        // Test 1: each thread wrote exactly 10,000 characters
        if (letters == COUNT && digits == COUNT && symbols == COUNT) {
            System.out.println("Count test: PASS");
        } else {
            System.out.println("Count test: FAIL");
        }
 
        // Test 2: the first 100 characters are mixed, not all letters or none
        if (lettersInFirst100 > 0 && lettersInFirst100 < 100) {
            System.out.println("Mixed output test: PASS");
        } else {
            System.out.println("Mixed output test: FAIL");
        }
    }
}
 
// Writes random characters from a given set to the text area
class CharWriter implements Runnable {
    private JTextArea textArea;
    private String chars;
    private Random random = new Random();
 
    public CharWriter(JTextArea textArea, String chars) {
        this.textArea = textArea;
        this.chars = chars;
    }
 
    public void run() {
        for (int i = 0; i < ScottThreeThreads.COUNT; i++) {
            // Pick a random character and show it right away
            String letter = String.valueOf(chars.charAt(random.nextInt(chars.length())));
            SwingUtilities.invokeLater(() -> textArea.append(letter));
 
            // Short pause so the three threads take turns
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
 