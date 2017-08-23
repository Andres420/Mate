
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Eventos_Mate extends JApplet {

    public static JTextField txtFuncion, raiz;
    private JPanel PanelSuperior, PanelDerecho, PanelInferior_2;
    public static JTextArea txtRespuesta;
    JLabel respuesta;
    JButton boton = new JButton("Resolver raiz");

    /*Este metodo es ql que inicia el programa*/
    public static void main(String[] args) {
        Eventos_Mate iniciar = new Eventos_Mate();
        iniciar.VisualizaVentana();
    }

    /*Este metodo llama a los otros metodo para los paneles y sus componentes*/
    private void VisualizaVentana() {
        JFrame v = new JFrame("Matematicas");
        construir(v.getContentPane());
        v.pack();
        v.setVisible(true);
        v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        v.setLocationRelativeTo(null);
        JOptionPane.showMessageDialog(this, "Por favor escriba un espacio al separar: \n x^2,x y el numero");
    }

    /*Este metodo es para iniciar la ventana y ver si funciona*/
    @Override
    public void start() {
        construir(this);
    }

    /*Este metodo llama los metodos que crean los componentes
    y los acomoda en la ventana*/
    private void construir(Container contenedor) {
        contenedor.setLayout(new BorderLayout());
        Componentes();
        Componentes_1();
        Componentes_2();
        TxtRespuesta();
        contenedor.setLayout(new BorderLayout());
        contenedor.add(txtRespuesta, BorderLayout.CENTER);
        contenedor.add(PanelSuperior, BorderLayout.NORTH);
        contenedor.add(PanelDerecho, BorderLayout.EAST);
        contenedor.add(PanelInferior_2, BorderLayout.SOUTH);

    }

    /*Este metodo crea el el cuadro donde se escribira la respuesta*/
    private void TxtRespuesta() {
        txtRespuesta = new JTextArea(15, 30);
        txtRespuesta.setFont(new java.awt.Font("Dialog", 0, 18));
        txtRespuesta.setEditable(false);
    }

    /*Crea el panel superior de la ventana es donde el usuario agrega la ecuación*/
    private void Componentes() {
        JLabel lblPregunta = new JLabel("f(x)= ");
        JButton btnResolver = new JButton("Resolver");
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Resolver_Ecuacion eq = new Resolver_Ecuacion();
                eq.resolver();
            }
        };
        btnResolver.addActionListener(listener);
        txtFuncion = new JTextField(25);
        PanelSuperior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        PanelSuperior.add(lblPregunta);
        PanelSuperior.add(txtFuncion);
        PanelSuperior.add(btnResolver);
        PanelSuperior.setLayout(new BoxLayout(PanelSuperior, BoxLayout.X_AXIS));

    }

    /*Crea el panel derecho de la ventana donde el usuario resuelve las raiz que tenga en su ecuación*/
    private void Componentes_1() {
        PanelDerecho = new JPanel();
        JLabel label = new JLabel("Raiz: ");
        PanelDerecho.add(label);
        raiz = new JTextField();
        PanelDerecho.add(raiz);
        respuesta = new JLabel();
        PanelDerecho.add(respuesta);
        PanelDerecho.add(boton);
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double valor = Math.sqrt(Double.parseDouble(raiz.getText()));
                respuesta.setText(String.valueOf(valor));
                raiz.setText("");
            }
        };
        boton.addActionListener(listener);
        PanelDerecho.setLayout(new BoxLayout(PanelDerecho, BoxLayout.Y_AXIS));
    }

    /*Crea el panel inferior de la ventana donde el usuario resuelve operaciones basicas*/
    private void Componentes_2() {
        PanelInferior_2 = new JPanel();
        JButton resolver_operacion = new JButton("Resolver operacion");
        JLabel respuesta_operacion = new JLabel();
        JTextField num_1 = new JTextField();
        JTextField num_2 = new JTextField();
        JComboBox caja = new JComboBox();
        caja.addItem("+");
        caja.addItem("-");
        caja.addItem("*");
        caja.addItem("/");

        PanelInferior_2.add(num_1);
        PanelInferior_2.add(caja);
        PanelInferior_2.add(num_2);

        ActionListener listener1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.valueOf(num_1.getText());
                    double num2 = Double.valueOf(num_2.getText());
                    num_1.setText("");
                    num_2.setText("");
                    switch (caja.getSelectedItem().toString()) {
                        case "+":
                            double respuesta_suma = num1 + num2;
                            respuesta_operacion.setText(num1 + "+" + num2 + " = " + respuesta_suma);
                            break;
                        case "-":
                            double respuesta_resta = num1 - num2;
                            respuesta_operacion.setText(num1 + "-" + num2 + " = " + respuesta_resta);
                            break;
                        case "*":
                            double respuesta_multi = num1 * num2;
                            respuesta_operacion.setText(num1 + "*" + num2 + " = " + respuesta_multi);
                            break;
                        case "/":
                            double respuesta_divi = num1 / num2;
                            respuesta_operacion.setText(num1 + "/" + num2 + " = " + respuesta_divi);
                            break;
                    }
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                }
            }
        };
        resolver_operacion.addActionListener(listener1);
        PanelInferior_2.add(respuesta_operacion);
        PanelInferior_2.add(resolver_operacion);
        PanelInferior_2.setLayout(new BoxLayout(PanelInferior_2, BoxLayout.X_AXIS));
    }
}
