import javax.swing.*;

public class TestGui {

	public static void main(String[] args) {
		MyFirstCalc window = new MyFirstCalc();
		window.setTitle("Calculator");
		window.setVisible(true);
		window.setSize(400,700);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
