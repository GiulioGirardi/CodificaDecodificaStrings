package Codificadores;


public class Codifica19180875 implements Codifica {

    public String codifica(String str) {
        return str.replaceAll("(.)", "$1_&#");
    }

    public String decodifica(String str) {
        str = str.replaceAll("_", "");
        str = str.replaceAll("#", "");
        str = str.replaceAll("&", "");
        return str;
    }

    public String getMatriculaAutor() {
        return "19180875";
    }

    public String getNomeAutor() {
        return "Giulio Dille Girardi";
    }
}