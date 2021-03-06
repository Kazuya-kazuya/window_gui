package window_gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args)  {
		Main program = new Main();
		program.start();
	}

	private void start() {
		MyFrame myFrame = new MyFrame();
		myFrame.open();
	}
}

class MyFrame extends JFrame implements ActionListener{
	public MyFrame() {
		super();
		//画面の生成
		this.setSize(400, 200);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//画面分割
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new GridLayout(1, 3));

		//ボタン生成
		JButton gButton = new JButton("グー");
		JButton cButton = new JButton("チョキ");
		JButton pButton = new JButton("パー");
		gButton.addActionListener(this);
		cButton.addActionListener(this);
		pButton.addActionListener(this);
		gButton.setActionCommand("0");
		cButton.setActionCommand("1");
		pButton.setActionCommand("2");
		contentPane.add(gButton);
		contentPane.add(cButton);
		contentPane.add(pButton);
	}

	public void actionPerformed(ActionEvent e) {
		//選択ボタン受け取り
		String cmd = e.getActionCommand();
		int myChoice = Integer.parseInt(cmd);

		//相手の手決定
		Random rand = new Random();
		int comChoice = rand.nextInt(3);

		String result = "";
		result += "あなたは" + toJankenChoice(myChoice) + "\n";
		result += "相手は" + toJankenChoice(comChoice) + "\n";
		//勝ち負け判定
		switch(myChoice - comChoice) {
		case -2:
			result += "あなたの負けです\n";
			break;
		case -1:
			result += "あなたの勝ちです\n";
			break;
		case 0:
			result += "あいこです\n";
			break;
		case 1:
			result += "あなたの負けです\n";
			break;
		case 2:
			result += "あなたの勝ちです\n";
			break;
		default:
			break;
		}
		//ポップアップ表示
		JOptionPane.showMessageDialog(null, result);
	}

	//整数をじゃんけんの手に変換
	public String toJankenChoice(int choice) {
		String str = "";
		switch(choice) {
		case 0:
			str = "グー";
			break;
		case 1:
			str = "チョキ";
			break;
		case 2:
			str = "パー";
			break;
		default:
			break;
		}
		return str;
	}

	//画面の表示
	public void open() {
		this.setVisible(true);
	}
}