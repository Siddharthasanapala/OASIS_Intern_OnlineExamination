import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  
import java.lang.Exception; 
import java.util.Timer;
import java.util.TimerTask; 

public class OnlineExamination extends Frame{
    public static String User_Name,PWD;
    public void loginForm(){
        JLabel user,det,pass;
        JFrame f1= new JFrame();
        JTextField UID;
        JPasswordField pwd;
        JButton submit,clear;
        det = new JLabel("Please Login to your Account");
        det.setBounds(40,40,400,40);
        user = new JLabel("Enter User ID : ");
        user.setBounds(40,90,120,40);
        pass = new JLabel("Enter Password : ");
        pass.setBounds(40,150,150,40);
        UID = new JTextField("User ID");
        UID.setBounds(210,95,150,30);
        pwd = new JPasswordField("");
        pwd.setBounds(210,159,150,30);
        submit = new JButton("SUBMIT");
        submit.setBounds(80,210,100,35);
        clear = new JButton("CLEAR");
        clear.setBounds(200,210,100,35);
        f1.add(user);f1.add(det);f1.add(UID);
        f1.add(user);f1.add(det);f1.add(UID);
        f1.add(pwd);f1.add(pass);f1.add(submit);f1.add(clear);
        submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent p){
                if (!new String(pwd.getPassword()).equals("")){
                    User_Name=UID.getText();
                    PWD=new String(pwd.getPassword());
                    home(User_Name);
                }
            }
        });
        clear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                UID.setText("");
                pwd.setText("");
            }
        });
        f1.setSize(800,800);
        f1.setTitle("Login Page");
        f1.setLayout(null);
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void home(String s){
        String un="Home Page - "+s;
        JFrame f2 = new JFrame();
        JButton UpdP,UpdPsw,StEx;
        UpdP = new JButton("Update UserID");
        UpdP.setBounds(60,100,200,45);
        UpdPsw = new JButton("Change Password");
        UpdPsw.setBounds(290,100,200,45);
        StEx = new JButton("Start Exam");
        StEx.setBounds(170,220,200,45);
        UpdP.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent  D){
                UpdateProfile(User_Name);
            }
        });
        UpdPsw.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent  F){
                UpdatePassword(PWD);
            }
        });
        StEx.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent  G){
                new BeginTest(User_Name);
            }
        });
        f2.setSize(800,800);
        f2.setTitle(un);
        f2.add(UpdPsw);f2.add(UpdP);f2.add(StEx);
        f2.setLayout(null);
        f2.setVisible(true);
        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void UpdateProfile(String nme){
        String UP= "Updating Profile - "+nme;
        JFrame f3 = new JFrame();
        JPasswordField PD;
        JTextField new_UID;
        JButton submit,clear;
        JLabel up_UID,en_pd;
        up_UID = new JLabel("Enter New User ID : ");
        up_UID.setBounds(40,90,200,40);
        en_pd = new JLabel("Enter Your Password : ");
        en_pd.setBounds(40,150,200,40);
        new_UID = new JTextField("User ID");
        new_UID.setBounds(210,95,150,30);
        PD = new JPasswordField("");
        PD.setBounds(210,159,150,30);
        submit = new JButton("SUBMIT");
        submit.setBounds(80,210,100,35);
        clear = new JButton("CLEAR");
        clear.setBounds(200,210,100,35);
        f3.setTitle(UP);
        f3.add(up_UID);f3.add(en_pd);f3.add(new_UID);f3.add(PD);
        f3.add(clear);f3.add(submit);
        submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent p){
                if(new String(PD.getPassword()).equals(PWD)){
                    User_Name=new_UID.getText();
                    home(User_Name);
                }
            }
        });
        clear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new_UID.setText("");
                PD.setText("");
            }
        });
        f3.setSize(800,800);
        f3.setLayout(null);
        f3.setVisible(true);
        f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void UpdatePassword(String P){
        String UP= "Updating Password - "+P;
        JFrame f4 = new JFrame();
        JTextField old_P;
        JButton submit,clear;
        JLabel T_old_pwd,T_new_pwd,TC_new_pwd;
        JPasswordField en_newPd,cfm_newPd;
        T_old_pwd = new JLabel("Enter old Password : ");
        T_old_pwd.setBounds(40,90,120,40);
        T_new_pwd = new JLabel("Enter Your New Password : ");
        T_new_pwd.setBounds(40,150,150,40);
        TC_new_pwd = new JLabel("Confirm Your New Password : ");
        TC_new_pwd.setBounds(40,210,150,40);
        old_P = new JTextField("old password");
        old_P.setBounds(210,95,150,30);
        en_newPd = new JPasswordField("");
        en_newPd.setBounds(210,159,150,30);
        cfm_newPd = new JPasswordField("");
        cfm_newPd.setBounds(210,219,150,30);
        submit = new JButton("SUBMIT");
        submit.setBounds(80,280,100,35);
        clear = new JButton("CLEAR");
        clear.setBounds(200,280,100,35);
        f4.setTitle(UP);
        f4.add(T_old_pwd);f4.add(T_new_pwd);f4.add(TC_new_pwd);f4.add(old_P);
        f4.add(en_newPd);f4.add(cfm_newPd);f4.add(submit);f4.add(clear);
        submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent p){
                if((old_P.getText()).equals(PWD) && (new String(en_newPd.getPassword())).equals(new String(cfm_newPd.getPassword())) ){  
                    PWD=new String(en_newPd.getPassword());
                    home(User_Name);
                }
            }
        });
        clear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                old_P.setText("");
                en_newPd.setText("");
                cfm_newPd.setText("");
            }
        });
        f4.setSize(800,800);
        f4.setLayout(null);
        f4.setVisible(true);
        f4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String args[]){
        OnlineExamination te=new OnlineExamination();
        te.loginForm();
    }
}

class BeginTest extends JFrame implements ActionListener{
    JLabel maintxt,lb1,lb2;
    JRadioButton op[]=new JRadioButton[6];
    JButton sub,save_n,mark_r;
    ButtonGroup BG;
    int count=0,current=0,rn=1,y=1,now=0;
    static int rev[]=new int[10];
    Timer TIME = new Timer();
    void Question()  
    {  
        op[4].setSelected(true);  
        if(current==0)  
        {  
            lb1.setText("Que1: Who invented Java Programming?");  
            op[0].setText("Guido van Rossum");op[1].setText("James Gosling");op[2].setText("Dennis Ritchie");op[3].setText("Bjarne Stroustrup");   
        }  
        if(current==1)  
        {  
            lb1.setText("Que2: Which component is used to compile, debug and execute the java programs?");  
            op[0].setText("JRE");op[1].setText("JIT");op[2].setText("JDK");op[3].setText("JVM");  
        }  
        if(current==2)  
        {  
            lb1.setText("Que3: Which one of the following is not a Java feature?");  
            op[0].setText("Object-oriented");op[1].setText("Use of pointers");op[2].setText("Portable");op[3].setText("Dynamic and Extensible");  
        }  
        if(current==3)  
        {  
            lb1.setText("Que4: Which of these cannot be used for a variable name in Java?");  
            op[0].setText("identifier & keyword");op[1].setText("identifier");op[2].setText("keyword");op[3].setText("none of the mentioned");  
        }  
        if(current==4)  
        {  
            lb1.setText("Que5: Which environment variable is used to set the java path?");  
            op[0].setText("MAVEN_Path");op[1].setText("JavaPATH");op[2].setText("JAVA");op[3].setText("JAVA_HOME");  
        }  
        if(current==5)  
        {  
            lb1.setText("Que6: Which of the following is a type of polymorphism in Java Programming?");  
            op[0].setText("Multiple polymorphism");op[1].setText("Compile time polymorphism");op[2].setText("Multilevel polymorphism");op[3].setText("Execution time polymorphism");  
        }  
        if(current==6)  
        {  
            lb1.setText("Que7: What is not the use of “this” keyword in Java?");  
            op[0].setText(" Referring to the instance variable when a local variable has the same name");op[1].setText(" Passing itself to another method");  
            op[3].setText("Calling another constructor in constructor chaining");  
        }  
        if(current==7)  
        {  
            lb1.setText("Que8: What is Truncation in Java?");  
            op[0].setText("Floating-point value assigned to a Floating type");op[1].setText("Floating-point value assigned to an integer type");op[2].setText("Integer value assigned to floating type");  
            op[3].setText("Integer value assigned to floating type");         
        }  
        if(current==8)  
        {  
            lb1.setText("Que9: Which exception is thrown when java is out of memory?");  
            op[0].setText("MemoryError");op[1].setText("OutOfMemoryError");op[2].setText("MemoryOutOfBoundsException");op[3].setText("MemoryFullException");  
        }  
        if(current==9)  
        {  
            lb1.setText("Que10: Which of the following is a superclass of every class in Java?");  
            op[0].setText("ArrayList");op[1].setText("Abstract class");op[2].setText(" Object class");  
                        op[3].setText("String");  
        }  
        lb1.setBounds(30,50,8000,20);  
        for(int i=0,j=0;i<=90;i+=30,j++)  
            op[j].setBounds(50,80+i,400,20);  
    }  
    boolean answer()  
    {  
        if(current==0)  
            return(op[1].isSelected());  
        if(current==1)  
            return(op[2].isSelected());  
        if(current==2)  
            return(op[1].isSelected());  
        if(current==3)  
            return(op[2].isSelected());  
        if(current==4)  
            return(op[3].isSelected());  
        if(current==5)  
            return(op[1].isSelected());  
        if(current==6)  
            return(op[1].isSelected());  
        if(current==7)  
            return(op[1].isSelected());  
        if(current==8)  
            return(op[1].isSelected());  
        if(current==9)  
            return(op[2].isSelected());  
        return false;  
    } 
    BeginTest(String USER){
        lb1=new JLabel(); 
        lb1.setBounds(30,40,450,30);
        lb2 = new JLabel();
        lb2.setBounds(20,20,450,30);
        BG=new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            op[i]=new JRadioButton();     
            add(op[i]);  
            BG.add(op[i]);  
        } 
        Question();
        op[0].setBounds(50,80,200,20);  
        op[1].setBounds(50,110,200,20);  
        op[2].setBounds(50,140,200,20);  
        op[3].setBounds(50,170,200,20);
        save_n=new JButton("Save and Next");  
        save_n.setBounds(80,240,150,30);
        mark_r=new JButton("Mark for Review and next");
        mark_r.setBounds(270,240,230,30); 
        save_n.addActionListener(this);  
        mark_r.addActionListener(this); 
        add(lb1);add(lb2);add(mark_r);add(save_n);
        add(op[0]);add(op[1]);add(op[2]);add(op[3]);
        setSize(800,800);
        setLocation(250,100); 
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TIME.scheduleAtFixedRate(new TimerTask() {
            int i = 500;
            public void run() {  
                lb2.setText("Time left : " + i);
                i--;   
                if (i < 0) {
                    TIME.cancel();
                    lb2.setText("Time Out");                     
                } 
            }
        }, 0, 1000); 
    }
    public void actionPerformed(ActionEvent e)  
    {          
        if(e.getSource()==save_n)  
        {  
            if(answer())  
                count=count+1;  
            current++;  
            Question();    
            if(current==9)  
            {  
                save_n.setEnabled(false); 
                mark_r.setText("Submit");  
            }  
        }  
        if(e.getActionCommand().equals("Mark for Review and next"))  
        {  
            JButton NEW_B=new JButton("Review-"+rn);  
            NEW_B.setBounds(600,40+30*rn,100,30);  
            add(NEW_B);  
            NEW_B.addActionListener(this);  
            rev[rn]=current;  
            rn++;  
            current++;  
            Question();    
            if(current==9)  
                save_n.setText("Submit");
            setVisible(false);  
            setVisible(true);  
        }  
        for(int i=0,y=1;i<rn;i++,y++)  
        {  
        if(e.getActionCommand().equals("Review-"+y))  
        {  
            if(answer())  
                count=count+1;  
            now=current;  
            current=rev[y];  
            Question();  
            ((JButton)e.getSource()).setEnabled(false);  
            current=now;  
        }  
        }      
        if(e.getActionCommand().equals("Submit"))  
        {  
            if(answer())  
                count=count+1;  
            current++;  
            JOptionPane.showMessageDialog(this,"You Score = "+count);  
            System.exit(0);  
        }  
    }  
    
}