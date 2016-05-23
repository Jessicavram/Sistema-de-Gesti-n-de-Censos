
package Vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Rectangle;

public interface Componentes
{
    public final Color ColorPrincipal = new Color(0,114,188);
    public final Color BlancoEtiqueta = Color.WHITE;
    public final Color NegroEtiqueta = Color.BLACK;
    public final Color RojoEtiqueta = new Color(192,0,0);
    public final Font Etiqueta = new Font("Calibri",Font.BOLD,16);
    public final Font Titulo = new Font("Calibri",Font.BOLD,24);
    public final Font Boton = new Font("Calibri",Font.BOLD,16);
    public final int TamFuncion = 150;
    public final Rectangle dimForms = new Rectangle(3,3,1018,765);
    public final ImageIcon logo = new ImageIcon("Imagenes/logo.png");
    public final ImageIcon usuario = new ImageIcon("Imagenes/usuario.png");
    public final ImageIcon word = new ImageIcon("Imagenes/word.png");
    public final ImageIcon flecha = new ImageIcon("Imagenes/atras.png");
}
