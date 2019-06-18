import java.util.ArrayList;
import java.util.List;

public class ListaRecursiva {
    public static void main(String[] args) {
        //System.out.println(factorial(5));
        List<String> lista = new ArrayList<>();
        System.out.println(lista.toString());
        lista.add("Hola");
        lista.add("Jeff");
        lista.add("Puto");
        lista.add("YaNo");
        System.out.println(lista.size());
        System.out.println(lista.toString());
        System.out.println(lista.remove(2));
        System.out.println(lista.toString());

        System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-");

        Element miLista = new Element();
        System.out.println(miLista.toString());
        miLista.add("Hola");
        miLista.add("Jeff");
        miLista.add("Puto");
        miLista.add("YaNo");
        System.out.println(miLista.size());
        System.out.println(miLista.toString());
        System.out.println(miLista.remove(2));
        System.out.println(miLista.toString());
    }

    private static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}

class Element {
    private int i;
    private String v;
    private Element n;

    private Element(int i, String v) {
        this.i = i;
        this.v = v;
    }

    Element() {
        this.i = -1;
    }

    public boolean isEmpty() {
        return v == null;
    }

    String get(int i) {
        if (i >= 0) {
            if (i == this.i) {
                return v;
            } else {
                return n.get(i);
            }
        } else {
            throw new ArrayIndexOutOfBoundsException(i);
        }
    }

    void add(String v) {
        if (this.v == null) {
            this.i++;
            this.v = v;
        } else {
            if (n == null) {
                n = new Element(i + 1, v);
            } else {
                n.add(v);
            }
        }
    }

    public String toString() {
        String r = (this.i == 0 || this.i == -1) ? "[" : "";
        if (n == null) {
            r += v == null ? "" : i + "-" + v;
        } else {
            r += i + "-" + v + ", " + n.toString();
        }
        return r += this.n == null ? "]" : "";
    }

    public String remove(int i) {
        String r = removeReal(i);
        return r;
    }

    private void order() {
        if(this.n != null) {
            this.n.i--;
            this.n.order();
        }
    }

    private String removeReal(int i) {
        String r;
        if (this.n == null) {
            if (this.i == i) {
                r = this.v;
                this.v = null;
                this.i = -1;
            } else {
                throw new ArrayIndexOutOfBoundsException(i);
            }
        } else {
            if (this.i == i) {
                r = this.v;
                this.v = this.n.v;
                this.n = this.n.n;
                this.order();
            } else {
                if (this.n.i == i) {
                    r = this.n.v;
                    this.n = this.n.n;
                    this.order();
                } else {
                    return this.n.remove(i);
                }
            }
        }
        return r;
    }

    public int size() {
        if (this.v == null) {
            return 0;
        } else {
            if (this.n == null) {
                return 1;
            } else {
                return 1 + this.n.size();
            }
        }
    }
}
