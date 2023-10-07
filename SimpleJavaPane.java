import javax.swing.*;

public class SimpleJavaPane {
    public static void main(String[] args) {
        JOptionPane frame = new JOptionPane("Main");

        frame.setSize(350,350);
        frame.setVisible(true);
        JOptionPane.showMessageDialog(frame, "This is a message", "Error", JOptionPane.ERROR_MESSAGE);


    }
}
