package arbolAVL.modelo;

import static java.lang.Math.max;

public class ArbolAVL {
///brayan
    private Nodo raiz;

    public ArbolAVL() {
        raiz = null;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    private int altura(Nodo raiz) {
        if (raiz == null) {
            return 0;
        } else {
            return raiz.getAltura();
        }
    }

    public void insertar(Object valor) throws Exception {
        Commparable dato;
        dato = (Commparable) valor;
        raiz = insertarAvl(raiz, dato);
    }

    private Nodo insertarAvl(Nodo raiz, Commparable clave) throws Exception {
        if (raiz == null) {
            return new Nodo(clave);

        }
        if (clave.esMenor(raiz.getValor())) {
            raiz.setIzquierdo(insertarAvl(raiz.getIzquierdo(), clave));
        } else if (clave.esMayor(raiz.getValor())) {
            raiz.setDerecho(insertarAvl(raiz.getDerecho(), clave));
        } else {
            return raiz;
        }
        int a = 1 + max(altura(raiz.getIzquierdo()), altura(raiz.getDerecho()));
        raiz.setAltura(a);
        return realizarequilibrio(raiz);
    }

    private Nodo realizarequilibrio(Nodo nodo) {
        int balance = obtnerbalance(nodo);

        if (balance > 1) {
            Nodo nodohijo = nodo.getDerecho();
            int alturaD = altura(nodohijo.getDerecho());
            int alturaI = altura(nodo.getIzquierdo());
            if (alturaD > alturaI) {
                return RotacionSimpleIsq(nodo);
            } else 
                return RotacionDobleIsq(nodo);
            
        } else if (balance < -1) {
            Nodo nodohijo = nodo.getIzquierdo();
            int alturaD = altura(nodohijo.getDerecho());
            int alturaI = altura(nodo.getIzquierdo());
            if (alturaD < alturaI) {
                return RotacionSimpleDer(nodo);
            } else 
                return RotacionDobleDer(nodo);
            
        }
        return nodo;
    }

    private int max(int a, int b) {
        if (a > b) {
            return a;

        } else {
            return b;
        }
    }

    private int obtnerbalance(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return (altura(nodo.getDerecho()) - altura(nodo.getIzquierdo()));
    }

    private Nodo RotacionSimpleIsq(Nodo nodo) {
        Nodo y = nodo.getDerecho();
        Nodo t2 = y.getIzquierdo();
        y.setIzquierdo(nodo);
        nodo.setDerecho(t2);
        nodo.setAltura(1 + max(altura(nodo.getIzquierdo()), altura(nodo.getDerecho())));
        y.setAltura(1 + max(altura(y.getIzquierdo()), altura(y.getDerecho())));
        return y;
    }

    private Nodo RotacionSimpleDer(Nodo nodo) {
        Nodo x = nodo.getIzquierdo();
        Nodo t2 = x.getDerecho();
        x.setDerecho(nodo);
        nodo.setIzquierdo(t2);
        nodo.setAltura(1 + max(altura(nodo.getIzquierdo()), altura(nodo.getDerecho())));
        x.setAltura(1 + max(altura(x.getIzquierdo()), altura(x.getDerecho())));
        return x;
    }

    private Nodo RotacionDobleIsq(Nodo nodo) {
        nodo.setDerecho(RotacionSimpleDer(nodo.getDerecho()));
        return RotacionSimpleIsq(nodo);
    }

    private Nodo RotacionDobleDer(Nodo nodo) {
        nodo.setIzquierdo(RotacionSimpleIsq(nodo.getIzquierdo()));
        return RotacionSimpleDer(nodo);
    }

    public void elminar(Object valor) throws Exception {

    }

    public void preorden() {
        preorden(raiz);
    }

    private void preorden(Nodo aux) {
        if (aux != null) {
            visitar(aux);
            preorden(aux.getIzquierdo());
            preorden(aux.getDerecho());
        }
    }

    private void visitar(Nodo aux) {
        System.out.print(aux.getValor() + " ");
    }

}
