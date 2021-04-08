package br.edu.ufc.smd.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import br.edu.ufc.smd.entidades.Atendimento;
import br.edu.ufc.smd.entidades.Enfermeiro;
import br.edu.ufc.smd.entidades.Exame;
import br.edu.ufc.smd.entidades.ExameImagem;
import br.edu.ufc.smd.entidades.ExameLaboratorial;
import br.edu.ufc.smd.entidades.Medico;
import br.edu.ufc.smd.entidades.Paciente;
import br.edu.ufc.smd.entidades.ProfissionalSaude;
import br.edu.ufc.smd.entidades.Tecnico;

public class Tela extends JPanel {

	JTabbedPane tabbedPane;

	JComponent panelProfissional;
	JComponent panelPaciente;
	JComponent panelExame;
	JComponent panelAtendimento;

	// Profissional
	String[] perfilProfissional = { "MEDICO", "ENFERMEIRO", "TECNICO" };
	JPanel panelPerfil;
	JLabel lbPerfil;
	JComboBox<String> cbPerfis;
	JPanel panelRegistro;
	JLabel lbRegistro;
	JTextField tfRegistro;
	JPanel panelNomeProfis;
	JLabel lbNomeProfis;
	JTextField tfNomeProfis;
	JPanel panelContatoProfis;
	JLabel lbContatoProfis;
	JTextField tfContatoProfis;
	JPanel panelBotaoProfis;
	JButton btSalvarProfis;
	JPanel panelListaProfis;
	JTable tabelaProfis;
	JPanel panelFormProfis;

	// Paciente
	JPanel panelNomePct;
	JLabel lbNomePct;
	JTextField tfNomePct;
	JPanel panelNascimento;
	JLabel lbNascimento;
	JTextField tfNascimento;
	JPanel panelTelefonePct;
	JLabel lbTelefonePct;
	JTextField tfTelefonePct;
	JPanel panelEnderecoPct;
	JLabel lbEnderecoPct;
	JTextField tfEnderecoPct;
	JPanel panelBotaoPct;
	JButton btSalvarPct;
	JPanel panelFormPct;
	JTable tabelaPct;
	JPanel panelListaPct;

	// Exame
	String[] tipoExame = { "LABORATORIAL", "IMAGEM" };
	JPanel panelIdentificador;
	JLabel lbIdentificador;
	JTextField tfIdentificador;
	JPanel panelTipoExame;
	JLabel lbTipoExame;
	JComboBox<String> cbTipoExame;
	JPanel panelDescricao;
	JLabel lbDescricao;
	JTextField tfDescricao;
	JPanel panelPreparo;
	JLabel lbPreparo;
	JTextField tfPreparo;
	JPanel panelBotaoExame;
	JButton btSalvarExame;
	JPanel panelListaExame;
	JTable tabelaExame;
	JPanel panelFormExame;

	// Atendimento
	JPanel panelData;
	JLabel lbData;
	JLabel lbDataHint;
	JTextField tfData;
	JPanel panelHora;
	JLabel lbHora;
	JLabel lbHoraHint;
	JTextField tfHora;
	JPanel panelPacienteAtd;
	JLabel lbPacienteAtd;
	JComboBox<Paciente> cbPaciente;
	JComboBox<ProfissionalSaude> cbProfissional;
	JPanel panelProfissionalAtd;
	JLabel lbProfissionalAtd;
	JPanel panelBotaoAtd;
	JButton btSalvarAtd;
	JPanel panelListaAtd;
	JTable tabelaAtd;
	JPanel panelFormAtd;

	// Objetos para "memória"
	List<ProfissionalSaude> listaProfissionais;
	List<Exame> listaExames;
	List<Atendimento> listaAtendimentos;
	
	private void criarJanela() {
		panelProfissional = makeTextPanel("Profissional");
		tabbedPane.addTab("Profissional", null, panelProfissional, "Does nothing");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		panelPaciente = makeTextPanel("Paciente");
		tabbedPane.addTab("Paciente", null, panelPaciente, "Does twice as much nothing");
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

		panelExame = makeTextPanel("Exame");
		tabbedPane.addTab("Exame", null, panelExame, "Still does nothing");
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

		panelAtendimento = makeTextPanel("Atendimento");
		panelAtendimento.setPreferredSize(new Dimension(410, 50));
		tabbedPane.addTab("Atendimento", null, panelAtendimento, "Does nothing at all");
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);

		// Add the tabbed pane to this panel.
		add(tabbedPane);

		// The following line enables to use scrolling tabs.
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	}

	private void criarPainelProfissional() {
		panelPerfil = new JPanel();
		panelPerfil.setLayout(new FlowLayout());

		lbPerfil = new JLabel("Perfil");
		lbPerfil.setPreferredSize(new Dimension(50, 24));
		lbPerfil.setVisible(true);
		panelPerfil.add(lbPerfil);

		cbPerfis = new JComboBox<String>(perfilProfissional);
		cbPerfis.setPreferredSize(new Dimension(200, 24));
		panelPerfil.add(cbPerfis);

		cbPerfis.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (cbPerfis.getSelectedItem().equals("ENFERMEIRO")) {
					System.out.println("Sou um enfermeiro");
				}
				if (cbPerfis.getSelectedItem().equals("MEDICO")) {
					System.out.println("Sou um médico");
				}
				if (cbPerfis.getSelectedItem().equals("TECNICO")) {
					System.out.println("Sou um técnico");
				}
			}
		});

		panelRegistro = new JPanel();
		panelRegistro.setLayout(new FlowLayout());

		lbRegistro = new JLabel("Registro");
		lbRegistro.setPreferredSize(new Dimension(50, 24));
		lbRegistro.setVisible(true);
		panelRegistro.add(lbRegistro);

		tfRegistro = new JTextField();
		tfRegistro.setPreferredSize(new Dimension(200, 24));
		panelRegistro.add(tfRegistro);

		panelNomeProfis = new JPanel();
		panelNomeProfis.setLayout(new FlowLayout());

		lbNomeProfis = new JLabel("Nome");
		lbNomeProfis.setPreferredSize(new Dimension(50, 24));
		lbNomeProfis.setVisible(true);
		panelNomeProfis.add(lbNomeProfis);

		tfNomeProfis = new JTextField();
		tfNomeProfis.setPreferredSize(new Dimension(200, 24));
		panelNomeProfis.add(tfNomeProfis);

		panelContatoProfis = new JPanel();
		panelContatoProfis.setLayout(new FlowLayout());

		lbContatoProfis = new JLabel("Contato");
		lbContatoProfis.setPreferredSize(new Dimension(50, 24));
		lbContatoProfis.setVisible(true);
		panelContatoProfis.add(lbContatoProfis);

		tfContatoProfis = new JTextField();
		tfContatoProfis.setPreferredSize(new Dimension(200, 24));
		panelContatoProfis.add(tfContatoProfis);

		panelBotaoProfis = new JPanel();
		panelBotaoProfis.setLayout(new FlowLayout());

		btSalvarProfis = new JButton("Adicionar");
		btSalvarProfis.setBounds(50, 100, 95, 30);
		panelBotaoProfis.add(btSalvarProfis);

		// Evento do botão Adicionar
		btSalvarProfis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica aqui...
				if (cbPerfis.getSelectedItem().equals("ENFERMEIRO")) {
					listaProfissionais.add(
							new Enfermeiro(tfRegistro.getText(), tfNomeProfis.getText(), tfContatoProfis.getText()));
				} else if (cbPerfis.getSelectedItem().equals("MEDICO")) {
					listaProfissionais
							.add(new Medico(tfRegistro.getText(), tfNomeProfis.getText(), tfContatoProfis.getText()));
				} else if (cbPerfis.getSelectedItem().equals("TECNICO")) {
					listaProfissionais
							.add(new Tecnico(tfRegistro.getText(), tfNomeProfis.getText(), tfContatoProfis.getText()));
				}
				
				TableModelProfissionalSaude modeloProfissionalSaude = new TableModelProfissionalSaude(listaProfissionais);
				tabelaProfis.setModel(modeloProfissionalSaude);
			}
		});

		panelFormProfis = new JPanel();
		panelFormProfis.setLayout(new BoxLayout(panelFormProfis, BoxLayout.Y_AXIS));

		panelFormProfis.add(panelPerfil);
		panelFormProfis.add(panelRegistro);
		panelFormProfis.add(panelNomeProfis);
		panelFormProfis.add(panelContatoProfis);
		panelFormProfis.add(panelBotaoProfis);

		panelListaProfis = new JPanel();
		panelListaProfis.setLayout(new FlowLayout());
		panelListaProfis.setPreferredSize(new Dimension(400, 30));

		tabelaProfis = new JTable();
		panelListaProfis.add(tabelaProfis);

		panelProfissional.setLayout(new BorderLayout());
		panelProfissional.add(panelFormProfis, BorderLayout.WEST);
		panelProfissional.add(panelListaProfis, BorderLayout.EAST);
	}

	private void criarPainelPaciente() {
		panelNomePct = new JPanel();
		panelNomePct.setLayout(new FlowLayout());

		lbNomePct = new JLabel("Nome");
		lbNomePct.setPreferredSize(new Dimension(50, 24));
		lbNomePct.setVisible(true);
		panelNomePct.add(lbNomePct);

		tfNomePct = new JTextField();
		tfNomePct.setPreferredSize(new Dimension(200, 24));
		panelNomePct.add(tfNomePct);

		panelNascimento = new JPanel();
		panelNascimento.setLayout(new FlowLayout());

		lbNascimento = new JLabel("Dt Nascimento");
		lbNascimento.setPreferredSize(new Dimension(50, 24));
		lbNascimento.setVisible(true);
		panelNascimento.add(lbNascimento);

		tfNascimento = new JTextField();
		tfNascimento.setPreferredSize(new Dimension(200, 24));
		panelNascimento.add(tfNascimento);

		panelTelefonePct = new JPanel();
		panelTelefonePct.setLayout(new FlowLayout());

		lbTelefonePct = new JLabel("Telefone");
		lbTelefonePct.setPreferredSize(new Dimension(50, 24));
		lbTelefonePct.setVisible(true);
		panelTelefonePct.add(lbTelefonePct);

		tfTelefonePct = new JTextField();
		tfTelefonePct.setPreferredSize(new Dimension(200, 24));
		panelTelefonePct.add(tfTelefonePct);

		panelEnderecoPct = new JPanel();
		panelEnderecoPct.setLayout(new FlowLayout());

		lbEnderecoPct = new JLabel("Endereço");
		lbEnderecoPct.setPreferredSize(new Dimension(50, 24));
		lbEnderecoPct.setVisible(true);
		panelEnderecoPct.add(lbEnderecoPct);

		tfEnderecoPct = new JTextField();
		tfEnderecoPct.setPreferredSize(new Dimension(200, 24));
		panelEnderecoPct.add(tfEnderecoPct);

		panelBotaoPct = new JPanel();
		panelBotaoPct.setLayout(new FlowLayout());

		btSalvarPct = new JButton("Adicionar");
		btSalvarPct.setBounds(50, 100, 95, 30);
		panelBotaoPct.add(btSalvarPct);

		// Evento do botão Adicionar
		btSalvarPct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica aqui...
				System.out.println("Faço paciente...");
			}
		});

		panelFormPct = new JPanel();
		panelFormPct.setLayout(new BoxLayout(panelFormPct, BoxLayout.Y_AXIS));

		panelFormPct.add(panelNomePct);
		panelFormPct.add(panelNascimento);
		panelFormPct.add(panelTelefonePct);
		panelFormPct.add(panelEnderecoPct);
		panelFormPct.add(panelBotaoPct);

		panelListaPct = new JPanel();
		panelListaPct.setLayout(new FlowLayout());
		panelListaPct.setPreferredSize(new Dimension(400, 30));

		tabelaPct = new JTable();
		panelListaPct.add(tabelaPct);

		panelPaciente.setLayout(new BorderLayout());
		panelPaciente.add(panelFormPct, BorderLayout.WEST);
		panelPaciente.add(panelListaPct, BorderLayout.EAST);
	}

	private void criarPainelExame() {

		panelIdentificador = new JPanel();
		panelIdentificador.setLayout(new FlowLayout());

		lbIdentificador = new JLabel("Identificador");
		lbIdentificador.setPreferredSize(new Dimension(50, 24));
		lbIdentificador.setVisible(true);
		panelIdentificador.add(lbIdentificador);

		tfIdentificador = new JTextField();
		tfIdentificador.setPreferredSize(new Dimension(200, 24));
		panelIdentificador.add(tfIdentificador);
		
		panelTipoExame = new JPanel();
		panelTipoExame.setLayout(new FlowLayout());

		lbTipoExame = new JLabel("Tipo");
		lbTipoExame.setPreferredSize(new Dimension(50, 24));
		lbTipoExame.setVisible(true);
		panelTipoExame.add(lbTipoExame);

		cbTipoExame = new JComboBox<String>(tipoExame);
		cbTipoExame.setPreferredSize(new Dimension(200, 24));
		panelTipoExame.add(cbTipoExame);

		cbTipoExame.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (cbTipoExame.getSelectedItem().equals("LABORATORIAL")) {
					System.out.println("Exame laboratorial");
				} else if (cbTipoExame.getSelectedItem().equals("IMAGEM")) {
					System.out.println("Exame imagem");
				} 
			}
		});

		panelDescricao = new JPanel();
		panelDescricao.setLayout(new FlowLayout());

		lbDescricao = new JLabel("Descrição");
		lbDescricao.setPreferredSize(new Dimension(50, 24));
		lbDescricao.setVisible(true);
		panelDescricao.add(lbDescricao);

		tfDescricao = new JTextField();
		tfDescricao.setPreferredSize(new Dimension(200, 24));
		panelDescricao.add(tfDescricao);

		panelPreparo = new JPanel();
		panelPreparo.setLayout(new FlowLayout());

		lbPreparo = new JLabel("Preparo");
		lbPreparo.setPreferredSize(new Dimension(50, 24));
		lbPreparo.setVisible(true);
		panelPreparo.add(lbPreparo);

		tfPreparo = new JTextField();
		tfPreparo.setPreferredSize(new Dimension(200, 24));
		panelPreparo.add(tfPreparo);

		panelBotaoExame = new JPanel();
		panelBotaoExame.setLayout(new FlowLayout());

		btSalvarExame = new JButton("Adicionar");
		btSalvarExame.setBounds(50, 100, 95, 30);
		panelBotaoExame.add(btSalvarExame);

		// Evento do botão Adicionar
		btSalvarExame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbTipoExame.getSelectedItem().equals("LABORATORIAL")) {
					listaExames.add(
							new ExameLaboratorial(tfIdentificador.getText(), tfDescricao.getText(), tfPreparo.getText()));
				} else if (cbTipoExame.getSelectedItem().equals("IMAGEM")) {
					listaExames
							.add(new ExameImagem(tfIdentificador.getText(), tfDescricao.getText(), tfPreparo.getText()));
				} 
				
				TableModelExame modeloExame = new TableModelExame(listaExames);
				tabelaExame.setModel(modeloExame);
				System.out.println("Adicionando exame...");
			}
		});

		panelFormExame = new JPanel();
		panelFormExame.setLayout(new BoxLayout(panelFormExame, BoxLayout.Y_AXIS));

		panelFormExame.add(panelIdentificador);
		panelFormExame.add(panelTipoExame);
		panelFormExame.add(panelDescricao);
		panelFormExame.add(panelPreparo);
		panelFormExame.add(panelBotaoExame);

		panelListaExame = new JPanel();
		panelListaExame.setLayout(new FlowLayout());
		panelListaExame.setPreferredSize(new Dimension(400, 30));

		tabelaExame = new JTable();
		panelListaExame.add(tabelaExame);

		panelExame.setLayout(new BorderLayout());
		panelExame.add(panelFormExame, BorderLayout.WEST);
		panelExame.add(panelListaExame, BorderLayout.EAST);
	}

	private void criarPainelAtendimento() {
		panelData = new JPanel();
		panelData.setLayout(new FlowLayout());

		lbData = new JLabel("Data");
		lbData.setPreferredSize(new Dimension(50, 24));
		lbData.setVisible(true);
		panelData.add(lbData);

		tfData = new JTextField("Ex.: 2021-abr-01");
		tfData.setPreferredSize(new Dimension(200, 24));
		panelData.add(tfData);

		panelHora = new JPanel();
		panelHora.setLayout(new FlowLayout());

		lbHora = new JLabel("Hora");
		lbHora.setPreferredSize(new Dimension(50, 24));
		lbHora.setVisible(true);
		panelHora.add(lbHora);

		tfHora = new JTextField("Ex.: 12:10:00");
		tfHora.setPreferredSize(new Dimension(200, 24));
		panelHora.add(tfHora);
		
		panelPacienteAtd = new JPanel();
		panelPacienteAtd.setLayout(new FlowLayout());

		lbPacienteAtd = new JLabel("Paciente");
		lbPacienteAtd.setPreferredSize(new Dimension(50, 24));
		lbPacienteAtd.setVisible(true);
		panelPacienteAtd.add(lbPacienteAtd);

		cbPaciente = new JComboBox<Paciente>();
		cbPaciente.setPreferredSize(new Dimension(200, 24));
		panelPacienteAtd.add(cbPaciente);

		cbPaciente.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				// Lógica aqui...
			}
		});

		panelProfissionalAtd = new JPanel();
		panelProfissionalAtd.setLayout(new FlowLayout());

		lbProfissionalAtd = new JLabel("Profissional");
		lbProfissionalAtd.setPreferredSize(new Dimension(50, 24));
		lbProfissionalAtd.setVisible(true);
		panelProfissionalAtd.add(lbProfissionalAtd);

		cbProfissional = new JComboBox<ProfissionalSaude>();
		cbProfissional.setPreferredSize(new Dimension(200, 24));
		panelProfissionalAtd.add(cbProfissional);

		cbProfissional.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				// Lógica aqui...
			}
		});

		panelBotaoAtd = new JPanel();
		panelBotaoAtd.setLayout(new FlowLayout());

		btSalvarAtd = new JButton("Adicionar");
		btSalvarAtd.setBounds(50, 100, 95, 30);
		panelBotaoAtd.add(btSalvarAtd);

		// Evento do botão Adicionar
		btSalvarAtd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Locale brazilLocale = new Locale("pt", "BR");
				final DateTimeFormatter formatter = new DateTimeFormatterBuilder()
				           .parseCaseInsensitive()
				           .appendPattern("yyyy-MMM-dd")
				           .toFormatter(brazilLocale);
				
				LocalDate data = LocalDate.parse(tfData.getText(), formatter);
				LocalTime hora = LocalTime.parse(tfHora.getText());
				
//				listaAtendimentos.add(new Atendimento(data, hora, cbPaciente.getSelectedItem(), cbProfissional.getSelectedItem()));
	
				TableModelAtendimento modeloAtendimento = new TableModelAtendimento(listaAtendimentos);
				tabelaAtd.setModel(modeloAtendimento);
				System.out.println("Faço atendimento...");
			}
		});

		panelFormAtd = new JPanel();
		panelFormAtd.setLayout(new BoxLayout(panelFormAtd, BoxLayout.Y_AXIS));

		panelFormAtd.add(panelData);
		panelFormAtd.add(panelHora);
		panelFormAtd.add(panelPacienteAtd);
		panelFormAtd.add(panelProfissionalAtd);
		panelFormAtd.add(panelBotaoAtd);

		panelListaAtd = new JPanel();
		panelListaAtd.setLayout(new FlowLayout());
		panelListaAtd.setPreferredSize(new Dimension(400, 30));

		tabelaAtd = new JTable();
		panelListaAtd.add(tabelaAtd);

		panelAtendimento.setLayout(new BorderLayout());
		panelAtendimento.add(panelFormAtd, BorderLayout.WEST);
		panelAtendimento.add(panelListaAtd, BorderLayout.EAST);
	}

	public Tela() {
		super(new GridLayout(1, 1));
		listaProfissionais = new ArrayList<ProfissionalSaude>();
		listaExames = new ArrayList<Exame>();
		listaAtendimentos = new ArrayList<Atendimento>();
		tabbedPane = new JTabbedPane();

		criarJanela();
		criarPainelProfissional();
		criarPainelPaciente();
		criarPainelExame();
		criarPainelAtendimento();
	}

	protected JComponent makeTextPanel(String text) {
		JPanel panel = new JPanel(false);
		JLabel filler = new JLabel(text);
		filler.setHorizontalAlignment(JLabel.CENTER);
		panel.setLayout(new GridLayout(1, 1));
		panel.add(filler);
		return panel;
	}

	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("Trabalho POO - Clínica");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Add content to the window.
		frame.add(new Tela(), BorderLayout.CENTER);

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// Schedule a job for the event dispatch thread:
		// creating and showing this application's GUI.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// Turn off metal's use of bold fonts
				UIManager.put("swing.boldMetal", Boolean.FALSE);
				ExameImagem.setPerito("Dr. José Maciel");
				createAndShowGUI();
			}
		});
	}

}
