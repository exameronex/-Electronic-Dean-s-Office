import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Int {
    public static void main(String[] args) {
        Int gui = new Int();
        gui.go();}
    JFrame frame;
    public void go() {
        frame = new JFrame();
        JLabel label;
        GridLayout gr = new GridLayout(3,3);
        JPanel windowPanel = new JPanel();
        windowPanel.setLayout(gr);
        JButton button = new JButton("Студент");
        button.addActionListener(new Student());
        JButton button2 = new JButton("Дисциплина");
        button2.addActionListener(new Discip());
        JButton button3 = new JButton("Учебный план");
        JButton button4 = new JButton("Аттестация");
        button4.addActionListener(new Attes());
        JButton button5 = new JButton("Группа");
        button5.addActionListener(new GroupB());
        JButton button6 = new JButton("Стипендия");
        button6.addActionListener(new Stipendia());
        JButton button7 = new JButton("Сессия");
        button7.addActionListener(new Ses());
        windowPanel.add(button);
        windowPanel.add(button2);
        windowPanel.add(button3);
        windowPanel.add(button4);
        windowPanel.add(button5);
        windowPanel.add(button6);
        windowPanel.add(new JPanel());
        windowPanel.add(button7);
        windowPanel.add(new JPanel());
        label = new JLabel("Электронный деканат");
        label.setPreferredSize(new Dimension(100,100));
        label.setFont(new Font("Serif", Font.PLAIN, 32));
        frame.setLocationRelativeTo(label);
        frame.getContentPane().add(BorderLayout.NORTH,label);
        frame.getContentPane().add(BorderLayout.CENTER,windowPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1368,550);
        frame.setLocation(0,0);
        frame.setVisible(true);}
    class GroupB implements ActionListener{
        public void actionPerformed(ActionEvent event)
        {Gr gr = new Gr();
            gr.opi(frame);}}
    class Student implements ActionListener{
        public void actionPerformed(ActionEvent event)
        {St st = new St();
            st.opi1(frame);}}
    class Stipendia implements ActionListener{
        public void actionPerformed(ActionEvent event)
        {Stip stip1 = new Stip();
            stip1.opi1(frame);}}
    class Discip implements ActionListener{
        public void actionPerformed(ActionEvent event)
        {Ds ds = new Ds();
            ds.opi1(frame);}}
    class Attes implements ActionListener{
        public void actionPerformed(ActionEvent event)
        {Att att = new Att();
            att.opi1(frame);}}
    class Ses implements ActionListener{
        public void actionPerformed(ActionEvent event)
        {Sessia ses = new Sessia();
            ses.opi1(frame);}}}
