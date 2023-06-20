import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class Formulario extends JFrame implements ChangeListener, ItemListener {
   private static ArrayList<Alumno> alumnos=new ArrayList<>();


    private JPanel paneliz, paneliz1, panelde1, panelde, panelButton,panelRadio, panelForm, panelContainer;
    private JLabel nombre, apellidos, telefono, ine, genero, carrera, semestre, matricula;
    private JTextField text1, text2, text3, text4, text5, text6, text7, text8;
    private JButton boton1, boton2,boton3;
    private JRadioButton radio1,radio2,radio3;
    private ButtonGroup buttonGroup;
    private JComboBox<String> carreras;
    private JComboBox<String> semestres;
    private static final ArrayList<String> listaEstados = Carreras.listaCarrera();
    private static final ArrayList<String> listaSemestre = Carreras.listaSemestre();

    public Formulario() {
        carreras = new JComboBox<>();
        semestres = new JComboBox<>();
        paneliz = new JPanel();
        panelde = new JPanel();
        paneliz1 = new JPanel();
        panelde1 = new JPanel();
        panelRadio=new JPanel();
        panelButton = new JPanel();
        panelForm = new JPanel();
        panelContainer = new JPanel();
        radio1 = new JRadioButton();
        radio2 = new JRadioButton();
        radio3 = new JRadioButton();
        buttonGroup = new ButtonGroup();
        carreras.addItemListener(this);

        inicializarComponentes();
        setupFrame();

    }

    private void inicializarComponentes() {
        crearLabels();
        crearTextFields();
        crearBotones();
        crearPanels();
        crearLayouts();
        llenarCombo();
        radio1.addChangeListener(this);
        radio2.addChangeListener(this);
        radio3.addChangeListener(this);

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
        radio1.setText("Deshabilita uno");
        radio2.setText("Deshabilita dos");
        radio3.setText("Habilitar todo");
        boton1 = new JButton("Aceptar");
        boton2 = new JButton("Consultar");
        boton3=new JButton("Tabla");
        boton1.addActionListener(new EventClick());
        boton2.addActionListener(e ->{
            FormList formList = new FormList();
            formList.setVisible(true);
            setVisible(false);
        } );
        boton3.addActionListener(e -> {
            Formulario2 formulario2 = new Formulario2();
            formulario2.setVisible(true);
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
        panelde1.add(semestres);
        panelde1.add(carreras);
        panelde1.add(text8);

        panelButton.setLayout(new FlowLayout());
        panelButton.setPreferredSize(new Dimension(250, 0));
        panelButton.add(boton1);
        panelButton.add(boton2);
        panelButton.add(boton3);

        panelRadio.setLayout(new FlowLayout());
        panelRadio.setPreferredSize(new Dimension(250, 5));
        buttonGroup.add(radio1);
        buttonGroup.add(radio2);
        buttonGroup.add(radio3);
        panelRadio.add(radio1);
        panelRadio.add(radio2);
        panelRadio.add(radio3);
    }

    private void crearLayouts() {
        panelForm.setLayout(new GridLayout(1, 2));
        panelForm.setPreferredSize(new Dimension(600, 130));
        panelForm.add(paneliz);
        panelForm.add(panelde);
        panelForm.add(paneliz1);
        panelForm.add(panelde1);

        panelContainer.setLayout(new GridLayout(3, 0));
        panelContainer.add(panelForm);
        panelContainer.add(panelRadio);
        panelContainer.add(panelButton);

    }

    private void setupFrame() {
        setTitle("Formulario");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(700, 350);
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
            mostrar(alumnos);

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
    public void stateChanged(ChangeEvent e) {
        if (radio1.isSelected()) {
            text8.setEnabled(false);
        }
        if (radio2.isSelected()) {
            text5.setEditable(false);
            text8.setEditable(false);
        }
        if (radio3.isSelected()) {
            text1.setEditable(true);
            text2.setEditable(true);
            text3.setEditable(true);
            text4.setEditable(true);
            text5.setEditable(true);
            text6.setEditable(true);
            text7.setEditable(true);
            text8.setEditable(true);
        }
    }
    private void llenarCombo() {
        for (String s : listaEstados) {
            carreras.addItem(s);
        }
        for (String semestreItem : listaSemestre) {
            semestres.addItem(semestreItem);
        }
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == carreras) {
            String item = (String) carreras.getSelectedItem();
            text5.setText(item);
        }
    }
}
