import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        JFrame frame1=new JFrame("Menú Login TaskFlow");
        frame1.setContentPane((new Login()).PanelLogin);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(800, 600);
        frame1.pack();
        frame1.setVisible(true);
    }
}