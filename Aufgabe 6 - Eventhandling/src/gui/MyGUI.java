package gui;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

public class MyGUI extends Frame implements ActionListener {

	private Button btn1;
	private Button btn2;
	private Button btn3;
	private Button btn4;
	private TextArea txtArea;
	private List<String> bList;
	
	
	private static final long serialVersionUID = 1L;
	
	public MyGUI ()
	{
		
		this.setBounds(200, 200, 800, 600);
		this.setLayout(new FlowLayout());

		txtArea = new TextArea("Prozessoren: "+ Runtime.getRuntime().availableProcessors()) ;
		txtArea.setName("TXTAREA");
		this.add(txtArea);

		btn1 = new Button("to Lower");
		btn1.setName("BTN_TOLOWER");
		btn1.addActionListener(this);
		this.add(btn1);
		
		btn2 = new Button("to Upper");
		btn2.setName("BTN_TOUPPER");
		btn2.addActionListener(this);
		this.add(btn2);
		
		btn3 = new Button("swap");
		btn3.setName("BTN_SWAP");
		btn3.addActionListener(this);
		this.add(btn3);
		
		this.setVisible(true);
		
		
		this.addWindowListener(new WindowListener() 
		{
	
			@Override
			public void windowClosing(WindowEvent e) {
				e.getWindow().dispose();
			}

			@Override
			public void windowActivated(WindowEvent e) {}

			@Override
			public void windowClosed(WindowEvent e) {
				System.exit(0);
			}

			@Override
			public void windowDeactivated(WindowEvent e) {}

			@Override
			public void windowDeiconified(WindowEvent e) {}

			@Override
			public void windowIconified(WindowEvent e) {}

			@Override
			public void windowOpened(WindowEvent e) {}
	
		});
	}
	
	public MyGUI(List<String> blacklist)
	{
		this.bList=blacklist;
		this.setBounds(200, 200, 800, 600);
		this.setLayout(new FlowLayout());

		txtArea = new TextArea("Prozessoren: "+ Runtime.getRuntime().availableProcessors()) ;
		txtArea.setName("TXTAREA");
		this.add(txtArea);

		btn1 = new Button("to Lower");
		btn1.setName("BTN_TOLOWER");
		btn1.addActionListener(this);
		this.add(btn1);
		
		btn2 = new Button("to Upper");
		btn2.setName("BTN_TOUPPER");
		btn2.addActionListener(this);
		this.add(btn2);
		
		btn3 = new Button("swap");
		btn3.setName("BTN_SWAP");
		btn3.addActionListener(this);
		this.add(btn3);
		
		btn4 = new Button("Censor");
		btn4.setName("BTN_CENSOR");
		btn4.addActionListener(this);
		this.add(btn4);
		
		this.setVisible(true);
		
		
		this.addWindowListener(new WindowListener() 
		{
	
			@Override
			public void windowClosing(WindowEvent e) {
				e.getWindow().dispose();
			}

			@Override
			public void windowActivated(WindowEvent e) {}

			@Override
			public void windowClosed(WindowEvent e) {
				System.exit(0);
			}

			@Override
			public void windowDeactivated(WindowEvent e) {}

			@Override
			public void windowDeiconified(WindowEvent e) {}

			@Override
			public void windowIconified(WindowEvent e) {}

			@Override
			public void windowOpened(WindowEvent e) {}
	
		});		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource() == this.btn1)
		{
			this.txtArea.setText(this.txtArea.getText().toLowerCase());
		}
		if(e.getSource() == this.btn2)
		{
			this.txtArea.setText(this.txtArea.getText().toUpperCase());
		}
		if(e.getSource() == this.btn3)
		{
			Character[] c = new Character[txtArea.getText().length()];
			for(int i=0; i<txtArea.getText().length(); i++)
			{
				c[i] = txtArea.getText().charAt(i);
				
				if(Character.isLowerCase(c[i]))
				{
					c[i] = Character.toUpperCase(c[i]);
				}
				else
				{
					c[i] = Character.toLowerCase(c[i]);
				}
			}
			String text = "" ;
			for(int i=0; i<c.length; i++)
			{
				text+=c[i];
			}
			txtArea.setText(text);
		}
		if(e.getSource() == this.btn4)
		{
			
			for(int i=0;i<bList.size();i++)
			{
				String code = "" ;
				for(int j=0;j<bList.get(i).length();j++)
				{
					code+= "x";
				}
				txtArea.setText(txtArea.getText().replaceAll("(?i)"+bList.get(i), code ));
			}
		}
		
	}

}
