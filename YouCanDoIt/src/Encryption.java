import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class Encryption extends JFrame {

	private static final String GLOBALFILENAME = "/Users/awesome/Dropbox/encrypted.txt";
	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Encryption frame = new Encryption();
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
	public Encryption() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final JTextArea txtrTextArea = new JTextArea();
		txtrTextArea.setText("Text Area");
		txtrTextArea.setBounds(6, 19, 229, 253);
		contentPane.add(txtrTextArea);

		JLabel lblFileContents = new JLabel("File Contents");
		lblFileContents.setBounds(6, 6, 229, 16);
		contentPane.add(lblFileContents);

		JButton btnDecrypt = new JButton("Decrypt");
		btnDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtrTextArea.setText("Changed Text using button");
				// get string from file
				// decrypt it using the password
				// display file in text view
				try {
					String s = getFile();
					System.out.println("file contents: " + s);
					txtrTextArea.setText(s);

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnDecrypt.setBounds(247, 40, 93, 29);
		contentPane.add(btnDecrypt);

		JButton btnEncrypt = new JButton("Encrypt");
		btnEncrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// take text area contents as a string
				// using the entered encrypted key encrypt it
				// store it into the file
				String s = txtrTextArea.getText();
				try {
					writeFile(s);
					String encr = encrypt(s, "key");
					System.out.println("Encrypted text: " + encr);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvalidKeyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalBlockSizeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BadPaddingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchPaddingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvalidKeySpecException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnEncrypt.setBounds(333, 40, 93, 29);
		contentPane.add(btnEncrypt);

		passwordField = new JPasswordField();
		passwordField.setBounds(256, 19, 170, 15);
		contentPane.add(passwordField);

		JLabel status = new JLabel("Updated on");
		status.setBounds(268, 81, 61, 16);
		contentPane.add(status);
	}

	public String getFile() throws IOException {

		FileReader fileReader = new FileReader(GLOBALFILENAME);

		// Always wrap FileReader in BufferedReader.
		String line = null;
		StringBuffer sb = new StringBuffer();
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		while ((line = bufferedReader.readLine()) != null) {
			sb.append(line);
			System.out.println(line);
		}
		return sb.toString();
	}

	public void writeFile(String s) throws IOException {
		FileWriter fileWriter = new FileWriter(GLOBALFILENAME);

		FileWriter fw = new FileWriter(GLOBALFILENAME);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(s);
		bw.close();
	}

	public String encrypt(String pt, String key)
			throws IllegalBlockSizeException, BadPaddingException,
			UnsupportedEncodingException, NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException,
			InvalidKeySpecException {
		SecretKeyFactory factory = SecretKeyFactory
				.getInstance("PBKDF2WithHmacSHA1");
		byte[] salt = { 0x74, 0x68, 0x69, 0x73, 0x49, 0x73, 0x41, 0x53, 0x65,
				0x63, 0x72, 0x65, 0x74, 0x4b, 0x65, 0x79 };// "thisIsASecretKey";
		KeySpec spec = new PBEKeySpec(key.toCharArray(), salt, 65536, 256);
		SecretKey tmp = factory.generateSecret(spec);
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		final SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		return new String(cipher.doFinal(pt.getBytes("UTF-8")));
	}
}
