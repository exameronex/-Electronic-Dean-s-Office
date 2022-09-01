import java.awt.Font;
import java.awt.event.*;
import java.sql.*;
import java.util.Calendar;
import java.util.logging.*;
import javax.swing.*;
public class Stip {
    JFrame fr;
    JTextField famT = new JTextField();;
    JTextField nameT = new JTextField();;
    JTextField otT = new JTextField();
    JComboBox groupT  = new JComboBox();
    JComboBox stipendiaT  = new JComboBox();
    JTextField razT = new JTextField();
    JTextField uchebT = new JTextField();
    JComboBox voT  = new JComboBox();
    void opi1(JFrame frame){
        fr=frame;
        fr.setLayout(null);
        fr.getContentPane().removeAll();
        JButton vod = new JButton("Добавление стипендии студенту");
        vod.setBounds(500,100,400,70);
        vod.addActionListener(new St());
        JButton vivod = new JButton("Просмотр всех стипендий");
        vivod.setBounds(500,200,400,70);
        vivod.addActionListener(new Viv());
        JButton back = new JButton("Назад");
        back.setBounds(500,300,400,70);
        back.addActionListener(new Back());
        fr.add(vod);
        fr.add(vivod);
        fr.add(back);
        fr.revalidate();
        fr.repaint();  }
    class St implements ActionListener{
        public void actionPerformed(ActionEvent event) {
            Calendar calendar = Calendar.getInstance();
            int Month = calendar.get(Calendar.MONTH)+1;
            int Year = calendar.get(Calendar.YEAR);
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            try { Class.forName("org.h2.Driver");
                conn = DriverManager.getConnection("jdbc:h2:file://c:\\test\\testbase","sa","");
                stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT * FROM GROUPU");
                while(rs.next()){
                    if((Year-Integer.parseInt(rs.getString("YEAR_OF_FORMATION")))<=4){
                        if(8-Month>0){
                            groupT.addItem(rs.getString("GROUP_NAME")); }}}}
            catch  (ClassNotFoundException | SQLException ex){
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE,null,ex); }
            finally{ if(conn!=null){ try{ conn.close();
                stmt.close();
                rs.close();}
            catch (SQLException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE,null,ex); } } }
            fr.getContentPane().removeAll();
            fr.setLayout(null);
            JLabel fam = new JLabel("Фамилия");
            fam.setFont(new Font("Serif", Font.PLAIN, 24));
            fam.setBounds(20,20,280,28);
            JLabel name = new JLabel("Имя");
            name.setFont(new Font("Serif", Font.PLAIN, 24));
            name.setBounds(20,65,280,28);
            JLabel ot = new JLabel("Отчество");
            ot.setFont(new Font("Serif", Font.PLAIN, 24));
            ot.setBounds(20,110,280,28);
            JLabel group = new JLabel("Группа");
            group.setFont(new Font("Serif", Font.PLAIN, 24));
            group.setBounds(20,155,280,28);
            JLabel stipendia = new JLabel("Стипендия");
            stipendia.setFont(new Font("Serif", Font.PLAIN, 24));
            stipendia.setBounds(20,200,280,28);
            JLabel raz = new JLabel("Размер стипендии");
            raz.setFont(new Font("Serif", Font.PLAIN, 24));
            raz.setBounds(20,245,280,28);
            JLabel ucheb = new JLabel("Учебный год");
            ucheb.setFont(new Font("Serif", Font.PLAIN, 24));
            ucheb.setBounds(20,290,280,28);
            JLabel vo = new JLabel("Весна/Осень");
            vo.setFont(new Font("Serif", Font.PLAIN, 24));
            vo.setBounds(20,335,280,28);
            famT.setBounds(420,20,750,23);
            nameT.setBounds(420,65,750,23);
            otT.setBounds(420,110,750,23);
            groupT.setBounds(420,155,100,23);
            stipendiaT.setBounds(420,200,750,23);
            stipendiaT.addItem("Академическая стипендия на «хорошо»");
            stipendiaT.addItem("Академическая стипендия на «отлично» и «хорошо»");
            stipendiaT.addItem("Академическая стипендия на «отлично»");
            stipendiaT.addItem("Социальная стипендия");
            razT.setBounds(420,245,750,23);
            uchebT.setBounds(420,290,750,23);
            voT.setBounds(420,335,100,23);
            voT.addItem("Весна");
            voT.addItem("Осень");
            JButton ok = new JButton("ОК");
            ok.addActionListener(new OK());
            ok.setBounds(800,370,170,70);
            JButton back = new JButton("Назад");
            back.setBounds(1000,370,170,70);
            back.addActionListener(new Back2());
            fr.add(fam);
            fr.add(name);
            fr.add(ot);
            fr.add(group);
            fr.add(stipendia);
            fr.add(raz);
            fr.add(ucheb);
            fr.add(vo);
            fr.add(famT);
            fr.add(nameT);
            fr.add(otT);
            fr.add(groupT);
            fr.add(stipendiaT);
            fr.add(razT);
            fr.add(uchebT);
            fr.add(voT);
            fr.add(ok);
            fr.add(back);
            fr.revalidate();
            fr.repaint(); }}
    class OK implements ActionListener{
        public void actionPerformed(ActionEvent event){
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            try { Class.forName("org.h2.Driver");
                conn = DriverManager.getConnection("jdbc:h2:file://c:\\test\\testbase","sa","");
                stmt = conn.createStatement();
                String s = famT.getText();
                String v = nameT.getText();
                String c = otT.getText();
                String p = null;
                rs = stmt.executeQuery("SELECT * FROM STUDENT");
                while(rs.next()){                      if(s.equals(rs.getString("SURNAME"))&&v.equals(rs.getString("NAM"))&&c.equals(rs.getString("PATR")))
                { p=rs.getString("id");
                    break; }}
                stmt.executeUpdate("insert into STIPEND (ID_STUDENT,FAM,NM,OT,GR,NAM,RAZMER,UCH,VO) VALUES ('"+p+"','"+famT.getText()+"','"+nameT.getText()+"','"+otT.getText()+"','"+(String)groupT.getSelectedItem()+"','"+(String)stipendiaT.getSelectedItem()+"','"+razT.getText()+"','"+uchebT.getText()+"','"+voT.getSelectedItem()+"')");
            }catch  (ClassNotFoundException | SQLException ex){
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE,null,ex); }
            finally{if(conn!=null){  try{ conn.close();  stmt.close(); rs.close(); }
            catch (SQLException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE,null,ex); } } } } }
    JTextField ucT = new JTextField();
    JComboBox votT  = new JComboBox();
    void viv()
    { fr.getContentPane().removeAll();
        JLabel viv = new JLabel("Введите учебный год");
        viv.setBounds(20,20,700,28);
        viv.setFont(new Font("Serif", Font.PLAIN, 24));
        votT.setBounds(140,70,100,23);
        votT.addItem("Весна");
        votT.addItem("Осень");
        JButton ok = new JButton("ОК");
        ok.setBounds(800,400,170,70);
        ok.addActionListener(new OK2());
        JButton back = new JButton("Назад");
        back.addActionListener(new Back2());
        back.setBounds(1000,400,170,70);
        ucT.setBounds(20,70,100,25);
        fr.add(viv);
        fr.add(ucT);
        fr.add(votT);
        fr.add(ok);
        fr.add(back);
        fr.revalidate();
        fr.repaint();}
    class Viv implements ActionListener{
        public void actionPerformed(ActionEvent event) {
            viv();}}
    JPanel wind1 =new JPanel();
    public class OK2 implements ActionListener{
        public void actionPerformed(ActionEvent event)
        {wind1.removeAll();
            String s = (String) votT.getSelectedItem();
            String a = ucT.getText();
            String[] columnName = {"Фамилия","Имя","Отчество","Группа","Наименование стипендии", "Размер стипендии",};
            wind1.setLayout(null);
            wind1.setBounds(20,120,1310,800);
            String[][] matrixA;
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            try { Class.forName("org.h2.Driver");
                conn = DriverManager.getConnection("jdbc:h2:file://c:\\test\\testbase","sa","");
                stmt = conn.createStatement();
                int p = 0;
                rs = stmt.executeQuery("SELECT * FROM STIPEND");
                while(rs.next()){if(s.equals(rs.getString("VO"))&&a.equals(rs.getString("UCH"))) {p++;}}
                matrixA = new String[p][6];
                int g=0;
                rs = stmt.executeQuery("SELECT * FROM STIPEND");
                while(rs.next()){ if(s.equals(rs.getString("VO"))&&a.equals(rs.getString("UCH")))
                {matrixA[g][0] =  rs.getString("FAM");
                    matrixA[g][1] = rs.getString("NM");
                    matrixA[g][2] = rs.getString("OT");
                    matrixA[g][3] = rs.getString("GR");
                    matrixA[g][4] = rs.getString("NAM");
                    matrixA[g][5] = rs.getString("RAZMER");
                    g++;}}
                JTable table = new JTable(matrixA,columnName);
                JScrollPane scrollPane = new JScrollPane(table);
                scrollPane.setBounds(0,0,1310,280);
                wind1.add(scrollPane);}
            catch  (ClassNotFoundException | SQLException ex){
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE,null,ex); }
            finally{if(conn!=null){ try{ conn.close(); stmt.close();  rs.close(); }
            catch (SQLException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE,null,ex);  } }  }
            fr.add(wind1);
            fr.revalidate();
            fr.repaint(); } }
    public class Back implements ActionListener{
        public void actionPerformed(ActionEvent event)
        { Int gui = new Int();
            gui.go();
            fr.setVisible(false); }}
    public class Back2 implements ActionListener{
        public void actionPerformed(ActionEvent event)
        {  groupT.removeAllItems();
            stipendiaT.removeAllItems();
            voT.removeAllItems();
            votT.removeAllItems();
            opi1(fr); }}}
