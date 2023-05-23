import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Formulario extends JFrame{
   private static ArrayList<Alumno> alumnos=new ArrayList<>();


    private JPanel paneliz, paneliz1, panelde1, panelde, panelButton, panelForm, panelContainer;
    private JLabel nombre, apellidos, telefono, ine, genero, carrera, semestre, matricula;
    private JTextField text1, text2, text3, text4, text5, text6, text7, text8;
    private JButton boton1, boton2;

    public Formulario() {

        paneliz = new JPanel();
        panelde = new JPanel();
        paneliz1 = new JPanel();
        panelde1 = new JPanel();
        panelButton = new JPanel();
        panelForm = new JPanel();
        panelContainer = new JPanel();

        inicializarComponentes();
        setupFrame();
    }

    private void inicializarComponentes() {
        crearLabels();
        crearTextFields();
        crearBotones();
        crearPanels();
        crearLayouts();
    }

    private void crearLabels() {
        nombre = new JLabel("Nombre");
        apellidos = new JLabel("Apellidos");
        telefono = new JLabel("Telefono");
        ine = new JLabel("INE");
        genero = new JLabel("Genero");
        semestre = new JLabel("Semestre");
        carrera = new JLabel("Carrera");
        matricula = new JLabel("Matricula");
    }

    private void crearTextFields() {
        text1 = new JTextField();
        text2 = new JTextField();
        text3 = new JTextField();
        text4 = new JTextField();
        text5 = new JTextField();
        text6 = new JTextField();
        text7 = new JTextField();
        text8 = new JTextField();
    }

    private void crearBotones() {
        boton1 = new JButton("Aceptar");
        boton2 = new JButton("Consultar");
        boton1.addActionListener(new EventClick());
        boton2.addActionListener(e -> {
            FormList formList = new FormList();
            formList.setVisible(true);
            setVisible(false);
        });
    }


    private void crearPanels() {
        paneliz.setLayout(new GridLayout(4, 0));
        paneliz.add(nombre);
        paneliz.add(apellidos);
        paneliz.add(telefono);
        paneliz.add(ine);

        paneliz1.setLayout(new GridLayout(4, 0));
        paneliz1.add(genero);
        paneliz1.add(semestre);
        paneliz1.add(carrera);
        paneliz1.add(matricula);

        panelde.setLayout(new GridLayout(4, 0));
        panelde.add(text1);
        panelde.add(text2);
        panelde.add(text3);
        panelde.add(text4);

        panelde1.setLayout(new GridLayout(4, 0));
        panelde1.add(text5);
        panelde1.add(text6);
        panelde1.add(text7);
        panelde1.add(text8);

        panelButton.setLayout(new FlowLayout());
        panelButton.setPreferredSize(new Dimension(250, 50));
        panelButton.add(boton1);
        panelButton.add(boton2);
    }

    private void crearLayouts() {
        panelForm.setLayout(new GridLayout(1, 2));
        panelForm.setPreferredSize(new Dimension(600, 100));
        panelForm.add(paneliz);
        panelForm.add(panelde);
        panelForm.add(paneliz1);
        panelForm.add(panelde1);

        panelContainer.setLayout(new GridLayout(2, 0));
        panelContainer.add(panelForm);
        panelContainer.add(panelButton);
    }

    private void setupFrame() {
        setTitle("Formulario");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
        setSize(700, 200);
        add(panelContainer);
    }

    private void clearFields() {
        text1.setText("");
        text2.setText("");
        text3.setText("");
        text4.setText("");
        text5.setText("");
        text6.setText("");
        text7.setText("");
        text8.setText("");
    }
    public static ArrayList<Alumno> getElemento (){
        return alumnos;
    }
    private void query(){
        boton2.addActionListener(e -> {
            FormList formList = new FormList();
            formList.setVisible(true);
            this.setVisible(false);
        });
    }

    public class EventClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nombre = text1.getText();
            String apellidos = text2.getText();
            String telefono = text3.getText();
            String ine = text4.getText();
            String genero = text5.getText();
            String semestre = text6.getText();
            String carrera = text7.getText();
            String matricula = text8.getText();
            alumnos.add(new Alumno(nombre, apellidos, telefono, ine, genero, semestre, carrera, matricula));

            // Mostrar la ventana FormList con los datos actualizados
            FormList formList = new FormList();
            mostrar(alumnos);
            formList.setVisible(true);

            // Limpiar los campos de texto del formulario principal
            clearFields();

        }

        }
    public void mostrar(ArrayList<Alumno> alumnos){
        for (Alumno alumno:alumnos) {
            System.out.println("Nombre: " + alumno.getNombre() + " Apellido: " + alumno.getApellidos() + " Tel: " + alumno.getTelefono() + " Ine: " + alumno.getIne()
                    + " Genero: " + alumno.getGenero() + " Semestre: " + alumno.getSemestre() + " Carrera: " + alumno.getCarrera() + " Matricula: "
                    + alumno.getMatricular());
        }
    }

}
