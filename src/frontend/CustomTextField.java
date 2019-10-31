package frontend;

import javax.swing.*;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Esta clase sirve para crear CustomTextFields
 * @author Alumno Amaia y Olatz
 *
 */
 

public class CustomTextField extends JTextField {
 
    private Font originalFont;
    private Color originalForeground;
    private Color placeholderForeground = new Color(160, 160, 160);
    private boolean textWrittenIn;
    
    /**
     * Constructor con par�metros
     * @param columns columnas
     */
    
    public CustomTextField(int columns) {
        super(columns);
    }
    
    /**
     * m�todo para establecer la fuente
     */
 
    @Override
    public void setFont(Font f) {
        super.setFont(f);
        if (!isTextWrittenIn()) {
            originalFont = f;
        }
    }
    
    /**
     * M�todo para establecer el primer plano
     */
 
    @Override
    public void setForeground(Color fg) {
        super.setForeground(fg);
        if (!isTextWrittenIn()) {
            originalForeground = fg;
        }
    }
    
    /**
     * sirve para obtener la localizaci�n
     * @return devuelve la localizaci�n
     */
 
    public Color getPlaceholderForeground() {
        return placeholderForeground;
    }
    
    /**
     * Sirve para establecer la localizaci�n 
     * @param placeholderForeground
     */
 
    public void setPlaceholderForeground(Color placeholderForeground) {
        this.placeholderForeground = placeholderForeground;
    }
    
    /**
     * M�todo para saber si est� escrito
     * @return si est� escrito o no
     */
 
    public boolean isTextWrittenIn() {
        return textWrittenIn;
    }
    
    /**
     * M�todo para establecer si est� escrito
     * @param textWrittenIn texto escrito
     */
 
    public void setTextWrittenIn(boolean textWrittenIn) {
        this.textWrittenIn = textWrittenIn;
    }
    
    /**
     * M�todo para establecer el marcador de posici�n
     * @param text el texto
     */
 
    public void setPlaceholder(final String text) {
 
        this.customizeText(text);
 
        this.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                warn();
            }
 
            @Override
            public void removeUpdate(DocumentEvent e) {
                warn();
            }
 
            @Override
            public void changedUpdate(DocumentEvent e) {
                warn();
            }
 
            public void warn() {
                if (getText().trim().length() != 0) {
                    setFont(originalFont);
                    setForeground(originalForeground);
                    setTextWrittenIn(true);
                }
 
            }
        });
 
        this.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (!isTextWrittenIn()) {
                    setText("");
                }
 
            }
 
            @Override
            public void focusLost(FocusEvent e) {
                if (getText().trim().length() == 0) {
                    customizeText(text);
                }
            }
 
        });
 
    }
    
    /**
     * M�todo del customizeTextField
     * @param text el texto
     */
 
    private void customizeText(String text) {
        setText(text);
        /**If you change font, family and size will follow
         * changes, while style will always be italic**/
        setFont(new Font(getFont().getFamily(), Font.ITALIC, getFont().getSize()));
        setForeground(getPlaceholderForeground());
        setTextWrittenIn(false);
    }
 
}