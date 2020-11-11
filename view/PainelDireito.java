/* ***************************************************************
Autor: Aleksander Santos Sousa*
Matricula: 201810825*
Inicio: 02/11/2020*
Ultima alteracao: 07/11/2020*
Nome: Simulador de Redes*
Funcao: Simular o envio de uma mensagem de texto.
*************************************************************** */
package view;

import util.Constantes;
import util.Formatacao;

import java.awt.Dimension;
import java.awt.Color;

import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class PainelDireito extends JPanel {
  public static ArrayList<JTextArea> arrayCaixasDeTexto;
  private ArrayList<JPanel> arrayPaineis;
  private JTextArea txtLabelNumerosAciiDecodificados;
  private JTextArea txtLabelQuadrosDecodificados;
  private JTextArea txtLabelInstrucoes;
  private JTextArea txtLabelCRCDecodificado;

  /*
   * ************************************************************** Metodo:
   * PainelDireito* Funcao: Construtor da classe PainelDireito.* Parametros: nulo*
   * Retorno: void*
   */
  public PainelDireito() {
    PainelDireito.arrayCaixasDeTexto = Formatacao.inicializarCaixasDeTexto();
    this.arrayPaineis = new ArrayList<>();

    this.txtLabelNumerosAciiDecodificados = new JTextArea("Numero Ascii: ");
    this.txtLabelQuadrosDecodificados = new JTextArea("Quadros Decodificados: ");
    this.txtLabelInstrucoes = new JTextArea("Clique no botão ou aperte enter para enviar.");
    this.txtLabelCRCDecodificado = new JTextArea("CRC decodificado: ");


    for (int i = 0; i < Constantes.TAMANHO_ARRAY_PAINEIS; i++) {
      arrayPaineis.add(new JPanel());
      if (i != Constantes.TAMANHO_ARRAY_PAINEIS - 1)
        arrayPaineis.get(i).setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
    }

    this.initGUIComponents();
  }

  /*
   * ************************************************************** Metodo:
   * initGUIComponents* Funcao: inicializar os componentes do painel.* Parametros:
   * nulo* Retorno: void*
   */
  private void initGUIComponents() {
    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    this.formatarLabels();
    this.adicionarComponentes();
  }

  /*
   * ************************************************************** Metodo:
   * formatarLabels* Funcao: formata os labels.* Parametros: nulo* Retorno: void*
   */
  private void formatarLabels() {
    this.txtLabelNumerosAciiDecodificados.setBackground(this.getBackground());
    this.txtLabelQuadrosDecodificados.setBackground(this.getBackground());
    this.txtLabelCRCDecodificado.setBackground(this.getBackground());
    this.txtLabelInstrucoes.setBackground(this.getBackground());

    Formatacao.inicializarLabels(txtLabelNumerosAciiDecodificados, Constantes.LARGURA_LABELS_DIREITO,
        Constantes.ALTURA_LABELS);
    Formatacao.inicializarLabels(txtLabelQuadrosDecodificados, Constantes.LARGURA_LABELS_DIREITO,
        Constantes.ALTURA_LABELS);
    Formatacao.inicializarLabels(txtLabelCRCDecodificado, Constantes.LARGURA_LABELS_DIREITO,
        Constantes.ALTURA_LABELS);
    Formatacao.inicializarLabels(txtLabelInstrucoes, 320, 20);
    txtLabelInstrucoes.setForeground(Color.RED);
    txtLabelInstrucoes.setBounds(50, 32, 320, 20);
  }

  /*
   * ************************************************************** Metodo:
   * adicionarComponentes* Funcao: inicializa e adiciona os componentes ao
   * painel.* Parametros: nulo* Retorno: void*
   */
  private void adicionarComponentes() {
    arrayPaineis.get(0).add(Formatacao.inicializarBarraDeRolagem(PainelDireito.arrayCaixasDeTexto.get(4),
        Constantes.LARGURA_COMPONENTES, Constantes.ALTURA_COMPONENTES));

    arrayPaineis.get(1).add(txtLabelNumerosAciiDecodificados);
    arrayPaineis.get(1).add(Formatacao.inicializarBarraDeRolagem(PainelDireito.arrayCaixasDeTexto.get(1),
        Constantes.LARGURA_COMPONENTES, Constantes.ALTURA_COMPONENTES * 2));

    arrayPaineis.get(2).add(txtLabelQuadrosDecodificados);
    arrayPaineis.get(2).add(Formatacao.inicializarBarraDeRolagem(Formatacao.arrayCaixasDeTexto.get(5),
        Constantes.LARGURA_COMPONENTES, Constantes.ALTURA_COMPONENTES * 2));
    
    arrayPaineis.get(3).add(txtLabelCRCDecodificado);
    arrayPaineis.get(3).add(Formatacao.inicializarBarraDeRolagem(Formatacao.arrayCaixasDeTexto.get(6),
        Constantes.LARGURA_COMPONENTES, Constantes.ALTURA_COMPONENTES * 2));
    
    arrayPaineis.get(4).setPreferredSize(new Dimension(320, 60));
    arrayPaineis.get(4).setLayout(null);
    arrayPaineis.get(4).add(txtLabelInstrucoes);

    for (int i = 0; i < Constantes.TAMANHO_ARRAY_PAINEIS; i++) {
      this.add(arrayPaineis.get(i));
    }
  }

  /*
   * ************************************************************** Metodo:
   * getPreferredSize* Funcao: seta o tamanho deste painel.* Parametros: nulo*
   * Retorno: void*
   */
  @Override
  public Dimension getPreferredSize() {
    return new Dimension(600, 300);
  }
}
