/* ***************************************************************
Autor: Aleksander Santos Sousa*
Matricula: 201810825*
Inicio: 02/11/2020*
Ultima alteracao: 07/11/2020*
Nome: Simulador de Redes*
Funcao: Simular o envio de uma mensagem de texto.
*************************************************************** */
package camadas.camada_enlace;

import camadas.camada_aplicacao.CamadaDeAplicacaoReceptora;
import camadas.camada_enlace.controle_de_erro.CamadaEnlaceDadosReceptoraControleDeErro;
import camadas.camada_enlace.enquadramento.CamadaEnlaceDadosReceptoraEnquadramento;

public class CamadaEnlaceDadosReceptora {
  public static void camadaEnlaceDadosReceptora(int[] quadro) {
    quadro = CamadaEnlaceDadosReceptoraControleDeErro.camadaEnlaceDadosReceptoraControleDeErro(quadro);
    quadro = CamadaEnlaceDadosReceptoraEnquadramento.camadaDeEnlaceDeDadosReceptoraEnquadramento(quadro);
    CamadaDeAplicacaoReceptora.camadaDeAplicacaoReceptora(quadro);
  }
}
