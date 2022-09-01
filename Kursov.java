import java.awt.Font;
import java.awt.event.*;
import java.sql.*;
import java.util.Calendar;
import java.util.logging.*;
import javax.swing.*;
public class Kursov {
    JFrame fr;
    JComboBox groupT  = new JComboBox();
    JComboBox dsT  = new JComboBox();
    JTextField uchebT = new JTextField();
    JComboBox semT = new JComboBox();
    void opi1(JFrame frame){
        fr=frame;
        fr.setLayout(null);
        fr.getContentPane().removeAll();
        JButton vod = new JButton("Ввод результатов курсовой работы");
        vod.setBounds(500,100,400,70);
        vod.addActionListener(new Vod());
        JButton vivod = new JButton("Вывод результатов курсовой работы");
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
    public class Vivod implements ActionListener{
        public void actionPerformed(ActionEvent event)
        {vivod();}}
    void vivod(){
        fr.getContentPane().removeAll();
        JLabel zapros = new JLabel("Выберете группу и дисциплину");
        zapros.setFont(new Font("Serif", Font.PLAIN, 24));
        zapros.setBounds(20,20,700,28);
        Connection conn = null; Statement stmt = null; ResultSet rs = null;
        int Year; int Month;
        Calendar calendar = Calendar.getInstance();
        Month = calendar.get(Calendar.MONTH)+1;
        Year = calendar.get(Calendar.YEAR);
        try {Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:file://c:\\test\\testbase","sa","");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM DIS");
            while(rs.next()){ dsT.addItem(rs.getString("NAM"));  }
            rs = stmt.executeQuery("SELECT * FROM GROUPU");
            while(rs.next()){
                if((Year-Integer.parseInt(rs.getString("YEAR_OF_FORMATION")))<=4){
                    if(8-Month>0){
                        groupT.addItem(rs.getString("GROUP_NAME"));}}}}
        catch  (ClassNotFoundException | SQLException ex){
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE,null,ex); }
        finally{if(conn!=null){ try{ conn.close(); stmt.close(); rs.close();}
        catch (SQLException ex) {Logger.getLogger(Test.class.getName()).log(Level.SEVERE,null,ex);}}}
        JButton ok = new JButton("ОК");
        ok.addActionListener(new Ok2());
        ok.setBounds(800,370,170,70);
        JButton back = new JButton("Назад");
        back.setBounds(1000,370,170,70);
        back.addActionListener(new Back2());
        groupT.setBounds(820,20,100,23);
        dsT.setBounds(820,70,300,23);
        fr.add(dsT);
        fr.add(groupT);
        fr.add(zapros);
        fr.add(ok);
        fr.add(back);
        fr.revalidate();
        fr.repaint(); }
    JTable  table1;
    public class Ok2 implements ActionListener{
        public void actionPerformed(ActionEvent event)
        { fr.getContentPane().removeAll();
            String[] columnName = {"ФИО","Баллы", "Пропущено часов" };
            String[][] matrixB;
            int p = 0;
            Connection conn = null;  Statement stmt = null;  ResultSet rs = null;
            String a = (String) dsT.getSelectedItem();
            String c = (String) groupT.getSelectedItem();
            try {  Class.forName("org.h2.Driver");
                conn = DriverManager.getConnection("jdbc:h2:file://c:\\test\\testbase","sa","");
                stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT * FROM KURSOVA");
                while(rs.next()){
                    if(a.equals(rs.getString("DISC"))&&c.equals(rs.getString("GR"))){   p++;     }     }
                matrixB = new String[p][3];
                int g=0;
                rs = stmt.executeQuery("SELECT * FROM KURSOVA");
                while(rs.next()){
                    if(a.equals(rs.getString("DISC"))&&c.equals(rs.getString("GR"))) {
                        matrixB[g][0] =  rs.getString("FIO");
                        matrixB[g][1] = rs.getString("NAM");
                        matrixB[g][2] = rs.getString("BAL");
                        g++;   }}
                table1 = new JTable(matrixB,columnName);
                JScrollPane scrollPane = new JScrollPane(table1);
                scrollPane.setBounds(0,0,1350,300);
                fr.add(scrollPane); }
            catch  (ClassNotFoundException | SQLException ex){
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE,null,ex); }
            finally{if(conn!=null){ try{ conn.close(); stmt.close(); rs.close();}
            catch (SQLException ex) {Logger.getLogger(Test.class.getName()).log(Level.SEVERE,null,ex);}}}
            JButton back = new JButton("Назад");
            back.setBounds(1000,370,170,70);
            back.addActionListener(new Back4());
            fr.add(back);
            fr.revalidate();
            fr.repaint();  } }
    void vod(){
        fr.getContentPane().removeAll();
        JLabel group = new JLabel("Группа");
        group.setFont(new Font("Serif", Font.PLAIN, 24));
        group.setBounds(20,20,280,28);
        JLabel ds = new JLabel("Дисциплина");
        ds.setFont(new Font("Serif", Font.PLAIN, 24));
        ds.setBounds(20,70,280,28);
        JLabel ucheb = new JLabel("Учебный год");
        ucheb.setFont(new Font("Serif", Font.PLAIN, 24));
        ucheb.setBounds(20,120,280,28);
        JLabel sem = new JLabel("Весна/Осень");
        sem.setFont(new Font("Serif", Font.PLAIN, 24));
        sem.setBounds(20,170,280,28);
        JButton ok = new JButton("ОК");
        ok.addActionListener(new Ok());
        ok.setBounds(800,370,170,70);
        JButton back = new JButton("Назад");
        back.setBounds(1000,370,170,70);
        back.addActionListener(new Back2());
        Connection conn = null; Statement stmt = null; ResultSet rs = null;
        int Year;  int Month;
        Calendar calendar = Calendar.getInstance();
        Month = calendar.get(Calendar.MONTH)+1;
        Year = calendar.get(Calendar.YEAR);
        try { Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:file://c:\\test\\testbase","sa","");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM DIS");
            while(rs.next()){
                dsT.addItem(rs.getString("NAM"));  }
            rs = stmt.executeQuery("SELECT * FROM GROUPU");
            while(rs.next()){
                if((Year-Integer.parseInt(rs.getString("YEAR_OF_FORMATION")))<=4){
                    if(8-Month>0){
                        groupT.addItem(rs.getString("GROUP_NAME"));    }}} }
        catch  (ClassNotFoundException | SQLException ex){
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE,null,ex);}
        finally{if(conn!=null){ try{ conn.close(); stmt.close(); rs.close();}
        catch (SQLException ex) {Logger.getLogger(Test.class.getName()).log(Level.SEVERE,null,ex);}}}
        semT.addItem("Весна");
        semT.addItem("Осень");
        groupT.setBounds(420,20,100,23);
        dsT.setBounds(420,70,400,23);
        uchebT.setBounds(420,120,100,23);
        semT.setBounds(420,170,100,23);
        fr.add(group);
        fr.add(ds);
        fr.add(sem);
        fr.add(ucheb);
        fr.add(groupT);
        fr.add(dsT);
        fr.add(uchebT);
        fr.add(semT);
        fr.add(ok);
        fr.add(back);
        fr.setLayout(null);
        fr.revalidate();
        fr.repaint(); }
    JTable table;
    int p = 0;
    String[][] matrixA;
    public class Ok implements ActionListener{
        public void actionPerformed(ActionEvent event){
            fr.getContentPane().removeAll();
            String s = (String) groupT.getSelectedItem();
            String h = null;
            String[] columnName = {"ФИО","Название курсвой работы", "Оценка"};
            Connection conn = null;Statement stmt = null; ResultSet rs = null;
            int Year; int Month;
            Calendar calendar = Calendar.getInstance();
            Month = calendar.get(Calendar.MONTH)+1;
            Year = calendar.get(Calendar.YEAR);
            try {Class.forName("org.h2.Driver");
                conn = DriverManager.getConnection("jdbc:h2:file://c:\\test\\testbase","sa","");
                stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT * FROM GROUPU");
                while(rs.next()){
                    if((Year-Integer.parseInt(rs.getString("YEAR_OF_FORMATION")))<=4){
                        if(8-Month>0){
                            if(s.equals(rs.getString("GROUP_NAME")))
                                h = (rs.getString("id"));}}}
                p=0;
                rs = stmt.executeQuery("SELECT * FROM STUDENT");
                while(rs.next()){
                    if(h.equals(rs.getString("ID_GROUP"))) {  p++; }}
                matrixA = new String[p][3];
                int g=0;
                rs = stmt.executeQuery("SELECT * FROM STUDENT");
                while(rs.next()){if(h.equals(rs.getString("ID_GROUP"))) {
                    matrixA[g][0] =  rs.getString("SURNAME")+" "+rs.getString("NAM")+" "+rs.getString("PATR");
                    g++;  }}}
            catch  (ClassNotFoundException | SQLException ex){
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE,null,ex); }
            finally{if(conn!=null){ try{ conn.close(); stmt.close(); rs.close();}
            catch (SQLException ex) {Logger.getLogger(Test.class.getName()).log(Level.SEVERE,null,ex);}}}
            table = new JTable(matrixA,columnName);
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBounds(0,0,1350,300);
            fr.add(scrollPane);
            JButton ok = new JButton("ОК");
            ok.addActionListener(new Ok1());
            ok.setBounds(800,370,170,70);
            JButton back = new JButton("Назад");
            back.setBounds(1000,370,170,70);
            back.addActionListener(new Back3());
            fr.add(ok);
            fr.add(back);
            fr.revalidate();
            fr.repaint(); }}
    public class Ok1 implements ActionListener{
        public void actionPerformed(ActionEvent event)  {
            Connection conn = null;
            Statement stmt = null;
            try {
                Class.forName("org.h2.Driver");
                conn = DriverManager.getConnection("jdbc:h2:file://c:\\test\\testbase","sa","");
                String a,b,c,d,e,f,g;
                stmt = conn.createStatement();
                for(int i = 0; i<p; i++)
                {  a= (String) table.getValueAt(i,0);
                    b= (String) groupT.getSelectedItem();
                    c = (String) dsT.getSelectedItem();
                    d =  (String) table.getValueAt(i,1);
                    e =  (String) table.getValueAt(i,2);
                    f =  uchebT.getText();
                    g =  (String) semT.getSelectedItem();
                    stmt.executeUpdate("insert into KURSOVA (FIO,GR,DISC,NAM,BAL,UC,VO) VALUES ('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"')");}}
            catch  (ClassNotFoundException | SQLException ex){
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE,null,ex); }
            finally{if(conn!=null){ try{ conn.close(); stmt.close();}
            catch (SQLException ex) {Logger.getLogger(Test.class.getName()).log(Level.SEVERE,null,ex);}}}} }
    public class Vod implements ActionListener{
        public void actionPerformed(ActionEvent event)
        { vod();}}
    public class Back implements ActionListener{
        public void actionPerformed(ActionEvent event)
        {  Sessia gui = new Sessia();
            gui.opi1(  fr);}}
    public class Back2 implements ActionListener{
        public void actionPerformed(ActionEvent event)
        {  opi1(fr);
            dsT.removeAllItems();
            groupT.removeAllItems();
            semT.removeAllItems();    }}
    public class Back3 implements ActionListener{
        public void actionPerformed(ActionEvent event)
        {     dsT.removeAllItems();
            groupT.removeAllItems();
            semT.removeAllItems();
            vod();    }}
    public class Back4 implements ActionListener{
        public void actionPerformed(ActionEvent event)
        {      dsT.removeAllItems();
            groupT.removeAllItems();
            semT.removeAllItems();
            vivod();}}}
