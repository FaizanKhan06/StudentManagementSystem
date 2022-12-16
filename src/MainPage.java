import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;

public class MainPage {
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
                
                if(name.equals("Dashboard")) {
                	g1.drawRoundRect(175, 10, 26, 15, 5, 5);
                	g1.drawLine(188, 25, 188, 30);
                	g1.drawLine(183, 30, 194, 30);
                }
                else if(name.equals("Class")) {
                	
                	g1.drawLine(188, 7, 175, 13);
                	g1.drawLine(188, 7, 202, 13);
                	g1.drawLine(188, 19, 175, 13);
                	g1.drawLine(188, 19, 202, 13);
                	
                	g1.drawLine(179, 16, 175, 18);
                	g1.drawLine(197, 16, 202, 18);                	
                	g1.drawLine(188, 24, 175, 18);
                	g1.drawLine(188, 24, 202, 18);
                	
                	g1.drawLine(179, 21, 175, 23);
                	g1.drawLine(197, 21, 202, 23);                	
                	g1.drawLine(188, 29, 175, 23);
                	g1.drawLine(188, 29, 202, 23);
                }
                else if(name.equals("Students")) {
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
                
                if(name.equals("Dashboard")) {
                	g1.drawRoundRect(175, 10, 26, 15, 5, 5);
                	g1.drawLine(188, 25, 188, 30);
                	g1.drawLine(183, 30, 194, 30);
                }
                else if(name.equals("Class")) {
                	
                	g1.drawLine(188, 7, 175, 13);
                	g1.drawLine(188, 7, 202, 13);
                	g1.drawLine(188, 19, 175, 13);
                	g1.drawLine(188, 19, 202, 13);
                	
                	g1.drawLine(179, 16, 175, 18);
                	g1.drawLine(197, 16, 202, 18);                	
                	g1.drawLine(188, 24, 175, 18);
                	g1.drawLine(188, 24, 202, 18);
                	
                	g1.drawLine(179, 21, 175, 23);
                	g1.drawLine(197, 21, 202, 23);                	
                	g1.drawLine(188, 29, 175, 23);
                	g1.drawLine(188, 29, 202, 23);
                }
                else if(name.equals("Students")) {
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

	public static void BTNselected(JButton b1,JButton b2,JButton b3,JButton b4,JButton b5,JButton selectedBTN) {
		b1.setVisible(true);b2.setVisible(true);b3.setVisible(true);b4.setVisible(true);
		b5.setVisible(true);
		selectedBTN.setVisible(false);
	}
	
	public static void PanelSelected(JPanel dashboardPanel,JPanel classPanel,JPanel studentsPanel,JPanel noticePanel,JPanel publicNoticePanel,JPanel selectedPanel) {
		dashboardPanel.setVisible(false);classPanel.setVisible(false);studentsPanel.setVisible(false);noticePanel.setVisible(false);
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
	
	public void MainPageRunner(String firstName,String lastName,String username) {
		 
		
		//Edited by KHAN FAIZAN
		//LoadAllStudentDetails();
		
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int)size.getWidth();
        int screenHeight = (int)size.getHeight();
		
		JFrame frame = new JFrame("Student Management & Enrollment System");
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
		
		JLabel nameLabel = new JLabel(firstName+" "+lastName);
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		nameLabel.setBounds(80,80,160,40);
		frame.add(nameLabel);
		
		JLabel usernameLabel = new JLabel(username);
		usernameLabel.setForeground(usernameColor);
		usernameLabel.setFont(new Font("Verdana", Font.BOLD, 10));
		usernameLabel.setBounds(80,105,160,40);
		frame.add(usernameLabel);
		
		JLabel dashboardLabel = new JLabel("DASHBOARD");
		dashboardLabel.setForeground(defaultMainColor);
		dashboardLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		dashboardLabel.setBounds(23,160,240,40);
		frame.add(dashboardLabel);
		
		JButton dashboardBTN = createBTN("Dashboard", 0,214,240,40,true,true);
		JButton classBTN = createBTN("Class", 0, 254, 240, 40,false,true);
		JButton studentsBTN = createBTN("Students", 0, 294, 240, 40,false,true);
		JButton noticeBTN = createBTN("Notice", 0, 334, 240, 40,false,true);
		JButton publicNoticeBTN = createBTN("Public Notice", 0, 374, 240, 40,false,true);
		
		JPanel dashboardPanel = createContentPanel("Dashboard",230,screenWidth);
		JPanel classPanel = createContentPanel("Class",480,screenWidth);
		JPanel studentsPanel = createContentPanel("Student",630,screenWidth);
		JPanel noticePanel = createContentPanel("Notice",620,screenWidth);
		JPanel publicNoticePanel = createContentPanel("Public Notice",620,screenWidth);
		
		dashboardBTN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BTNselected(dashboardBTN,classBTN,studentsBTN,noticeBTN,publicNoticeBTN,dashboardBTN);
				PanelSelected(dashboardPanel,classPanel,studentsPanel,noticePanel,publicNoticePanel,dashboardPanel);
			}
		});
		classBTN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BTNselected(dashboardBTN,classBTN,studentsBTN,noticeBTN,publicNoticeBTN,classBTN);
				PanelSelected(dashboardPanel,classPanel,studentsPanel,noticePanel,publicNoticePanel,classPanel);
			}
		});
		studentsBTN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BTNselected(dashboardBTN,classBTN,studentsBTN,noticeBTN,publicNoticeBTN,studentsBTN);
				PanelSelected(dashboardPanel,classPanel,studentsPanel,noticePanel,publicNoticePanel,studentsPanel);
			}
		});
		noticeBTN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BTNselected(dashboardBTN,classBTN,studentsBTN,noticeBTN,publicNoticeBTN,noticeBTN);
				PanelSelected(dashboardPanel,classPanel,studentsPanel,noticePanel,publicNoticePanel,noticePanel);
			}
		});
		publicNoticeBTN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BTNselected(dashboardBTN,classBTN,studentsBTN,noticeBTN,publicNoticeBTN,publicNoticeBTN);
				PanelSelected(dashboardPanel,classPanel,studentsPanel,noticePanel,publicNoticePanel,publicNoticePanel);
			}
		});
		dashboardBTN.setVisible(false);
		
		frame.add(dashboardBTN);
		frame.add(classBTN);
		frame.add(studentsBTN);
		frame.add(noticeBTN);
		frame.add(publicNoticeBTN);
		
		
		JLabel dashboardLBL = createLabel("Dashboard", 0,214,240,40,true,true);
		JLabel classLBL = createLabel("Class", 0, 254, 240, 40,false,true);
		JLabel studentsLBL = createLabel("Students", 0, 294, 240, 40,false,true);
		JLabel noticeLBL = createLabel("Notice", 0, 334, 240, 40,false,true);
		JLabel publicNoticeLBL = createLabel("Public Notice", 0, 374, 240, 40,false,true);
		        
        frame.add(dashboardLBL);
        frame.add(classLBL);
        frame.add(studentsLBL);
        frame.add(noticeLBL);
        frame.add(publicNoticeLBL);
        
        
        JLabel welcomeLabel = new JLabel("Welcome "+firstName+"!");
        welcomeLabel.setForeground(Color.BLACK);
        welcomeLabel.setFont(new Font("Verdana", Font.BOLD, 15));
        welcomeLabel.setBounds(270,15,240,40);
		frame.add(welcomeLabel);
		
		
		String userText = firstName+" "+lastName;
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
        	
        JLabel signOutNameLabel = new JLabel(firstName+" "+lastName);
        signOutNameLabel.setBounds(1,250,265,53);
        signOutNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        signOutNameLabel.setFont(new Font("Verdana", Font.BOLD, 13));
        logOutPanel.add(signOutNameLabel);
        
        JLabel signOutUserNameLabel = new JLabel(username);
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
		
        
        panelDesign.ClassPanel(classPanel,frame,screenWidth);
        
        panelDesign.NoticePanel(noticePanel,frame,screenWidth,true,null);
        
        panelDesign.PublicNoticePanel(publicNoticePanel,frame,screenWidth,true);
        
		panelDesign.StudentPanel(studentsPanel,frame,screenWidth);
		
		panelDesign.DashboardPanel(dashboardPanel,screenWidth,dashboardBTN,classBTN,studentsBTN,noticeBTN,publicNoticeBTN,dashboardPanel,classPanel,studentsPanel,noticePanel,publicNoticePanel);
		
		

		dashboardPanel.setVisible(true);
		classPanel.setVisible(false);
		studentsPanel.setVisible(false);
		noticePanel.setVisible(false);
		publicNoticePanel.setVisible(false);
		
		
		layeredPane.add(dashboardPanel);
		layeredPane.add(classPanel);
		layeredPane.add(studentsPanel);
		layeredPane.add(noticePanel);
		layeredPane.add(publicNoticePanel);
		
				
		frame.add(leftPanel);
		frame.add(rightPanelHeader);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		MainPage page = new MainPage();
		page.MainPageRunner("Abdul","Sameer","1hk20cs001@hkbk.edu.in");
	}

}