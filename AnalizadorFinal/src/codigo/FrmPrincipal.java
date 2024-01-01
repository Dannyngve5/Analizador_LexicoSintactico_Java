/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package codigo;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.JFileChooser;

/**
 *
 * @author asant
 */
public class FrmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private void analizarLexico() throws IOException {
        int cont = 1;

        String expr = (String) txtResultado.getText();
        Lexico lexico = new Lexico(new StringReader(expr));
        String resultado = "LINEA " + cont + "\t\tSIMBOLO\n";
        while (true) {
            Tokens tokens = lexico.yylex();
            if (tokens == null) {
                resultado += "FIN";
                txtAnalizarLex.setText(resultado);
                return;
            }
            switch (tokens) {
                case Linea:
                    cont++;
                    resultado += "\nLINEA " + cont + "\t\t\tSIMBOLO\n\n";
                    break;
                case ERROR:
                    resultado += "  <Simbolo no definido>\n";
                    break;
                case Numeral:
                    resultado += "  <Reservada Numeral>\t\t" + lexico.lexemas + "\n";
                    break;
                case Include:
                    resultado += "  <Reservada Include>\t\t" + lexico.lexemas + "\n";
                    break;
                case Define:
                    resultado += "  <Reservada Define>\t\t" + lexico.lexemas + "\n";
                    break;
                case Iostream:
                    resultado += "  <Reservada Iostream>\t\t" + lexico.lexemas + "\n";
                    break;
                case Break:
                    resultado += "  <Reservada Break>\t\t" + lexico.lexemas + "\n";
                    break;
                case Case:
                    resultado += "  <Reservada Case>\t\t" + lexico.lexemas + "\n";
                    break;
                case Char:
                    resultado += "  <Tipo de dato Char>\t\t" + lexico.lexemas + "\n";
                    break;
                case Const:
                    resultado += "  <Reservada Const>\t\t" + lexico.lexemas + "\n";
                    break;
                case Continue:
                    resultado += "  <Reservada Continue>\t\t" + lexico.lexemas + "\n";
                    break;
                case Default:
                    resultado += "  <Reservada Default>\t\t" + lexico.lexemas + "\n";
                    break;
                case Do:
                    resultado += "  <Funcion Do>\t\t" + lexico.lexemas + "\n";
                    break;
                case Double:
                    resultado += "  <Tipo de dato Double>\t\t" + lexico.lexemas + "\n";
                    break;
                case Float:
                    resultado += "  <Tipo de dato Float>\t\t" + lexico.lexemas + "\n";
                    break;
                case For:
                    resultado += "  <Funcion For>\t\t" + lexico.lexemas + "\n";
                    break;
                case If:
                    resultado += "  <Funcion If>\t\t\t" + lexico.lexemas + "\n";
                    break;
                case Else:
                    resultado += "  <Reservada Else>\t\t" + lexico.lexemas + "\n";
                    break;
                case Int:
                    resultado += "  <Tipo de dato Int>\t\t" + lexico.lexemas + "\n";
                    break;
                case Long:
                    resultado += "  <Tipo de dato Long>\t\t" + lexico.lexemas + "\n";
                    break;
                case Register:
                    resultado += "  <Reservada Register>\t\t" + lexico.lexemas + "\n";
                    break;
                case Return:
                    resultado += "  <Reservada Return>\t\t" + lexico.lexemas + "\n";
                    break;
                case Short:
                    resultado += "  <Tipo de dato Short>\t\t" + lexico.lexemas + "\n";
                    break;
                case Byte:
                    resultado += "  <Tipo de dato Byte>\t\t" + lexico.lexemas + "\n";
                    break;
                case Bool:
                    resultado += "  <Tipo de dato Bool>\t\t" + lexico.lexemas + "\n";
                    break;
                case Unsigned:
                    resultado += "  <Reservada Unsigned>\t\t" + lexico.lexemas + "\n";
                    break;
                case Struct:
                    resultado += "  <Reservada Struct>\t\t" + lexico.lexemas + "\n";
                    break;
                case Switch:
                    resultado += "  <Funcion Switch>\t\t" + lexico.lexemas + "\n";
                    break;
                case Typedef:
                    resultado += "  <Reservada Typedef>\t\t" + lexico.lexemas + "\n";
                    break;
                case Void:
                    resultado += "  <Reservada Void>\t\t" + lexico.lexemas + "\n";
                    break;
                case While:
                    resultado += "  <Funcion While>\t\t" + lexico.lexemas + "\n";
                    break;
                case Cadena:
                    resultado += "  <Tipo de dato String>\t\t" + lexico.lexemas + "\n";
                    break;
                case Comillas:
                    resultado += "  <Comillas>\t\t" + lexico.lexemas + "\n";
                    break;
                case Igual:
                    resultado += "  <Operador Igual>\t\t" + lexico.lexemas + "\n";
                    break;
                case Suma:
                    resultado += "  <Operador Suma>\t\t" + lexico.lexemas + "\n";
                    break;
                case Resta:
                    resultado += "  <Operador Resta>\t\t" + lexico.lexemas + "\n";
                    break;
                case Multiplicacion:
                    resultado += "  <Operador Multiplicacion>\t\t" + lexico.lexemas + "\n";
                    break;
                case Division:
                    resultado += "  <Operador Division>\t\t" + lexico.lexemas + "\n";
                    break;
                case Modulo:
                    resultado += "  <Operador Modulo>\t\t" + lexico.lexemas + "\n";
                    break;
                case Conjuncion:
                    resultado += "  <Operador Conjunción>\t\t" + lexico.lexemas + "\n";
                    break;
                case Disyuncion:
                    resultado += "  <Operador Disyunción>\t\t" + lexico.lexemas + "\n";
                    break;
                case Negacion:
                    resultado += "  <Operador Negación>\t\t" + lexico.lexemas + "\n";
                    break;
                case MayorQue:
                    resultado += "  <Mayor Que>\t\t" + lexico.lexemas + "\n";
                    break;
                case MenorQue:
                    resultado += "  <Menor Que>\t\t" + lexico.lexemas + "\n";
                    break;
                case EsIgual:
                    resultado += "  <Es Igual>\t\t" + lexico.lexemas + "\n";
                    break;
                case Diferente:
                    resultado += "  <Operador Diferente>\t\t" + lexico.lexemas + "\n";
                    break;
                case MayorIgual:
                    resultado += "  <Mayor Igual>\t\t" + lexico.lexemas + "\n";
                    break;
                case MenorIgual:
                    resultado += "  <Menor Igual>\t\t" + lexico.lexemas + "\n";
                    break;
                case ConjuncionBit:
                    resultado += "  <ConjuncionBit>\t\t" + lexico.lexemas + "\n";
                    break;
                case DisyuncionBit:
                    resultado += "  <DisyuncionBit>\t\t" + lexico.lexemas + "\n";
                    break;
                case DesplazamientoI:
                    resultado += "  <Operador Desplazamiento izquierda>\t\t" + lexico.lexemas + "\n";
                    break;
                case DesplazamientoD:
                    resultado += "  <Operador Desplazamiento derecha>\t\t" + lexico.lexemas + "\n";
                    break;
                case AsignacionSuma:
                    resultado += "  <Asignacion Suma>\t\t" + lexico.lexemas + "\n";
                    break;
                case AsignacionResta:
                    resultado += "  <Asignacion Resta>\t\t" + lexico.lexemas + "\n";
                    break;
                case AsignacionMultiplicacion:
                    resultado += "  <Asignacion Multiplicacion>\t\t" + lexico.lexemas + "\n";
                    break;
                case AsignacionDivision:
                    resultado += "  <Asignacion Division>\t\t" + lexico.lexemas + "\n";
                    break;
                case AsignacionModulo:
                    resultado += "  <Asignacion Modulo>\t\t" + lexico.lexemas + "\n";
                    break;
                case Incremento:
                    resultado += "  <Operador Incremento>\t\t" + lexico.lexemas + "\n";
                    break;
                case Decremento:
                    resultado += "  <Operador Decremento>\t\t" + lexico.lexemas + "\n";
                    break;
                case True:
                    resultado += "  <Operador True>\t\t" + lexico.lexemas + "\n";
                    break;
                case False:
                    resultado += "  <Operador False>\t\t" + lexico.lexemas + "\n";
                    break;
                case Parent_a:
                    resultado += "  <Parentesis de apertura>\t\t" + lexico.lexemas + "\n";
                    break;
                case Parent_c:
                    resultado += "  <Parentesis de cierre>\t\t" + lexico.lexemas + "\n";
                    break;
                case Llave_a:
                    resultado += "  <Llave de apertura>\t\t" + lexico.lexemas + "\n";
                    break;
                case Llave_c:
                    resultado += "  <Llave de cierre>\t\t" + lexico.lexemas + "\n";
                    break;
                case Corchete_a:
                    resultado += "  <Corchete de apertura>\t\t" + lexico.lexemas + "\n";
                    break;
                case Corchete_c:
                    resultado += "  <Corchete de cierre>\t\t" + lexico.lexemas + "\n";
                    break;
                case Main:
                    resultado += "  <Marcador de inicio de algoritmo>\t\t" + lexico.lexemas + "\n";
                    break;
                case P_coma:
                    resultado += "  <Punto y Coma>\t\t" + lexico.lexemas + "\n";
                    break;
                case Punto:
                    resultado += "  <Punto>\t\t" + lexico.lexemas + "\n";
                    break;
                case DosPuntos:
                    resultado += "  <Dos Puntos>\t\t" + lexico.lexemas + "\n";
                    break;
                case Coma:
                    resultado += "  <Coma>\t\t" + lexico.lexemas + "\n";
                    break;
                case Identificador:
                    resultado += "  <Identificador>\t\t" + lexico.lexemas + "\n";
                    break;
               /* case Numero:
                    resultado += "  <Numero>\t\t\t\t" + lexico.lexemas + "\n";
                    break;*/
                case PrintF:
                    resultado += "  <Funcion Printf>\t\t" + lexico.lexemas + "\n";
                    break;
                case ScanF:
                    resultado += "  <Funcion ScanF>\t\t" + lexico.lexemas + "\n";
                    break;
                case Cin:
                    resultado += "  <Funcion Cin>\t\t" + lexico.lexemas + "\n";
                    break;
                case Cout:
                    resultado += "  <Funcion Cout>\t\t" + lexico.lexemas + "\n";
                    break;
                case Using:
                    resultado += "  <Funcion Using>\t\t" + lexico.lexemas + "\n";
                    break;
                case Namespace:
                    resultado += "  <Funcion Namespace>\t\t" + lexico.lexemas + "\n";
                    break;
                case Std:
                    resultado += "  <Funcion Std>\t\t" + lexico.lexemas + "\n";
                    break;
                case Endl:
                    resultado += "  <Reservada Endl>\t\t" + lexico.lexemas + "\n";
                    break;
                case Overrides:
                    resultado += "  <Reservada Overridel>\t\t" + lexico.lexemas + "\n";
                case Util:
                    resultado += "  <Reservada Util>\t\t" + lexico.lexemas + "\n";
                case Abstract:
                    resultado += "  <Reservada Abstract>\t\t" + lexico.lexemas + "\n";
                case Assert:
                    resultado += "  <Reservada Assert>\t\t" + lexico.lexemas + "\n";
                case Cath:
                    resultado += "  <Reservada Cath>\t\t" + lexico.lexemas + "\n";
                case Class:
                    resultado += "  <Reservada Class>\t\t" + lexico.lexemas + "\n";
                case Enum:
                    resultado += "  <Reservada Enum>\t\t" + lexico.lexemas + "\n";
                case Extends:
                    resultado += "  <Reservada Extends>\t\t" + lexico.lexemas + "\n";
                    case Final:
                    resultado += "  <Reservada Final>\t\t" + lexico.lexemas + "\n";
                    case Finally:
                    resultado += "  <Reservada Finally>\t\t" + lexico.lexemas + "\n";
                    case Goto:
                    resultado += "  <Reservada Goto>\t\t" + lexico.lexemas + "\n";
                    case Implements:
                    resultado += "  <Reservada Implements>\t\t" + lexico.lexemas + "\n";
                    case Import:
                    resultado += "  <Reservada Import>\t\t" + lexico.lexemas + "\n";
                    case Instanceof:
                    resultado += "  <Reservada Instanceof>\t\t" + lexico.lexemas + "\n";
                    case Interface:
                    resultado += "  <Reservada Interface>\t\t" + lexico.lexemas + "\n";
                    case Native:
                    resultado += "  <Reservada Native>\t\t" + lexico.lexemas + "\n";
                    case Private:
                    resultado += "  <Reservada Private>\t\t" + lexico.lexemas + "\n";
                    case Protected:
                    resultado += "  <Reservada Protected>\t\t" + lexico.lexemas + "\n";
                    case Public:
                    resultado += "  <Reservada Public>\t\t" + lexico.lexemas + "\n";
                    case Static:
                    resultado += "  <Reservada Static>\t\t" + lexico.lexemas + "\n";
                    case Super:
                    resultado += "  <Reservada Super>\t\t" + lexico.lexemas + "\n";
                    case This:
                    resultado += "  <Reservada This>\t\t" + lexico.lexemas + "\n";
                    case Throw:
                    resultado += "  <Reservada Throw>\t\t" + lexico.lexemas + "\n";
                    case Try:
                    resultado += "  <Reservada Try>\t\t" + lexico.lexemas + "\n";
                    case Volatile:
                    resultado += "  <Reservada Volatile>\t\t" + lexico.lexemas + "\n";
                    case Transient:
                    resultado += "  <Reservada Transient>\t\t" + lexico.lexemas + "\n";
                    case Synchronized:
                    resultado += "  <Reservada Synchronized>\t\t" + lexico.lexemas + "\n";
                    case Arroba:
                    resultado += "  <Símbolo Arroba>\t\t" + lexico.lexemas + "\n";
                    case Union:
                    resultado += "  <Reservada Union>\t\t" + lexico.lexemas + "\n";
                    case NumeroR:
                    resultado += "  <Número real positivo>\t\t" + lexico.lexemas + "\n";
                    case NumeroR_negativo:
                    resultado += "  <Número real negativo>\t\t" + lexico.lexemas + "\n";
                    
                default:
                    resultado += "  < " + lexico.lexemas + " >\n";
                    break;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnArchivo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        btnLimpiarLex = new javax.swing.JButton();
        btnAnalizarLex = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAnalizarLex = new javax.swing.JTextArea();
        btnGuardar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnAnalizarSin = new javax.swing.JButton();
        btnLimpiarSin = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAnalizarSin = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Analizador Lexico", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 24))); // NOI18N

        btnArchivo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnArchivo.setText("Subir Archivo");
        btnArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchivoActionPerformed(evt);
            }
        });

        txtResultado.setColumns(20);
        txtResultado.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtResultado.setRows(5);
        jScrollPane1.setViewportView(txtResultado);

        btnLimpiarLex.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnLimpiarLex.setText("Borrar");
        btnLimpiarLex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarLexActionPerformed(evt);
            }
        });

        btnAnalizarLex.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnAnalizarLex.setText("Analizar");
        btnAnalizarLex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarLexActionPerformed(evt);
            }
        });

        txtAnalizarLex.setEditable(false);
        txtAnalizarLex.setColumns(20);
        txtAnalizarLex.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtAnalizarLex.setRows(5);
        jScrollPane2.setViewportView(txtAnalizarLex);

        btnGuardar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Analizador Sintactico", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 24))); // NOI18N

        btnAnalizarSin.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnAnalizarSin.setText("Analizar");
        btnAnalizarSin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarSinActionPerformed(evt);
            }
        });

        btnLimpiarSin.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnLimpiarSin.setText("Borrar");
        btnLimpiarSin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarSinActionPerformed(evt);
            }
        });

        txtAnalizarSin.setEditable(false);
        txtAnalizarSin.setColumns(20);
        txtAnalizarSin.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtAnalizarSin.setRows(5);
        jScrollPane3.setViewportView(txtAnalizarSin);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAnalizarSin, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpiarSin, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnalizarSin)
                    .addComponent(btnLimpiarSin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnLimpiarLex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAnalizarLex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnalizarLex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimpiarLex))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarSinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarSinActionPerformed
        txtAnalizarSin.setText(null);
    }//GEN-LAST:event_btnLimpiarSinActionPerformed

    private void btnAnalizarSinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarSinActionPerformed
        String ST = txtResultado.getText();
        Sintaxis s = new Sintaxis(new codigo.LexicoCup(new StringReader(ST)));

        try {
            s.parse();
            txtAnalizarSin.setText("Analisis realizado correctamente");
            txtAnalizarSin.setForeground(new Color(25, 111, 61));
        } catch (Exception ex) {
            Symbol sym = s.getS();
            txtAnalizarSin.setText("Error de sintaxis. Linea: " + (sym.right + 1) + " Columna: " + (sym.left + 1) + ", Texto: \"" + sym.value + "\"");
            txtAnalizarSin.setForeground(Color.red);
        }
    }//GEN-LAST:event_btnAnalizarSinActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {

            JFileChooser escoger = new JFileChooser();
            if (escoger.showDialog(null, "Guardar") == JFileChooser.APPROVE_OPTION) {
                File file = escoger.getSelectedFile();
                if (file.getName().endsWith("cpp")) {
                    String doc = txtResultado.getText();
                    boolean successful = saveFile(file, doc);
                    if (successful) {
                        System.out.println("Archivo guardado con exito");
                    }
                }
            }
        } catch (Exception e) {
            //
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnAnalizarLexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarLexActionPerformed
        try {
            analizarLexico();
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAnalizarLexActionPerformed

    private void btnLimpiarLexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarLexActionPerformed
        txtAnalizarLex.setText(null);
    }//GEN-LAST:event_btnLimpiarLexActionPerformed

    private void btnArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchivoActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File archivo = new File(chooser.getSelectedFile().getAbsolutePath());

        try {
            String ST = new String(Files.readAllBytes(archivo.toPath()));
            txtResultado.setText(ST);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnArchivoActionPerformed

    private boolean saveFile(File file, String doc) {
        String message = null;
        try {
            FileOutputStream out = new FileOutputStream(file);
            byte[] bytxt = doc.getBytes();
            out.write(bytxt);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @param args the command line arguments
     */

    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalizarLex;
    private javax.swing.JButton btnAnalizarSin;
    private javax.swing.JButton btnArchivo;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiarLex;
    private javax.swing.JButton btnLimpiarSin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea txtAnalizarLex;
    private javax.swing.JTextArea txtAnalizarSin;
    private javax.swing.JTextArea txtResultado;
    // End of variables declaration//GEN-END:variables
}
