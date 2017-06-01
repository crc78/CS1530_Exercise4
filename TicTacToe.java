import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe {
  JFrame _frame = new JFrame("Tic-Tac-Toe");
  JPanel _ttt = new JPanel();
	JPanel _newPanel = new JPanel();
  JButton[] _buttons = new JButton[10];
  boolean asdf = false;

  public static void main(String[] args) {
    new TicTacToe();
  }

  public TicTacToe(){
    _frame.setSize(400, 400);
    _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    _ttt.setLayout(new GridLayout(3, 3));
    _newPanel.setLayout(new FlowLayout());

    _frame.add(_ttt, BorderLayout.NORTH);
    _frame.add(_newPanel, BorderLayout.SOUTH);

    for (int j=0; j<9; j++) {
      _buttons[j] = new JButton("_");
      ActionListener buttonListener = new ButtonListener();
      _buttons[j].addActionListener(buttonListener);
      _buttons[j].setFont(new Font("Courier", Font.PLAIN, 48));
      _ttt.add(_buttons[j]);
    }

    _buttons[9] = new JButton("New Game");
    ActionListener bListen = new BListen();
    _buttons[9].addActionListener(bListen);
    _buttons[9].setFont(new Font("Courier", Font.PLAIN, 48));
    _newPanel.add(_buttons[9]);
    _frame.setVisible(true);
  }

  class BListen implements ActionListener {
    public void actionPerformed(ActionEvent e){
      asdf = false;
      for (int i=0; i<9; i++){
        _buttons[i].setText("_");
      }
    }
  }

  class ButtonListener implements ActionListener {

	// Every time we click the button, it will perform
	// the following action.

    public void actionPerformed(ActionEvent e) {

	  JButton source = (JButton) e.getSource();
	  String currentText = source.getText();

    if(!currentText.equals("X") && !currentText.equals("O")){
      if(asdf){
        source.setText("O");
      }
      else{
        source.setText("X");
      }
      asdf = !asdf;
    }

	}

    }
}
