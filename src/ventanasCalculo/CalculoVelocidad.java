package ventanasCalculo;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculoVelocidad extends JPanel{
    private JButton btncalcular;
    private JTextField box1;
    private JTextField box2;
    private JLabel txt1;
    private JLabel txt2;
    CalculoVelocidad(){
        setPreferredSize(new Dimension(0,130));
        TitledBorder Borde = BorderFactory.createTitledBorder("Calculo de la velocidad");
        //Aplicaremos un color al borde
        Borde.setTitleColor(Color.ORANGE);
        setBorder(Borde);

        setLayout(new BorderLayout());
        //lo siguiente, se creara un contenedor para los componentes que se encuentran debajo de la tabla.
        Container contieneOpc = new Container();

        contieneOpc.setLayout(new GridBagLayout());
        //creamos el el objeto restricciones
        GridBagConstraints gbc1 = new GridBagConstraints();

        txt1 = new JLabel("Proporciona la distancia:");
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        gbc1.ipadx = 10;
        gbc1.ipady = 0;
        contieneOpc.add(txt1,gbc1);

        box1 = new JTextField ();
       // box1.setEditable(false);
        gbc1.gridx = 2;
        gbc1.gridy = 0;
        gbc1.ipadx = 100;
        gbc1.ipady = 0;
        gbc1.insets.set(10,0,0,30);
        contieneOpc.add(box1,gbc1);

        txt2 = new JLabel(" Proporciona el tiempo: ");
        gbc1.gridx = 0;
        gbc1.gridy = 2;
        gbc1.ipadx = 0;
        gbc1.ipady = 0;
        contieneOpc.add(txt2,gbc1);

        box2 = new JTextField();
        gbc1.gridx = 2;
        gbc1.gridy = 2;
        gbc1.ipadx = 100;
        gbc1.ipady = 0;

        gbc1.insets.set(10,0,0,30);
        contieneOpc.add(box2,gbc1);
        btncalcular = new JButton("Calcular Velocidad");
        gbc1.gridx = 2;
        gbc1.gridy = 3;
        gbc1.ipadx = 60;
        gbc1.ipady = 0;
        contieneOpc.add(btncalcular,gbc1);

        add(contieneOpc);

        //Oyentes
        accionBotonVelocidad oyenteBtnVelocidad = new accionBotonVelocidad();

        btncalcular.addActionListener(oyenteBtnVelocidad);
    }

    public class accionBotonVelocidad implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e){

            if((JButton )e.getSource() == btncalcular){
                try{
                    //Obtenemos el valor de btncalcular.
                    String distancia = box1.getText() ;
                    String tiempo = box2.getText();
                    //convertir
                    double dist = Double.parseDouble(distancia);
                    double time = Double.parseDouble(tiempo);

                    //aplicamos la formula
                    double velocidad;
                    velocidad = dist / time;

                    JOptionPane.showMessageDialog(null, "RESULTADO DE VELOCIDAD: "+velocidad);
                }catch(Exception x){
                    JOptionPane.showMessageDialog(null,"El dato introducido no es correcto / no hay datos completos");
                }
            }
        }



    }



}
