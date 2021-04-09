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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.text.DateFormatter;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

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

	// Componentes para criar as abas
	JTabbedPane tabbedPane;
	JComponent panelProfissional;
	JComponent panelPaciente;
	JComponent panelExame;
	JComponent panelAtendimento;

	// Componentes para a aba "Profissional"
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

	// Componentes para a aba "Paciente"
	JPanel panelNomePct;
	JLabel lbNomePct;
	JTextField tfNomePct;
	JPanel panelNascimento;
	JLabel lbNascimento;
	JDatePanelImpl datePanel;
 	JDatePickerImpl datePicker;
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

	// Componentes para a aba "Exame"
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

	// Componentes para a aba "Atendimento"
	JPanel panelData;
	JLabel lbData;
	JLabel lbDataHint;
	JDatePanelImpl datePanelAtd;
 	JDatePickerImpl datePickerAtd;
	JPanel panelHora;
	JLabel lbHora;
	JLabel lbHoraHint;
	JTextField tfHora;
	JPanel panelPacienteAtd;
	JLabel lbPacienteAtd;
	JComboBox cbPaciente;
	JComboBox<ProfissionalSaude> cbProfissional;
	JPanel panelProfissionalAtd;
	JLabel lbProfissionalAtd;
	JPanel panelBotaoAtd;
	JButton btSalvarAtd;
	JPanel panelListaAtd;
	JTable tabelaAtd;
	JPanel panelFormAtd;

	// Listas de objetos
	List<ProfissionalSaude> listaProfissionais;
	List<Paciente> listaPacientes;
	List<Exame> listaExames;
	List<Atendimento> listaAtendimentos;
	
	private void criarJanela() {
		panelProfissional = makeTextPanel("Profissional");
		tabbedPane.addTab("Profissional", null, panelProfissional, "Profissional");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		panelPaciente = makeTextPanel("Paciente");
		tabbedPane.addTab("Paciente", null, panelPaciente, "Paciente");
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

		panelExame = makeTextPanel("Exame");
		tabbedPane.addTab("Exame", null, panelExame, "Exame");
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

		panelAtendimento = makeTextPanel("Atendimento");
		panelAtendimento.setPreferredSize(new Dimension(410, 50));
		tabbedPane.addTab("Atendimento", null, panelAtendimento, "Atendimento");
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);

		// Adiciona o tabbed pane à janela.
		add(tabbedPane);

		// Habilita a rolagem nas abas.
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	}

	private void criarPainelProfissional() {
		panelPerfil = new JPanel();
		panelPerfil.setLayout(new FlowLayout());

		lbPerfil = new JLabel("Perfil");
		lbPerfil.setPreferredSize(new Dimension(100, 24));
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
		lbRegistro.setPreferredSize(new Dimension(100, 24));
		lbRegistro.setVisible(true);
		panelRegistro.add(lbRegistro);

		tfRegistro = new JTextField();
		tfRegistro.setPreferredSize(new Dimension(200, 24));
		panelRegistro.add(tfRegistro);

		panelNomeProfis = new JPanel();
		panelNomeProfis.setLayout(new FlowLayout());

		lbNomeProfis = new JLabel("Nome");
		lbNomeProfis.setPreferredSize(new Dimension(100, 24));
		lbNomeProfis.setVisible(true);
		panelNomeProfis.add(lbNomeProfis);

		tfNomeProfis = new JTextField();
		tfNomeProfis.setPreferredSize(new Dimension(200, 24));
		panelNomeProfis.add(tfNomeProfis);

		panelContatoProfis = new JPanel();
		panelContatoProfis.setLayout(new FlowLayout());

		lbContatoProfis = new JLabel("Contato");
		lbContatoProfis.setPreferredSize(new Dimension(100, 24));
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
				
				/**
				 * O atributo "listaProfissionais" é do tipo "ProfissionalSaude". 
				 * Como as classes "Medico", "Enfermeiro" e "Tecnico" são subclasses de "ProfissionalSaude", 
				 * instâcias dessas classes podem ser adcionadas à "listaProfissionais".
				 */
				if (cbPerfis.getSelectedItem().equals("ENFERMEIRO")) {
					listaProfissionais
							.add(new Enfermeiro(tfRegistro.getText(), tfNomeProfis.getText(), tfContatoProfis.getText()));
				} else if (cbPerfis.getSelectedItem().equals("MEDICO")) {
					listaProfissionais
							.add(new Medico(tfRegistro.getText(), tfNomeProfis.getText(), tfContatoProfis.getText()));
				} else if (cbPerfis.getSelectedItem().equals("TECNICO")) {
					listaProfissionais
							.add(new Tecnico(tfRegistro.getText(), tfNomeProfis.getText(), tfContatoProfis.getText()));
				}
				
				// Para desenhar a tabela.
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
		lbNomePct.setPreferredSize(new Dimension(100, 24));
		lbNomePct.setVisible(true);
     	panelNomePct.add(lbNomePct);
     		
     	tfNomePct = new JTextField();
     	tfNomePct.setPreferredSize(new Dimension(200, 24));
     	panelNomePct.add(tfNomePct);

     	panelNascimento = new JPanel();
     	panelNascimento.setLayout(new FlowLayout());

     	lbNascimento = new JLabel("Dt Nascimento");
     	lbNascimento.setPreferredSize(new Dimension(100, 24));
     	lbNascimento.setVisible(true);
     	panelNascimento.add(lbNascimento);
     	    	
     	UtilDateModel model = new UtilDateModel();
     	Properties p = new Properties();
     	p.put("text.today", "Hoje");
     	p.put("text.month", "Month");
     	p.put("text.year", "Year");
     	datePanel = new JDatePanelImpl(model, p);
     	datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
     	panelNascimento.add(datePicker);

     	panelTelefonePct = new JPanel();
     	panelTelefonePct.setLayout(new FlowLayout());
     		
     	lbTelefonePct = new JLabel("Telefone");
     	lbTelefonePct.setPreferredSize(new Dimension(100, 24));
     	lbTelefonePct.setVisible(true);
     	panelTelefonePct.add(lbTelefonePct);
     		
     	tfTelefonePct = new JTextField();
     	tfTelefonePct.setPreferredSize(new Dimension(200, 24));
     	panelTelefonePct.add(tfTelefonePct);

     	panelEnderecoPct = new JPanel();
     	panelEnderecoPct.setLayout(new FlowLayout());
     		
     	lbEnderecoPct = new JLabel("Endereço");
     	lbEnderecoPct.setPreferredSize(new Dimension(100, 24));
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
     	btSalvarPct.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		listaPacientes
	    			.add(new Paciente(tfNomePct.getText(), (Date) datePicker.getModel().getValue(), tfTelefonePct.getText(), tfEnderecoPct.getText()));
	    		TableModelPaciente modeloPaciente = new TableModelPaciente(listaPacientes);
	    		tabelaPct.setModel(modeloPaciente);
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
		lbIdentificador.setPreferredSize(new Dimension(100, 24));
		lbIdentificador.setVisible(true);
		panelIdentificador.add(lbIdentificador);

		tfIdentificador = new JTextField();
		tfIdentificador.setPreferredSize(new Dimension(200, 24));
		panelIdentificador.add(tfIdentificador);
		
		panelTipoExame = new JPanel();
		panelTipoExame.setLayout(new FlowLayout());

		lbTipoExame = new JLabel("Tipo");
		lbTipoExame.setPreferredSize(new Dimension(100, 24));
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
		lbDescricao.setPreferredSize(new Dimension(100, 24));
		lbDescricao.setVisible(true);
		panelDescricao.add(lbDescricao);

		tfDescricao = new JTextField();
		tfDescricao.setPreferredSize(new Dimension(200, 24));
		panelDescricao.add(tfDescricao);

		panelPreparo = new JPanel();
		panelPreparo.setLayout(new FlowLayout());

		lbPreparo = new JLabel("Preparo");
		lbPreparo.setPreferredSize(new Dimension(100, 24));
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
					listaExames
						.add(new ExameLaboratorial(tfIdentificador.getText(), tfDescricao.getText(), tfPreparo.getText()));
				} else if (cbTipoExame.getSelectedItem().equals("IMAGEM")) {
					listaExames
						.add(new ExameImagem(tfIdentificador.getText(), tfDescricao.getText(), tfPreparo.getText()));
				} 
				
				// Para desenhar a tabela
				TableModelExame modeloExame = new TableModelExame(listaExames);
				tabelaExame.setModel(modeloExame);
				System.out.println("Adicionando exame: " + listaExames.get(listaExames.size() - 1).getDescricao());
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
		
		// Data
		panelData = new JPanel();
		panelData.setLayout(new FlowLayout());

		lbData = new JLabel("Data");
		lbData.setPreferredSize(new Dimension(100, 24));
		lbData.setVisible(true);
		panelData.add(lbData);

		UtilDateModel model = new UtilDateModel();
     	Properties p = new Properties();
     	p.put("text.today", "Hoje");
     	p.put("text.month", "Month");
     	p.put("text.year", "Year");
     	datePanelAtd = new JDatePanelImpl(model, p);
     	datePickerAtd = new JDatePickerImpl(datePanelAtd, new DateLabelFormatter());
     	datePickerAtd.setPreferredSize(new Dimension(200, 24));
     	panelData.add(datePickerAtd);

     	// Hora
		panelHora = new JPanel();
		panelHora.setLayout(new FlowLayout());

		lbHora = new JLabel("Hora");
		lbHora.setPreferredSize(new Dimension(100, 24));
		lbHora.setVisible(true);
		panelHora.add(lbHora);
		
		Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 24); // 24 == 12 PM == 00:00:00
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        SpinnerDateModel spinnerDateModel = new SpinnerDateModel();
        model.setValue(calendar.getTime());

        JSpinner spinner = new JSpinner(spinnerDateModel);

        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "HH:mm:ss");
        DateFormatter formatter = (DateFormatter)editor.getTextField().getFormatter();
        formatter.setAllowsInvalid(false); // this makes what you want
        formatter.setOverwriteMode(true);
        spinner.setPreferredSize(new Dimension(200, 24));

        spinner.setEditor(editor);
		panelHora.add(spinner);
		
		// Paciente
		panelPacienteAtd = new JPanel();
		panelPacienteAtd.setLayout(new FlowLayout());

		lbPacienteAtd = new JLabel("Paciente");
		lbPacienteAtd.setPreferredSize(new Dimension(100, 24));
		lbPacienteAtd.setVisible(true);
		panelPacienteAtd.add(lbPacienteAtd);

		cbPaciente = new JComboBox();
		PacienteComboModel modeloComboPaciente = new PacienteComboModel(listaPacientes);
		cbPaciente.setModel(modeloComboPaciente);
		cbPaciente.setPreferredSize(new Dimension(200, 24));
		panelPacienteAtd.add(cbPaciente);

		// Profissional
		panelProfissionalAtd = new JPanel();
		panelProfissionalAtd.setLayout(new FlowLayout());

		lbProfissionalAtd = new JLabel("Profissional");
		lbProfissionalAtd.setPreferredSize(new Dimension(100, 24));
		lbProfissionalAtd.setVisible(true);
		panelProfissionalAtd.add(lbProfissionalAtd);
		
		cbProfissional = new JComboBox();
		ProfissionalComboModel modeloComboProfissional = new ProfissionalComboModel(listaProfissionais);
		cbProfissional.setModel(modeloComboProfissional);
		cbProfissional.setPreferredSize(new Dimension(200, 24));
		panelProfissionalAtd.add(cbProfissional);

		panelBotaoAtd = new JPanel();
		panelBotaoAtd.setLayout(new FlowLayout());

		btSalvarAtd = new JButton("Iniciar Atendimento");
		btSalvarAtd.setBounds(50, 100, 95, 30);
		panelBotaoAtd.add(btSalvarAtd);

		// Evento do botão Adicionar
		btSalvarAtd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date data = (Date) datePickerAtd.getModel().getValue();
				Date hora = (Date) spinner.getModel().getValue();
				
				Atendimento atendimento = new Atendimento();
				atendimento.setData(data);
				atendimento.setHora(hora);
				atendimento.registrar((Paciente) cbPaciente.getSelectedItem(), (ProfissionalSaude) cbProfissional.getSelectedItem());

				listaAtendimentos.add(atendimento);
	
				TableModelAtendimento modeloAtendimento = new TableModelAtendimento(listaAtendimentos);
				tabelaAtd.setModel(modeloAtendimento);
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
		listaPacientes = new ArrayList<Paciente>();
		listaExames = new ArrayList<Exame>();
		listaAtendimentos = new ArrayList<Atendimento>();
		tabbedPane = new JTabbedPane();

		criarJanela();
		criarPainelProfissional();
		criarPainelPaciente();
		criarPainelExame();
		criarPainelAtendimento();
		
		ExameImagem.setPerito("Dr. José Maciel");
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
		JFrame frame = new JFrame("Trabalho POO - Clínica");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(new Tela(), BorderLayout.CENTER);

		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				UIManager.put("swing.boldMetal", Boolean.FALSE);
				createAndShowGUI();
			}
		});
	}

}
