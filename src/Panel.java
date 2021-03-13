import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel{
	Game game;
	Timer tm;
	Panel(){
		setLayout(null);
		game = new Game();
//		tm = new Timer(100, new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				repaint();
//			}
//		});
//		tm.start();
		repaint();
		
		JButton nGameBtn = new JButton("Новая игра");
		nGameBtn.setBounds(500, 700, 200, 50);
		add(nGameBtn);
		nGameBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				game = new Game();
				repaint();
			}
		});
		JButton exitBtn = new JButton("Выход");
		exitBtn.setBounds(1250, 700, 200, 50);
		add(exitBtn);
		exitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
	}
	public void paint(Graphics g) {
		super.paint(g);
		game.computerField.paintField(g);
		game.playerField.paintField(g);
	}
}
