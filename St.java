import java.awt.Font;
import java.awt.*;
import java.sql.*;
import java.util.Calendar;
import java.util.logging.*;
import javax.swing.*;
public class St {
    JFrame fr = new JFrame();
    void opi1(JFrame frame){
        fr=frame;
        fr.setLayout(null);
        fr.getContentPane().removeAll();
        JButton vod = new JButton("Ввод нового студента");
        vod.setBounds(500,100,400,70);
        vod.addActionListener(new Vod());
        JButton vivod = new JButton("Поиск студентов");
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
    JTextField famT;
    JTextField nameT;
    JTextField otT;
    JTextField datT;
    JTextField adressT;
    JTextField phoneT;
    JComboBox polT = new JComboBox();
    JTextField nacT  = new JTextField();
    JComboBox groupT  = new JComboBox();
    public class Vod implements ActionListener{
        public void actionPerformed(ActionEvent event)
        { int Year; int Month;
            Calendar calendar = Calendar.getInstance();
            Month = calendar.get(Calendar.MONTH)+1;
            Year = calendar.get(Calendar.YEAR);
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            try {
                Class.forName("org.h2.Driver");
                conn = DriverManager.getConnection("jdbc:h2:file://c:\\test\\testbase","sa","");
                stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT * FROM GROUPU");
                while(rs.next()){
                    if((Year-Integer.parseInt(rs.getString("YEAR_OF_FORMATION")))<=4){
                        if(8-Month>0){
                            groupT.addItem(rs.getString("GROUP_NAME")); }}} }
            catch  (ClassNotFoundException | SQLException ex){
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE,null,ex); }
            finally{
                if(conn!=null){
                    try{
                        conn.close();
                        stmt.close();
                        rs.close();}
                    catch (SQLException ex) {
                        Logger.getLogger(Test.class.getName()).log(Level.SEVERE,null,ex); }}}
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
            JLabel dat = new JLabel("Дата рождения");
            dat.setFont(new Font("Serif", Font.PLAIN, 24));
            dat.setBounds(20,155,280,28);
            JLabel adress = new JLabel("Адрес");
            adress.setFont(new Font("Serif", Font.PLAIN, 24));
            adress.setBounds(20,200,280,28);
            JLabel phone = new JLabel("Телефон");
            phone.setFont(new Font("Serif", Font.PLAIN, 24));
            phone.setBounds(20,245,280,28);
            JLabel pol = new JLabel("Пол");
            pol.setFont(new Font("Serif", Font.PLAIN, 24));
            pol.setBounds(20,290,280,28);
            JLabel nac = new JLabel("Национальность");
            nac.setFont(new Font("Serif", Font.PLAIN, 24));
            nac.setBounds(20,335,280,28);
            JLabel group = new JLabel("Группа");
            group.setFont(new Font("Serif", Font.PLAIN, 24));
            group.setBounds(20,380,280,28);
            famT = new JTextField();
            famT.setBounds(420,20,750,23);
            nameT = new JTextField();
            nameT.setBounds(420,65,750,23);
            otT = new JTextField();
            otT.setBounds(420,110,750,23);
            datT = new JTextField();
            datT.setBounds(420,155,750,23);
            adressT = new JTextField();
            adressT.setBounds(420,200,750,23);
            phoneT = new JTextField();
            phoneT.setBounds(420,245,750,23);
            polT.setBounds(420,290,100,23);
            polT.addItem("Мужской");
            polT.addItem("Женский");
            nacT.setBounds(420,335,750,23);
            groupT.setBounds(420,380,100,23);
            JButton ok = new JButton("ОК");
            ok.addActionListener(new OK());
            ok.setBounds(800,420,170,70);
            JButton back = new JButton("Назад");
            back.setBounds(1000,420,170,70);
            back.addActionListener(new Back2());
            fr.add(fam);
            fr.add(name);
            fr.add(ot);
            fr.add(dat);
            fr.add(adress);
            fr.add(phone);
            fr.add(pol);
            fr.add(nac);
            fr.add(group);
            fr.add(famT);
            fr.add(nameT);
            fr.add(otT);
            fr.add(datT);
            fr.add(adressT);
            fr.add(phoneT);
            fr.add(polT);
            fr.add(nacT);
            fr.add(groupT);
            fr.add(ok);
            fr.add(back);
            fr.revalidate();
            fr.repaint(); }}
    public class OK implements ActionListener{
        public void actionPerformed(ActionEvent event) {
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            try {
                Class.forName("org.h2.Driver");
                conn = DriverManager.getConnection("jdbc:h2:file://c:\\test\\testbase","sa","");
                stmt = conn.createStatement();
                String a = famT.getText();
                String b = nameT.getText();
                String c = otT.getText();
                String d = datT.getText();
                String e = adressT.getText();
                String f = phoneT.getText();
                String z = (String) polT.getSelectedItem();
                String s = nacT.getText();
                String j = (String) groupT.getSelectedItem();
                String l = null;
                rs = stmt.executeQuery("select * from GROUPU");
                Calendar calendar = Calendar.getInstance();
                int Year = calendar.get(Calendar.YEAR);
                while(rs.next()){
                    if((Year-Integer.parseInt(rs.getString("YEAR_OF_FORMATION")))<=4) {
                        if(j.equals(rs.getString("GROUP_NAME"))){
                            l=rs.getString("id"); } } }
                stmt.executeUpdate("insert into STUDENT (SURNAME,NAM,PATR,SEX,NATIONALITY,YEAR_OF_BIRTH,ADDRES,PHONE,ID_GROUP) VALUES ('"+a+"','"+b+"','"+c+"','"+z+"','"+s+"','"+d+"','"+e+"','"+f+"',"+l+")");          }
            catch  (ClassNotFoundException | SQLException ex){
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE,null,ex); }
            finally{
                if(conn!=null){
                    try{
                        conn.close();
                        stmt.close();
                        rs.close();  }
                    catch (SQLException ex) {
                        Logger.getLogger(Test.class.getName()).log(Level.SEVERE,null,ex);   }} }}}
    void vivod()
    {fr.getContentPane().removeAll();
        JButton vod = new JButton("Поиск студента по ФИО");
        vod.setBounds(500,100,400,70);
        vod.addActionListener(new PoiskF());
        JButton vivod = new JButton("Поиск студента по группе");
        vivod.setBounds(500,200,400,70);
        vivod.addActionListener(new VivodG());
        JButton back = new JButton("Назад");
        back.setBounds(500,300,400,70);
        back.addActionListener(new Back2());
        fr.add(vod);
        fr.add(vivod);
        fr.add(back);
        fr.revalidate();
        fr.repaint(); }
    JComboBox grT  = new JComboBox();
    public class VivodG implements ActionListener{
        public void actionPerformed(ActionEvent event) {
            fr.getContentPane().removeAll();
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
                while(rs.next()){ if((Year-Integer.parseInt(rs.getString("YEAR_OF_FORMATION")))<=4){
                    if(8-Month>0){
                        grT.addItem(rs.getString("GROUP_NAME"));  }}} }
            catch  (ClassNotFoundException | SQLException ex){
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE,null,ex); }
            finally{ if(conn!=null){ try{
                conn.close();
                stmt.close();
                rs.close(); }
            catch (SQLException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE,null,ex); }}}
            JLabel viv = new JLabel("Выберете группу, в которой учиться студент");
            viv.setBounds(20,20,700,28);
            viv.setFont(new Font("Serif", Font.PLAIN, 24));
            JButton ok = new JButton("ОК");
            ok.setBounds(800,400,170,70);
            ok.addActionListener(new OK2());
            JButton back = new JButton("Назад");
            back.addActionListener(new Back3());
            back.setBounds(1000,400,170,70);
            grT.setBounds(20,70,280,25);
            fr.add(viv);
            fr.add(grT);
            fr.add(ok);
            fr.add(back);
            fr.revalidate();
            fr.repaint();}}
    JPanel wind1 =new JPanel();
    public class OK2 implements ActionListener{
        public void actionPerformed(ActionEvent event) {
            wind1.removeAll();
            String s = (String) grT.getSelectedItem();
            String[] columnName = {"Фамилия","Имя","Отчество","Пол","Нация","Дата рождения","Адрес",Телефон"       }; wind1.setLayout(null);
                    wind1.setBounds(20,120,1310,800);
            String[][] matrixA;
            Calendar calendar = Calendar.getInstance();
            int Month = calendar.get(Calendar.MONTH)+1;
            int Year = calendar.get(Calendar.YEAR);
            String m=null;
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
                            if(s.equals(rs.getString("GROUP_NAME"))) {
                                m=rs.getString("id"); }}}}
                int p = 0;
                rs = stmt.executeQuery("SELECT * FROM STUDENT");
                while(rs.next()){
                    if(m.equals(rs.getString("ID_GROUP"))) {
                        p++;}}
                matrixA = new String[p][8];
                int g=0;
                rs = stmt.executeQuery("SELECT * FROM STUDENT");
                while(rs.next()){
                    if(m.equals(rs.getString("ID_GROUP"))) {
                        matrixA[g][0] =  rs.getString("SURNAME");
                        matrixA[g][1] = rs.getString("NAM");
                        matrixA[g][2] = rs.getString("PATR");
                        matrixA[g][3] = rs.getString("SEX");
                        matrixA[g][4] = rs.getString("NATIONALITY");
                        matrixA[g][5] = rs.getString("YEAR_OF_BIRTH");
                        matrixA[g][6] = rs.getString("ADDRES");
                        matrixA[g][7] = rs.getString("PHONE");
                        g++;}}
                JTable table = new JTable(matrixA,columnName);
                JScrollPane scrollPane = new JScrollPane(table);
                scrollPane.setBounds(0,0,1310,280);
                wind1.add(scrollPane);}
            catch  (ClassNotFoundException | SQLException ex){
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE,null,ex); }
            finally{
                if(conn!=null){
                    try{ conn.close();
                        stmt.close();
                        rs.close();  }
                    catch (SQLException ex) {
                        Logger.getLogger(Test.class.getName()).log(Level.SEVERE,null,ex);  }}}
            fr.add(wind1);
            fr.revalidate();
            fr.repaint(); }}
        public class Vivod implements ActionListener{
            public void actionPerformed(ActionEvent event) {
                vivod(); }}
        void vivod1(){
            fr.getContentPane().removeAll();
            wind.removeAll();
            JLabel zapros = new JLabel("Введите ФИО студента");
            zapros.setFont(new Font("Serif", Font.PLAIN, 24));
            zapros.setBounds(20,20,280,28);
            zaprT.setBounds(320,20,680,28);
            JButton ok = new JButton("ОК");
            ok.setBounds(800,420,170,70);
            ok.addActionListener(new OK1());
            JButton back = new JButton("Назад");
            back.setBounds(1000,420,170,70);
            back.addActionListener(new Back3());
            fr.add(zapros);
            fr.add(zaprT);
            fr.add(ok);
            fr.add(back);
            fr.revalidate();
            fr.repaint();}
        JTextField zaprT = new JTextField();
        public class PoiskF implements ActionListener{
            public void actionPerformed(ActionEvent event) {
                vivod1(); }}
        JPanel wind =new JPanel();
        public class OK1 implements ActionListener{
            public void actionPerformed(ActionEvent event){
                fr.getContentPane().removeAll();
                wind.setLayout(null);
                String s = zaprT.getText();
                String[] words = s.split("\\s");
                JLabel fam = new JLabel("Фамилия");
                fam.setFont(new Font("Serif", Font.PLAIN, 24));
                fam.setBounds(20,0,280,28);
                JLabel name = new JLabel("Имя");
                name.setFont(new Font("Serif", Font.PLAIN, 24));
                name.setBounds(20,45,280,28);
                JLabel ot = new JLabel("Отчество");
                ot.setFont(new Font("Serif", Font.PLAIN, 24));
                ot.setBounds(20,90,280,28);
                JLabel dat = new JLabel("Дата рождения");
                dat.setFont(new Font("Serif", Font.PLAIN, 24));
                dat.setBounds(20,135,280,28);
                JLabel adress = new JLabel("Адрес");
                adress.setFont(new Font("Serif", Font.PLAIN, 24));
                adress.setBounds(20,180,280,28);
                JLabel phone = new JLabel("Телефон");
                phone.setFont(new Font("Serif", Font.PLAIN, 24));
                phone.setBounds(20,225,280,28);
                JLabel pol = new JLabel("Пол");
                pol.setFont(new Font("Serif", Font.PLAIN, 24));
                pol.setBounds(20,270,280,28);
                JLabel nac = new JLabel("Национальность");
                nac.setFont(new Font("Serif", Font.PLAIN, 24));
                nac.setBounds(20,315,280,28);
                JLabel group = new JLabel("Группа");
                group.setFont(new Font("Serif", Font.PLAIN, 24));
                group.setBounds(20,360,280,28);
                wind.add(fam);
                wind.add(name);
                wind.add(ot);
                wind.add(dat);
                wind.add(pol);
                wind.add(nac);
                wind.add(phone);
                wind.add(adress);
                wind.add(group);
                JLabel famV = new JLabel();
                famV.setFont(new Font("Serif", Font.PLAIN, 24));
                famV.setBounds(520,0,280,28);
                JLabel nameV = new JLabel();
                nameV.setFont(new Font("Serif", Font.PLAIN, 24));
                nameV.setBounds(520,45,280,28);
                JLabel otV = new JLabel();
                otV.setFont(new Font("Serif", Font.PLAIN, 24));
                otV.setBounds(520,90,280,28);
                JLabel datV = new JLabel();
                datV.setFont(new Font("Serif", Font.PLAIN, 24));
                datV.setBounds(520,135,280,28);
                JLabel adressV = new JLabel();
                adressV.setFont(new Font("Serif", Font.PLAIN, 24));
                adressV.setBounds(520,180,280,28);
                JLabel phoneV = new JLabel();
                phoneV.setFont(new Font("Serif", Font.PLAIN, 24));
                phoneV.setBounds(520,225,280,28);
                JLabel polV = new JLabel();
                polV.setFont(new Font("Serif", Font.PLAIN, 24));
                polV.setBounds(520,270,280,28);
                JLabel nacV = new JLabel();
                nacV.setFont(new Font("Serif", Font.PLAIN, 24));
                nacV.setBounds(520,315,280,28);
                JLabel groupV = new JLabel();
                groupV.setFont(new Font("Serif", Font.PLAIN, 24));
                groupV.setBounds(520,360,280,28);
                Connection conn = null;
                Statement stmt = null;
                ResultSet rs = null;
                try { Class.forName("org.h2.Driver");
                    conn = DriverManager.getConnection("jdbc:h2:file://c:\\test\\testbase","sa","");
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery("select * from STUDENT");
                    String q = null;
                    while(rs.next()){
                        if (words[0].equals(rs.getString("SURNAME"))&&words[1].equals(rs.getString("NAM"))&&words[2].equals(rs.getString("PATR"))) {
                            famV.setText(rs.getString("SURNAME"));
                            nameV.setText(rs.getString("NAM"));
                            otV.setText(rs.getString("PATR"));
                            datV.setText(rs.getString("YEAR_OF_BIRTH"));
                            adressV.setText(rs.getString("ADDRES"));
                            phoneV.setText(rs.getString("PHONE"));
                            polV.setText(rs.getString("SEX"));
                            nacV.setText(rs.getString("NATIONALITY"));
                            q = rs.getString("ID_GROUP");  } }
                    rs = stmt.executeQuery("select * from GROUPU");
                    while(rs.next()){
                        if(q.equals(rs.getString("id"))){
                            groupV.setText(rs.getString("GROUP_NAME"));   } } }
                catch  (ClassNotFoundException | SQLException ex){
                    Logger.getLogger(Test.class.getName()).log(Level.SEVERE,null,ex); }
                finally{ if(conn!=null){ try{
                    conn.close();
                    stmt.close();
                    rs.close();}
                catch (SQLException ex) {Logger.getLogger(Test.class.getName()).log(Level.SEVERE,null,ex);}}}
                wind.add(famV);
                wind.add(nameV);
                wind.add(otV);
                wind.add(datV);
                wind.add(polV);
                wind.add(nacV);
                wind.add(phoneV);
                wind.add(adressV);
                wind.add(groupV);
                wind.setBounds(20,20,900,1000);
                JButton back = new JButton("Назад");
                back.setBounds(1000,420,170,70);
                back.addActionListener(new Back4());
                fr.add(wind);
                fr.add(back);
                fr.revalidate();
                fr.repaint(); }}
        public class Back implements ActionListener{
            public void actionPerformed(ActionEvent event) {
                Int gui = new Int();
                gui.go();
                fr.setVisible(false);  }}
        public class Back2 implements ActionListener{
            public void actionPerformed(ActionEvent event){ opi1(fr);
                polT.removeAllItems();
                groupT.removeAllItems();}}
        public class Back3 implements ActionListener{
            public void actionPerformed(ActionEvent event)  { grT.removeAllItems();
                vivod();   }}
        public class Back4 implements ActionListener{
            public void actionPerformed(ActionEvent event)
            { vivod1();    }}}
