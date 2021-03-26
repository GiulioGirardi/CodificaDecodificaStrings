package Codificadores;


// Codificador e descodificador
public class Codifica20108183 implements Codifica {
    private String tabelaAlfaNumericaOriginal = "AÃBCÇDEÉFGHIJKLMNOPQRSTUVWXYZãabcçdeéfghijklmnopqrstuvwxyz0123456789+/";
    private String tabelaCodificada = "ZKw25zCBGDWAGhFYuIÇ782QfgMy*637-_+?=jLlkzop:rS{u}ç#aq|<y>)!@#$%ˆ&V(vx`";

    // Codifica a string de acordo com comparações nas duas tabelas
    // Juntamente com uma variavel de deslocamento baseada no comprimento texto, ou seja, diferente a cada entrada
    public String codifica(String textoACodificar) {
        StringBuilder textoCodificado = new StringBuilder();
        for (int i = 0; i < textoACodificar.length(); i++) {
            char caractereAtual = textoACodificar.charAt(i);
            // Percorre a tabela alfa numerica procurando o digito
            for (int j = 0; i < tabelaAlfaNumericaOriginal.length() - 1; j++) {
                char letraAtual = tabelaAlfaNumericaOriginal.charAt(j);
                if (letraAtual == caractereAtual) {
                    // Calcula o deslocamento na tabela
                    int deslocamento = (textoACodificar.length() - 1) * 3;
                     // Pega o indice equivalente na outra tabela
                    int indiceCodificado = Math.floorMod(j - deslocamento, tabelaCodificada.length());
                    char charCodificado = tabelaCodificada.charAt(indiceCodificado);
                    textoCodificado.append(charCodificado);
                    break;
                }
            }
        }
        return textoCodificado.toString();
    }

    public String decodifica(String textoADecodificar) {     
        StringBuilder textoDecodificado = new StringBuilder();
        for (int i = 0; i < textoADecodificar.length(); i++) {
            char caractereAtual = textoADecodificar.charAt(i);
            // Percorre a tabela codificada procurando o digito
            for (int j = 0; i < tabelaCodificada.length() - 1; j++) {
                char letraAtual = tabelaCodificada.charAt(j);
                if (letraAtual == caractereAtual) {
                    // Calcula o deslocamento na tabela
                    int deslocamento = (textoADecodificar.length() - 1) * 3;
                    // Pega o indice equivalente na outra tabela
                    int indiceDecodificado = Math.floorMod(j + deslocamento, tabelaAlfaNumericaOriginal.length());
                    char charDecodificado = tabelaAlfaNumericaOriginal.charAt(indiceDecodificado);
                    textoDecodificado.append(charDecodificado);
                    break;
                }
            }
        }
        return textoDecodificado.toString();
    }

    public String getNomeAutor() {
        return "João Gabriel Cervo";
    }

    public String getMatriculaAutor() {
        return "20108183";
    }
}
