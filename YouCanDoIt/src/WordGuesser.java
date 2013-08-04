import java.awt.EventQueue;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.apache.commons.lang3.StringUtils;

//THis program was created for cracking the app Riddle me that on Android appstore and it is very helpful, esp for larger word length.
//Unfortunately, the dictionary has a lot of words that may confuse the users
//Also, I got tired to playing the game

public class WordGuesser extends JFrame {

	private static final String GLOBALFILENAME = "/Users/awesome/Documents/dictionary.txt";
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WordGuesser frame = new WordGuesser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WordGuesser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(6, 40, 134, 28);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblLength = new JLabel("Length");
		lblLength.setBounds(174, 6, 61, 16);
		contentPane.add(lblLength);

		JLabel lblLetters = new JLabel("Letters");
		lblLetters.setBounds(6, 6, 61, 16);
		contentPane.add(lblLetters);

		textField_1 = new JTextField();
		textField_1.setBounds(166, 40, 91, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JButton btnGuessTheWord = new JButton("Guess The Word");
		final TextArea textArea = new TextArea();
		textArea.setBounds(6, 85, 423, 170);
		contentPane.add(textArea);

		btnGuessTheWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ArrayList<String> matches = doEverythingReturnsStrings(
							textField.getText(), textField_1.getText());
					String allWords = "";
					for (String str : matches) {
						allWords = allWords + str + "\n";
					}
					textArea.setText(allWords);
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnGuessTheWord.setBounds(269, 41, 117, 29);
		contentPane.add(btnGuessTheWord);

	}

	protected ArrayList<String> doEverythingReturnsStrings(String text,
			String text2) throws NumberFormatException, IOException {
		ArrayList<String> refinedMatches;
		ArrayList<String> possibleMatches = getFile(Integer.parseInt(text2));
		refinedMatches = hasAll(possibleMatches, text.toLowerCase());
		return refinedMatches;
	}

	private ArrayList<String> hasAll(ArrayList<String> possibleMatches,
			String text) {
		ArrayList<String> refinedMatches = new ArrayList<String>();
		for (String x : possibleMatches) {
			// if all chars in the text are present in the string before the
			// string is empty then it is it
			StringBuffer sb = new StringBuffer();
			sb.append(x);
			for (char ch : text.toCharArray()) {
				int pos = sb.indexOf("" + ch);
				if (pos != -1)
					sb.deleteCharAt(pos);

				if (StringUtils.isEmpty(sb)) {
					// found our match print it and add it
					refinedMatches.add(x);
					System.out.println(x);
					break;
				}

			}
			sb = new StringBuffer();
		}
		return refinedMatches;
	}

	ArrayList<String> getFile(int length) throws IOException {

		FileReader fileReader = new FileReader(GLOBALFILENAME);
		ArrayList<String> dictionary = new ArrayList<String>();
		// Always wrap FileReader in BufferedReader.
		String line = null;
		StringBuffer sb = new StringBuffer();
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		while ((line = bufferedReader.readLine()) != null) {
			sb.append(line);
			if (line.length() == length)
				dictionary.add(line.toLowerCase());
		}
		return dictionary;
	}
}
