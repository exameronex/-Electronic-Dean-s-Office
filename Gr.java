import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class Gr {
    JTextField nameG;
    JTextField yearT;
    JFrame fr;
    Connection conn = null;
    Statement stmt = null;
    void opi(JFrame frame){
        fr=frame;
        fr.getContentPane().removeAll();
        fr.setLayout(null);
        JLabel name = new JLabel("Наименование группы");
        name.setFont(new Font("Serif", Font.PLAIN, 24));
        name.setBounds(20,20,280,25);
        nameG = new JTextField(100);
        nameG.setBounds(420,20,750,23);
        JLabel amount = new JLabel("Год формирования");
        amount.setFont(new Font("Serif", Font.PLAIN, 24));
        amount.setBounds(20,120,280,25);
        yearT = new JTextField(100);
        yearT.setBounds(420,120,750,23);
        JButton ok = new JButton("ОК");
        ok.addActionListener(new GrV());
        ok.setBounds(800,220,170,70);
        JButton back = new JButton("Назад");
        back.setBounds(1000,220,170,70);
        back.addActionListener(new Back());
        fr.add(name);
        fr.add(nameG);
        fr.add(amount);
        fr.add(yearT);
        fr.add(ok);
        fr.add(back);
        fr.revalidate();
        fr.repaint();}
    class GrV implements ActionListener{
        public void actionPerformed(ActionEvent event)
        {try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:file://c:\\test\\testbase","sa","");
            stmt = conn.createStatement();
            String s = nameG.getText();
            String v = yearT.getText();
            stmt.executeUpdate("insert into GROUPU (GROUP_NAME,YEAR_OF_FORMATION) VALUES ('"+s+"',"+v+")"); }
        catch  (ClassNotFoundException | SQLException ex){
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE,null,ex); }
        finally{
            if(conn!=null){
                try{
                    conn.close();
                    stmt.close();
                }
                catch (SQLException ex) {
                    Logger.getLogger(Test.class.getName()).log(Level.SEVERE,null,ex); }}}}}
    public class Back implements ActionListener{
        public void actionPerformed(ActionEvent event) {
            Int gui = new Int();
            gui.go();
            fr.setVisible(false);    }}}
