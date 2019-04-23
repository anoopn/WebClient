package com.ats.application.network.webclient.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileFilter;

import com.ats.application.network.webclient.xsd.WebClientXSDDTO;

public class WebClientUI extends javax.swing.JFrame {

	private WebClientXSDDTO xsdDTO;
	DefaultComboBoxModel<String> comboBoxModel;

	public WebClientUI(WebClientXSDDTO xsdDTO) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		super();
		this.xsdDTO = xsdDTO;
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		initComponents();
		loadURL();
		jProg_RequestStatus.setVisible(false);
		loadDefaults();
	}

	private void loadDefaults() {
		txt_Certifcate.setText("");
		txt_InputFile.setText("");
		jtxt_CertifcatePassword.setText("");
		txt_Certifcate.setText(xsdDTO.getFileConfig().getCertificatePath());
		txt_InputFile.setText(xsdDTO.getFileConfig().getInputFilePath());
		jtxt_CertifcatePassword.setText(xsdDTO.getFileConfig().getCertificatePassword());
	}

	private void loadURL() {
		comboBoxModel = new DefaultComboBoxModel<String>();
		if (xsdDTO.getAppURLs() != null) {
			List<String> lstURL = xsdDTO.getAppURLs().getURL();
			if (lstURL != null) {
				for (String url : lstURL) {
					comboBoxModel.addElement(url);
				}
				cmb_URL.setModel(comboBoxModel);
			}
		}
	}

	private void initComponents() {

		jBGrp_ContentTypeGroup = new javax.swing.ButtonGroup();
		jBGrp_SigningArea = new javax.swing.ButtonGroup();
		jBGrp_EncryptContent = new javax.swing.ButtonGroup();
		lbl_Url = new javax.swing.JLabel();
		cmb_URL = new javax.swing.JComboBox<>();
		jPl_Security = new javax.swing.JPanel();
		jLb_Certificate = new javax.swing.JLabel();
		txt_Certifcate = new javax.swing.JTextField();
		but_CertificatePath = new javax.swing.JButton();
		jLb_CertPasswd = new javax.swing.JLabel();
		jtxt_CertifcatePassword = new javax.swing.JPasswordField();
		jPl_Signing = new javax.swing.JPanel();
		jRad_WholeMessage = new javax.swing.JRadioButton();
		jRad_BodyContent = new javax.swing.JRadioButton();
		jRd_EncryptAttach = new javax.swing.JRadioButton();
		jRad_EncryptDetached = new javax.swing.JRadioButton();
		jPl_ContentType = new javax.swing.JPanel();
		jRad_PlainContent = new javax.swing.JRadioButton();
		jRad_ZipContent = new javax.swing.JRadioButton();
		jPl_RequestResponseArea = new javax.swing.JPanel();
		jLb_InputFile = new javax.swing.JLabel();
		txt_InputFile = new javax.swing.JTextField();
		but_InputFile = new javax.swing.JButton();
		but_SendRequest = new javax.swing.JButton();
		jProg_RequestStatus = new javax.swing.JProgressBar();
		jScrollPane1 = new javax.swing.JScrollPane();
		txt_InputContent = new javax.swing.JTextArea();
		jScrollPane2 = new javax.swing.JScrollPane();
		txt_OutputContent = new javax.swing.JTextArea();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Client Tool");
		setName("jf_ClientUI"); // NOI18N
		setPreferredSize(new java.awt.Dimension(1000, 650));
		setResizable(false);
		getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		lbl_Url.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		lbl_Url.setText("URL");
		getContentPane().add(lbl_Url, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 30, 20));

		cmb_URL.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		cmb_URL.setToolTipText("Please select a URL");
		getContentPane().add(cmb_URL, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 930, -1));

		jPl_Security.setBorder(
				javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""),
						"Security", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
		jPl_Security.setToolTipText("To select the certifcate for signing");
		jPl_Security.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		jPl_Security.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jLb_Certificate.setText("Certificate: ");
		jPl_Security.add(jLb_Certificate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));
		jPl_Security.add(txt_Certifcate, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 260, -1));

		but_CertificatePath.setText(" ... ");
		but_CertificatePath.setToolTipText("Please select the certifcate(*.pfx)");
		but_CertificatePath.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				but_CertificatePathActionPerformed(evt);
			}
		});
		jPl_Security.add(but_CertificatePath, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, -1, -1));

		jLb_CertPasswd.setText("Password: ");
		jPl_Security.add(jLb_CertPasswd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

		jtxt_CertifcatePassword.setText("jPasswordField1");
		jtxt_CertifcatePassword.setToolTipText("Please provide certifcate password");
		jPl_Security.add(jtxt_CertifcatePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 260, -1));

		getContentPane().add(jPl_Security, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 440, 100));

		jPl_Signing.setBorder(
				javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""),
						"Signing", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
		jPl_Signing.setToolTipText("Select the option to sign the data");
		jPl_Signing.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jBGrp_SigningArea.add(jRad_WholeMessage);
		jRad_WholeMessage.setSelected(true);
		jRad_WholeMessage.setText("Whole Message");
		jRad_WholeMessage.setToolTipText("Will sign the whole message");
		jPl_Signing.add(jRad_WholeMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

		jBGrp_SigningArea.add(jRad_BodyContent);
		jRad_BodyContent.setText("Body Content");
		jRad_BodyContent.setToolTipText("Will sign the content inside Body tag");
		jPl_Signing.add(jRad_BodyContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, -1));

		jBGrp_EncryptContent.add(jRd_EncryptAttach);
		jRd_EncryptAttach.setSelected(true);
		jRd_EncryptAttach.setText("Full Encrypt");
		jRd_EncryptAttach.setToolTipText("Will encrypt the whole content");
		jPl_Signing.add(jRd_EncryptAttach, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 100, -1));

		jBGrp_EncryptContent.add(jRad_EncryptDetached);
		jRad_EncryptDetached.setText("Attach");
		jRad_EncryptDetached.setToolTipText("Will attach the signed content");
		jPl_Signing.add(jRad_EncryptDetached, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, -1, -1));

		getContentPane().add(jPl_Signing, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 270, 100));

		jPl_ContentType.setBorder(
				javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""),
						"Content Type", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
		jPl_ContentType.setToolTipText("Select option to send the content");
		jPl_ContentType.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jBGrp_ContentTypeGroup.add(jRad_PlainContent);
		jRad_PlainContent.setSelected(true);
		jRad_PlainContent.setText("Plain Text/XML");
		jRad_PlainContent.setToolTipText("Will send request as plain text or XML");
		jPl_ContentType.add(jRad_PlainContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

		jBGrp_ContentTypeGroup.add(jRad_ZipContent);
		jRad_ZipContent.setText("Zip Content");
		jRad_ZipContent.setToolTipText("Will send the content as Zip or GZip");
		jPl_ContentType.add(jRad_ZipContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

		getContentPane().add(jPl_ContentType, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 50, 180, 100));

		jPl_RequestResponseArea.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Process Request",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Tahoma", 1, 12))); // NOI18N
		jPl_RequestResponseArea.setToolTipText("WIll show the request and response");
		jPl_RequestResponseArea.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jLb_InputFile.setText("Input File");
		jPl_RequestResponseArea.add(jLb_InputFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

		txt_InputFile.setToolTipText("Input file");
		jPl_RequestResponseArea.add(txt_InputFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 320, -1));

		but_InputFile.setText(" ... ");
		but_InputFile.setToolTipText("Please choose the input file for sending");
		but_InputFile.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				but_InputFileActionPerformed(evt);
			}
		});
		jPl_RequestResponseArea.add(but_InputFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, -1, -1));

		but_SendRequest.setText("Send");
		but_SendRequest.setToolTipText("Please click to send the request to URL");
		but_SendRequest.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				but_SendRequestActionPerformed(evt);
			}
		});
		jPl_RequestResponseArea.add(but_SendRequest,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, -1, -1));

		jProg_RequestStatus.setAutoscrolls(true);
		jProg_RequestStatus.setOpaque(true);
		jPl_RequestResponseArea.add(jProg_RequestStatus,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, 170, -1));

		txt_InputContent.setColumns(20);
		txt_InputContent.setRows(5);
		jScrollPane1.setViewportView(txt_InputContent);

		jPl_RequestResponseArea.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 60, 480, 420));

		txt_OutputContent.setColumns(20);
		txt_OutputContent.setRows(5);
		jScrollPane2.setViewportView(txt_OutputContent);

		jPl_RequestResponseArea.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 460, 420));

		getContentPane().add(jPl_RequestResponseArea,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 980, 490));

		setSize(new java.awt.Dimension(1016, 689));
		setLocationRelativeTo(null);
	}

	private void but_CertificatePathActionPerformed(java.awt.event.ActionEvent evt) {
		// To browse the certificate file
		String strExistingPath = txt_Certifcate.getText();
		List<FileFilter> lstFileFilters = null;
		strExistingPath = loadSelectedFilePath(strExistingPath, lstFileFilters);
		txt_Certifcate.setText(strExistingPath);
		jtxt_CertifcatePassword.setText("");
	}

	private void but_InputFileActionPerformed(java.awt.event.ActionEvent evt) {
		// To browse the input file
		String strInputFile = xsdDTO.getFileConfig().getInputFilePath();
		String data = "";
		List<FileFilter> lstFileFilters = null;
		strInputFile = loadSelectedFilePath(strInputFile, lstFileFilters);
		txt_InputFile.setText(strInputFile);
		FileInputStream fin = null;
		try {
			File file = new File(strInputFile);
			if (file.isDirectory()) {
				return;
			}
			if(file.isFile() && file.canRead()) {
				fin = new FileInputStream(file);
				byte[] byContent = new byte[fin.available()];
				fin.read(byContent, 0, fin.available());
				data = new String(byContent, StandardCharsets.UTF_8);				
			}
		} catch (Exception e) {
			data = "Failed to read file content. Please check the file. Error " + e.getMessage();
		} finally {
			if (fin != null) {
				try {
					fin.close();
				} catch (IOException e) {

				}
			}
		}
		txt_InputContent.setText(data);
	}

	private void but_SendRequestActionPerformed(java.awt.event.ActionEvent evt) {
		// To send the request content to the URL

	}

	/**
	 * This method will load the certifcate file path to the textbox
	 *
	 * @param strExistingPath
	 * @return
	 */
	private String loadSelectedFilePath(String strExistingPath, List<FileFilter> lstFileFilters) {
		File fPath = null;
		if (strExistingPath != null) {
			if (strExistingPath.trim().equals("")) {
				fPath = new File(".");
			} else {
				fPath = new File(strExistingPath.trim());
			}
		} else {
			fPath = new File(".");
		}
		JFileChooser jfCertifcateChooser = null;
		jfCertifcateChooser = new JFileChooser(fPath);
		if (lstFileFilters != null) {
			if (lstFileFilters.size() > 0) {
				for (FileFilter fileFilter : lstFileFilters) {
					jfCertifcateChooser.addChoosableFileFilter(fileFilter);
				}
			}
		}
		int returnValue = jfCertifcateChooser.showOpenDialog(this);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfCertifcateChooser.getSelectedFile();
			strExistingPath = selectedFile.getAbsolutePath();
		} else {
			return strExistingPath;
		}
		return strExistingPath;
	}

	private javax.swing.JButton but_CertificatePath;
	private javax.swing.JButton but_InputFile;
	private javax.swing.JButton but_SendRequest;
	private javax.swing.JComboBox<String> cmb_URL;
	private javax.swing.ButtonGroup jBGrp_ContentTypeGroup;
	private javax.swing.ButtonGroup jBGrp_EncryptContent;
	private javax.swing.ButtonGroup jBGrp_SigningArea;
	private javax.swing.JLabel jLb_CertPasswd;
	private javax.swing.JLabel jLb_Certificate;
	private javax.swing.JLabel jLb_InputFile;
	private javax.swing.JPanel jPl_ContentType;
	private javax.swing.JPanel jPl_RequestResponseArea;
	private javax.swing.JPanel jPl_Security;
	private javax.swing.JPanel jPl_Signing;
	private javax.swing.JProgressBar jProg_RequestStatus;
	private javax.swing.JRadioButton jRad_BodyContent;
	private javax.swing.JRadioButton jRad_EncryptDetached;
	private javax.swing.JRadioButton jRad_PlainContent;
	private javax.swing.JRadioButton jRad_WholeMessage;
	private javax.swing.JRadioButton jRad_ZipContent;
	private javax.swing.JRadioButton jRd_EncryptAttach;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JPasswordField jtxt_CertifcatePassword;
	private javax.swing.JLabel lbl_Url;
	private javax.swing.JTextField txt_Certifcate;
	private javax.swing.JTextArea txt_InputContent;
	private javax.swing.JTextField txt_InputFile;
	private javax.swing.JTextArea txt_OutputContent;

}
