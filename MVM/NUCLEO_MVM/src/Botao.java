
import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.objects.ArrayBufferView.buffer;

public class Botao extends javax.swing.JFrame {

    private static short memParm[];
    private String[] args;

    /**
     * Creates new form Botao
     */
    public Botao() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textarea = new javax.swing.JTextArea();
        jbCarregar = new javax.swing.JButton();
        jbSalvar = new javax.swing.JButton();
        jbExecutar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Botao"));

        jButton1.setText("Interrupcao");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Salvar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Carregar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Carregar aquivo fonte");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Executar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        textarea.setColumns(20);
        textarea.setRows(5);
        jScrollPane1.setViewportView(textarea);

        jbCarregar.setText("Carregar");
        jbCarregar.setFocusable(false);
        jbCarregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbCarregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbCarregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCarregarActionPerformed(evt);
            }
        });

        jbSalvar.setText("Salvar");
        jbSalvar.setToolTipText("");
        jbSalvar.setMaximumSize(new java.awt.Dimension(75, 23));
        jbSalvar.setMinimumSize(new java.awt.Dimension(75, 23));
        jbSalvar.setPreferredSize(new java.awt.Dimension(75, 23));
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jbExecutar.setText("Executar");
        jbExecutar.setToolTipText("");
        jbExecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExecutarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jbCarregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbExecutar)
                .addGap(0, 311, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jbCarregar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbExecutar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(288, 288, 288))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCarregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCarregarActionPerformed

        try {
            JFileChooser fc = new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int resultado = fc.showOpenDialog(this);
            if (resultado == JFileChooser.CANCEL_OPTION) {
                System.exit(1);
            }
            File fileName = fc.getSelectedFile();
            FileReader input = new FileReader(fileName);
            BufferedReader bufRead = new BufferedReader(input);
            String linha = null;
            linha = (String) bufRead.readLine();
            textarea.setText("");
            while (linha != null) {
                textarea.append(linha + "\n");
                linha = bufRead.readLine();
            }
            bufRead.close();
        } catch (ArrayIndexOutOfBoundsException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jbCarregarActionPerformed

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        FileDialog Fsalvar = new FileDialog(this, "Salvar Arquivo", FileDialog.SAVE);
        Fsalvar.setVisible(true);

        if (Fsalvar.getFile() == null) {
            return;
        }
        // path // caminho para pasta e nome do arquivo
        String nome_do_arquivo = Fsalvar.getDirectory() + Fsalvar.getFile();
        
        try {
            FileWriter out = new FileWriter(nome_do_arquivo);
            out.write(textarea.getText());
            JOptionPane.showMessageDialog(this, "Arquivo salvo com sucesso!");
            out.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nao foi possível salvar!", " Erro!", JOptionPane.ERROR_MESSAGE);;
        }

//        O código abaixo também funciona
//        String newLine = System.getProperty("line.separator");
//        try {
//            File f = new File(nome_do_arquivo);
//            PrintWriter out = new PrintWriter(new FileOutputStream(f));
//            out.append(textarea.getText());
//            JOptionPane.showMessageDialog(this, "Arquivo salvo com sucesso!");
//            out.flush();
//            out.close();
//        } catch (IOException exc) {
//            JOptionPane.showMessageDialog(this, "Não foi possível salvar a alteração!");
//        }

    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbExecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExecutarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbExecutarActionPerformed

    private void jButton1ActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        MVM.botao = 1;
    }// GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        final int inicio = Integer.parseInt(JOptionPane.showInputDialog("Posição de início do programa"));
        final int fim = Integer.parseInt(JOptionPane.showInputDialog("Posição de fim do programa"));
        try {
            SalvarPrograma.salvar(inicio, fim, memParm);
        } catch (final IOException ex) {
            Logger.getLogger(Botao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        final int posicao = Integer.parseInt(JOptionPane.showInputDialog("Posição onde o programa será gravado"));
        try {
            SalvarPrograma.ler(memParm, posicao);
        } catch (final FileNotFoundException ex) {
            Logger.getLogger(Botao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (final IOException ex) {
            Logger.getLogger(Botao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        final int posicao = Integer.parseInt(JOptionPane.showInputDialog("Posição onde o programa será gravado"));
        try {
            SalvarPrograma.carregaArquivo(memParm, posicao);
        } catch (final FileNotFoundException ex) {
            Logger.getLogger(Botao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (final IOException ex) {
            Logger.getLogger(Botao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        final int posicao = Integer.parseInt(JOptionPane.showInputDialog("Posição onde o programa será gravado"));
        try {
            SalvarPrograma.carregaArquivo(memParm, posicao);
        } catch (final FileNotFoundException ex) {
            Logger.getLogger(Botao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (final IOException ex) {
            Logger.getLogger(Botao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(final String args[], final short mem[]) {
        memParm = mem;
        /*
         * Set the Nimbus look and feel
         */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting
        // code (optional) ">
		/*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.
         * html
         */
        try {
            for (final javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (final ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Botao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (final InstantiationException ex) {
            java.util.logging.Logger.getLogger(Botao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (final IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Botao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (final javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Botao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Botao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbCarregar;
    private javax.swing.JButton jbExecutar;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JTextArea textarea;
    // End of variables declaration//GEN-END:variables
}
