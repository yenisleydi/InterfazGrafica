import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class Formulario2 extends JFrame{
    private JTable jTable;
    private DefaultTableModel modelo;
    private JButton botonRegresar;

    public Formulario2 (){
        crearBotones();
        initControl();
        configTable();
        configFrame();

    }
    private void crearBotones() {
        botonRegresar = new JButton("Regresar");
        botonRegresar.addActionListener(e -> {
            Formulario formulario = new Formulario();
            formulario.setVisible(true);
            setVisible(false);
        });
    }
    private void initControl(){
        modelo = new DefaultTableModel();
        // DefaultTableModel modelo1 = new DefaultTableModel(UtilTable.usuarios,UtilTable.titulos);
        //modelo.setDataVector(UtilTable.usuarios,UtilTable.titulos);
        modelo.setColumnIdentifiers(Titulos.misTitulos);
        String [] fila = new String[modelo.getColumnCount()];
        // Vector<String> data = new Vector<>(modelo.getColumnCount());
        ArrayList<Alumno> lista = Formulario.getElemento();
        for (Alumno userTable : lista) {
            fila[0] = userTable.getNombre();
            fila[1] = userTable.getApellidos();
            fila[2] = userTable.getTelefono();
            fila[3] = userTable.getIne();
            fila[4] = userTable.getGenero();
            fila[5] = userTable.getSemestre();
            fila[6] = userTable.getCarrera();
            fila[7] = userTable.getMatricular();


            modelo.addRow(fila);
        }
        jTable = new JTable(modelo);
    }
    private void configFrame(){
        setTitle("Tabla de usuarios");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //pack();
        setVisible(true);
        setResizable(false);
        setSize(600, 200);
    }
    private void configTable(){
        jTable.setGridColor(new Color(88, 214, 141));
        jTable.setPreferredScrollableViewportSize(new Dimension(500, 70));
        //Creamos un JscrollPane y le agregamos la JTable
        JScrollPane scrollPane = new JScrollPane(jTable);

        //Agregamos el JScrollPane al contenedor
        getContentPane().add(scrollPane, BorderLayout.CENTER);


    }



}