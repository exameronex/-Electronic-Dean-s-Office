import java.awt.Font;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;
public class Ds {
    JFrame fr = new JFrame();
    JTextField nazT = new JTextField();
    JTextField kolT = new JTextField();
    JTextField semT = new JTextField();
    JComboBox dsT  = new JComboBox();
    JPanel wind =new JPanel();
    void opi1(JFrame frame){
        fr=frame;
        fr.setLayout(null);
        fr.getContentPane().removeAll();
        JButton vod = new JButton("Ввод новой дисциплины");
        vod.setBounds(500,100,400,70);
        vod.addActionListener(new Vod());
        JButton vivod = new JButton("Просмотр информации о дисциплины");
        vivod.setBounds(500,200,400,70);
        vivod.addActionListener(new Vivod());
        JButton back = new JButton("Назад");
        back.setBounds(500,300,400,70);
        back.addActionListener(new Back());
        fr.add(vod);
        fr.add(vivod);
        fr.add(back);
        fr.revalidate();
        fr.repaint(); }
    public class Vod implements ActionListener{
        public void actionPerformed(ActionEvent event)
        {fr.getContentPane().removeAll();
            JLabel naz = new JLabel("Название");
            naz.setFont(new Font("Serif", Font.PLAIN, 24));
            naz.setBounds(20,20,280,28);
            JLabel kol = new JLabel("Количество часов");
            kol.setFont(new Font("Serif", Font.PLAIN, 24));
            kol.setBounds(20,70,280,28);
            JLabel sem = new JLabel("Семестр");
            sem.setFont(new Font("Serif", Font.PLAIN, 24));
            sem.setBounds(20,120,280,28);
            nazT.setBounds(420,20,750,23);
            kolT.setBounds(420,70,50,23);
            semT.setBounds(420,120,50,23);
            JButton ok = new JButton("ОК");
            ok.addActionListener(new DsV());
            ok.setBounds(800,370,170,70);
            JButton back = new JButton("Назад");
            back.addActionListener(new Back2());
            back.setBounds(1000,370,170,70);
            fr.add(naz);
            fr.add(kol);
            fr.add(sem);
            fr.add(nazT);
            fr.add(kolT);
            fr.add(semT);
            fr.add(ok);
            fr.add(back);
            fr.revalidate();
            fr.repaint(); }}

    public class Vivod implements ActionListener{
        public void actionPerformed(ActionEvent event)
        {fr.getContentPane().removeAll();
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            try {Class.forName("org.h2.Driver");
                conn = DriverManager.getConnection("jdbc:h2:file://c:\\test\\testbase","sa","");
                stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT * FROM DIS");
                while(rs.next()){
                    dsT.addItem(rs.getString("NAM")); } }
            catch  (ClassNotFoundException | SQLException ex){
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE,null,ex); }
            finally{  if(conn!=null){  try{  conn.close();  stmt.close();  rs.close(); }
            catch (SQLException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE,null,ex);  }    }    }
            JLabel viv = new JLabel("Выберете интересующую дисциплину");
            viv.setBounds(20,20,400,28);
            viv.setFont(new Font("Serif", Font.PLAIN, 24));
            JButton ok = new JButton("ОК");
            ok.setBounds(800,370,170,70);
            ok.addActionListener(new OK());
            JButton back = new JButton("Назад");
            back.addActionListener(new Back2());
            back.setBounds(1000,370,170,70);
            dsT.setBounds(20,70,280,25);
            fr.add(viv);
            fr.add(dsT);
            fr.add(ok);
            fr.add(back);
            fr.revalidate();
            fr.repaint();  }  }
    class DsV implements ActionListener{//Ввод стипендии в базу данных
        public void actionPerformed(ActionEvent event)
        {Connection conn = null;
            Statement stmt = null;
            try {Class.forName("org.h2.Driver");
                conn = DriverManager.getConnection("jdbc:h2:file://c:\\test\\testbase","sa","");
                stmt = conn.createStatement();
                String s = nazT.getText();
                String v = kolT.getText();
                String c = semT.getText();
                stmt.executeUpdate("insert into DIS (NAM,KOL,SEM) VALUES ('"+s+"',"+v+","+c+")"); }
            catch  (ClassNotFoundException | SQLException ex){
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE,null,ex); }
            finally{ if(conn!=null){   try{  conn.close();  stmt.close(); }
            catch (SQLException ex) {Logger.getLogger(Test.class.getName()).log(Level.SEVERE,null,ex);}} }}}
    public class OK implements ActionListener{
        public void actionPerformed(ActionEvent event){
            wind.removeAll();
            String s = (String) dsT.getSelectedItem();
            JLabel kol = new JLabel("Количество часов");
            kol.setFont(new Font("Serif", Font.PLAIN, 24));
            kol.setBounds(0,0,280,28);
            JLabel sem = new JLabel("Семестр");
            sem.setFont(new Font("Serif", Font.PLAIN, 24));
            sem.setBounds(0,70,280,28);
            JLabel kolTS = new JLabel();
            JLabel semTS = new JLabel();
            wind.setLayout(null);
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            try {Class.forName("org.h2.Driver");
                conn = DriverManager.getConnection("jdbc:h2:file://c:\\test\\testbase","sa","");
                stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT * FROM DIS");
                while(rs.next()){
                    if(s.equals(rs.getString("NAM"))){
                        kolTS.setText(rs.getString("KOL"));
                        semTS.setText(rs.getString("SEM"));
                        break; }  }  }
            catch  (ClassNotFoundException | SQLException ex){
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE,null,ex); }
            finally{ if(conn!=null){ try{ conn.close(); stmt.close(); rs.close(); }
            catch (SQLException ex) { Logger.getLogger(Test.class.getName()).log(Level.SEVERE,null,ex); }}}
            kolTS.setFont(new Font("Serif", Font.PLAIN, 24));
            kolTS.setBounds(260,0,280,28);
            semTS.setFont(new Font("Serif", Font.PLAIN, 24));
            semTS.setBounds(260,70,280,28);
            wind.setBounds(20,120,380,180);
            wind.add(kol);
            wind.add(kolTS);
            wind.add(semTS);
            wind.add(sem);
            fr.add(wind);
            fr.revalidate();
            fr.repaint();  } }
    public class Back implements ActionListener{
        public void actionPerformed(ActionEvent event)  {
            Int gui = new Int();
            gui.go();
            fr.setVisible(false);}}
    public class Back2 implements ActionListener{
        public void actionPerformed(ActionEvent event)
        {dsT.removeAllItems();
            opi1(fr); }}}

