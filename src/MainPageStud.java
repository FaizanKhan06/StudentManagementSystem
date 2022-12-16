import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;

public class MainPageStud {
	//static JPanel dashboardPanel,classPanel,studentsPanel,noticePanel,publicNoticePanel;
	
	static Color lightGrey = new Color(34,36,48);
	static Color defaultIconLeftSideColor = new Color(52,55,77);
	static Color defaultLeftPanelBackground = new Color(23,23,35);
	static Color defaultMainColor = new Color(0,103,255);//Green//new Color(38,86,158);//Blue//new Color(26,176,34);//Green
	static Color leftPanelRolledOverBtnColor = new Color(40,42,62);
	static Color usernameColor = new Color(105,105,105);
	static Color userProfileBorderColor = new Color(214,214,214);
	
	public static JButton createBTN(String name,int x,int y,int width,int height,boolean upLine,boolean downLine) {
		
		JButton btn = new JButton(" "+name) {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(lightGrey);
                if(upLine)
                g.fillRect(20,0,200,1);
                if(downLine)
                g.fillRect(20,39,200,1);
                
                Graphics2D g1 = (Graphics2D) g;
                g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            	g1.setColor(defaultIconLeftSideColor);
            	g1.setStroke(new BasicStroke(1.2f));
                
                if(name.equals("Profile")) {
                	g1.drawOval(189,10,10,10);
                	g1.drawArc(186,20,18,18,90,90);
                	g1.drawArc(186,20,18,18,0,45);
                	g1.drawArc(183,10,10,10,100,130);
                	g1.drawArc(180,20,18,18,115,65);
                	g1.drawArc(177,10,10,10,100,130);
                	g1.drawArc(174,20,18,18,115,65);
                }
                else if(name.equals("Notice")) {
                	g1.drawRoundRect(180, 7, 18, 25, 5,5);
                	g1.drawLine(184,11,194,11);
                	g1.drawLine(184,15,194,15);
                	//g1.drawLine(184,19,194,19);
                	g1.drawLine(184,19,188,19);g1.drawLine(191,19,194,19);
                	g1.drawLine(184,23,194,23);
                	g1.drawLine(184,27,187,27);g1.drawLine(190,27,194,27);
                }
                else if(name.equals("Public Notice")) {
                	g1.drawRoundRect(180, 7, 18, 25, 5,5);
                	g1.drawLine(194, 7, 194, 30);
                	g1.drawLine(179, 11, 182, 11);
                	g1.drawLine(179, 15, 182, 15);
                	g1.drawLine(179, 19, 182, 19);
                	g1.drawLine(179, 23, 182, 23);
                	g1.drawLine(179, 27, 182, 27);
                	g1.drawLine(179, 31, 182, 31);
                }                
            }};
		btn.setBounds(x,y,width,height);
		btn.setBackground(defaultLeftPanelBackground);
		btn.setFont(new Font("Verdana", Font.BOLD, 15));
		btn.setForeground(Color.WHITE);
		btn.setBorderPainted(false);
		btn.setFocusPainted(false);
		btn.setOpaque(true);
		btn.setHorizontalAlignment(SwingConstants.LEFT);
		btn.getModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ButtonModel model = (ButtonModel) e.getSource();

                if (model.isRollover()) {
                	btn.setBackground(leftPanelRolledOverBtnColor);
                } else if (model.isPressed()) {
                	btn.setBackground(defaultLeftPanelBackground);
                } else {
                	btn.setBackground(defaultLeftPanelBackground);
                }
            }
        });
		
		return btn;
	}
	
	public static JLabel createLabel(String name,int x,int y,int width,int height,boolean upLine,boolean downLine) {
		
		JLabel label = new JLabel("    "+name) {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(lightGrey);
                if(upLine)
                g.fillRect(20,0,200,1);
                if(downLine)
                g.fillRect(20,39,200,1);
                
                Graphics2D g1 = (Graphics2D) g;
                g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            	g1.setColor(defaultMainColor);
            	g1.setStroke(new BasicStroke(1.2f));
                
                if(name.equals("Profile")) {
                	g1.drawOval(189,10,10,10);
                	g1.drawArc(186,20,18,18,90,90);
                	g1.drawArc(186,20,18,18,0,45);
                	g1.drawArc(183,10,10,10,100,130);
                	g1.drawArc(180,20,18,18,115,65);
                	g1.drawArc(177,10,10,10,100,130);
                	g1.drawArc(174,20,18,18,115,65);
                }
                else if(name.equals("Notice")) {
                	g1.drawRoundRect(180, 7, 18, 25, 5,5);
                	g1.drawLine(184,11,194,11);
                	g1.drawLine(184,15,194,15);
                	//g1.drawLine(184,19,194,19);
                	g1.drawLine(184,19,188,19);g1.drawLine(191,19,194,19);
                	g1.drawLine(184,23,194,23);
                	g1.drawLine(184,27,187,27);g1.drawLine(190,27,194,27);
                }
                else if(name.equals("Public Notice")) {
                	g1.drawRoundRect(180, 7, 18, 25, 5,5);
                	g1.drawLine(194, 7, 194, 30);
                	g1.drawLine(179, 11, 182, 11);
                	g1.drawLine(179, 15, 182, 15);
                	g1.drawLine(179, 19, 182, 19);
                	g1.drawLine(179, 23, 182, 23);
                	g1.drawLine(179, 27, 182, 27);
                	g1.drawLine(179, 31, 182, 31);
                }
            }};
        label.setBounds(x,y,width,height);
        label.setBackground(leftPanelRolledOverBtnColor);
		label.setFont(new Font("Verdana", Font.BOLD, 15));
		label.setForeground(Color.WHITE);
		label.setOpaque(true);
		//label.setHorizontalAlignment(SwingConstants.LEFT);
		
		return label;
	}

	public static void BTNselected(JButton b1,JButton b2,JButton b3,JButton selectedBTN) {
		b1.setVisible(true);b2.setVisible(true);b3.setVisible(true);
		selectedBTN.setVisible(false);
	}
	
	public static void PanelSelected(JPanel dashboardPanel,JPanel noticePanel,JPanel publicNoticePanel,JPanel selectedPanel) {
		dashboardPanel.setVisible(false);noticePanel.setVisible(false);
		publicNoticePanel.setVisible(false);
		selectedPanel.setVisible(true);
	}
	
	public static JPanel createContentPanel(String header,int heightOfContentPanel,int screenWidth) {
		JPanel panel = new JPanel(){
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);
                g.fillRoundRect( 0, 0, screenWidth-260-22, heightOfContentPanel-4, 20, 20);
            }};
		panel.setBounds(260,115,screenWidth-260-20,heightOfContentPanel);
		panel.setLayout(null);
		/*JLabel label = new JLabel(header);
		label.setBounds(100,0,100,30);
		panel.add(label);*/
		return panel; 
	}
	
	public void MainPageStudRunner(String fname,String lname,String id,String ph,String classs,String gender,String fathername,String fatherph,String mothername,String motherph,String guardianname,String guardianph,String password,String mail){
		 
		
		//Edited by KHAN FAIZAN
		//LoadAllStudentDetails();
		
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int)size.getWidth();
        int screenHeight = (int)size.getHeight();
		
		JFrame frame = new JFrame("Student Management & Enrollment System For Student");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		ImageIcon img = new ImageIcon("IconPlaceHolder.png");
    	frame.setIconImage(img.getImage());
		//frame.setResizable(false);
		frame.setLayout(null);

        JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0,0,screenWidth,screenHeight);
		frame.add(layeredPane);
		
		JPanel leftPanel = new JPanel(){
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                //Profile Pic
                Graphics2D g1 = (Graphics2D) g;
                g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
                g1.setColor(Color.WHITE);
                g1.fillOval(20, 85, 50, 50);
                g1.setColor(defaultLeftPanelBackground);
                g1.fillOval(35, 89, 23, 23);
                g1.fillArc(21, 113, 50, 50, 30,120);
                g1.setColor(defaultMainColor);
                g1.setColor(defaultMainColor);
                g1.setStroke(new BasicStroke(3));
                g1.drawOval(20, 85, 50, 50);
            }};
		leftPanel.setBounds(0,0,240,792);
		leftPanel.setBackground(defaultLeftPanelBackground);
		
		
		JPanel rightPanelHeader = new JPanel();
		rightPanelHeader.setBounds(240,0,1295,72);
		rightPanelHeader.setBackground(Color.WHITE);
		
		JLabel logoPlaceHolder = new JLabel("SM&ES");
		logoPlaceHolder.setForeground(Color.WHITE);
		logoPlaceHolder.setFont(new Font("Verdana", Font.BOLD, 22));
		logoPlaceHolder.setBounds(25,25,240,22);
		frame.add(logoPlaceHolder);
		
		JLabel nameLabel = new JLabel(fname+" "+lname);
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		nameLabel.setBounds(80,80,160,40);
		frame.add(nameLabel);
		
		JLabel usernameLabel = new JLabel(mail);
		usernameLabel.setForeground(usernameColor);
		usernameLabel.setFont(new Font("Verdana", Font.BOLD, 10));
		usernameLabel.setBounds(80,105,160,40);
		frame.add(usernameLabel);
		
		JLabel dashboardLabel = new JLabel("DASHBOARD");
		dashboardLabel.setForeground(defaultMainColor);
		dashboardLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		dashboardLabel.setBounds(23,160,240,40);
		frame.add(dashboardLabel);
		
		JButton dashboardBTN = createBTN("Profile", 0,214,240,40,true,true);
		JButton noticeBTN = createBTN("Notice", 0, 254, 240, 40,false,true);
		JButton publicNoticeBTN = createBTN("Public Notice", 0, 294, 240, 40,false,true);
		
		JPanel dashboardPanel = createContentPanel("Dashboard",530,screenWidth);
		JPanel noticePanel = createContentPanel("Notice",620,screenWidth);
		JPanel publicNoticePanel = createContentPanel("Public Notice",620,screenWidth);
		
		dashboardBTN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BTNselected(dashboardBTN,noticeBTN,publicNoticeBTN,dashboardBTN);
				PanelSelected(dashboardPanel,noticePanel,publicNoticePanel,dashboardPanel);
			}
		});
		noticeBTN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BTNselected(dashboardBTN,noticeBTN,publicNoticeBTN,noticeBTN);
				PanelSelected(dashboardPanel,noticePanel,publicNoticePanel,noticePanel);
			}
		});
		publicNoticeBTN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BTNselected(dashboardBTN,noticeBTN,publicNoticeBTN,publicNoticeBTN);
				PanelSelected(dashboardPanel,noticePanel,publicNoticePanel,publicNoticePanel);
			}
		});
		dashboardBTN.setVisible(false);
		
		frame.add(dashboardBTN);
		frame.add(noticeBTN);
		frame.add(publicNoticeBTN);
		
		
		JLabel dashboardLBL = createLabel("Profile", 0,214,240,40,true,true);
		JLabel noticeLBL = createLabel("Notice", 0, 254, 240, 40,false,true);
		JLabel publicNoticeLBL = createLabel("Public Notice", 0, 294, 240, 40,false,true);
		        
        frame.add(dashboardLBL);
        frame.add(noticeLBL);
        frame.add(publicNoticeLBL);
        
        
        JLabel welcomeLabel = new JLabel("Welcome "+fname+"!");
        welcomeLabel.setForeground(Color.BLACK);
        welcomeLabel.setFont(new Font("Verdana", Font.BOLD, 15));
        welcomeLabel.setBounds(270,15,240,40);
		frame.add(welcomeLabel);
		
		
		String userText = fname+" "+lname;
		Font font = new Font("Verdana", Font.BOLD, 12);
        FontRenderContext frc = new FontRenderContext(new AffineTransform(), true, true);
        int textwidth = (int)(font.getStringBounds(userText, frc).getWidth())+45;
        
        int heightOfLogoutPanel = 431;
        JPanel logOutPanel = new JPanel(){
        	protected void paintComponent(Graphics g) {
        		super.paintComponent(g);
        		Graphics2D g1 = (Graphics2D) g;
                g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        		g1.setColor(Color.WHITE);
        		g1.fillRoundRect( 0, 0, screenWidth-1248-22, heightOfLogoutPanel-4, 15, 15);
        		g1.setColor(userProfileBorderColor);
        		g1.drawRoundRect( 0, 0, screenWidth-1248-22, heightOfLogoutPanel-4, 15, 15);
        		
        		//profile Pic
        		g1.setColor(Color.BLACK);
        		g1.fillOval(9, 10, 250, 250);
        		g1.setColor(Color.WHITE);
        		g1.fillArc(25, 150, 220, 300, 33, 115);
        		g1.fillOval(83, 45, 100, 100);
                g1.setColor(defaultMainColor);
                g1.setStroke(new BasicStroke(3));
        		g1.drawArc(25, 150, 220, 300, 33, 114);
        		g1.drawOval(83, 45, 100, 100);
                g1.setColor(defaultMainColor);
                g1.setStroke(new BasicStroke(5));
                g1.drawOval(9, 10, 250, 250);
        	}};
        logOutPanel.setBounds(screenWidth-268-20, 72, 268, heightOfLogoutPanel);
        logOutPanel.setLayout(null);
        logOutPanel.setVisible(false);
        layeredPane.add(logOutPanel,JLayeredPane.DRAG_LAYER);
        	
        JLabel signOutNameLabel = new JLabel(fname+" "+lname);
        signOutNameLabel.setBounds(1,250,265,53);
        signOutNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        signOutNameLabel.setFont(new Font("Verdana", Font.BOLD, 13));
        logOutPanel.add(signOutNameLabel);
        
        JLabel signOutUserNameLabel = new JLabel(mail);
        signOutUserNameLabel.setBounds(1,270,265,53);
        signOutUserNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        signOutUserNameLabel.setFont(new Font("Verdana", Font.PLAIN, 10));
        logOutPanel.add(signOutUserNameLabel);

        JButton profileBTN = new JButton("       My Profile"){
        	protected void paintComponent(Graphics g) {
        		super.paintComponent(g);
        		Graphics2D g1 = (Graphics2D) g;
                g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
                g1.setColor(new Color(207, 207, 207));
                g1.setStroke(new BasicStroke(2));
                g1.drawLine(32, 53, 235, 53);
                g1.drawLine(32, -1, 235, -1);
                
                g1.setColor(defaultMainColor);
                g1.setStroke(new BasicStroke(3));
                g1.drawOval(25, 12, 15, 15);
                g1.drawArc(21, 27, 22, 22, 90, 90);
                g1.drawArc(21, 27, 22, 22, 0, 35);
        	}};
        profileBTN.setBounds(1, 315, 265, 53);
        profileBTN.setBackground(Color.WHITE);
        profileBTN.setFont(new Font("Verdana", Font.BOLD, 15));
        profileBTN.setForeground(Color.BLACK);
        profileBTN.setBorderPainted(false);
        profileBTN.setFocusPainted(false);
        profileBTN.setOpaque(true);
        profileBTN.setHorizontalAlignment(SwingConstants.LEFT);
        profileBTN.getModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ButtonModel model = (ButtonModel) e.getSource();

                if (model.isRollover()) {
                	profileBTN.setBackground(new Color(235,235,235));
                } else if (model.isPressed()) {
                	profileBTN.setBackground(new Color(235,235,235));
                } else {
                	profileBTN.setBackground(Color.WHITE);
                }
            }
        });
        logOutPanel.add(profileBTN);
        
        
        JButton signOutBTN = new JButton("       Sign Out"){
        	protected void paintComponent(Graphics g) {
        		super.paintComponent(g);
        		                
        		Graphics2D g1 = (Graphics2D) g;
                g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
                g1.setColor(defaultMainColor);
                g1.setStroke(new BasicStroke(3));
                g1.drawArc(18, 16, 26, 26, 115, 310);
                g1.drawLine(31, 13, 31, 22);
        	}};
        signOutBTN.setBounds(1, 368, 265, 53);
        signOutBTN.setBackground(Color.WHITE);
        signOutBTN.setFont(new Font("Verdana", Font.BOLD, 15));
        signOutBTN.setForeground(Color.BLACK);
        signOutBTN.setBorderPainted(false);
        signOutBTN.setFocusPainted(false);
        signOutBTN.setOpaque(true);
        signOutBTN.setHorizontalAlignment(SwingConstants.LEFT);
        signOutBTN.getModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ButtonModel model = (ButtonModel) e.getSource();

                if (model.isRollover()) {
                	signOutBTN.setBackground(new Color(235,235,235));
                } else if (model.isPressed()) {
                	signOutBTN.setBackground(new Color(235,235,235));
                } else {
                	signOutBTN.setBackground(Color.WHITE);
                }
            }
        });
        signOutBTN.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		LoginSignUpPage loginSignUpPageOBJ = new LoginSignUpPage();
        		loginSignUpPageOBJ.LoginPageGUI(loginSignUpPageOBJ);
        		frame.setVisible(false);
        	}
        });
        logOutPanel.add(signOutBTN);

        	
        	JButton nameDDBTN = new JButton(userText){
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                Graphics2D g1 = (Graphics2D) g;
                g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

                //Profile Pic
                g1.setColor(defaultLeftPanelBackground);
                g1.fillOval(1, 1, 40, 40);
                g1.setColor(defaultLeftPanelBackground);
                g1.setStroke(new BasicStroke(2));
                g1.drawLine(textwidth+1, 17, textwidth+6, 24);
                g1.drawLine(textwidth+6+1, 24, textwidth+12, 17);
                
                g1.setColor(Color.WHITE);
                g1.fillOval(14+1, 8+1, 13, 13);
                g1.fillArc(1+1, 22+1, 40, 40, 35,120);
                
                
                g1.setColor(defaultMainColor);
                g1.setStroke(new BasicStroke(3));                
                g1.drawOval(1+1, 1+1, 38, 38);
            }};
		nameDDBTN.setBackground(Color.WHITE);
		nameDDBTN.setForeground(Color.BLACK);
		nameDDBTN.setFont(font);
		nameDDBTN.setBounds(screenWidth-textwidth-36,13,textwidth+16,42);
		nameDDBTN.setBorderPainted(false);
		nameDDBTN.setFocusPainted(false);
		nameDDBTN.setHorizontalAlignment(SwingConstants.LEFT);
		nameDDBTN.setMargin(new Insets(0, 40, 0,0));
		nameDDBTN.setOpaque(true);
		nameDDBTN.getModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ButtonModel model = (ButtonModel) e.getSource();

                if (model.isRollover()) {
                	nameDDBTN.setBackground(new Color(235, 235, 235));
                } else if (model.isPressed()) {
                	nameDDBTN.setBackground(Color.WHITE);
                } else {
                	nameDDBTN.setBackground(Color.WHITE);
                }
            }
        });
		nameDDBTN.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		if(!logOutPanel.isVisible()) {
        			logOutPanel.setVisible(true);
        		}
        		else {
        			logOutPanel.setVisible(false);
        		}
        	}
        });
		frame.add(nameDDBTN);
				
		PanelDesign panelDesign = new PanelDesign(); 
        
        panelDesign.NoticePanel(noticePanel,frame,screenWidth,false,classs);
        
        panelDesign.PublicNoticePanel(publicNoticePanel,frame,screenWidth,false);
		
      //Add Student
		int textFieldHeight = 40, x1 = 40, x2 = dashboardPanel.getWidth()/2+20;
		Font textFieldFont = new Font("MS PGothic", Font.BOLD, 14);
		
		JLabel studDetailsLabel = new JLabel("Student's Profile");
		studDetailsLabel.setBounds(40,5,500,40);
		studDetailsLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		dashboardPanel.add(studDetailsLabel);
		
		JLabel fnameLabel = new JLabel("Student's First Name");
		fnameLabel.setBounds(x1,40,dashboardPanel.getWidth()/2-x1-20,textFieldHeight);
		dashboardPanel.add(fnameLabel);
		JTextField fnameTF = new JTextField(fname);
		fnameTF.setEditable(false);
		fnameTF.setBounds(x1,fnameLabel.getBounds().y+textFieldHeight-10,(dashboardPanel.getWidth()/2-x1-20)/2,textFieldHeight);
		fnameTF.setFont(textFieldFont);
		fnameTF.setMargin(new Insets(10, 10, 10,50));
		dashboardPanel.add(fnameTF);
		
		JLabel lnameLabel = new JLabel("Student's Last Name");
		lnameLabel.setBounds((dashboardPanel.getWidth()/2-x1-20)/2+50,40,dashboardPanel.getWidth()/2-x1-20,textFieldHeight);
		dashboardPanel.add(lnameLabel);
		JTextField lnameTF = new JTextField(lname);
		lnameTF.setEditable(false);
		lnameTF.setBounds((dashboardPanel.getWidth()/2-x1-20)/2+50,lnameLabel.getBounds().y+textFieldHeight-10,(dashboardPanel.getWidth()/2-x1-20)/2,textFieldHeight);
		lnameTF.setFont(textFieldFont);
		lnameTF.setMargin(new Insets(10, 10, 10,50));
		dashboardPanel.add(lnameTF);
		
		JLabel idLabel = new JLabel("Student's ID");
		idLabel.setBounds(x2,40,dashboardPanel.getWidth()/2-x1-20,textFieldHeight);
		dashboardPanel.add(idLabel);
		JTextField idTF = new JTextField(id);
		idTF.setEditable(false);
		idTF.setBounds(x2,idLabel.getBounds().y+textFieldHeight-10,dashboardPanel.getWidth()/2-x1-20,textFieldHeight);
		idTF.setFont(textFieldFont);
		idTF.setMargin(new Insets(10, 10, 10,50));
		dashboardPanel.add(idTF);
		
		JLabel phLabel = new JLabel("Student's Phone No.");
		phLabel.setBounds(40,120,dashboardPanel.getWidth()/3-40,textFieldHeight);
		dashboardPanel.add(phLabel);
		JTextField phTF = new JTextField(ph);
		phTF.setEditable(false);
		phTF.setBounds(40,120+textFieldHeight-10,dashboardPanel.getWidth()/3-40,textFieldHeight);
		phTF.setFont(textFieldFont);
		phTF.setMargin(new Insets(10, 10, 10,50));
		dashboardPanel.add(phTF);
		
		JLabel classLabel = new JLabel("Student's Class");
		classLabel.setBounds(dashboardPanel.getWidth()/3+20,120,dashboardPanel.getWidth()/3-40,textFieldHeight);
		dashboardPanel.add(classLabel);				
		JTextField classTF = new JTextField(classs);
		classTF.setEditable(false);
		classTF.setBounds(dashboardPanel.getWidth()/3+20,120+textFieldHeight-10,dashboardPanel.getWidth()/3-40,textFieldHeight);
		classTF.setFont(textFieldFont);
		classTF.setMargin(new Insets(10, 10, 10,50));
		dashboardPanel.add(classTF);
		
		
		JLabel genderLabel = new JLabel("Student's Gender");
		genderLabel.setBounds(2*dashboardPanel.getWidth()/3,120,dashboardPanel.getWidth()/3-40,textFieldHeight);
		dashboardPanel.add(genderLabel);
		JTextField genderTF = new JTextField(gender);
		genderTF.setEditable(false);
		genderTF.setBounds(2*dashboardPanel.getWidth()/3,120+textFieldHeight-10,dashboardPanel.getWidth()/3-40,textFieldHeight);
		genderTF.setFont(textFieldFont);
		genderTF.setMargin(new Insets(10, 10, 10,50));
		dashboardPanel.add(genderTF);
		
		JLabel parentsDetailsLabel = new JLabel("Parents/Guardian's details");
		parentsDetailsLabel.setBounds(40,205,500,40);
		parentsDetailsLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		dashboardPanel.add(parentsDetailsLabel);
		
		JLabel fatherNameLabel = new JLabel("Father's Name");
		fatherNameLabel.setBounds(x1,240,dashboardPanel.getWidth()/2-x1-20,textFieldHeight);
		dashboardPanel.add(fatherNameLabel);
		JTextField fatherNameTF = new JTextField(fathername);
		fatherNameTF.setEditable(false);
		fatherNameTF.setBounds(x1,fatherNameLabel.getBounds().y+textFieldHeight-10,dashboardPanel.getWidth()/2-x1-20,textFieldHeight);
		fatherNameTF.setFont(textFieldFont);
		fatherNameTF.setMargin(new Insets(10, 10, 10,50));
		dashboardPanel.add(fatherNameTF);
		
		JLabel fatherPhLabel = new JLabel("Father's Phone No.");
		fatherPhLabel.setBounds(x2,240,dashboardPanel.getWidth()/2-x1-20,textFieldHeight);
		dashboardPanel.add(fatherPhLabel);
		JTextField fatherPhTF = new JTextField(fatherph);
		fatherPhTF.setEditable(false);
		fatherPhTF.setBounds(x2,fatherPhLabel.getBounds().y+textFieldHeight-10,dashboardPanel.getWidth()/2-x1-20,textFieldHeight);
		fatherPhTF.setFont(textFieldFont);
		fatherPhTF.setMargin(new Insets(10, 10, 10,50));
		dashboardPanel.add(fatherPhTF);
		
		JLabel motherNameLabel = new JLabel("Mother's Name");
		motherNameLabel.setBounds(x1,320,dashboardPanel.getWidth()/2-x1-20,textFieldHeight);
		dashboardPanel.add(motherNameLabel);
		JTextField motherNameTF = new JTextField(mothername);
		motherNameTF.setEditable(false);
		motherNameTF.setBounds(x1,motherNameLabel.getBounds().y+textFieldHeight-10,dashboardPanel.getWidth()/2-x1-20,textFieldHeight);
		motherNameTF.setFont(textFieldFont);
		motherNameTF.setMargin(new Insets(10, 10, 10,50));
		dashboardPanel.add(motherNameTF);
		
		JLabel motherPhLabel = new JLabel("Mother's Phone No.");
		motherPhLabel.setBounds(x2,320,dashboardPanel.getWidth()/2-x1-20,textFieldHeight);
		dashboardPanel.add(motherPhLabel);
		JTextField motherPhTF = new JTextField(motherph);
		motherPhTF.setEditable(false);
		motherPhTF.setBounds(x2,motherPhLabel.getBounds().y+textFieldHeight-10,dashboardPanel.getWidth()/2-x1-20,textFieldHeight);
		motherPhTF.setFont(textFieldFont);
		motherPhTF.setMargin(new Insets(10, 10, 10,50));
		dashboardPanel.add(motherPhTF);
		
		JLabel guardianNameLabel = new JLabel("Guardian's Name");
		guardianNameLabel.setBounds(x1,400,dashboardPanel.getWidth()/2-x1-20,textFieldHeight);
		dashboardPanel.add(guardianNameLabel);
		JTextField guardianNameTF = new JTextField(guardianname);
		guardianNameTF.setEditable(false);
		guardianNameTF.setBounds(x1,guardianNameLabel.getBounds().y+textFieldHeight-10,dashboardPanel.getWidth()/2-x1-20,textFieldHeight);
		guardianNameTF.setFont(textFieldFont);
		guardianNameTF.setMargin(new Insets(10, 10, 10,50));
		dashboardPanel.add(guardianNameTF);
		
		JLabel guardianPhLabel = new JLabel("Guardian's Phone No.");
		guardianPhLabel.setBounds(x2,400,dashboardPanel.getWidth()/2-x1-20,textFieldHeight);
		dashboardPanel.add(guardianPhLabel);
		JTextField guardianPhTF = new JTextField(guardianph);
		guardianPhTF.setEditable(false);
		guardianPhTF.setBounds(x2,guardianPhLabel.getBounds().y+textFieldHeight-10,dashboardPanel.getWidth()/2-x1-20,textFieldHeight);
		guardianPhTF.setFont(textFieldFont);
		guardianPhTF.setMargin(new Insets(10, 10, 10,50));
		dashboardPanel.add(guardianPhTF);
		
		

		dashboardPanel.setVisible(true);
		noticePanel.setVisible(false);
		publicNoticePanel.setVisible(false);
		
		
		layeredPane.add(dashboardPanel);
		layeredPane.add(noticePanel);
		layeredPane.add(publicNoticePanel);
		
				
		frame.add(leftPanel);
		frame.add(rightPanelHeader);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		MainPageStud page = new MainPageStud();
		page.MainPageStudRunner("Abdul","Sameer","1HK20CS001","9900101394","1 A","Male","Faizan Khan","6362630712","Pankaj Barad","9886473778","","","1HK20CS001@123","1hk20cs001@hkbk.edu.in");
	}

}