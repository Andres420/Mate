
import java.util.ArrayList;

public class Resolver_Ecuacion {

    ArrayList<String> ecuacion_separada = new ArrayList<>();
    String respuesta;

    double x2 = 0, x = 0, num = 0;

    /*Este constructor guarda la variable escrita por el usuario*/
    public Resolver_Ecuacion() {

        if (Eventos_Mate.txtFuncion.getText().endsWith(" ")) {
            this.respuesta = Eventos_Mate.txtFuncion.getText();
        } else {
            this.respuesta = Eventos_Mate.txtFuncion.getText() + " ";
        }

    }

    /*Este metodo separa los valores escritos por el usuario*/
    public void resolver() {
        String palabra = "";
        for (int i = 0; i < respuesta.length(); i++) {
            String letra = String.valueOf(respuesta.charAt(i));

            if (letra.equals(" ")) {
                palabra = palabra + letra;
                ecuacion_separada.add(palabra);
                palabra = "";
            } else {
                palabra = palabra + letra;
            }

        }

        for (int i = 0; i < ecuacion_separada.size(); i++) {
            String ecuacion_completa = ecuacion_separada.get(i).toLowerCase();
            if (ecuacion_completa.contains("x^2 ")) {
                if (ecuacion_completa.equals("+x^2 ") || ecuacion_completa.equals("-x^2 ")) {
                    if (ecuacion_completa.equals("+x^2 ")) {
                        x2 += 1;
                    } else {
                        x2 -= 1;
                    }
                } else if (ecuacion_completa.equals("x^2 ")) {
                    x2 += 1;
                } else {
                    String replace1 = ecuacion_completa.replace("x^2 ", "");
                    x2 += Integer.parseInt(replace1);
                }

            } else if (ecuacion_completa.contains("x ")) {
                if (ecuacion_completa.equals("+x ") || ecuacion_completa.equals("-x ")) {
                    if (ecuacion_completa.equals("+x ")) {
                        x += 1;
                    } else {
                        x -= 1;
                    }

                } else if (ecuacion_completa.equals("x ")) {
                    x += 1;
                } else {
                    String replace1 = ecuacion_completa.replace("x ", "");
                    x += Integer.parseInt(replace1);
                }

            } else {
                String replace1 = ecuacion_completa.replace(" ", "");
                num = Integer.parseInt(replace1);
            }
        }
        if (x2 == 0) {
            x2 += 1;
        }
        if (x2 > 0) {
            conUp();
        } else {
            conDown();
        }

    }

    /*Este metodo contiene las operaciones de concava hacia arriba y su orden*/
    private void conUp() {
        boolean solucion = true;
        String concava = "Concava hacia arriba";
        double discri = (x * x) - 4 * x2 * num;
        double ejeSim = -x / 2 * x2;
        double vertice1 = -discri / 4 * x2;
        double interX1 = 0, interX2 = 0;

        String txtEje1 = "(-∞, " + ejeSim + ")";
        String txtEje2 = "(" + ejeSim + ",+∞)";
        String vertice = "(" + ejeSim + "," + vertice1 + ")";
        String interY = "(0," + num + ")";
        String Rango = "[" + vertice1 + ",+∞)";

        if (discri > 0) {
            interX1 = ((-x - Math.sqrt(discri)) / (2 * x2));
            interX2 = ((-x + Math.sqrt(discri)) / (2 * x2));
        } else if (discri == 0) {
            interX1 = ((-x + Math.sqrt(discri)) / (2 * x2));
            interX2 = interX1;
        } else {
            Eventos_Mate.txtRespuesta.setText("a= " + x2 + "\tb= " + x + "\tc= " + num + "\n" + concava + "\n" + "Eje de simetria= " + ejeSim
                    + "\n" + txtEje1 + "\n" + txtEje2 + "\nDiscriminante= " + discri + "\nPunto minimo\nVertice= " + vertice + "\n"
                    + "Rango= " + Rango + "\nIntersecciones= \nX1=?\nX2=?\nY=" + interY);
            solucion = false;
        }
        if (solucion == true) {
            String x_1 = "(" + interX1 + ",0)";
            String x_2 = "(" + interX2 + ",0)";
            Eventos_Mate.txtRespuesta.setText("a= " + x2 + "\tb= " + x + "\tc= " + num + "\n" + concava + "\n" + "Eje de simetria= " + ejeSim
                    + "\n" + txtEje1 + "\n" + txtEje2 + "\nDiscriminante= " + discri + "\nPunto minimo\nVertice= " + vertice + "\n"
                    + "Rango= " + Rango + "\nIntersecciones= \n" + "X1= " + x_1 + "\nX2= " + x_2 + "\nY= " + interY);
        }
    }

    /*Este metodo contiene las operaciones de concava hacia abajo y su orden*/
    private void conDown() {
        boolean solucion = true;
        String concava = "Concava hacia abajo";
        double discri = (x * x) - 4 * x2 * num;
        double ejeSim = -x / 2 * x2;
        double vertice1 = -discri / 4 * x2;
        double interX1 = 0, interX2 = 0;

        String txtEje1 = " (-∞, " + ejeSim + ")";
        String txtEje2 = " (" + ejeSim + ",+∞)";
        String vertice = "(" + ejeSim + "," + vertice1 + ")";
        String interY = "(0," + num + ")";
        String Rango = "(-∞," + vertice1 + "]";

        if (discri > 0) {
            interX1 = ((-x - Math.sqrt(discri)) / (2 * x2));
            interX2 = ((-x + Math.sqrt(discri)) / (2 * x2));
        } else if (discri == 0) {
            interX1 = ((-x + Math.sqrt(discri)) / (2 * x2));
            interX2 = interX1;
        } else {
            Eventos_Mate.txtRespuesta.setText("a= " + x2 + "\tb= " + x + "\tc= " + num + "\n" + concava + "\n" + "Eje de simetria= " + ejeSim
                    + "\n" + txtEje1 + "\n" + txtEje2 + "\nDiscriminante= " + discri + "\nPunto maximo\nVertice= " + vertice + "\n"
                    + "Rango= " + Rango + "\nIntersecciones= \n" + "X1= ?\nX2=?\nY= " + interY);
            solucion = false;
        }
        if (solucion == true) {
            String x_1 = "(" + interX1 + ",0)";
            String x_2 = "(" + interX2 + ",0)";
            Eventos_Mate.txtRespuesta.setText("a= " + x2 + "\tb= " + x + "\tc= " + num + "\n" + concava + "\n" + "Eje de simetria= " + ejeSim
                    + "\n" + txtEje1 + "\n" + txtEje2 + "\nDiscriminante= " + discri + "\nPunto maximo\nVertice= " + vertice + "\n"
                    + "Rango= " + Rango + "\nIntersecciones= \n" + "X1= " + x_1 + "\nX2= " + x_2 + "\nY= " + interY);
        }
    }
}
