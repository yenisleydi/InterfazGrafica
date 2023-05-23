import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class FormList extends JFrame{
    private JList<Alumno> jLista;
    private JButton btnMostrar, btnEliminar, btnEliminarTodo, btnRegresar;
    private DefaultListModel<Alumno> elementosModel;

    //CONTENEDORES
    private JPanel panelList, panelButton, panelContainer;


    public FormList() {
        initControl();
        configFrame();
        setControl();
        configPanel();
        add(panelContainer);

        showList();
        eliminar();
        eliminarTodo();
        regresar();

    }

    private void showList() {
        btnMostrar.addActionListener(e -> {
            elementosModel = new DefaultListModel<>();
            ArrayList<Alumno> alumnos = Formulario.getElemento();
            if (!alumnos.isEmpty()) {
                for (Alumno alumno : alumnos) {
                    elementosModel.addElement(alumno);
                }
            }
            jLista.setModel(elementosModel);
        });
    }
    private void eliminar(){
        btnEliminar.addActionListener(e -> {
            Alumno alumnoSeleccionado = jLista.getSelectedValue();
            if (alumnoSeleccionado != null) {
                elementosModel.removeElement(alumnoSeleccionado);
            }
        });
    }


    private void eliminarTodo(){
        btnEliminarTodo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elementosModel.removeAllElements();
            }
        });
    }
    private void regresar() {
        btnRegresar.addActionListener(e -> {
            this.setVisible(false);
            Formulario formulario = new Formulario();
            formulario.setVisible(true);
        });
    }

    private void initControl(){
        jLista = new JList<>();
        panelButton = new JPanel();
        panelList = new JPanel();
        panelContainer = new JPanel();
        btnMostrar = new JButton();
        btnEliminar = new JButton();
        btnEliminarTodo = new JButton();
        btnRegresar = new JButton();
    }

    private void configFrame(){
        setTitle("Lista de elementos");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(420, 420);
    }

    private void setControl(){
        btnMostrar.setText("Mostrar");
        btnEliminar.setText("Eliminar");
        btnEliminarTodo.setText("Eliminar todo");
        btnRegresar.setText("Regresar");
    }

    private void configPanel(){
        panelList.setLayout(new GridLayout(1, 0));
        panelList.add(jLista);
        panelList.setPreferredSize(new Dimension(300,300));

        panelButton.setLayout(new FlowLayout());
        panelButton.setPreferredSize(new Dimension(380, 50));
        panelButton.add(btnMostrar);
        panelButton.add(btnEliminar);
        panelButton.add(btnEliminarTodo);
        panelButton.add(btnRegresar);

        panelContainer.setLayout(new GridLayout(2, 0));
        panelContainer.add(panelList);
        panelContainer.add(panelButton);
    }

}