import java.awt.event.*;
import javax.swing.*;
public class Sessia {
    JFrame fr;
    void opi1(JFrame frame){
        fr=frame;
        fr.setLayout(null);
        fr.getContentPane().removeAll();
        JButton vod = new JButton("Экзамен");
        vod.setBounds(500,70,400,70);
        vod.addActionListener(new Ex());
        JButton vivod = new JButton("Зачет");
        vivod.setBounds(500,170,400,70);
        vivod.addActionListener(new Zac());
        JButton kursova = new JButton("Курсовая работа");
        kursova.setBounds(500,270,400,70);
        kursova.addActionListener(new Kurs());
        JButton back = new JButton("Назад");
        back.setBounds(500,370,400,70);
        back.addActionListener(new Back());
        fr.add(vod);
        fr.add(vivod);
        fr.add(kursova);
        fr.add(back);
        fr.revalidate();
        fr.repaint(); }
    public class Ex implements ActionListener{
        public void actionPerformed(ActionEvent event) {
            Exam gui = new Exam();
            gui.opi1(fr); }}
    public class Zac implements ActionListener{
        public void actionPerformed(ActionEvent event)  {
            Zach gui = new Zach();
            gui.opi1(fr);  }}
    public class Kurs implements ActionListener{
        public void actionPerformed(ActionEvent event){
            Kursov gui = new Kursov();
            gui.opi1(fr); }}
    public class Back implements ActionListener{
        public void actionPerformed(ActionEvent event)
        { Int gui = new Int();  gui.go();  fr.setVisible(false);}}}