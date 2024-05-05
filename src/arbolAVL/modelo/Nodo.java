package arbolAVL.modelo;


public class Nodo {

    private Commparable valor;
    private Nodo izquierdo;
    private Nodo derecho;
    
    private int altura;

    public Nodo() {
        valor = null;
        izquierdo = null;
        derecho = null;
        altura = 1;
    }

    public Nodo(Commparable valor) {
        this.valor = valor;
        izquierdo = null;
        derecho = null;
        altura = 1;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public Commparable getValor() {
        return valor;
    }

    public void setValor(Commparable valor) {
        this.valor = valor;
    }

    public Nodo getIzquierdo() {
        return izquierdo;
    }

    public Nodo getDerecho() {
        return derecho;
    }

    public void setIzquierdo(Nodo izquierdo) {
        this.izquierdo = izquierdo;
    }

    public void setDerecho(Nodo der) {
        this.derecho = der;
    }
}
