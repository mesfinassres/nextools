package exhalia_project;

/*
 * --------------------------------------------------------------------------------------------------------------
 * -	Brunel University London																				-
 * -	NEWTON Project		       																				-
 * -	Olfaction experimentation using Exhalia 																-
 * -	Towards developing APIs for Mulsemedia integration								       					-
 * -	2017																									-
 * -																											-
 * -	Updates:																								-
 * -	"Exhalia.jar" - included into the build path of the project												-
 * -	"Exhalia.dll" - copied to eclipse folder and loaded into this project.									-
 * -	Once the program is executed, all fans run turn by turn by setting a delay in between. 					-
 * -	In addition, buttons with images of different scents are added to diffuse the appropriate scent 		-
 * -	on mouse hover.																							-
 * --------------------------------------------------------------------------------------------------------------
 */

import exhalia.CScentDiffusionContext;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class TestExhalia_Java_v4 {

	private JFrame frmScentDiffuser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestExhalia_Java_v4 window = new TestExhalia_Java_v4();
					window.frmScentDiffuser.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TestExhalia_Java_v4() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmScentDiffuser = new JFrame();
		frmScentDiffuser.setResizable(false);
		frmScentDiffuser.setAlwaysOnTop(true);
		frmScentDiffuser.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Software development\\java\\exhalia_project\\src\\exhalia_project\\img\\icon.jpg"));
		frmScentDiffuser.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmScentDiffuser.setTitle("Scent diffuser");
		
		frmScentDiffuser.setLocation(500, 200);
		frmScentDiffuser.setSize(400, 300);
		frmScentDiffuser.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmScentDiffuser.getContentPane().add(tabbedPane);
		
		JDesktopPane diffusePane = new JDesktopPane();
		tabbedPane.addTab("Diffuse", null, diffusePane, null);
		tabbedPane.setEnabledAt(0, true);
		
		JButton btnDiffuse = new JButton("Diffuse all");
		btnDiffuse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				///diffuse here
				try {
					this.diffuseScent();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			private void diffuseScent() throws InterruptedException {
				
				// Create the diffusion context		
				CScentDiffusionContext diffusionContext=new CScentDiffusionContext("","","","","","","");
				// Get the version
				System.out.println("Exhalia version: " + diffusionContext.GetExhaliaVersion());
				
				diffusionContext.LoadCartridge(false, "d:/Software development/java/exhalia_project/ref/Brunel University - SBi4.cfg");

				//Diffuse the 1st scent
				System.out.println("Diffuse scent 1");		
				diffusionContext.DiffuseCommand(",SCENT_1,,,10,10,");
				
				//Delay until previous fan finishes
				Thread.sleep(10000);

				System.out.println("Diffuse scent 2");	
				diffusionContext.DiffuseCommand(",SCENT_2,,,10,10,");
				
				Thread.sleep(10000);
				
				System.out.println("Diffuse scent 3");		
				diffusionContext.DiffuseCommand(",SCENT_3,,,10,10,");
				
				Thread.sleep(10000);
				
				System.out.println("Diffuse scent 4");		
				diffusionContext.DiffuseCommand(",SCENT_4,,,10,10,");
				
				System.out.println("Finish diffusion.");
			}

		});
		btnDiffuse.setBounds(136, 103, 106, 32);
		diffusePane.add(btnDiffuse);
		
		JDesktopPane scentsPane = new JDesktopPane();
		tabbedPane.addTab("Scents", null, scentsPane, null);
		
		JButton btnScent1 = new JButton("");
        btnScent1.addMouseListener(new MouseListener()
        {
            public void mouseEntered(MouseEvent evt)
            {
				//Diffuse mint
				CScentDiffusionContext diffusionContext=new CScentDiffusionContext("","","","","","","");
				System.out.println("Diffuse mint fresher");		
				diffusionContext.DiffuseCommand(",SCENT_1,,,10,10,");
            }
			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}
        });
		btnScent1.setIcon(new ImageIcon("D:\\Software development\\java\\exhalia_project\\src\\exhalia_project\\img\\mint.jpg"));
		btnScent1.setBounds(10, 11, 185, 108);
		scentsPane.add(btnScent1);
		
		JButton btnScent2 = new JButton("");
        btnScent2.addMouseListener(new MouseListener()
        {
            public void mouseEntered(MouseEvent evt)
            {
				//Diffuse mint
				CScentDiffusionContext diffusionContext=new CScentDiffusionContext("","","","","","","");
				System.out.println("Diffuse rosemary");		
				diffusionContext.DiffuseCommand(",SCENT_2,,,10,10,");
            }
			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}
        });
		btnScent2.setIcon(new ImageIcon("D:\\Software development\\java\\exhalia_project\\src\\exhalia_project\\img\\rosemary.jpg"));
		btnScent2.setBounds(205, 11, 174, 108);
		scentsPane.add(btnScent2);
		
		JButton btnScent3 = new JButton("");
        btnScent3.addMouseListener(new MouseListener()
        {
            public void mouseEntered(MouseEvent evt)
            {
				//Diffuse mint
				CScentDiffusionContext diffusionContext=new CScentDiffusionContext("","","","","","","");
				System.out.println("Diffuse jasmin");		
				diffusionContext.DiffuseCommand(",SCENT_3,,,10,10,");
            }
			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}
        });		
		btnScent3.setIcon(new ImageIcon("D:\\Software development\\java\\exhalia_project\\src\\exhalia_project\\img\\jasmin.jpg"));
		btnScent3.setBounds(10, 130, 185, 102);
		scentsPane.add(btnScent3);
		
		JButton btnScent4 = new JButton("");
        btnScent4.addMouseListener(new MouseListener()
        {
            public void mouseEntered(MouseEvent evt)
            {
				//Diffuse mint
				CScentDiffusionContext diffusionContext=new CScentDiffusionContext("","","","","","","");
				System.out.println("Diffuse ammonia");		
				diffusionContext.DiffuseCommand(",SCENT_4,,,10,10,");
            }
			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}
        });	
		btnScent4.setIcon(new ImageIcon("D:\\Software development\\java\\exhalia_project\\src\\exhalia_project\\img\\ammonia.jpg"));
		btnScent4.setBounds(205, 130, 174, 102);
		scentsPane.add(btnScent4);
	}
}
