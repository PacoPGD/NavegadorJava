import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;

public class Navegador extends JFrame {
   private JTextField campo;
   private JEditorPane area;
   public Navegador()
   {

      Container contenedor = getContentPane();
 
      campo = new JTextField( "" );
      campo.addActionListener(
         new ActionListener() {
            
            public void actionPerformed( ActionEvent evento )
            {
               obtenerLaPagina( evento.getActionCommand() );
            }
         } 

      ); 
      contenedor.add( campo, BorderLayout.NORTH );
      
      area = new JEditorPane();
      area.setEditable( false );
      
      area.addHyperlinkListener(
         new HyperlinkListener() {
       
            public void hyperlinkUpdate( HyperlinkEvent evento )
            {
               if ( evento.getEventType() == HyperlinkEvent.EventType.ACTIVATED )
                  obtenerLaPagina( evento.getURL().toString() );
            }
         } 
      ); 

      contenedor.add( new JScrollPane( area ),
      BorderLayout.CENTER );
		
		this.setBounds(400, 50, 500, 500);
      setVisible( true );

   } 

   private void obtenerLaPagina( String ubicacion )
   {
      try {
         area.setPage( ubicacion );
         campo.setText( ubicacion );
      }
      catch ( IOException excepcionES ) {
      }

   } 
} 