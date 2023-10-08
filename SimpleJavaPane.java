import javax.swing.JOptionPane;

public class SimpleJavaPane {
    public static void main(String[] args) {
        JOptionPane frame = new JOptionPane("Main");

        frame.setSize(350,350);
        JOptionPane.showMessageDialog(frame, "This is an error message", "Error", JOptionPane.ERROR_MESSAGE);
        frame.setVisible(true);


    }
}
