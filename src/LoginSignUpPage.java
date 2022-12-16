import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class LoginDetail{
	String username;
	String password;
	String firstName;
	String lastName;
	public LoginDetail(String uname,String pass,String firstN,String lastN){
		username=uname;
		password=pass;
		firstName=firstN;
		lastName=lastN;
	}
}

class StudentList2{
	String fname;
	String lname;
	String id;
	String ph;
	String classs;
	
	String gender;
	String fathername;
	String fatherph;
	String mothername;
	String motherph;
	String guardianname;
	String guardianph;
	
	String password;
	
	String mail;
	public StudentList2(String f,String l,String i,String c,String m,String p, String g,	String fn,String fph,String mn,String mph,String gn,String gph, String pass){
		fname=f;
		lname=l;
		id=i;
		classs=c;
		mail=m;
		ph=p;
		
		gender=g;
		fathername=fn;
		fatherph=fph;
		mothername=mn;
		motherph=mph;
		guardianname=gn;
		guardianph=gph;
		
		password = pass;
	}
}


class LoginSignUpPage{
	static LoginDetail[] loginDetailsObj;
	static int n;
	
	static StudentList2[] studentList;
	static int n1;
	
	static JFrame frame;
	
	static Color defaultMainColor = new Color(38,86,158);//new Color(26,176,34);
	static Color rolledOverColorBtn = new Color(0,103,255);
	
	static Color grey1 = new Color(186,186,186);
	static Color grey2 = new Color(122,121,121);
	static Color grey3 = new Color(238,238,238);
	
	LoginSignUpPage(){
		frame = new JFrame();
		frame.setBounds(600,175,425,532);
	}
	
	public static void LoadAllStudentDetails() {
		studentList = new StudentList2[100];
		File file = new File("Files\\StudentDetails.txt");
		n1=0;
		String fname="",lname="",id="",classs="",mail="",ph="",gender="";
		
		String fathername="",fatherph="";
		String mothername="",motherph="";
		String guardianname="",guardianph="";
		
		String password = "";
		
		Scanner sc;
		try {
			sc = new Scanner(file);
			sc.useDelimiter("[,,,,,,,,,,,,\n]");
			while(sc.hasNext()) {
				fname =sc.next().trim();
				lname =sc.next().trim();
				id  = sc.next().trim();
				classs  = sc.next().trim();
				mail  = sc.next().trim();
				ph  = sc.next().trim();
				gender  = sc.next().trim();
				fathername  = sc.next().trim();
				fatherph  = sc.next().trim();
				mothername  = sc.next().trim();
				motherph  = sc.next().trim();
				guardianname  = sc.next().trim();
				guardianph  = sc.next().trim();
				password = sc.next().trim();
				studentList[n1++]=new StudentList2(fname,lname,id,classs,mail,ph,gender,fathername,fatherph,mothername,motherph,guardianname,guardianph,id+"@123");			
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//for testing
		for(int i=0;i<n1;i++) {System.out.println(studentList[i].mail+","+studentList[i].password+"   "+(i+1));}
	}
	
	public static void LoadAllUsernameAndPassword(LoginSignUpPage loginSignUpPageObj) {
		loginDetailsObj = new LoginDetail[100];
		File file = new File("Files\\LoginDetails.txt");
		n=0;
		String uname="",pass="",firstName="",lastName="";
	    Scanner sc;
		try {
			sc = new Scanner(file);
			sc.useDelimiter("[,,,\n]");
			while(sc.hasNext()) {
				uname =loginSignUpPageObj.Decode(sc.next().trim());
				pass  =loginSignUpPageObj.Decode(sc.next().trim());
				firstName  =loginSignUpPageObj.Decode(sc.next().trim());
				lastName  =loginSignUpPageObj.Decode(sc.next().trim());
				loginDetailsObj[n++]=new LoginDetail(uname,pass,firstName,lastName);			
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//for testing
		//for(int i=0;i<n;i++) {System.out.println(loginDetailsObj[i].username+","+loginDetailsObj[i].password+","+loginDetailsObj[i].firstName+","+loginDetailsObj[i].lastName+",");}
	}
	
	public String Encode(String text) {
		for(int i=0;i<text.length();i++)
		{
			char ch =(char) (text.charAt(i)+12);
			text = text.substring(0, i) + ch + text.substring(i + 1);
		}
		return text;
	}
	
	public String Decode(String text) {
		for(int i=0;i<text.length();i++)
		{
			char ch =(char) (text.charAt(i)-12);
			text = text.substring(0, i) + ch + text.substring(i + 1);
		}
		return text;
	}
		
    public static void LoginPageGUI(LoginSignUpPage loginSignUpPageObj){
    	
    	//LOGO START
        BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("LogoPlaceHolder.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Image newImage = myPicture.getScaledInstance((int)(341/1.5),(int)(120/1.5), Image.SCALE_SMOOTH);
		//JLabel picLabel = new JLabel(new ImageIcon(newImage));
		//picLabel.setBounds(100,0,200,100);		
		//panel.add(picLabel);
		//LOGO END
        
        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(grey1);
                g.fillRect(20, 400, 370, 1);
                Graphics2D g2 = (Graphics2D) g;
                //g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                g.drawImage(newImage, 100, 0, null);
            }};
            
        Border br1 = BorderFactory.createLineBorder(defaultMainColor, 1, false);
        Border br2 = BorderFactory.createEmptyBorder(5,10,5,10);
        Border br = BorderFactory.createCompoundBorder(br1,br2);
        
        frame.setTitle("Login Student Enrollment And Management System");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	//ImageIcon img = new ImageIcon("IconPlaceHolder.png");frame.setIconImage(img.getImage());
    	Image imga= new ImageIcon("IconPlaceHolder.png").getImage().getScaledInstance((int)(500/1.2),(int)(500/1.2), Image.SCALE_SMOOTH);frame.setIconImage(imga);
        panel.setLayout(null);
               
        JLabel label1 = new JLabel("LOG IN TO YOUR ACCOUNT");
        label1.setBounds(30,93,420,20);
        label1.setFont(new Font("Archivo Black", Font.PLAIN, 15));
        
        JLabel validateText = new JLabel("");
        validateText.setBounds(30,280,420,20);        
        
        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(30,130,400,20);
        userLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        
        JTextField userTF = new JTextField();
        userTF.setBounds(30,160,350,35);
        userTF.setFont(new Font("Arial", Font.BOLD, 13));
        userTF.setBorder(br);
        userTF.setMargin(new Insets(10, 10, 10,50));
        
        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(30,205,400,20);
        passLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        
        JPasswordField passTF = new JPasswordField();
        passTF.setBounds(30,235,350,35);
        passTF.setFont(new Font("Arial", Font.BOLD, 13));
        passTF.setBorder(br);        
        
        JButton loginButton = new JButton("Log in");
        loginButton.setBounds(30,310,140,60);
        loginButton.setBackground(defaultMainColor);
        loginButton.setFont(new Font("Verdana", Font.BOLD, 15));
        loginButton.setForeground(Color.WHITE);
        loginButton.setBorderPainted(false);
        loginButton.setFocusPainted(false);
        loginButton.setOpaque(true);
        loginButton.getModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ButtonModel model = (ButtonModel) e.getSource();

                if (model.isRollover()) {
                	loginButton.setBackground(rolledOverColorBtn);
                } else if (model.isPressed()) {
                	loginButton.setBackground(rolledOverColorBtn);
                } else {
                	loginButton.setBackground(defaultMainColor);
                }
            }
        });
        loginButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		boolean verified1 = false,verified2=false;
        		int i,j;
        		String uname = userTF.getText();
        		String pass = passTF.getText();
        		
        		if(userTF.getText().equals("") && passTF.getText().equals("")) {
        			validateText.setText("Enter Username And Password");
        			validateText.setForeground(Color.RED);
        		}
        		else if(userTF.getText().equals("")) {
        			validateText.setText("Enter Username");
        			validateText.setForeground(Color.RED);
        		}
        		else if(passTF.getText().equals("")) {
        			validateText.setText("Enter Password");
        			validateText.setForeground(Color.RED);
        		}
        		else {
        			for(i=0;i<n && !verified1 ;i++) {
        				if(uname.equals(loginDetailsObj[i].username)) {
        					if(pass.equals(loginDetailsObj[i].password)) {
        						verified1 = true;
        					}
        				}
        			}
        			
        			for(j=0;j<n1 && !verified2 ;j++) {
        				if(uname.equals(studentList[j].mail)) {
        					if(pass.equals(studentList[j].password)) {
        						verified2 = true;
        					}
        				}
        			}
        			
        			if(verified1) {
        				validateText.setText("Welcome "+loginDetailsObj[i-1].firstName+" "+loginDetailsObj[i-1].lastName);
        				validateText.setForeground(Color.GREEN);
        				MainPage page = new MainPage();
        				page.MainPageRunner(loginDetailsObj[i-1].firstName, loginDetailsObj[i-1].lastName, loginDetailsObj[i-1].username);
        				frame.setVisible(false);
        			}
        			else if(verified2)
        			{
        				validateText.setText("Welcome "+studentList[j-1].fname+" "+studentList[j-1].lname);
        				validateText.setForeground(Color.GREEN);
        				MainPageStud pageStud = new MainPageStud();
        				pageStud.MainPageStudRunner(studentList[j-1].fname,studentList[j-1].lname,studentList[j-1].id,studentList[j-1].ph,studentList[j-1].classs,studentList[j-1].gender,studentList[j-1].fathername,studentList[j-1].fatherph,studentList[j-1].mothername,studentList[j-1].motherph,studentList[j-1].guardianname,studentList[j-1].guardianph,studentList[j-1].password,studentList[j-1].mail);
        				frame.setVisible(false);
        			}
        			else {
        				validateText.setText("Username or Password Incorrect");
        				validateText.setForeground(Color.RED);
        			}
        		}
        	}
        });
        
        JLabel signLabel = new JLabel("Don't have an account yet?");
        signLabel.setBounds(30,410,400,20);
        signLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
        signLabel.setForeground(grey2);
        
        JButton signUpBtn = new JButton("Sign Up");
        signUpBtn.setBounds(13,440,110,21);
        signUpBtn.setBackground(grey3);
        signUpBtn.setFont(new Font("Verdana", Font.BOLD, 16));
        signUpBtn.setForeground(defaultMainColor);
        signUpBtn.setBorderPainted(false);
        signUpBtn.setFocusPainted(false);
        signUpBtn.setOpaque(true);
        signUpBtn.getModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ButtonModel model = (ButtonModel) e.getSource();

                if (model.isRollover()) {
                	signUpBtn.setForeground(rolledOverColorBtn);
                } else if (model.isPressed()) {
                	signUpBtn.setBackground(grey3);
                } else {
                	signUpBtn.setForeground(defaultMainColor);
                }
            }
        });
        signUpBtn.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		SignUpPageGUI(loginSignUpPageObj);
        		panel.setVisible(false);
        	}
        });

        panel.add(label1);
        panel.add(userLabel);
        panel.add(userTF);
        panel.add(passLabel);
        panel.add(passTF);
        panel.add(loginButton);
        panel.add(validateText);
        panel.add(signLabel);
        panel.add(signUpBtn);
        
        frame.add(panel);
        frame.setVisible(true);
    }
    
    public static void SignUpPageGUI(LoginSignUpPage loginSignUpPageObj) {
    	
    	//LOGO START
        BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("LogoPlaceHolder.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Image newImage = myPicture.getScaledInstance((int)(341/1.5),(int)(120/1.5), Image.SCALE_SMOOTH);
		//JLabel picLabel = new JLabel(new ImageIcon(newImage));
		//picLabel.setBounds(100,0,200,100);		
		//panel.add(picLabel);
		//LOGO END	
    	
        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(grey1);
                g.fillRect(20, 440, 370, 1);
                Graphics2D g2 = (Graphics2D) g;
                //g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                g.drawImage(newImage, 100, 0, null);
            }};
            
            
        Border br1 = BorderFactory.createLineBorder(defaultMainColor, 1, false);
        Border br2 = BorderFactory.createEmptyBorder(5,10,5,10);
        Border br = BorderFactory.createCompoundBorder(br1,br2);        

        frame.setTitle("Sign Up Student Enrollment And Management System");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	ImageIcon img = new ImageIcon("IconPlaceHolder.png");
    	frame.setIconImage(img.getImage());
        panel.setLayout(null);        
        
       	
        
        JLabel label1 = new JLabel("SIGN UP");
        label1.setBounds(30,93,420,20);
        label1.setFont(new Font("Archivo Black", Font.PLAIN, 15));
        
        JLabel validateText = new JLabel("");
        validateText.setBounds(30,337,420,20);
        
        JLabel firstNameLabel = new JLabel("First Name");
        firstNameLabel.setBounds(30,115,400,20);
        firstNameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        
        JTextField firstNameTF = new JTextField();
        firstNameTF.setBounds(30,135,170,35);
        firstNameTF.setFont(new Font("Arial", Font.BOLD, 13));
        firstNameTF.setBorder(br);
        firstNameTF.setMargin(new Insets(10, 10, 10,50));
        
        JLabel lastNameLabel = new JLabel("Last Name");
        lastNameLabel.setBounds(210,115,400,20);
        lastNameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        
        JTextField lastNameTF = new JTextField();
        lastNameTF.setBounds(210,135,170,35);
        lastNameTF.setFont(new Font("Arial", Font.BOLD, 13));
        lastNameTF.setBorder(br);
        lastNameTF.setMargin(new Insets(10, 10, 10,50));
        
        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(30,170,400,20);
        userLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        
        JTextField userTF = new JTextField();
        userTF.setBounds(30,190,350,35);
        userTF.setFont(new Font("Arial", Font.BOLD, 13));
        userTF.setBorder(br);
        userTF.setMargin(new Insets(10, 10, 10,50));
        
        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(30,225,400,20);
        passLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        
        JPasswordField passTF = new JPasswordField();
        passTF.setBounds(30,245,350,35);
        passTF.setFont(new Font("Arial", Font.BOLD, 13));
        passTF.setBorder(br);
        
        JLabel confirPassLabel = new JLabel("Confirm Password");
        confirPassLabel.setBounds(30,280,400,20);
        confirPassLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        
        JPasswordField confirmPassTF = new JPasswordField();
        confirmPassTF.setBounds(30,300,350,35);
        confirmPassTF.setFont(new Font("Arial", Font.BOLD, 13));
        confirmPassTF.setBorder(br);        
        
        JButton signUpBtn = new JButton("Sign Up");
        signUpBtn.setBounds(30,360,140,60);
        signUpBtn.setBackground(defaultMainColor);
        signUpBtn.setFont(new Font("Verdana", Font.BOLD, 15));
        signUpBtn.setForeground(Color.WHITE);
        signUpBtn.setBorderPainted(false);
        signUpBtn.setFocusPainted(false);
        signUpBtn.setOpaque(true);
        signUpBtn.getModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ButtonModel model = (ButtonModel) e.getSource();

                if (model.isRollover()) {
                	signUpBtn.setBackground(rolledOverColorBtn);
                } else if (model.isPressed()) {
                	signUpBtn.setBackground(rolledOverColorBtn);
                } else {
                	signUpBtn.setBackground(defaultMainColor);
                }
            }
        });
        signUpBtn.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		boolean unameExist = false;
    			String firstN = firstNameTF.getText();
    			String lastN = lastNameTF.getText();
    			String uname = userTF.getText();
    			String pass = passTF.getText();
    			String confirmPass = confirmPassTF.getText();
    			
    			if(pass.equals(confirmPass) && !pass.equals("") && !confirmPass.equals("") && !firstN.equals("") && !lastN.equals("") && !uname.equals("")) {// && loginAndSignUpPageObj.checkValidUsernameAndPassword(uname, pass)) {
    				for(int i=0;i<n;i++) {
    					if(uname.equals(loginDetailsObj[i].username)) {
    						unameExist = true;
    						validateText.setText("Username Already Exist");
    						validateText.setForeground(Color.RED);
    					}
    				}
    				if(!unameExist) {
    					loginSignUpPageObj.writeUsernameAndPasswordToTextFile(uname, pass,firstN,lastN,loginSignUpPageObj);
    					loginDetailsObj[n++]=new LoginDetail(uname,pass,firstN,lastN);
    					validateText.setText("Account Created");
    					validateText.setForeground(Color.GREEN);
    				}
    			}
    			else if(pass.equals("") || confirmPass.equals("") || firstN.equals("") || lastN.equals("") || uname.equals("")) {
    				validateText.setText("Enter Details To Create An Account");
    				validateText.setForeground(Color.RED);
    			}
    			else {validateText.setText("Passwords Does not match");validateText.setForeground(Color.RED);}
        	}
        });
        
        JLabel loginLabel = new JLabel("Already have an account?");
        loginLabel.setBounds(30,450,400,20);
        loginLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
        loginLabel.setForeground(grey2);
        
        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(225,450,85,21);
        loginBtn.setBackground(grey3);
        loginBtn.setFont(new Font("Verdana", Font.BOLD, 16));
        loginBtn.setForeground(defaultMainColor);
        loginBtn.setBorderPainted(false);
        loginBtn.setFocusPainted(false);
        loginBtn.setOpaque(true);
        loginBtn.getModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ButtonModel model = (ButtonModel) e.getSource();

                if (model.isRollover()) {
                	loginBtn.setForeground(rolledOverColorBtn);
                } else if (model.isPressed()) {
                } else {
                	loginBtn.setForeground(defaultMainColor);
                }
            }
        });
        loginBtn.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		LoginPageGUI(loginSignUpPageObj);
        		panel.setVisible(false);
        	}
        });

        panel.add(label1);
        panel.add(firstNameLabel);
        panel.add(firstNameTF);
        panel.add(lastNameLabel);
        panel.add(lastNameTF);        
        panel.add(userLabel);
        panel.add(userTF);
        panel.add(passLabel);
        panel.add(passTF);
        panel.add(confirPassLabel);
        panel.add(confirmPassTF);
        panel.add(signUpBtn);
        panel.add(validateText);
        panel.add(loginLabel);
        panel.add(loginBtn);
        
        frame.add(panel);
        frame.setVisible(true);
    }
        
    public void writeUsernameAndPasswordToTextFile(String username,String password,String firstName,String lastName,LoginSignUpPage loginSignUpPageObj) {
		username=loginSignUpPageObj.Encode(username);
		password=loginSignUpPageObj.Encode(password);
		firstName=loginSignUpPageObj.Encode(firstName);
		lastName=loginSignUpPageObj.Encode(lastName);
		try {
			BufferedWriter myWriter = new BufferedWriter(new FileWriter("Files\\LoginDetails.txt",true));
		      myWriter.write(username+","+password+","+firstName+","+lastName);
		      myWriter.newLine();
		      myWriter.close();
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
    
    public static void main(String[] args) {
    	LoginSignUpPage loginSignUpPageObj = new LoginSignUpPage();
    	LoadAllUsernameAndPassword(loginSignUpPageObj);
    	LoadAllStudentDetails();
    	LoginPageGUI(loginSignUpPageObj);
    }
}