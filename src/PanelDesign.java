import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    



class StudentList{
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
	public StudentList(String f,String l,String i,String c,String m,String p, String g,	String fn,String fph,String mn,String mph,String gn,String gph, String pass){
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
class ClassList{
	String name;
	String section;
	String creationDate;
	public ClassList(String n,String s,String c){
		name=n;
		section=s;
		creationDate = c;
	}
}

class NoticeList{
	String Title;
	String Date;
	String Message;
	String forClass;
	Boolean Full=false;
	public NoticeList(String t,String d,String m,String forC,Boolean f){
		Title=t;
		Date=d;
		Message=m;
		forClass = forC;
		Full=f;
	}
}

class PublicNoticeList{
	String Title;
	String Date;
	String Message;
	Boolean Full=false;
	public PublicNoticeList(String t,String d,String m,Boolean f){
		Title=t;
		Date=d;
		Message=m;
		Full=f;
	}
}

public class PanelDesign {
	static String classsss[];
	static StudentList[] studentList; static int n,totPagesStud=0;static JPanel studDetailsPanel[]=new JPanel[20];static int studDetailspage=0;
	
	static ClassList[] classList; static int n1,totPagesClass=0;static JPanel classDetailsPanel[]=new JPanel[5];static int classDetailspage=0;
	
	static JComboBox<String> classTF = new JComboBox<String>(),sectionTF;
	
	public String[] UpdateClasss() {
		classsss = new String[n1];
		for(int i=0;i<n1;i++)classsss[i]= (classList[i].name)+" "+(classList[i].section);
	    System.out.print(classsss);
	    return classsss;
	}
	
	public void changeDetailsInComboBox(JComboBox<String> op) {
		op.removeAllItems();
		String[] new_entries=UpdateClasss();
		for (String s : new_entries) {
		     op.insertItemAt(s, op.getItemCount());
		}
		op.setSelectedIndex(0);
	}
	
	public static void LoadAllStudentDetails() {
		studentList = new StudentList[100];
		File file = new File("Files\\StudentDetails.txt");
		n=0;
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
				studentList[n++]=new StudentList(fname,lname,id,classs,mail,ph,gender,fathername,fatherph,mothername,motherph,guardianname,guardianph,id+"@123");			
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//for testing
		//for(int i=0;i<n;i++) {System.out.println(studentList[i].name+","+studentList[i].id+","+studentList[i].classs+","+studentList[i].mail+","+studentList[i].ph+"   "+(i+1));}
	}
	
	public static void LoadAllClassDetails() {
		classList = new ClassList[100];
		File file = new File("Files\\ClassDetails.txt");
		n1=0;
		String name="",section="",creationDate="";
	    Scanner sc;
		try {
			sc = new Scanner(file);
			sc.useDelimiter("[,,\n]");
			while(sc.hasNext()) {
				name =sc.next().trim();
				section  = sc.next().trim();
				creationDate = sc.next().trim();
				classList[n1++]=new ClassList(name,section,creationDate);			
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//for testing
		//for(int i=0;i<n1;i++) {System.out.println(classList[i].name+","+classList[i].section+","+classList[i].creationDate+"   "+(i+1));}
	}

	static void writeStudDetailsToTextFile(String lname,String fname,String id,String classs,String mail,String ph, String g, String fn,String fph,String mn,String mph,String gn,String gph, String pass) {
		try {
			BufferedWriter myWriter = new BufferedWriter(new FileWriter("Files\\StudentDetails.txt",true));
			myWriter.write(fname+","+lname+","+id+","+classs+","+mail+","+ph+","+g+","+fn+","+fph+","+mn+","+mph+","+gn+","+gph+","+pass);
			myWriter.newLine();
			myWriter.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	
	static void writeClassDetailsToTextFile(String name,String section,String creationDate) {
		try {
			BufferedWriter myWriter = new BufferedWriter(new FileWriter("Files\\ClassDetails.txt",true));
			myWriter.write(name+","+section+","+creationDate);
			myWriter.newLine();
			myWriter.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	
	static void ArrangeStudDetails(JPanel panel,JPanel viewStudPanel) {
		//view Student Details
		int k=0;
		totPagesStud=0;
		for(int i=0;k<n;i++)
		{
			studDetailsPanel[i].removeAll();studentList(5,"Sl No.","Student", "Name","Student ID","Class","Student Email","Phone No.",studDetailsPanel[i]);
			totPagesStud++;
			for(int j=0;j<8 && k<n;j++) {
				studentList(50+(40*j),String.valueOf(k+1),studentList[k].fname,studentList[k].lname,studentList[k].id,studentList[k].classs,studentList[k].mail,studentList[k].ph,studDetailsPanel[i]);
				k++;
			}
			viewStudPanel.add(studDetailsPanel[i]);
		}
		for(int i=0;i<totPagesStud;i++)studDetailsPanel[i].setVisible(false);
		studDetailsPanel[0].setVisible(true);
		studDetailspage=0;
	}
	
	static void ArrangeClassDetails(JPanel panel,JPanel viewClassPanel) {
		//view Student Details
		int k=0;
		totPagesClass=0;
		for(int i=0;k<n1;i++)
		{
			classDetailsPanel[i].removeAll();classList(5,"Sl No.","Class Name","Section","Creation Date",classDetailsPanel[i]);
			totPagesClass++;
			for(int j=0;j<5 && k<n1;j++) {
				classList(50+(40*j),String.valueOf(k+1),classList[k].name,classList[k].section,classList[k].creationDate,classDetailsPanel[i]);
				k++;
			}
			viewClassPanel.add(classDetailsPanel[i]);
		}
		for(int i=0;i<totPagesClass;i++)classDetailsPanel[i].setVisible(false);
		classDetailsPanel[0].setVisible(true);
		classDetailspage=0;
	}
	
	static Color defaultMainColor = new Color(38,86,158);//new Color(26,176,34);
	static Color rolledOverColorBtn = new Color(0,103,255);
	static Color BTNSelectedColor = new Color(200,200,200);

	PanelDesign(){
		LoadAllStudentDetails();
		LoadAllClassDetails();
	}
	
	
	public static JPanel createStudentListPanel(JPanel panel) {
		//view Student Details
		JPanel detailsPanel = new JPanel(){
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				
				Graphics2D g1 = (Graphics2D) g;
                g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

				g1.setColor(new Color(227, 227, 227));
				g1.fillRoundRect(1, 1,panel.getBounds().width-201,43, 20, 20);
				g1.fillRect(1, 21,panel.getBounds().width-201,23);
				
				g1.setColor(new Color(209, 207, 207));
				g1.drawLine(1, 44, panel.getBounds().width-201, 43);
				g1.drawLine(6, 84, panel.getBounds().width-206, 83);
				g1.drawLine(6, 124, panel.getBounds().width-206, 123);
				g1.drawLine(6, 164, panel.getBounds().width-206, 163);
				g1.drawLine(6, 204, panel.getBounds().width-206, 203);
				g1.drawLine(6, 244, panel.getBounds().width-206, 243);
				g1.drawLine(6, 284, panel.getBounds().width-206, 283);
				g1.drawLine(6, 324, panel.getBounds().width-206, 323);
				g1.drawRoundRect(1, 1,panel.getBounds().width-201,369, 20, 20);
			}};
		detailsPanel.setOpaque(false);
		detailsPanel.setBounds(100,110,panel.getBounds().width-200,380);
		detailsPanel.setBackground(Color.RED);
		detailsPanel.setLayout(null);
		return detailsPanel;
	}
	
	public static JPanel createClassListPanel(JPanel panel) {
		//view Student Details
		JPanel detailsPanel = new JPanel(){
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				
				Graphics2D g1 = (Graphics2D) g;
                g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

				g1.setColor(new Color(227, 227, 227));
				g1.fillRoundRect(1, 1,panel.getBounds().width-201,43, 20, 20);
				g1.fillRect(1, 21,panel.getBounds().width-201,23);
				
				g1.setColor(new Color(209, 207, 207));
				g1.drawLine(1, 44, panel.getBounds().width-201, 43);
				g1.drawLine(6, 84, panel.getBounds().width-206, 83);
				g1.drawLine(6, 124, panel.getBounds().width-206, 123);
				g1.drawLine(6, 164, panel.getBounds().width-206, 163);
				g1.drawLine(6, 204, panel.getBounds().width-206, 203);
				g1.drawRoundRect(1, 1,panel.getBounds().width-201,249, 20, 20);
			}};
		detailsPanel.setOpaque(false);
		detailsPanel.setBounds(100,110,panel.getBounds().width-200,380);
		detailsPanel.setBackground(Color.RED);
		detailsPanel.setLayout(null);
		return detailsPanel;
	}

	static void studentList(int y, String slno, String fname, String lname, String id, String section, String uname, String phno, JPanel panel) {
		int offset = -10;
		Font font;
		//if(id.equals("Student ID")) font = new Font("Segoe UI Black", Font.BOLD, 17);else font = new Font("MS PGothic", Font.BOLD, 16);
		font = new Font("MS PGothic", Font.BOLD, 16);
		JLabel slLabel = new JLabel(slno);
			slLabel.setBounds(30+offset, y, 60, 30);
			slLabel.setFont(font);
			panel.add(slLabel);
		JLabel nameLabel = new JLabel(fname+" "+lname);
				nameLabel.setBounds(120+offset, y, 300, 30);
				nameLabel.setFont(font);
				panel.add(nameLabel);
		JLabel idLabel = new JLabel(id);
			idLabel.setBounds(450+offset, y, 100, 30);
			idLabel.setFont(font);
			panel.add(idLabel);
		JLabel sectionLabel = new JLabel(section);
				sectionLabel.setBounds(620+offset, y, 50, 30);
				sectionLabel.setFont(font);
				panel.add(sectionLabel);			
		JLabel unameLabel = new JLabel(uname);
				unameLabel.setBounds(720+offset, y, 250, 30);
				unameLabel.setFont(font);
				panel.add(unameLabel);

		JLabel phLabel = new JLabel(phno);
				phLabel.setBounds(965+offset, y, 300, 30);
				phLabel.setFont(font);
				panel.add(phLabel);
		
		
	}
	
	static void classList(int y, String slno, String name, String section, String creationDate, JPanel panel) {
		int offset = -10;
		Font font;
		font = new Font("MS PGothic", Font.BOLD, 16);
		JLabel slLabel = new JLabel(slno);
			slLabel.setBounds(30+offset, y, 60, 30);
			slLabel.setFont(font);
			panel.add(slLabel);
		JLabel nameLabel = new JLabel(name);
				nameLabel.setBounds(120+offset, y, 300, 30);
				nameLabel.setFont(font);
				panel.add(nameLabel);		
		JLabel sectionLabel = new JLabel(section);
				if(section.equals("Section"))sectionLabel.setBounds(550+offset, y, 200, 30);
				else sectionLabel.setBounds(570+offset, y, 200, 30);
				sectionLabel.setFont(font);
				panel.add(sectionLabel);			
		JLabel unameLabel = new JLabel(creationDate);
				unameLabel.setBounds(720+offset, y, 250, 30);
				unameLabel.setFont(font);
				panel.add(unameLabel);		
	}
	
	public void StudentPanel(JPanel panel,JFrame frame, int screenWidth){
				
		
		for(int i =0; i<20;i++)studDetailsPanel[i]=createStudentListPanel(panel);
				
				JPanel viewStudPanel = new JPanel(){
					protected void paintComponent(Graphics g) {
						super.paintComponent(g);
						Graphics2D g1 = (Graphics2D) g;
		                g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
						g1.setColor(Color.WHITE);
						g1.fillArc(0, panel.getBounds().height-60-20, 20, 20, 180, 90);
						g1.fillArc(panel.getBounds().width-20, panel.getBounds().height-60-20, 20, 20, 270, 90);
						g1.fillRect(0, 0, panel.getBounds().width, panel.getBounds().height-65);
						g1.fillRect(10, panel.getBounds().height-65,panel.getBounds().width-20,10);
						//g.fillRoundRect( 0, 0,panel.getBounds().width-3, panel.getBounds().height-60, 20, 20);
					}};
					viewStudPanel.setBounds(0, 60, panel.getBounds().width-2, panel.getBounds().height-60);
					viewStudPanel.setOpaque(false);
					viewStudPanel.setLayout(null);
					viewStudPanel.setVisible(true);
					
				JLabel addStudSuccessfull = new JLabel("");
					
				JPanel addStudPanel = new JPanel(){
						protected void paintComponent(Graphics g) {
							super.paintComponent(g);
							Graphics2D g1 = (Graphics2D) g;
			                g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
							g1.setColor(Color.WHITE);
							g1.fillArc(0, panel.getBounds().height-60-20, 20, 20, 180, 90);
							g1.fillArc(panel.getBounds().width-20, panel.getBounds().height-60-20, 20, 20, 270, 90);
							g1.fillRect(0, 0, panel.getBounds().width, panel.getBounds().height-65);
							g1.fillRect(10, panel.getBounds().height-65,panel.getBounds().width-20,10);
						}};
						addStudPanel.setBounds(0, 60, panel.getBounds().width-2, panel.getBounds().height-60);
						addStudPanel.setOpaque(false);
						addStudPanel.setVisible(false);
				
				
				JButton addStudBTN,viewStudBTN;
				JLabel addStudLabel,viewStudLabel;

				viewStudBTN = new JButton("View Student List");
				addStudBTN = new JButton("Add Student");
				
				viewStudLabel = new JLabel("View Student List");
				addStudLabel = new JLabel("Add Student");
				viewStudLabel.setBounds(10,0,panel.getBounds().width/2-10,60);
				viewStudLabel.setFont(new Font("MS PGothic", Font.BOLD, 16));
				viewStudLabel.setHorizontalAlignment(SwingConstants.CENTER);
				addStudLabel.setBounds(panel.getBounds().width/2,0,panel.getBounds().width/2-10,60);
				addStudLabel.setFont(new Font("MS PGothic", Font.BOLD, 16));
				addStudLabel.setHorizontalAlignment(SwingConstants.CENTER);
				
				viewStudBTN.setBounds(0,0,panel.getBounds().width/2,60);
				viewStudBTN.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						addStudSuccessfull.setText("");
						addStudPanel.setVisible(false);					
						viewStudPanel.setVisible(true);
						addStudBTN.setVisible(true);
						viewStudBTN.setVisible(false);
					}
				});
				viewStudBTN.setVisible(false);
				viewStudBTN.setFont(new Font("MS PGothic", Font.BOLD, 16));
				viewStudBTN.setBackground(BTNSelectedColor);
				viewStudBTN.setBorderPainted(false);
				viewStudBTN.setFocusPainted(false);
				viewStudBTN.setOpaque(true);
				
				addStudBTN.setBounds(panel.getBounds().width/2,0,panel.getBounds().width/2-2,60);
				addStudBTN.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						viewStudPanel.setVisible(false);
						addStudPanel.setVisible(true);
						viewStudBTN.setVisible(true);
						addStudBTN.setVisible(false);
					}
				});
				addStudBTN.setVisible(true);
				addStudBTN.setFont(new Font("MS PGothic", Font.BOLD, 16));
				addStudBTN.setBackground(BTNSelectedColor);
				addStudBTN.setBorderPainted(false);
				addStudBTN.setFocusPainted(false);
				addStudBTN.setOpaque(true);
				addStudPanel.setLayout(null);
				
				panel.add(viewStudBTN);
				panel.add(addStudBTN);
				panel.add(viewStudLabel);
				panel.add(addStudLabel);
				panel.add(viewStudPanel);
				panel.add(addStudPanel);
				
				//Add Student
				int textFieldHeight = 40, x1 = 40, x2 = addStudPanel.getWidth()/2+20;
				Font textFieldFont = new Font("MS PGothic", Font.BOLD, 14);
				
				JLabel studDetailsLabel = new JLabel("Student's details");
				studDetailsLabel.setBounds(40,5,500,40);
				studDetailsLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
				addStudPanel.add(studDetailsLabel);
				
				JLabel fnameLabel = new JLabel("Student's First Name");
				fnameLabel.setBounds(x1,40,addStudPanel.getWidth()/2-x1-20,textFieldHeight);
				addStudPanel.add(fnameLabel);
				JTextField fnameTF = new JTextField();
				fnameTF.setBounds(x1,fnameLabel.getBounds().y+textFieldHeight-10,(addStudPanel.getWidth()/2-x1-20)/2,textFieldHeight);
				fnameTF.setFont(textFieldFont);
				fnameTF.setMargin(new Insets(10, 10, 10,50));
				fnameTF.addKeyListener(new KeyAdapter() {
			         public void keyPressed(KeyEvent ke) {
			        	 addStudSuccessfull.setText("");
			         }
			      });
				addStudPanel.add(fnameTF);
				
				JLabel lnameLabel = new JLabel("Student's Last Name");
				lnameLabel.setBounds((addStudPanel.getWidth()/2-x1-20)/2+50,40,addStudPanel.getWidth()/2-x1-20,textFieldHeight);
				addStudPanel.add(lnameLabel);
				JTextField lnameTF = new JTextField();
				lnameTF.setBounds((addStudPanel.getWidth()/2-x1-20)/2+50,lnameLabel.getBounds().y+textFieldHeight-10,(addStudPanel.getWidth()/2-x1-20)/2,textFieldHeight);
				lnameTF.setFont(textFieldFont);
				lnameTF.setMargin(new Insets(10, 10, 10,50));
				lnameTF.addKeyListener(new KeyAdapter() {
			         public void keyPressed(KeyEvent ke) {
			        	 addStudSuccessfull.setText("");
			         }
			      });
				addStudPanel.add(lnameTF);
				
				JLabel idLabel = new JLabel("Student's ID");
				idLabel.setBounds(x2,40,addStudPanel.getWidth()/2-x1-20,textFieldHeight);
				addStudPanel.add(idLabel);
				JTextField idTF = new JTextField();
				idTF.setBounds(x2,idLabel.getBounds().y+textFieldHeight-10,addStudPanel.getWidth()/2-x1-20,textFieldHeight);
				idTF.setFont(textFieldFont);
				idTF.setMargin(new Insets(10, 10, 10,50));
				idTF.addKeyListener(new KeyAdapter() {
			         public void keyPressed(KeyEvent ke) {
			            String value = idTF.getText();
			            int l = value.length();
			            if (l<10 && ke.getKeyChar() != ' ') {
			            	idTF.setEditable(true);
			            }
			            else if(ke.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE) {
			            	idTF.setEditable(true);
			            }
			            else {
			            	idTF.setEditable(false);
			            }
			         }
			      });
				addStudPanel.add(idTF);
				
				JLabel phLabel = new JLabel("Student's Phone No.");
				phLabel.setBounds(40,120,addStudPanel.getWidth()/3-40,textFieldHeight);
				addStudPanel.add(phLabel);
				JTextField phTF = new JTextField();
				phTF.setBounds(40,120+textFieldHeight-10,addStudPanel.getWidth()/3-40,textFieldHeight);
				phTF.setFont(textFieldFont);
				phTF.setMargin(new Insets(10, 10, 10,50));
				phTF.addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent ke) {
						String value = phTF.getText();
						int l = value.length();
						if (ke.getKeyChar() >= '0' && ke.getKeyChar() != ' '&& ke.getKeyChar() <= '9' && l<10) {
							phTF.setEditable(true);
						}
						else if(ke.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE) {
							phTF.setEditable(true);
						}
						else {
							phTF.setEditable(false);
						}
					}
				});
				addStudPanel.add(phTF);
				
				UpdateClasss();
				JLabel classLabel = new JLabel("Student's Class");
				classLabel.setBounds(addStudPanel.getWidth()/3+20,120,addStudPanel.getWidth()/3-40,textFieldHeight);
				addStudPanel.add(classLabel);				
				classTF = new JComboBox(classsss);
				classTF.setBounds(addStudPanel.getWidth()/3+20,120+textFieldHeight-10,addStudPanel.getWidth()/3-40,textFieldHeight);
				classTF.setFont(textFieldFont);
				classTF.setFocusable(false);
				classTF.setOpaque(false);
				classTF.setBackground(Color.WHITE);
				//classTF.setMargin(new Insets(10, 10, 10,50));
				addStudPanel.add(classTF);
				
				
				String genders[]={"Male","Female","Other"};
				
				JLabel genderLabel = new JLabel("Student's Gender");
				genderLabel.setBounds(2*addStudPanel.getWidth()/3,120,addStudPanel.getWidth()/3-40,textFieldHeight);
				addStudPanel.add(genderLabel);
				JComboBox genderTF = new JComboBox(genders);
				genderTF.setBounds(2*addStudPanel.getWidth()/3,120+textFieldHeight-10,addStudPanel.getWidth()/3-40,textFieldHeight);
				genderTF.setFont(textFieldFont);
				genderTF.setFocusable(false);
				genderTF.setOpaque(false);
				genderTF.setBackground(Color.WHITE);
				addStudPanel.add(genderTF);
				
				JLabel parentsDetailsLabel = new JLabel("Parents/Guardian's details");
				parentsDetailsLabel.setBounds(40,205,500,40);
				parentsDetailsLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
				addStudPanel.add(parentsDetailsLabel);
				
				JLabel fatherNameLabel = new JLabel("Father's Name");
				fatherNameLabel.setBounds(x1,240,addStudPanel.getWidth()/2-x1-20,textFieldHeight);
				addStudPanel.add(fatherNameLabel);
				JTextField fatherNameTF = new JTextField();
				fatherNameTF.setBounds(x1,fatherNameLabel.getBounds().y+textFieldHeight-10,addStudPanel.getWidth()/2-x1-20,textFieldHeight);
				fatherNameTF.setFont(textFieldFont);
				fatherNameTF.setMargin(new Insets(10, 10, 10,50));
				addStudPanel.add(fatherNameTF);
				
				JLabel fatherPhLabel = new JLabel("Father's Phone No.");
				fatherPhLabel.setBounds(x2,240,addStudPanel.getWidth()/2-x1-20,textFieldHeight);
				addStudPanel.add(fatherPhLabel);
				JTextField fatherPhTF = new JTextField();
				fatherPhTF.setBounds(x2,fatherPhLabel.getBounds().y+textFieldHeight-10,addStudPanel.getWidth()/2-x1-20,textFieldHeight);
				fatherPhTF.setFont(textFieldFont);
				fatherPhTF.setMargin(new Insets(10, 10, 10,50));
				fatherPhTF.addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent ke) {
						String value = fatherPhTF.getText();
						int l = value.length();
						if (ke.getKeyChar() >= '0' && ke.getKeyChar() != ' '&& ke.getKeyChar() <= '9' && l<10) {
							fatherPhTF.setEditable(true);
						}
						else if(ke.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE) {
							fatherPhTF.setEditable(true);
						}
						else {
							fatherPhTF.setEditable(false);
						}
					}
				});
				addStudPanel.add(fatherPhTF);
				
				JLabel motherNameLabel = new JLabel("Mother's Name");
				motherNameLabel.setBounds(x1,320,addStudPanel.getWidth()/2-x1-20,textFieldHeight);
				addStudPanel.add(motherNameLabel);
				JTextField motherNameTF = new JTextField();
				motherNameTF.setBounds(x1,motherNameLabel.getBounds().y+textFieldHeight-10,addStudPanel.getWidth()/2-x1-20,textFieldHeight);
				motherNameTF.setFont(textFieldFont);
				motherNameTF.setMargin(new Insets(10, 10, 10,50));
				addStudPanel.add(motherNameTF);
				
				JLabel motherPhLabel = new JLabel("Mother's Phone No.");
				motherPhLabel.setBounds(x2,320,addStudPanel.getWidth()/2-x1-20,textFieldHeight);
				addStudPanel.add(motherPhLabel);
				JTextField motherPhTF = new JTextField();
				motherPhTF.setBounds(x2,motherPhLabel.getBounds().y+textFieldHeight-10,addStudPanel.getWidth()/2-x1-20,textFieldHeight);
				motherPhTF.setFont(textFieldFont);
				motherPhTF.setMargin(new Insets(10, 10, 10,50));
				motherPhTF.addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent ke) {
						String value = motherPhTF.getText();
						int l = value.length();
						if (ke.getKeyChar() >= '0' && ke.getKeyChar() != ' '&& ke.getKeyChar() <= '9' && l<10) {
							motherPhTF.setEditable(true);
						}
						else if(ke.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE) {
							motherPhTF.setEditable(true);
						}
						else {
							motherPhTF.setEditable(false);
						}
					}
				});
				addStudPanel.add(motherPhTF);
				
				JLabel guardianNameLabel = new JLabel("Guardian's Name");
				guardianNameLabel.setBounds(x1,400,addStudPanel.getWidth()/2-x1-20,textFieldHeight);
				addStudPanel.add(guardianNameLabel);
				JTextField guardianNameTF = new JTextField();
				guardianNameTF.setBounds(x1,guardianNameLabel.getBounds().y+textFieldHeight-10,addStudPanel.getWidth()/2-x1-20,textFieldHeight);
				guardianNameTF.setFont(textFieldFont);
				guardianNameTF.setMargin(new Insets(10, 10, 10,50));
				addStudPanel.add(guardianNameTF);
				
				JLabel guardianPhLabel = new JLabel("Guardian's Phone No.");
				guardianPhLabel.setBounds(x2,400,addStudPanel.getWidth()/2-x1-20,textFieldHeight);
				addStudPanel.add(guardianPhLabel);
				JTextField guardianPhTF = new JTextField();
				guardianPhTF.setBounds(x2,guardianPhLabel.getBounds().y+textFieldHeight-10,addStudPanel.getWidth()/2-x1-20,textFieldHeight);
				guardianPhTF.setFont(textFieldFont);
				guardianPhTF.setMargin(new Insets(10, 10, 10,50));
				guardianPhTF.addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent ke) {
						String value = guardianPhTF.getText();
						int l = value.length();
						if (ke.getKeyChar() >= '0' && ke.getKeyChar() != ' '&& ke.getKeyChar() <= '9' && l<=10) {
							guardianPhTF.setEditable(true);
						}
						else if(ke.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE) {
							guardianPhTF.setEditable(true);
						}
						else {
							guardianPhTF.setEditable(false);
						}
					}
				});
				addStudPanel.add(guardianPhTF);
				
				addStudSuccessfull.setBounds(160,490,300,50);
				addStudPanel.add(addStudSuccessfull);
				
				JButton addStudentDetailsButton = new JButton("Add");
				addStudentDetailsButton.setBounds(40, 490, 100, 50);
				addStudentDetailsButton.setBackground(defaultMainColor);
				addStudentDetailsButton.setFont(new Font("Verdana", Font.BOLD, 15));
				addStudentDetailsButton.setForeground(Color.WHITE);
				addStudentDetailsButton.setBorderPainted(false);
				addStudentDetailsButton.setFocusPainted(false);
				addStudentDetailsButton.setOpaque(true);
				addStudentDetailsButton.getModel().addChangeListener(new ChangeListener() {
			            @Override
			            public void stateChanged(ChangeEvent e) {
			                ButtonModel model = (ButtonModel) e.getSource();

			                if (model.isRollover()) {
			                	addStudentDetailsButton.setBackground(rolledOverColorBtn);
			                } else if (model.isPressed()) {
			                	addStudentDetailsButton.setBackground(rolledOverColorBtn);
			                } else {
			                	addStudentDetailsButton.setBackground(defaultMainColor);
			                }
			            }
			    });
				
				JButton prevBtn = new JButton("< Prev");
				JButton nextBtn = new JButton("Next >");
				
				addStudentDetailsButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(fnameTF.getText().equals("") && lnameTF.getText().equals("") && classTF.getSelectedItem().equals("") && idTF.getText().equals("") && phTF.getText().equals("") && fatherNameTF.getText().equals("") && motherNameTF.getText().equals("") && fatherPhTF.getText().equals("") && motherPhTF.getText().equals("")) {
							addStudSuccessfull.setText("Student's Details Missing");
						}
						else{
							writeStudDetailsToTextFile(fnameTF.getText(),lnameTF.getText(),idTF.getText(),classTF.getSelectedItem().toString(),(idTF.getText()+"@hkbk.edu.in"),phTF.getText(),genderTF.getSelectedItem().toString(), fatherNameTF.getText(), fatherPhTF.getText(), motherNameTF.getText(), motherPhTF.getText(), guardianNameTF.getText(), guardianPhTF.getText(), idTF.getText()+"@123");
							studentList[n++]=new StudentList(fnameTF.getText(),lnameTF.getText(),idTF.getText(),classTF.getSelectedItem().toString(),(idTF.getText()+"@hkbk.edu.in"),phTF.getText() ,genderTF.getSelectedItem().toString(), fatherNameTF.getText(), fatherPhTF.getText(), motherNameTF.getText(), motherPhTF.getText(), guardianNameTF.getText(), guardianPhTF.getText(), idTF.getText()+"@123");
							ArrangeStudDetails(panel,viewStudPanel);
							addStudSuccessfull.setText("Student Added Successfully");
							if(studDetailspage==0)prevBtn.setVisible(false);
							else prevBtn.setVisible(true);
							if(studDetailspage==totPagesStud-1)nextBtn.setVisible(false);
							else nextBtn.setVisible(true);
							fnameTF.setText(null);
							lnameTF.setText(null);
							idTF.setText(null);
							//classTF.setText(null);
							phTF.setText(null);
							fatherNameTF.setText(null);
							motherNameTF.setText(null);
							guardianNameTF.setText(null);
							fatherPhTF.setText(null);
							motherPhTF.setText(null);
							guardianPhTF.setText(null);
						}
					}
				});
				addStudPanel.add(addStudentDetailsButton);
				
				
				
				JLabel studListLabel = new JLabel("Student's List");
				studListLabel.setBounds(100,50,500,40);
				studListLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
				viewStudPanel.add(studListLabel);
				
				
				
				

				ArrangeStudDetails(panel,viewStudPanel);
				
				prevBtn.setBounds(90,480,100,30);
				prevBtn.setFont(new Font("MS PGothic", Font.BOLD, 18));
				prevBtn.setBackground(Color.WHITE);
				prevBtn.setForeground(defaultMainColor);
				prevBtn.setBorderPainted(false);
				prevBtn.setFocusPainted(false);
				prevBtn.setOpaque(true);
				prevBtn.setHorizontalAlignment(SwingConstants.LEFT);
				prevBtn.getModel().addChangeListener(new ChangeListener() {
		            @Override
		            public void stateChanged(ChangeEvent e) {
		                ButtonModel model = (ButtonModel) e.getSource();

		                if (model.isRollover()) {
		                	prevBtn.setForeground(rolledOverColorBtn);
		                } else if (model.isPressed()) {
		                	prevBtn.setForeground(rolledOverColorBtn);
		                } else {
		                	prevBtn.setForeground(defaultMainColor);
		                }
		            }
		        });
				prevBtn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(studDetailspage>0) {
							for(int i=0;i<totPagesStud;i++)
								studDetailsPanel[i].setVisible(false);
							studDetailsPanel[--studDetailspage].setVisible(true);}
						//System.out.println(studDetailspage);
						if(studDetailspage==0)prevBtn.setVisible(false);
						else prevBtn.setVisible(true);
						if(studDetailspage==totPagesStud-1)nextBtn.setVisible(false);
						else nextBtn.setVisible(true);
					}
				});
				viewStudPanel.add(prevBtn);
				
				if(studDetailspage==0)prevBtn.setVisible(false);
				else prevBtn.setVisible(true);
				if(studDetailspage==totPagesStud-1)nextBtn.setVisible(false);
				else nextBtn.setVisible(true);
				
				nextBtn.setBounds(1075,480,100,30);
				nextBtn.setFont(new Font("MS PGothic", Font.BOLD, 18));
				nextBtn.setBackground(Color.WHITE);
				nextBtn.setForeground(defaultMainColor);
				nextBtn.setBorderPainted(false);
				nextBtn.setFocusPainted(false);
				nextBtn.setOpaque(true);
				nextBtn.setHorizontalAlignment(SwingConstants.RIGHT);
				nextBtn.getModel().addChangeListener(new ChangeListener() {
		            @Override
		            public void stateChanged(ChangeEvent e) {
		                ButtonModel model = (ButtonModel) e.getSource();

		                if (model.isRollover()) {
		                	nextBtn.setForeground(rolledOverColorBtn);
		                } else if (model.isPressed()) {
		                	nextBtn.setForeground(rolledOverColorBtn);
		                } else {
		                	nextBtn.setForeground(defaultMainColor);
		                }
		            }
		        });
				nextBtn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(studDetailspage<totPagesStud-1) {
							for(int i=0;i<totPagesStud;i++)
								studDetailsPanel[i].setVisible(false);
							studDetailsPanel[++studDetailspage].setVisible(true);}
						//System.out.println(studDetailspage);
						if(studDetailspage==0)prevBtn.setVisible(false);
						else prevBtn.setVisible(true);
						if(studDetailspage==totPagesStud-1)nextBtn.setVisible(false);
						else nextBtn.setVisible(true);
					}
				});
				viewStudPanel.add(nextBtn);
			}
		
	public void DashboardPanel(JPanel panel,int screenWidth,JButton dashboardBTN,JButton classBTN,JButton studentsBTN,JButton noticeBTN,JButton publicNoticeBTN,JPanel dashboardPanel,JPanel classPanel,JPanel studentsPanel,JPanel noticePanel,JPanel publicNoticePanel) {
		
		Color linesColorGrey = new Color(143, 141, 141);
		Color color1 = new Color(38,86,158);
		Color color2 = new Color(0,103,255);
		Font font0 = new Font("MS PGothic", Font.BOLD, 16);
		Font font1 = new Font("MS PGothic", Font.BOLD, 18);
		Font font2 = new Font("Segoe UI Black", Font.BOLD, 20);
		Font font3 = new Font("MS PGothic", Font.BOLD, 22);
		MainPage mpObj = new MainPage();
		
		
		
		JLabel totClassNoLabel = new JLabel(String.valueOf(n1));
		JLabel totStudNoLabel = new JLabel(String.valueOf(n));
		JLabel totNoticeNoLabel = new JLabel(String.valueOf(totalNotice));
		JLabel totPublicNoticeNoLabel = new JLabel(String.valueOf(totalPublicNotice));
		
		int y1=85,y2=185;
		
		JPanel contentPanel = new JPanel(){
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g1 = (Graphics2D) g;
                g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
                g1.setColor(new Color(194, 194, 196));
                g1.setStroke(new BasicStroke(1.5f));
                g1.drawLine(10, 65, panel.getWidth()-30, 65);
                g1.drawLine(panel.getWidth()/3, y1, panel.getWidth()/3, y2);
                g1.drawLine(panel.getWidth()/3*2, y1, panel.getWidth()/3*2, y2);
            }};
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBounds(10,10,panel.getWidth()-20,panel.getHeight()-20);
		contentPanel.setLayout(null);
		panel.add(contentPanel);
		
		JLabel reportSummaryLabel = new JLabel("Report  Summary");
		reportSummaryLabel.setBounds(20, 20, 200, 50);
		reportSummaryLabel.setFont(font2);
		contentPanel.add(reportSummaryLabel);
		
		int offset=1;
		JButton updateReportBTN = new JButton("   Update Report") {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g1 = (Graphics2D) g;
                g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
                g1.setColor(linesColorGrey);
                g1.setStroke(new BasicStroke(1.7f));
                //g1.drawOval(2, 2, 20, 20);  
                g1.drawArc(2, 2+offset, 20, 20, 130, 140);
                g1.drawArc(2, 2+offset, 20, 20, 310, 140);
                g1.drawLine(12, 22+offset, 8, 17+offset);
                g1.drawLine(12, 22+offset, 7, 24+offset);
                g1.drawLine(12, 2+offset, 18, 0+offset);
                //g1.setColor(Color.RED);
                g1.drawLine(12, 2+offset, 15, 8+offset);
            }};
        updateReportBTN.setForeground(linesColorGrey);
		updateReportBTN.setBounds(panel.getWidth()-180, 35, 153, 27);
		updateReportBTN.setBackground(Color.WHITE);
		updateReportBTN.setBorderPainted(false);
		updateReportBTN.setFocusPainted(false);
		updateReportBTN.setOpaque(true);
		updateReportBTN.setHorizontalAlignment(SwingConstants.LEFT);
		updateReportBTN.setVerticalAlignment(SwingConstants.TOP);
		updateReportBTN.setFont(font0);
		updateReportBTN.getModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ButtonModel model = (ButtonModel) e.getSource();

                if (model.isRollover()) {
                	updateReportBTN.setBackground(new Color(235, 235, 235));
                } else if (model.isPressed()) {
                	updateReportBTN.setBackground(Color.WHITE);
                } else {
                	updateReportBTN.setBackground(Color.WHITE);
                }
            }
        });
		updateReportBTN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				totClassNoLabel.setText(String.valueOf(n1));
				totStudNoLabel.setText(String.valueOf(n));
				totNoticeNoLabel.setText(String.valueOf(totalNotice));
				totPublicNoticeNoLabel.setText(String.valueOf(totalPublicNotice));
			}
		});
		contentPanel.add(updateReportBTN);
		
		JLabel totClassLabel = new JLabel("Total Class");
		totClassLabel.setBounds(30,85,100,50);
		totClassLabel.setFont(font1);
		contentPanel.add(totClassLabel);
		
		
		totClassNoLabel.setBounds(30,110,100,50);
		totClassNoLabel.setFont(font3);
		contentPanel.add(totClassNoLabel);
		
		JButton viewClassBtn = new JButton(" View Classes");
		viewClassBtn.setBounds(10,155,135,30);
		viewClassBtn.setFont(font0);
		viewClassBtn.setForeground(color1);
		viewClassBtn.setBackground(Color.WHITE);
		viewClassBtn.setBorderPainted(false);
		viewClassBtn.setFocusPainted(false);
		viewClassBtn.setOpaque(true);
		viewClassBtn.setHorizontalAlignment(SwingConstants.LEFT);
		//viewClassBtn.setVerticalAlignment(SwingConstants.TOP);
		viewClassBtn.getModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ButtonModel model = (ButtonModel) e.getSource();

                if (model.isRollover()) {
                	viewClassBtn.setForeground(color2);
                } else if (model.isPressed()) {
                	viewClassBtn.setForeground(color1);
                } else {
                	viewClassBtn.setForeground(color1);
                }
            }
        });
		viewClassBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mpObj.BTNselected(dashboardBTN,classBTN,studentsBTN,noticeBTN,publicNoticeBTN,classBTN);
				mpObj.PanelSelected(dashboardPanel,classPanel,studentsPanel,noticePanel,publicNoticePanel,classPanel);
			}
		});
		contentPanel.add(viewClassBtn);
		
		
		JLabel totStudLabel = new JLabel("Total Students");
		totStudLabel.setBounds(panel.getWidth()/3+30,85,150,50);
		totStudLabel.setFont(font1);
		contentPanel.add(totStudLabel);
		
		totStudNoLabel.setBounds(panel.getWidth()/3+30,110,100,50);
		totStudNoLabel.setFont(font3);
		contentPanel.add(totStudNoLabel);
		
		JButton viewStudBtn = new JButton(" View Students");
		viewStudBtn.setBounds(panel.getWidth()/3+10,155,155,30);
		viewStudBtn.setFont(font0);
		viewStudBtn.setForeground(color1);
		viewStudBtn.setBackground(Color.WHITE);
		viewStudBtn.setBorderPainted(false);
		viewStudBtn.setFocusPainted(false);
		viewStudBtn.setOpaque(true);
		viewStudBtn.setHorizontalAlignment(SwingConstants.LEFT);
		//viewClassBtn.setVerticalAlignment(SwingConstants.TOP);
		viewStudBtn.getModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ButtonModel model = (ButtonModel) e.getSource();

                if (model.isRollover()) {
                	viewStudBtn.setForeground(color2);
                } else if (model.isPressed()) {
                	viewStudBtn.setForeground(color1);
                } else {
                	viewStudBtn.setForeground(color1);
                }
            }
        });
		viewStudBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mpObj.BTNselected(dashboardBTN,classBTN,studentsBTN,noticeBTN,publicNoticeBTN,studentsBTN);
				mpObj.PanelSelected(dashboardPanel,classPanel,studentsPanel,noticePanel,publicNoticePanel,studentsPanel);
			}
		});
		contentPanel.add(viewStudBtn);
		
		
		
		JLabel totNoticeLabel = new JLabel("Total Notices");
		totNoticeLabel.setBounds(panel.getWidth()/3*2+30,85,150,50);
		totNoticeLabel.setFont(font1);
		contentPanel.add(totNoticeLabel);
		
		JLabel totClassNoticeLabel = new JLabel("Class Notices:");
		totClassNoticeLabel.setBounds(panel.getWidth()/3*2+30,108,150,50);
		totClassNoticeLabel.setFont(font0);
		contentPanel.add(totClassNoticeLabel);
		JLabel totPublicNoticeLabel = new JLabel("Public Notices:");
		totPublicNoticeLabel.setBounds(panel.getWidth()/3*2+30,128,150,50);
		totPublicNoticeLabel.setFont(font0);
		contentPanel.add(totPublicNoticeLabel);
		
		totNoticeNoLabel.setBounds(panel.getWidth()/3*2+133,107,100,50);
		totNoticeNoLabel.setFont(font3);
		contentPanel.add(totNoticeNoLabel);
		
		totPublicNoticeNoLabel.setBounds(panel.getWidth()/3*2+138,127,100,50);
		totPublicNoticeNoLabel.setFont(font3);
		contentPanel.add(totPublicNoticeNoLabel);
		
		JButton viewNoticeBtn = new JButton(" View Notices");
		viewNoticeBtn.setBounds(panel.getWidth()/3*2+10,160,155,30);
		viewNoticeBtn.setFont(font0);
		viewNoticeBtn.setForeground(color1);
		viewNoticeBtn.setBackground(Color.WHITE);
		viewNoticeBtn.setBorderPainted(false);
		viewNoticeBtn.setFocusPainted(false);
		viewNoticeBtn.setOpaque(true);
		viewNoticeBtn.setHorizontalAlignment(SwingConstants.LEFT);
		//viewClassBtn.setVerticalAlignment(SwingConstants.TOP);
		viewNoticeBtn.getModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ButtonModel model = (ButtonModel) e.getSource();

                if (model.isRollover()) {
                	viewNoticeBtn.setForeground(color2);
                } else if (model.isPressed()) {
                	viewNoticeBtn.setForeground(color1);
                } else {
                	viewNoticeBtn.setForeground(color1);
                }
            }
        });
		viewNoticeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mpObj.BTNselected(dashboardBTN,classBTN,studentsBTN,noticeBTN,publicNoticeBTN,noticeBTN);
				mpObj.PanelSelected(dashboardPanel,classPanel,studentsPanel,noticePanel,publicNoticePanel,noticePanel);
			}
		});
		contentPanel.add(viewNoticeBtn);
		
		
		JButton viewPublicNoticeBtn = new JButton(" View Public Notices");
		viewPublicNoticeBtn.setBounds(panel.getWidth()/3*2+10,180,200,30);
		viewPublicNoticeBtn.setFont(font0);
		viewPublicNoticeBtn.setForeground(color1);
		viewPublicNoticeBtn.setBackground(Color.WHITE);
		viewPublicNoticeBtn.setBorderPainted(false);
		viewPublicNoticeBtn.setFocusPainted(false);
		viewPublicNoticeBtn.setOpaque(true);
		viewPublicNoticeBtn.setHorizontalAlignment(SwingConstants.LEFT);
		//viewClassBtn.setVerticalAlignment(SwingConstants.TOP);
		viewPublicNoticeBtn.getModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ButtonModel model = (ButtonModel) e.getSource();

                if (model.isRollover()) {
                	viewPublicNoticeBtn.setForeground(color2);
                } else if (model.isPressed()) {
                	viewPublicNoticeBtn.setForeground(color1);
                } else {
                	viewPublicNoticeBtn.setForeground(color1);
                }
            }
        });
		viewPublicNoticeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mpObj.BTNselected(dashboardBTN,classBTN,studentsBTN,noticeBTN,publicNoticeBTN,publicNoticeBTN);
				mpObj.PanelSelected(dashboardPanel,classPanel,studentsPanel,noticePanel,publicNoticePanel,publicNoticePanel);
			}
		});
		contentPanel.add(viewPublicNoticeBtn);
		

		Color classLogoColor = new Color(51,205,57);
		JPanel classPanelLogo = new JPanel(){
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g1 = (Graphics2D) g;
                g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
                g1.setColor(classLogoColor);
                g1.fillRoundRect(0, 0, 80, 80, 20, 20);
                g1.setColor(Color.WHITE);
                g1.setStroke(new BasicStroke(2.5f));
                g1.drawRoundRect(10, 20, 60, 40, 10, 10); 
                g1.drawRoundRect(13, 23, 54, 33, 5, 5); 
                g1.fillRect( 50, 51, 12, 3);
                
                g1.setStroke(new BasicStroke(1f));
                g1.drawLine(30, 30, 50, 30);
                g1.drawLine(20, 35, 60, 35);
                g1.drawLine(20, 40, 60, 40);
                g1.drawLine(20, 45, 60, 45);
            }};
		classPanelLogo.setBounds(panel.getWidth()/3-100,95,80,80);
		classPanelLogo.setBackground(Color.WHITE);
		contentPanel.add(classPanelLogo);
		
		Color studLogoColor = new Color(250,75,106);
		JPanel studPanelLogo = new JPanel(){
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g1 = (Graphics2D) g;
                g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
                g1.setColor(studLogoColor);
                g1.fillRoundRect(0, 0, 80, 80, 20, 20);
                g1.setColor(Color.WHITE);
                g1.setStroke(new BasicStroke(2.5f));
                g1.drawRoundRect(20, 30, 40, 30, 10, 10);
                g1.fillRect(38, 38, 5, 10);
                g1.drawLine(20, 43, 60, 43);
                g1.drawRoundRect(30, 22, 20, 8, 1, 1);
            }};
		studPanelLogo.setBounds(panel.getWidth()/3*2-100,95,80,80);
		studPanelLogo.setBackground(Color.WHITE);
		contentPanel.add(studPanelLogo);
		
		Color noticeLogoColor = new Color(254,222,109);
		JPanel noticePanelLogo = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g1 = (Graphics2D) g;
                g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
                g1.setColor(noticeLogoColor);
                g1.fillRoundRect(0, 0, 80, 80, 20, 20);
                g1.setColor(Color.WHITE);
                g1.setStroke(new BasicStroke(2.5f));
                g1.drawOval(25, 25, 30, 30);
                g1.drawArc(21, 21, 38, 38, 250, 180);
                g1.drawLine(40,59,40,62);
                g1.setStroke(new BasicStroke(2f));
                g1.drawLine(35, 64, 45, 64);
                }};
		noticePanelLogo.setBounds(panel.getWidth()-120,95,80,80);
		noticePanelLogo.setBackground(Color.WHITE);
		contentPanel.add(noticePanelLogo);
	}

	public void NoticePanel(JPanel panel, JFrame frame, int screenWidth, boolean forTeachers, String forClassOfStud) {
		
		//initialize all the noticeList to null
		for(int i=0;i<10;i++)noticeList[i]=new NoticeList("","","","",false);
		//check if any of the list is free
		for(int i=0;i<10;i++) {
			if(new File("Files\\Notice Files\\Notice"+i+".txt").length()==0)	noticeList[i].Full=false;
			else {noticeList[i].Full=true;LoadNoticeDetails(i);}
		}
		//to test for free files
		//for(int i=0;i<10;i++)System.out.println(noticeList[i].Full);
		
		JPanel viewNoticePanel = new JPanel(){
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.WHITE);
				g.fillArc(0, panel.getBounds().height-60-20, 20, 20, 180, 90);
				g.fillArc(panel.getBounds().width-20, panel.getBounds().height-60-20, 20, 20, 270, 90);
				g.fillRect(0, 0, panel.getBounds().width, panel.getBounds().height-65);
				g.fillRect(10, panel.getBounds().height-65,panel.getBounds().width-20,10);
				//g.fillRoundRect( 0, 0,panel.getBounds().width-3, panel.getBounds().height-60, 20, 20);
			}};
			viewNoticePanel.setBounds(0, 60, panel.getBounds().width-2, panel.getBounds().height-60);
			if(!forTeachers)viewNoticePanel.setBounds(0, 10, panel.getBounds().width-2, panel.getBounds().height-60);
			viewNoticePanel.setOpaque(false);
			viewNoticePanel.setLayout(null);
			viewNoticePanel.setVisible(true);
			
		JPanel addNoticePanel = new JPanel(){
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					Graphics2D g1 = (Graphics2D) g;
	                g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
					g1.setColor(Color.WHITE);
					g1.fillArc(0, panel.getBounds().height-60-20, 20, 20, 180, 90);
					g1.fillArc(panel.getBounds().width-20, panel.getBounds().height-60-20, 20, 20, 270, 90);
					g1.fillRect(0, 0, panel.getBounds().width, panel.getBounds().height-65);
					g1.fillRect(10, panel.getBounds().height-65,panel.getBounds().width-20,10);
				}};
				addNoticePanel.setBounds(0, 60, panel.getBounds().width-2, panel.getBounds().height-60);
				addNoticePanel.setOpaque(false);
				addNoticePanel.setVisible(false);
		
		
		JButton addNoticeBTN,viewNoticeBTN;
		JLabel addNoticeLabel,viewNoticeLabel;

		JLabel addNoticeSuccessfull = new JLabel("");

		viewNoticeBTN = new JButton("Manage Notices");
		addNoticeBTN = new JButton("Add Notice");
		
		viewNoticeLabel = new JLabel("Manage Notices");
		addNoticeLabel = new JLabel("Add Notice");
		viewNoticeLabel.setBounds(10,0,panel.getBounds().width/2-10,60);
		viewNoticeLabel.setFont(new Font("MS PGothic", Font.BOLD, 16));
		viewNoticeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addNoticeLabel.setBounds(panel.getBounds().width/2,0,panel.getBounds().width/2-10,60);
		addNoticeLabel.setFont(new Font("MS PGothic", Font.BOLD, 16));
		addNoticeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		viewNoticeBTN.setBounds(0,0,panel.getBounds().width/2,60);
		viewNoticeBTN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addNoticeSuccessfull.setText("");
				addNoticePanel.setVisible(false);					
				viewNoticePanel.setVisible(true);
				addNoticeBTN.setVisible(true);
				viewNoticeBTN.setVisible(false);
			}
		});
		viewNoticeBTN.setVisible(false);
		viewNoticeBTN.setFont(new Font("MS PGothic", Font.BOLD, 16));
		viewNoticeBTN.setBackground(BTNSelectedColor);
		viewNoticeBTN.setBorderPainted(false);
		viewNoticeBTN.setFocusPainted(false);
		viewNoticeBTN.setOpaque(true);
		
		addNoticeBTN.setBounds(panel.getBounds().width/2,0,panel.getBounds().width/2-2,60);
		addNoticeBTN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				viewNoticePanel.setVisible(false);
				addNoticePanel.setVisible(true);
				viewNoticeBTN.setVisible(true);
				addNoticeBTN.setVisible(false);
			}
		});
		addNoticeBTN.setVisible(true);
		addNoticeBTN.setFont(new Font("MS PGothic", Font.BOLD, 16));
		addNoticeBTN.setBackground(BTNSelectedColor);
		addNoticeBTN.setBorderPainted(false);
		addNoticeBTN.setFocusPainted(false);
		addNoticeBTN.setOpaque(true);
		addNoticePanel.setLayout(null);
		
		if(!forTeachers) {
			panel.add(viewNoticePanel);
		}
		else {
			panel.add(viewNoticeBTN);
			panel.add(addNoticeBTN);
			panel.add(viewNoticeLabel);
			panel.add(addNoticeLabel);
			panel.add(addNoticePanel);
			panel.add(viewNoticePanel);
		}
		
		//Add Class
		int textFieldHeight = 40, x1 = 40, x2 = addNoticePanel.getWidth()/2+20;
		Font textFieldFont = new Font("MS PGothic", Font.BOLD, 14);
		
		JLabel noticeHeaderLabel = new JLabel("Add Notice");
		noticeHeaderLabel.setBounds(40,5,500,40);
		noticeHeaderLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		addNoticePanel.add(noticeHeaderLabel);
		
		
		JLabel noticeTitleLabel = new JLabel("Notice Title");
		noticeTitleLabel.setBounds(x1,40,addNoticePanel.getWidth()/2-x1-20,textFieldHeight);
		addNoticePanel.add(noticeTitleLabel);
		JTextField classNameTF = new JTextField();
		classNameTF.setBounds(x1,noticeTitleLabel.getBounds().y+textFieldHeight-10,addNoticePanel.getWidth()-x1-20,textFieldHeight);
		classNameTF.setFont(textFieldFont);
		classNameTF.setMargin(new Insets(10, 10, 10,50));
		classNameTF.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke) {
	        	 addNoticeSuccessfull.setText("");
	         }
	      });
		addNoticePanel.add(classNameTF);
		
		UpdateClasss();
		JLabel sectionLabel = new JLabel("Notice For");
		sectionLabel.setBounds(x1,120,addNoticePanel.getWidth()/2-x1-20,textFieldHeight);
		addNoticePanel.add(sectionLabel);
		sectionTF = new JComboBox(classsss);
		sectionTF.setBounds(x1,120+textFieldHeight-10,addNoticePanel.getWidth()-x1-20,textFieldHeight);
		sectionTF.setFont(textFieldFont);
		sectionTF.setFocusable(false);
		sectionTF.setOpaque(false);
		sectionTF.setBackground(Color.WHITE);
		addNoticePanel.add(sectionTF);

		addNoticeSuccessfull.setBounds(160,330+textFieldHeight-10,300,50);
		addNoticePanel.add(addNoticeSuccessfull);
		
		JLabel noticeMessageLabel = new JLabel("Notice Message");
		noticeMessageLabel.setBounds(x1,200,addNoticePanel.getWidth()/2-x1-20,textFieldHeight);
		addNoticePanel.add(noticeMessageLabel);
		
		JTextArea noticeArea = new JTextArea("");
		noticeArea.setMargin(new Insets(10, 10, 10,50));
		JScrollPane noticeScrollPane = new JScrollPane(noticeArea);
		noticeScrollPane.setBounds(x1,200+textFieldHeight-10,addNoticePanel.getWidth()-x1-20,100);
		noticeScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        noticeArea.setFont(textFieldFont);
        noticeArea.setLineWrap(true);
        noticeArea.setWrapStyleWord(true);
        addNoticePanel.add(noticeScrollPane);
        
        JButton addNoticeDetailsButton = new JButton("Add");
        addNoticeDetailsButton.setBounds(40, 330+textFieldHeight-10, 100, 50);
        addNoticeDetailsButton.setBackground(defaultMainColor);
        addNoticeDetailsButton.setFont(new Font("Verdana", Font.BOLD, 15));
        addNoticeDetailsButton.setForeground(Color.WHITE);
        addNoticeDetailsButton.setBorderPainted(false);
        addNoticeDetailsButton.setFocusPainted(false);
        addNoticeDetailsButton.setOpaque(true);
        addNoticeDetailsButton.getModel().addChangeListener(new ChangeListener() {
	            @Override
	            public void stateChanged(ChangeEvent e) {
	                ButtonModel model = (ButtonModel) e.getSource();

	                if (model.isRollover()) {
	                	addNoticeDetailsButton.setBackground(rolledOverColorBtn);
	                } else if (model.isPressed()) {
	                	addNoticeDetailsButton.setBackground(rolledOverColorBtn);
	                } else {
	                	addNoticeDetailsButton.setBackground(defaultMainColor);
	                }
	            }
	    });
        addNoticeDetailsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(classNameTF.getText().equals("") || noticeArea.getText().equals(""))
					addNoticeSuccessfull.setText("Notice Deatils Missing");
				else {
					int i;
					for(i=0;i<10&&noticeList[i].Full;i++) {}
					if(i==10) addNoticeSuccessfull.setText("Maximum Notice Limit Reached");
					else {
						DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
					    Calendar obj = Calendar.getInstance();
					    String dateTime = formatter.format(obj.getTime());
						writeNoticeToTextFile(i,classNameTF.getText(),dateTime,noticeArea.getText(),sectionTF.getSelectedItem().toString());
						noticeList[i].Title=classNameTF.getText();
						noticeList[i].Date=dateTime;
						noticeList[i].Message=noticeArea.getText();
						noticeList[i].forClass=sectionTF.getSelectedItem().toString();
						noticeList[i].Full=true;
						totalNotice++;
						arrangeNoticePanels(viewNoticePanel,forTeachers,forClassOfStud);
						//System.out.println(totalNotice);
						addNoticeSuccessfull.setText("Notice Added Successfully");
						noticeArea.setText("");classNameTF.setText("");
					}
				}
			}
		});
		addNoticePanel.add(addNoticeDetailsButton);
		
		arrangeNoticePanels(viewNoticePanel,forTeachers,forClassOfStud);
		
	}
	
	Boolean rolled;JPanel[] notificationPanel = new JPanel[10];static NoticeList[] noticeList=new NoticeList[10];static int totalNotice=0;
	
	static void writeNoticeToTextFile(int i,String title,String date,String message,String forClass) {
		try {
			BufferedWriter myWriter = new BufferedWriter(new FileWriter("Files\\Notice Files\\Notice"+i+".txt",true));
			myWriter.write(title+"|"+date+"|"+message+"|"+forClass);
			myWriter.newLine();
			myWriter.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	
	public static void LoadNoticeDetails(int i) {
		File file = new File("Files\\Notice Files\\Notice"+i+".txt");
		String title="",date="",message="",forClass="";
	    Scanner sc;
		try {
			sc = new Scanner(file);
			sc.useDelimiter("[|||]");
			while(sc.hasNext()) {
				title =sc.next().trim();
				date  = sc.next().trim();
				message = sc.next().trim();
				forClass = sc.next().trim();
				noticeList[totalNotice++]=new NoticeList(title,date,message,forClass,true);			
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//for testing
		//System.out.println();
		//System.out.println(noticeList[i].Title+","+noticeList[i].Date+","+noticeList[i].Message+"   "+(i+1));
	}

	public void arrangeNoticePanels(JPanel viewNoticePanel,boolean forTeachers, String forClassOfStud) {
		
		if(forTeachers) {
			for(int i=0,k=0;i<10;i++) {
				if((i%2)==0) {
					if(noticeList[i].Full)
						notificationPanel[i]=createNoticePanels(viewNoticePanel,50+k,true,noticeList[i].Title,noticeList[i].Date,noticeList[i].Message,noticeList[i].forClass,i,viewNoticePanel,forTeachers,forClassOfStud);
				}
				else {
					if(noticeList[i].Full) {
						notificationPanel[i]=createNoticePanels(viewNoticePanel,50+k,false,noticeList[i].Title,noticeList[i].Date,noticeList[i].Message,noticeList[i].forClass,i,viewNoticePanel,forTeachers,forClassOfStud);
						k+=100;}
				}
			}
		}
		else {
			for(int i=0,k=0;i<10;i++) {
				if(noticeList[i].forClass.equals(forClassOfStud)){
					if((i%2)==0) {
						if(noticeList[i].Full)
							notificationPanel[i]=createNoticePanels(viewNoticePanel,50+k,true,noticeList[i].Title,noticeList[i].Date,noticeList[i].Message,noticeList[i].forClass,i,viewNoticePanel,forTeachers,forClassOfStud);
					}
					else {
						if(noticeList[i].Full) {
							notificationPanel[i]=createNoticePanels(viewNoticePanel,50+k,false,noticeList[i].Title,noticeList[i].Date,noticeList[i].Message,noticeList[i].forClass,i,viewNoticePanel,forTeachers,forClassOfStud);
							k+=100;}
					}
				}
			}
		}
	}
	
	public JPanel createNoticePanels(JPanel panel,int y,Boolean left, String header, String date, String message, String forClass,int ik,JPanel viewNoticePanel, boolean forTeachers,String forClassOfStud) {
		Color color1 = new Color(217, 215, 215);
		JPanel panel1 = new JPanel(){
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g1 = (Graphics2D) g;
                g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
				g1.setColor(color1);
				g1.fillRoundRect(0, 0, panel.getWidth()/2-80, 80, 20, 20);
				//g1.fillRect(0, 0, panel.getWidth(), 80);
				g1.setColor(new Color(73,188,155));
				g1.fillOval(6, 5, 29, 29);
				g1.setColor(new Color(99,120,137));
				g1.fillOval(17, 22, 8, 8);
				g1.setColor(new Color(251,211,97));
				g1.fillArc(13, 8, 15, 15, 0, 180);
				g1.fillRect(13, 15, 15, 8);
				g1.fillRect(12, 22, 18, 5);
			}};
		panel1.setBackground(Color.WHITE);
		if(left)
			panel1.setBounds(40,y,panel.getWidth()/2-80,80);
		else
			panel1.setBounds(panel.getWidth()/2+20,y,panel.getWidth()/2-80,80);
		panel1.setLayout(null);
		
		JLabel noticeTitleinPanel = new JLabel(header);
		noticeTitleinPanel.setFont(new Font("MS PGothic", Font.BOLD, 14));
		noticeTitleinPanel.setBounds(40,5,panel1.getWidth()-130,30);
		panel1.add(noticeTitleinPanel);
		
		JLabel noticeDateinPanel = new JLabel(date);
		noticeDateinPanel.setFont(new Font("MS PGothic", Font.BOLD, 13));
		noticeDateinPanel.setBounds(panel1.getWidth()-80,5,panel1.getWidth()-40,30);
		panel1.add(noticeDateinPanel);
		
		JButton readMoreBTN = new JButton("Read More");
		readMoreBTN.setFont(new Font("MS PGothic", Font.BOLD, 15));
		readMoreBTN.setBounds(465,58,80,15);
		readMoreBTN.setBackground(color1);
		readMoreBTN.setBorderPainted(false);
		readMoreBTN.setFocusPainted(false);
		readMoreBTN.setOpaque(true);
		readMoreBTN.setForeground(defaultMainColor);
		readMoreBTN.setHorizontalAlignment(SwingConstants.LEFT);
		readMoreBTN.setMargin(new Insets(0,0,0,0));
		readMoreBTN.getModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ButtonModel model = (ButtonModel) e.getSource();

                if (model.isRollover()) {
                	readMoreBTN.setForeground(rolledOverColorBtn);
                } else if (model.isPressed()) {
                	readMoreBTN.setBackground(color1);
                } else {
                	readMoreBTN.setForeground(defaultMainColor);
                }
            }
        });
		readMoreBTN.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		JFrame f = new JFrame();
        		f.setBounds(0,0,500,500);
        		JTextArea noticeArea = new JTextArea(date+"\n"+header+"\n\n"+message+"\n-By Administrator");
        		noticeArea.setEditable(false);
        		noticeArea.setMargin(new Insets(10, 10, 10,10));
        		JScrollPane noticeScrollPane = new JScrollPane(noticeArea);
        		noticeScrollPane.setBounds(0,0,f.getWidth(),f.getHeight());
        		noticeScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                noticeArea.setFont(new Font("MS PGothic", Font.BOLD, 15));
                noticeArea.setLineWrap(true);
                noticeArea.setWrapStyleWord(true);
                f.add(noticeScrollPane);
                f.setVisible(true);
        	}
        });
		panel1.add(readMoreBTN);

		JTextArea noticeMessageinPanel = new JTextArea(message);
		noticeMessageinPanel.setBackground(color1);
		noticeMessageinPanel.setEditable(false);
		noticeMessageinPanel.setBounds(20,40,panel1.getWidth()-40,35);
		noticeMessageinPanel.setFont(new Font("MS PGothic", Font.BOLD, 15));
		noticeMessageinPanel.setLineWrap(true);
		noticeMessageinPanel.setWrapStyleWord(true);
		panel1.add(noticeMessageinPanel);
		
		rolled = true;

		JButton deleteBTN = new JButton(""){
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g1 = (Graphics2D) g;
                g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
				if(rolled) g1.setColor(defaultMainColor);
				else g1.setColor(rolledOverColorBtn);
				g1.setStroke(new BasicStroke(1.9f));
				g1.drawLine(8, 10, 10, 25);
				g1.drawLine(10, 25, 17, 25);
				g1.drawLine(20, 10, 18, 25);
				g1.drawLine(7, 10, 21, 10);
				g1.drawRect(12, 8, 5, 2);
			}};
		if(left) deleteBTN.setBounds(panel.getWidth()/3*2-245,y+30,30,30);
		else deleteBTN.setBounds(panel.getWidth()-55,y+30,30,30);
		deleteBTN.setBackground(Color.WHITE);
		deleteBTN.setBorderPainted(false);
		deleteBTN.setFocusPainted(false);
		deleteBTN.setOpaque(true);
		deleteBTN.getModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ButtonModel model = (ButtonModel) e.getSource();
                if (model.isRollover()) {
                	rolled = false;
                } else if (model.isPressed()) {
                	rolled = true;
                } else {
                	rolled = true;
                }
            }
        });
		deleteBTN.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		try{
        		    FileWriter fw = new FileWriter("Files\\Notice Files\\Notice"+ik+".txt", false);
        		    PrintWriter pw = new PrintWriter(fw, false);
        		    pw.flush();
        		    pw.close();
        		    fw.close();
        		    }catch(Exception exception){
        		        System.out.println("Exception have been caught");
        		    }
        		noticeList[ik].Full=false;
        		//for(int i=0;i<10;i++)System.out.println(noticeList[i].Full);
        		for (int i = ik; i < 10-1; i++)  
        	    {  
        			FileReader fin = null;
					try {
						fin = new FileReader("Files\\Notice Files\\Notice"+(i+1)+".txt");
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}  
        			  FileWriter fout = null;
					try {
						try{
		        		    FileWriter fw = new FileWriter("Files\\Notice Files\\Notice"+i+".txt", false);
		        		    PrintWriter pw = new PrintWriter(fw, false);
		        		    pw.flush();
		        		    pw.close();
		        		    fw.close();
		        		    }catch(Exception exception){
		        		        System.out.println("Exception have been caught");
		        		    }
						fout = new FileWriter("Files\\Notice Files\\Notice"+(i)+".txt", true);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}  
        			  int c;  
        			  try {
						while ((c = fin.read()) != -1) {  
						   fout.write(c);  
						  }
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}  
        			  System.out.println("Copy finish...");  
        			  try {
						fin.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}  
        			  try {
						fout.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
        	        noticeList[i] = noticeList[i+1]; // assign arr[i+1] to arr[i]  
        	    }
        		totalNotice--;
        		viewNoticePanel.setVisible(false);
        		viewNoticePanel.removeAll();
        		viewNoticePanel.setVisible(true);
        		arrangeNoticePanels(viewNoticePanel,forTeachers,forClassOfStud);
        	}
        });
		if(forTeachers)	panel.add(deleteBTN);
		
		
		panel.add(panel1);
		return panel1;
	}
		
	public void PublicNoticePanel(JPanel panel, JFrame frame, int screenWidth,  boolean forTeachers) {
		
		//initialize all the publicNoticeList to null
		for(int i=0;i<10;i++)publicNoticeList[i]=new PublicNoticeList("","","",false);
		//check if any of the list is free
		for(int i=0;i<10;i++) {
			if(new File("Files\\Public Notice Files\\Notice"+i+".txt").length()==0)	publicNoticeList[i].Full=false;
			else {publicNoticeList[i].Full=true;LoadPublicNoticeDetails(i);}
		}
		//to test for free files
		//for(int i=0;i<10;i++)System.out.println(publicNoticeList[i].Full);
		
		JPanel viewPublicNoticePanel = new JPanel(){
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.WHITE);
				g.fillArc(0, panel.getBounds().height-60-20, 20, 20, 180, 90);
				g.fillArc(panel.getBounds().width-20, panel.getBounds().height-60-20, 20, 20, 270, 90);
				g.fillRect(0, 0, panel.getBounds().width, panel.getBounds().height-65);
				g.fillRect(10, panel.getBounds().height-65,panel.getBounds().width-20,10);
				//g.fillRoundRect( 0, 0,panel.getBounds().width-3, panel.getBounds().height-60, 20, 20);
			}};
			viewPublicNoticePanel.setBounds(0, 60, panel.getBounds().width-2, panel.getBounds().height-60);
			if(!forTeachers)viewPublicNoticePanel.setBounds(0, 10, panel.getBounds().width-2, panel.getBounds().height-60);
			viewPublicNoticePanel.setOpaque(false);
			viewPublicNoticePanel.setLayout(null);
			viewPublicNoticePanel.setVisible(true);
			
		JPanel addPublicNoticePanel = new JPanel(){
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.setColor(Color.WHITE);
					g.fillArc(0, panel.getBounds().height-60-20, 20, 20, 180, 90);
					g.fillArc(panel.getBounds().width-20, panel.getBounds().height-60-20, 20, 20, 270, 90);
					g.fillRect(0, 0, panel.getBounds().width, panel.getBounds().height-65);
					g.fillRect(10, panel.getBounds().height-65,panel.getBounds().width-20,10);
				}};
				addPublicNoticePanel.setBounds(0, 60, panel.getBounds().width-2, panel.getBounds().height-60);
				addPublicNoticePanel.setOpaque(false);
				addPublicNoticePanel.setVisible(false);
		
		
		JButton addPublicNoticeBTN,viewPublicNoticeBTN;
		JLabel addPublicNoticeLabel,viewPublicNoticeLabel;

		JLabel addNoticeSuccessfull = new JLabel("");

		viewPublicNoticeBTN = new JButton("Manage Public Notices");
		addPublicNoticeBTN = new JButton("Add Public Notice");
		
		viewPublicNoticeLabel = new JLabel("Manage Public Notices");
		addPublicNoticeLabel = new JLabel("Add Public Notice");
		viewPublicNoticeLabel.setBounds(10,0,panel.getBounds().width/2-10,60);
		viewPublicNoticeLabel.setFont(new Font("MS PGothic", Font.BOLD, 16));
		viewPublicNoticeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addPublicNoticeLabel.setBounds(panel.getBounds().width/2,0,panel.getBounds().width/2-10,60);
		addPublicNoticeLabel.setFont(new Font("MS PGothic", Font.BOLD, 16));
		addPublicNoticeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		viewPublicNoticeBTN.setBounds(0,0,panel.getBounds().width/2,60);
		viewPublicNoticeBTN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addNoticeSuccessfull.setText("");
				addPublicNoticePanel.setVisible(false);					
				viewPublicNoticePanel.setVisible(true);
				addPublicNoticeBTN.setVisible(true);
				viewPublicNoticeBTN.setVisible(false);
			}
		});
		viewPublicNoticeBTN.setVisible(false);
		viewPublicNoticeBTN.setFont(new Font("MS PGothic", Font.BOLD, 16));
		viewPublicNoticeBTN.setBackground(BTNSelectedColor);
		viewPublicNoticeBTN.setBorderPainted(false);
		viewPublicNoticeBTN.setFocusPainted(false);
		viewPublicNoticeBTN.setOpaque(true);
		
		addPublicNoticeBTN.setBounds(panel.getBounds().width/2,0,panel.getBounds().width/2-2,60);
		addPublicNoticeBTN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				viewPublicNoticePanel.setVisible(false);
				addPublicNoticePanel.setVisible(true);
				viewPublicNoticeBTN.setVisible(true);
				addPublicNoticeBTN.setVisible(false);
			}
		});
		addPublicNoticeBTN.setVisible(true);
		addPublicNoticeBTN.setFont(new Font("MS PGothic", Font.BOLD, 16));
		addPublicNoticeBTN.setBackground(BTNSelectedColor);
		addPublicNoticeBTN.setBorderPainted(false);
		addPublicNoticeBTN.setFocusPainted(false);
		addPublicNoticeBTN.setOpaque(true);
		addPublicNoticePanel.setLayout(null);
		
		
		if(!forTeachers) {
			panel.add(viewPublicNoticePanel);
		}
		else {
			panel.add(viewPublicNoticeBTN);
			panel.add(addPublicNoticeBTN);
			panel.add(viewPublicNoticeLabel);
			panel.add(addPublicNoticeLabel);
			panel.add(viewPublicNoticePanel);
			panel.add(addPublicNoticePanel);
		}
		
		//Add Class
		int textFieldHeight = 40, x1 = 40, x2 = addPublicNoticePanel.getWidth()/2+20;
		Font textFieldFont = new Font("MS PGothic", Font.BOLD, 14);
		
		JLabel noticeHeaderLabel = new JLabel("Add Notice");
		noticeHeaderLabel.setBounds(40,5,500,40);
		noticeHeaderLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		addPublicNoticePanel.add(noticeHeaderLabel);
		
		
		JLabel noticeTitleLabel = new JLabel("Notice Title");
		noticeTitleLabel.setBounds(x1,40,addPublicNoticePanel.getWidth()/2-x1-20,textFieldHeight);
		addPublicNoticePanel.add(noticeTitleLabel);
		JTextField publicNoticeTitleTF = new JTextField();
		publicNoticeTitleTF.setBounds(x1,noticeTitleLabel.getBounds().y+textFieldHeight-10,addPublicNoticePanel.getWidth()-x1-20,textFieldHeight);
		publicNoticeTitleTF.setFont(textFieldFont);
		publicNoticeTitleTF.setMargin(new Insets(10, 10, 10,50));
		publicNoticeTitleTF.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke) {
	        	 addNoticeSuccessfull.setText("");
	         }
	      });
		addPublicNoticePanel.add(publicNoticeTitleTF);

		addNoticeSuccessfull.setBounds(160,240+textFieldHeight-10,300,50);
		addPublicNoticePanel.add(addNoticeSuccessfull);
		
		JLabel noticeMessageLabel = new JLabel("Notice Message");
		noticeMessageLabel.setBounds(x1,120,addPublicNoticePanel.getWidth()/2-x1-20,textFieldHeight);
		addPublicNoticePanel.add(noticeMessageLabel);
		
		JTextArea noticeArea = new JTextArea("");
		noticeArea.setMargin(new Insets(10, 10, 10,50));
		JScrollPane noticeScrollPane = new JScrollPane(noticeArea);
		noticeScrollPane.setBounds(x1,120+textFieldHeight-10,addPublicNoticePanel.getWidth()-x1-20,100);
		noticeScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        noticeArea.setFont(textFieldFont);
        noticeArea.setLineWrap(true);
        noticeArea.setWrapStyleWord(true);
        addPublicNoticePanel.add(noticeScrollPane);
        
        JButton addNoticeDetailsButton = new JButton("Add");
        addNoticeDetailsButton.setBounds(40, 240+textFieldHeight-10, 100, 50);
        addNoticeDetailsButton.setBackground(defaultMainColor);
        addNoticeDetailsButton.setFont(new Font("Verdana", Font.BOLD, 15));
        addNoticeDetailsButton.setForeground(Color.WHITE);
        addNoticeDetailsButton.setBorderPainted(false);
        addNoticeDetailsButton.setFocusPainted(false);
        addNoticeDetailsButton.setOpaque(true);
        addNoticeDetailsButton.getModel().addChangeListener(new ChangeListener() {
	            @Override
	            public void stateChanged(ChangeEvent e) {
	                ButtonModel model = (ButtonModel) e.getSource();

	                if (model.isRollover()) {
	                	addNoticeDetailsButton.setBackground(rolledOverColorBtn);
	                } else if (model.isPressed()) {
	                	addNoticeDetailsButton.setBackground(rolledOverColorBtn);
	                } else {
	                	addNoticeDetailsButton.setBackground(defaultMainColor);
	                }
	            }
	    });
        addNoticeDetailsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(publicNoticeTitleTF.getText().equals("") || noticeArea.getText().equals(""))
					addNoticeSuccessfull.setText("Notice Deatils Missing");
				else {
					int i;
					for(i=0;i<10&&publicNoticeList[i].Full;i++) {}
					if(i==10) addNoticeSuccessfull.setText("Maximum Notice Limit Reached");
					else {
						DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
					    Calendar obj = Calendar.getInstance();
					    String dateTime = formatter.format(obj.getTime());
						writePublicNoticeToTextFile(i,publicNoticeTitleTF.getText(),dateTime,noticeArea.getText());
						publicNoticeList[i].Title=publicNoticeTitleTF.getText();
						publicNoticeList[i].Date=dateTime;
						publicNoticeList[i].Message=noticeArea.getText();
						publicNoticeList[i].Full=true;
						totalPublicNotice++;
						arrangePublicNoticePanels(viewPublicNoticePanel,forTeachers);
						//System.out.println(totalPublicNotice);
						addNoticeSuccessfull.setText("Notice Added Successfully");
						noticeArea.setText("");publicNoticeTitleTF.setText("");
					}
				}
			}
		});
		addPublicNoticePanel.add(addNoticeDetailsButton);
		
		arrangePublicNoticePanels(viewPublicNoticePanel,forTeachers);
		
	}
	
	Boolean rolledForPublicNotice;JPanel[] publicNotificationPanel = new JPanel[10];static PublicNoticeList[] publicNoticeList=new PublicNoticeList[10];static int totalPublicNotice=0;
	
	static void writePublicNoticeToTextFile(int i,String title,String date,String message) {
		try {
			BufferedWriter myWriter = new BufferedWriter(new FileWriter("Files\\Public Notice Files\\Notice"+i+".txt",true));
			myWriter.write(title+"|"+date+"|"+message);
			myWriter.newLine();
			myWriter.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	
	public static void LoadPublicNoticeDetails(int i) {
		File file = new File("Files\\Public Notice Files\\Notice"+i+".txt");
		String title="",date="",message="";
	    Scanner sc;
		try {
			sc = new Scanner(file);
			sc.useDelimiter("[||]");
			while(sc.hasNext()) {
				title =sc.next();
				date  = sc.next();
				message = sc.next();
				publicNoticeList[totalPublicNotice++]=new PublicNoticeList(title,date,message,true);			
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//for testing
		//System.out.println();
		//System.out.println(publicNoticeList[i].Title+","+publicNoticeList[i].Date+","+publicNoticeList[i].Message+"   "+(i+1));
	}

	public void arrangePublicNoticePanels(JPanel viewPublicNoticePanel,boolean forTeachers) {
		
		for(int i=0,k=0;i<10;i++) {
			if((i%2)==0) {
				if(publicNoticeList[i].Full)
				publicNotificationPanel[i]=createPublicNoticePanels(viewPublicNoticePanel,50+k,true,publicNoticeList[i].Title,publicNoticeList[i].Date,publicNoticeList[i].Message,i,viewPublicNoticePanel,forTeachers);
			}
			else {
				if(publicNoticeList[i].Full) {
				publicNotificationPanel[i]=createPublicNoticePanels(viewPublicNoticePanel,50+k,false,publicNoticeList[i].Title,publicNoticeList[i].Date,publicNoticeList[i].Message,i,viewPublicNoticePanel,forTeachers);
				k+=100;}
			}
		}
	}
	
	public JPanel createPublicNoticePanels(JPanel panel,int y,Boolean left, String header, String date, String message,int ik,JPanel viewNoticePanel,boolean forTeachers) {
		Color color1 = new Color(217, 215, 215);
		JPanel panel1 = new JPanel(){
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g1 = (Graphics2D) g;
                g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
				g1.setColor(color1);
				g1.fillRoundRect(0, 0, panel.getWidth()/2-80, 80, 20, 20);
				//g1.fillRect(0, 0, panel.getWidth(), 80);
				g1.setColor(new Color(73,188,155));
				g1.fillOval(6, 5, 29, 29);
				g1.setColor(new Color(99,120,137));
				g1.fillOval(17, 22, 8, 8);
				g1.setColor(new Color(251,211,97));
				g1.fillArc(13, 8, 15, 15, 0, 180);
				g1.fillRect(13, 15, 15, 8);
				g1.fillRect(12, 22, 18, 5);
			}};
		panel1.setBackground(Color.WHITE);
		if(left)
			panel1.setBounds(40,y,panel.getWidth()/2-80,80);
		else
			panel1.setBounds(panel.getWidth()/2+20,y,panel.getWidth()/2-80,80);
		panel1.setLayout(null);
		
		JLabel noticeTitleinPanel = new JLabel(header);
		noticeTitleinPanel.setFont(new Font("MS PGothic", Font.BOLD, 14));
		noticeTitleinPanel.setBounds(40,5,panel1.getWidth()-130,30);
		panel1.add(noticeTitleinPanel);
		
		JLabel noticeDateinPanel = new JLabel(date);
		noticeDateinPanel.setFont(new Font("MS PGothic", Font.BOLD, 13));
		noticeDateinPanel.setBounds(panel1.getWidth()-80,5,panel1.getWidth()-40,30);
		panel1.add(noticeDateinPanel);
		
		JButton readMoreBTN = new JButton("Read More");
		readMoreBTN.setFont(new Font("MS PGothic", Font.BOLD, 15));
		readMoreBTN.setBounds(465,58,80,15);
		readMoreBTN.setBackground(color1);
		readMoreBTN.setBorderPainted(false);
		readMoreBTN.setFocusPainted(false);
		readMoreBTN.setOpaque(true);
		readMoreBTN.setForeground(defaultMainColor);
		readMoreBTN.setHorizontalAlignment(SwingConstants.LEFT);
		readMoreBTN.setMargin(new Insets(0,0,0,0));
		readMoreBTN.getModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ButtonModel model = (ButtonModel) e.getSource();

                if (model.isRollover()) {
                	readMoreBTN.setForeground(rolledOverColorBtn);
                } else if (model.isPressed()) {
                	readMoreBTN.setBackground(color1);
                } else {
                	readMoreBTN.setForeground(defaultMainColor);
                }
            }
        });
		readMoreBTN.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		JFrame f = new JFrame();
        		f.setBounds(0,0,500,500);
        		JTextArea noticeArea = new JTextArea(date+"\n"+header+"\n\n"+message+"\n-By Administrator");
        		noticeArea.setEditable(false);
        		noticeArea.setMargin(new Insets(10, 10, 10,10));
        		JScrollPane noticeScrollPane = new JScrollPane(noticeArea);
        		noticeScrollPane.setBounds(0,0,f.getWidth(),f.getHeight());
        		noticeScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                noticeArea.setFont(new Font("MS PGothic", Font.BOLD, 15));
                noticeArea.setLineWrap(true);
                noticeArea.setWrapStyleWord(true);
                f.add(noticeScrollPane);
                f.setVisible(true);
        	}
        });
		panel1.add(readMoreBTN);

		JTextArea noticeMessageinPanel = new JTextArea(message);
		noticeMessageinPanel.setBackground(color1);
		noticeMessageinPanel.setEditable(false);
		noticeMessageinPanel.setBounds(20,40,panel1.getWidth()-40,35);
		noticeMessageinPanel.setFont(new Font("MS PGothic", Font.BOLD, 15));
		noticeMessageinPanel.setLineWrap(true);
		noticeMessageinPanel.setWrapStyleWord(true);
		panel1.add(noticeMessageinPanel);
		
		rolled = true;

		JButton deleteBTN = new JButton(""){
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g1 = (Graphics2D) g;
                g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
				if(rolled) g1.setColor(defaultMainColor);
				else g1.setColor(rolledOverColorBtn);
				g1.setStroke(new BasicStroke(1.9f));
				g1.drawLine(8, 10, 10, 25);
				g1.drawLine(10, 25, 17, 25);
				g1.drawLine(20, 10, 18, 25);
				g1.drawLine(7, 10, 21, 10);
				g1.drawRect(12, 8, 5, 2);
			}};
		if(left) deleteBTN.setBounds(panel.getWidth()/3*2-245,y+30,30,30);
		else deleteBTN.setBounds(panel.getWidth()-55,y+30,30,30);
		deleteBTN.setBackground(Color.WHITE);
		deleteBTN.setBorderPainted(false);
		deleteBTN.setFocusPainted(false);
		deleteBTN.setOpaque(true);
		deleteBTN.getModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ButtonModel model = (ButtonModel) e.getSource();
                if (model.isRollover()) {
                	rolled = false;
                } else if (model.isPressed()) {
                	rolled = true;
                } else {
                	rolled = true;
                }
            }
        });
		deleteBTN.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		try{
        		    FileWriter fw = new FileWriter("Files\\Public Notice Files\\Notice"+ik+".txt", false);
        		    PrintWriter pw = new PrintWriter(fw, false);
        		    pw.flush();
        		    pw.close();
        		    fw.close();
        		    }catch(Exception exception){
        		        System.out.println("Exception have been caught");
        		    }
        		publicNoticeList[ik].Full=false;
        		//for(int i=0;i<10;i++)System.out.println(noticeList[i].Full);
        		for (int i = ik; i < 10-1; i++)  
        	    {  
        			FileReader fin = null;
					try {
						fin = new FileReader("Files\\Public Notice Files\\Notice"+(i+1)+".txt");
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}  
        			  FileWriter fout = null;
					try {
						try{
		        		    FileWriter fw = new FileWriter("Files\\Public Notice Files\\Notice"+i+".txt", false);
		        		    PrintWriter pw = new PrintWriter(fw, false);
		        		    pw.flush();
		        		    pw.close();
		        		    fw.close();
		        		    }catch(Exception exception){
		        		        System.out.println("Exception have been caught");
		        		    }
						fout = new FileWriter("Files\\Public Notice Files\\Notice"+(i)+".txt", true);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}  
        			  int c;  
        			  try {
						while ((c = fin.read()) != -1) {  
						   fout.write(c);  
						  }
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}  
        			  System.out.println("Copy finish...");  
        			  try {
						fin.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}  
        			  try {
						fout.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
        	        publicNoticeList[i] = publicNoticeList[i+1]; // assign arr[i+1] to arr[i]  
        	    }
        		totalPublicNotice--;
        		viewNoticePanel.setVisible(false);
        		viewNoticePanel.removeAll();
        		viewNoticePanel.setVisible(true);
        		arrangePublicNoticePanels(viewNoticePanel,forTeachers);
        	}
        });
		if(forTeachers)	panel.add(deleteBTN);
		
		
		panel.add(panel1);
		return panel1;
	}
	
	public void ClassPanel(JPanel panel,JFrame frame, int screenWidth){
				
		
		for(int i =0; i<5;i++)classDetailsPanel[i]=createClassListPanel(panel);
				
				JPanel viewStudPanel = new JPanel(){
					protected void paintComponent(Graphics g) {
						super.paintComponent(g);
						Graphics2D g1 = (Graphics2D) g;
		                g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
						g1.setColor(Color.WHITE);
						g1.fillArc(0, panel.getBounds().height-60-20, 20, 20, 180, 90);
						g1.fillArc(panel.getBounds().width-20, panel.getBounds().height-60-20, 20, 20, 270, 90);
						g1.fillRect(0, 0, panel.getBounds().width, panel.getBounds().height-65);
						g1.fillRect(10, panel.getBounds().height-65,panel.getBounds().width-20,10);
						//g1.fillRoundRect( 0, 0,panel.getBounds().width-3, panel.getBounds().height-60, 20, 20);
					}};
					viewStudPanel.setBounds(0, 60, panel.getBounds().width-2, panel.getBounds().height-60);
					viewStudPanel.setOpaque(false);
					viewStudPanel.setLayout(null);
					viewStudPanel.setVisible(true);
					
				JPanel addStudPanel = new JPanel(){
						protected void paintComponent(Graphics g) {
							super.paintComponent(g);
							Graphics2D g1 = (Graphics2D) g;
			                g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
							g1.setColor(Color.WHITE);
							g1.fillArc(0, panel.getBounds().height-60-20, 20, 20, 180, 90);
							g1.fillArc(panel.getBounds().width-20, panel.getBounds().height-60-20, 20, 20, 270, 90);
							g1.fillRect(0, 0, panel.getBounds().width, panel.getBounds().height-65);
							g1.fillRect(10, panel.getBounds().height-65,panel.getBounds().width-20,10);
						}};
						addStudPanel.setBounds(0, 60, panel.getBounds().width-2, panel.getBounds().height-60);
						addStudPanel.setOpaque(false);
						addStudPanel.setVisible(false);
				
				
				JButton addStudBTN,viewStudBTN;
				JLabel addStudLabel,viewStudLabel;

				JLabel addStudSuccessfull = new JLabel("");

				viewStudBTN = new JButton("View Class List");
				addStudBTN = new JButton("Add Class");
				
				viewStudLabel = new JLabel("View Class List");
				addStudLabel = new JLabel("Add Class");
				viewStudLabel.setBounds(10,0,panel.getBounds().width/2-10,60);
				viewStudLabel.setFont(new Font("MS PGothic", Font.BOLD, 16));
				viewStudLabel.setHorizontalAlignment(SwingConstants.CENTER);
				addStudLabel.setBounds(panel.getBounds().width/2,0,panel.getBounds().width/2-10,60);
				addStudLabel.setFont(new Font("MS PGothic", Font.BOLD, 16));
				addStudLabel.setHorizontalAlignment(SwingConstants.CENTER);
				
				viewStudBTN.setBounds(0,0,panel.getBounds().width/2,60);
				viewStudBTN.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						addStudSuccessfull.setText("");
						addStudPanel.setVisible(false);					
						viewStudPanel.setVisible(true);
						addStudBTN.setVisible(true);
						viewStudBTN.setVisible(false);
					}
				});
				viewStudBTN.setVisible(false);
				viewStudBTN.setFont(new Font("MS PGothic", Font.BOLD, 16));
				viewStudBTN.setBackground(BTNSelectedColor);
				viewStudBTN.setBorderPainted(false);
				viewStudBTN.setFocusPainted(false);
				viewStudBTN.setOpaque(true);
				
				addStudBTN.setBounds(panel.getBounds().width/2,0,panel.getBounds().width/2-2,60);
				addStudBTN.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						viewStudPanel.setVisible(false);
						addStudPanel.setVisible(true);
						viewStudBTN.setVisible(true);
						addStudBTN.setVisible(false);
					}
				});
				addStudBTN.setVisible(true);
				addStudBTN.setFont(new Font("MS PGothic", Font.BOLD, 16));
				addStudBTN.setBackground(BTNSelectedColor);
				addStudBTN.setBorderPainted(false);
				addStudBTN.setFocusPainted(false);
				addStudBTN.setOpaque(true);
				addStudPanel.setLayout(null);
				
				panel.add(viewStudBTN);
				panel.add(addStudBTN);
				panel.add(viewStudLabel);
				panel.add(addStudLabel);
				panel.add(viewStudPanel);
				panel.add(addStudPanel);
				
				//Add Class
				int textFieldHeight = 40, x1 = 40, x2 = addStudPanel.getWidth()/2+20;
				Font textFieldFont = new Font("MS PGothic", Font.BOLD, 14);
				
				JLabel studDetailsLabel = new JLabel("Class details");
				studDetailsLabel.setBounds(40,5,500,40);
				studDetailsLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
				addStudPanel.add(studDetailsLabel);
				
				JLabel classNameLabel = new JLabel("Class Name");
				classNameLabel.setBounds(x1,40,addStudPanel.getWidth()/2-x1-20,textFieldHeight);
				addStudPanel.add(classNameLabel);
				JTextField classNameTF = new JTextField();
				classNameTF.setBounds(x1,classNameLabel.getBounds().y+textFieldHeight-10,addStudPanel.getWidth()-x1-20,textFieldHeight);
				classNameTF.setFont(textFieldFont);
				classNameTF.setMargin(new Insets(10, 10, 10,50));
				classNameTF.addKeyListener(new KeyAdapter() {
			         public void keyPressed(KeyEvent ke) {
			        	 addStudSuccessfull.setText("");
			         }
			      });
				addStudPanel.add(classNameTF);
				
				
				String section[]={"A","B","C","D","E","F"};
				JLabel sectionLabel = new JLabel("Section");
				sectionLabel.setBounds(x1,120,addStudPanel.getWidth()/2-x1-20,textFieldHeight);
				addStudPanel.add(sectionLabel);
				JComboBox sectionTF1 = new JComboBox(section);
				sectionTF1.setBounds(x1,120+textFieldHeight-10,addStudPanel.getWidth()-x1-20,textFieldHeight);
				sectionTF1.setFont(textFieldFont);
				sectionTF1.setFocusable(false);
				sectionTF1.setOpaque(false);
				sectionTF1.setBackground(Color.WHITE);
				addStudPanel.add(sectionTF1);

				addStudSuccessfull.setBounds(160,200,300,50);
				addStudPanel.add(addStudSuccessfull);
				
				JButton addStudentDetailsButton = new JButton("Add");
				addStudentDetailsButton.setBounds(40, 200, 100, 50);
				addStudentDetailsButton.setBackground(defaultMainColor);
				addStudentDetailsButton.setFont(new Font("Verdana", Font.BOLD, 15));
				addStudentDetailsButton.setForeground(Color.WHITE);
				addStudentDetailsButton.setBorderPainted(false);
				addStudentDetailsButton.setFocusPainted(false);
				addStudentDetailsButton.setOpaque(true);
				addStudentDetailsButton.getModel().addChangeListener(new ChangeListener() {
			            @Override
			            public void stateChanged(ChangeEvent e) {
			                ButtonModel model = (ButtonModel) e.getSource();

			                if (model.isRollover()) {
			                	addStudentDetailsButton.setBackground(rolledOverColorBtn);
			                } else if (model.isPressed()) {
			                	addStudentDetailsButton.setBackground(rolledOverColorBtn);
			                } else {
			                	addStudentDetailsButton.setBackground(defaultMainColor);
			                }
			            }
			    });
				
				JButton prevBtn = new JButton("< Prev");
				JButton nextBtn = new JButton("Next >");
				
				addStudentDetailsButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(classNameTF.getText().equals("")) {
							addStudSuccessfull.setText("Class Details Missing");
						}
						else{
							UpdateClasss();
							DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
							LocalDateTime now = LocalDateTime.now();  
							String dateTime = dtf.format(now);  
							writeClassDetailsToTextFile(classNameTF.getText(),sectionTF1.getSelectedItem().toString(),dateTime);
							classList[n1++]=new ClassList(classNameTF.getText(),sectionTF1.getSelectedItem().toString(),dateTime);
							ArrangeClassDetails(panel,viewStudPanel);
							addStudSuccessfull.setText("Class Added Successfully");
							if(classDetailspage==0)prevBtn.setVisible(false);
							else prevBtn.setVisible(true);
							if(classDetailspage==totPagesClass-1)nextBtn.setVisible(false);
							else nextBtn.setVisible(true);
							classNameTF.setText(null);
							
							changeDetailsInComboBox(classTF);
							changeDetailsInComboBox(sectionTF);
							
						}
					}
				});
				addStudPanel.add(addStudentDetailsButton);
			
				
				JLabel studListLabel = new JLabel("Class List");
				studListLabel.setBounds(100,50,500,40);
				studListLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
				viewStudPanel.add(studListLabel);
				
				
				
				

				ArrangeClassDetails(panel,viewStudPanel);
				
				prevBtn.setBounds(90,360,100,30);
				prevBtn.setFont(new Font("MS PGothic", Font.BOLD, 18));
				prevBtn.setBackground(Color.WHITE);
				prevBtn.setForeground(defaultMainColor);
				prevBtn.setBorderPainted(false);
				prevBtn.setFocusPainted(false);
				prevBtn.setOpaque(true);
				prevBtn.setHorizontalAlignment(SwingConstants.LEFT);
				prevBtn.getModel().addChangeListener(new ChangeListener() {
		            @Override
		            public void stateChanged(ChangeEvent e) {
		                ButtonModel model = (ButtonModel) e.getSource();

		                if (model.isRollover()) {
		                	prevBtn.setForeground(rolledOverColorBtn);
		                } else if (model.isPressed()) {
		                	prevBtn.setForeground(rolledOverColorBtn);
		                } else {
		                	prevBtn.setForeground(defaultMainColor);
		                }
		            }
		        });
				prevBtn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(classDetailspage>0) {
							for(int i=0;i<totPagesClass;i++)
								classDetailsPanel[i].setVisible(false);
							classDetailsPanel[--classDetailspage].setVisible(true);}
						//System.out.println(studDetailspage);
						if(classDetailspage==0)prevBtn.setVisible(false);
						else prevBtn.setVisible(true);
						if(classDetailspage==totPagesClass-1)nextBtn.setVisible(false);
						else nextBtn.setVisible(true);
					}
				});
				viewStudPanel.add(prevBtn);
				
				if(classDetailspage==0)prevBtn.setVisible(false);
				else prevBtn.setVisible(true);
				if(classDetailspage==totPagesClass-1)nextBtn.setVisible(false);
				else nextBtn.setVisible(true);
				
				nextBtn.setBounds(1075,360,100,30);
				nextBtn.setFont(new Font("MS PGothic", Font.BOLD, 18));
				nextBtn.setBackground(Color.WHITE);
				nextBtn.setForeground(defaultMainColor);
				nextBtn.setBorderPainted(false);
				nextBtn.setFocusPainted(false);
				nextBtn.setOpaque(true);
				nextBtn.setHorizontalAlignment(SwingConstants.RIGHT);
				nextBtn.getModel().addChangeListener(new ChangeListener() {
		            @Override
		            public void stateChanged(ChangeEvent e) {
		                ButtonModel model = (ButtonModel) e.getSource();

		                if (model.isRollover()) {
		                	nextBtn.setForeground(rolledOverColorBtn);
		                } else if (model.isPressed()) {
		                	nextBtn.setForeground(rolledOverColorBtn);
		                } else {
		                	nextBtn.setForeground(defaultMainColor);
		                }
		            }
		        });
				nextBtn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(classDetailspage<totPagesClass-1) {
							for(int i=0;i<totPagesClass;i++)
								classDetailsPanel[i].setVisible(false);
							classDetailsPanel[++classDetailspage].setVisible(true);}
						//System.out.println(studDetailspage);
						if(classDetailspage==0)prevBtn.setVisible(false);
						else prevBtn.setVisible(true);
						if(classDetailspage==totPagesClass-1)nextBtn.setVisible(false);
						else nextBtn.setVisible(true);
					}
				});
				viewStudPanel.add(nextBtn);
			}

}

