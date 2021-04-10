import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel {
	Game game;
	Font font;
	String[] credits = { "Над игрой работали:", "\n",
			"Великий Всепоглощающий Всеобъемлющий Потрясающий Незабываемый Арсений", "\n", "EGORKA", "\n",
			"Anonimus228", "\n",  
			"Божиею милостию, Мы, Виликий Государь Царь и Великий Князь Дмитрий"
			," Андреевич Всея Руси Самодержец"
			, "\n",
			"Маленький Тостер Роман Олегович", "\n",
			"Непокоримый Прекрасный Всевидящий Неповторимый Король Java Prodackshen" };
	String paintedCredits = "";
	int letterPos = 0;
	int stringPos = 0;
	Timer tm;
	int blackSquareWidth = 4000;

	Panel() {
		tm = new Timer(1000 / 5, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		setLayout(null);
		game = new Game();
		tm = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				paintedCredits = paintedCredits + credits[stringPos].charAt(letterPos);
				letterPos = letterPos + 1;
				if (letterPos >= credits[stringPos].length()) {
					stringPos += 1;
					letterPos = 0;
					paintedCredits = "";
					if (stringPos >= credits.length) {
						tm.stop();
						blackSquareWidth = 0;
						repaint();
					}
				}
				repaint();
			}
		});
		repaint();
		font = new Font("Bold Script", 2, 40);
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
		if (game.computerWin()) {
			int x = game.computerLeftIndent - game.centerIndent;
			int y = game.topIndent + game.fieldSize * game.cellSize + 50;
			g.setFont(font);
			g.drawString("Поздравляем!Вы проиграли", x, y);
		} else if (game.playerWin()) {
			int x = game.computerLeftIndent - game.centerIndent;
			int y = game.topIndent + game.fieldSize * game.cellSize + 50;
			g.setFont(font);

			g.setColor(Color.black);
			g.fillRect(0, 0, blackSquareWidth, 2000);

			g.setColor(Color.white);
			g.drawString("К сожалению вы победили", x, y);
			if (stringPos == 0)
				tm.start();
			if (stringPos < credits.length) {
				if (stringPos > 0) {
					for (int i = 0; i < stringPos; i++) {
						g.drawString(credits[i], 0, 50 + 40 * i);
					}
				}
				g.drawString(paintedCredits, 0, 50 + 40 * stringPos);
			}
		}
		
	  }
    }