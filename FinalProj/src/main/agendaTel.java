/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Mustata Dumitru-Sebastian
 */
public class agendaTel extends javax.swing.JFrame {
    
    Agenda agenda = new Agenda();
    DefaultListModel modelLista = new DefaultListModel();
    
    boolean shareware=true;
    public void disableShareware(){
        shareware=false;
        miDeschidere.setEnabled(true);
        miSalvare.setEnabled(true);
        miInregistrare.setEnabled(false);
        lblAdvert.setEnabled(false);
        lblAdvert.setVisible(false);
        tAdverts.cancel();
    }
    
    public void actualizareModel(){
        agenda.ordoneaza(CriteriuOrdonare.values()[cbOrdonare.getSelectedIndex()]);
        int indexFiltru = cbFiltrare.getSelectedIndex();
        switch(indexFiltru){
            case 1:
                agenda.filtrareNrFix();
                break;
            case 2:
                agenda.filtrareNrMobil();
                break;
            case 3:
                agenda.filtrareNascutiLunaCurenta();
                break;
            case 4:
                agenda.filtrareNascutiZiuaCurenta();
                break;
            case 5:
                agenda.filtrarePersonalizata(tfFilter.getText());
                break;
            case 0:
                agenda.faraFiltru();
        }
        modelLista.clear();
        for(Contact c:agenda.contacte())
            modelLista.addElement(c);
    }
    
    public Contact getSelectedContact(){
        return agenda.contacte().get(lAgenda.getSelectedIndex());
    }
    
    
    public agendaTel() {
        initComponents();
        
        lAgenda.setModel(modelLista);
        tfFilter.setText("");
        actualizareModel();
        
        miDeschidere.setEnabled(false);
        miSalvare.setEnabled(false);
        initializeAdverts();
        
        mainPanel.setVisible(false);//se ascunde panel-ul principal, ramanand doar splash screen-ul
        mainPanel.setEnabled(false);
        splashScreen.schedule(splashScreenTask, 1000);//task care va porni dupa 1000ms/1s si va dezactiva splash screen-ul si activa panel-ul principal
    }
    
    Timer splashScreen = new Timer();
    TimerTask splashScreenTask = new TimerTask(){
        public void run(){
            
            //introPanel.setLayer(introPanel, introPanel.highestLayer());
            introPanel.setVisible(false);
            introPanel.setEnabled(false);
            mainPanel.setVisible(true);
            mainPanel.setEnabled(true);
        }
    };

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        introPanel = new javax.swing.JLayeredPane();
        lblJavaIcon = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        mainPanel = new javax.swing.JLayeredPane();
        upperPanel = new javax.swing.JPanel();
        lblFiltrare = new javax.swing.JLabel();
        lblOrdonare = new javax.swing.JLabel();
        cbFiltrare = new javax.swing.JComboBox<>();
        cbOrdonare = new javax.swing.JComboBox<>();
        lblFiltru = new javax.swing.JLabel();
        tfFilter = new javax.swing.JTextField();
        btnFiltrare = new javax.swing.JButton();
        spAgenda = new javax.swing.JScrollPane();
        lAgenda = new javax.swing.JList<>();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lblAdvert = new javax.swing.JLabel();
        mbFisiereAjuto = new javax.swing.JMenuBar();
        mFisiere = new javax.swing.JMenu();
        miDeschidere = new javax.swing.JMenuItem();
        miSalvare = new javax.swing.JMenuItem();
        miIesire = new javax.swing.JMenuItem();
        mAjutor = new javax.swing.JMenu();
        miInregistrare = new javax.swing.JMenuItem();
        miDespre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        introPanel.setOpaque(true);

        lblJavaIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Icons/javaIcon.png"))); // NOI18N

        lblName.setText("Mustata Dumitru-Sebastian");

        introPanel.setLayer(lblJavaIcon, javax.swing.JLayeredPane.DEFAULT_LAYER);
        introPanel.setLayer(lblName, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout introPanelLayout = new javax.swing.GroupLayout(introPanel);
        introPanel.setLayout(introPanelLayout);
        introPanelLayout.setHorizontalGroup(
            introPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(introPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(introPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblName)
                    .addComponent(lblJavaIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        introPanelLayout.setVerticalGroup(
            introPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(introPanelLayout.createSequentialGroup()
                .addContainerGap(130, Short.MAX_VALUE)
                .addComponent(lblJavaIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblName)
                .addContainerGap(206, Short.MAX_VALUE))
        );

        lblFiltrare.setText("Filtrare:");

        lblOrdonare.setText("Ordonare:");

        cbFiltrare.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(fara filtru)", "numar fix", "numar mobil", "nascuti luna curenta", "nascuti astazi", "personalizata" }));
        cbFiltrare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFiltrareActionPerformed(evt);
            }
        });

        cbOrdonare.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "dupa nume", "dupa prenume", "dupa numarul de telefon", "dupa ziua de nastere" }));
        cbOrdonare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbOrdonareActionPerformed(evt);
            }
        });

        lblFiltru.setText("filtru:");

        tfFilter.setText("TextHolder");
        tfFilter.setPreferredSize(new java.awt.Dimension(150, 22));

        btnFiltrare.setText("Filtrare");
        btnFiltrare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrareActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout upperPanelLayout = new javax.swing.GroupLayout(upperPanel);
        upperPanel.setLayout(upperPanelLayout);
        upperPanelLayout.setHorizontalGroup(
            upperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(upperPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(upperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblOrdonare)
                    .addComponent(lblFiltrare))
                .addGap(18, 18, 18)
                .addGroup(upperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(upperPanelLayout.createSequentialGroup()
                        .addComponent(cbFiltrare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblFiltru)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFiltrare))
                    .addComponent(cbOrdonare, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        upperPanelLayout.setVerticalGroup(
            upperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(upperPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(upperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFiltrare)
                    .addComponent(cbFiltrare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFiltru)
                    .addComponent(tfFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiltrare))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(upperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrdonare)
                    .addComponent(cbOrdonare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lAgenda.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        spAgenda.setViewportView(lAgenda);

        btnAdd.setText("Adauga contact");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setText("Editeaza contact selectat");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("Sterge contact selectat");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        lblAdvert.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        mainPanel.setLayer(upperPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mainPanel.setLayer(spAgenda, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mainPanel.setLayer(btnAdd, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mainPanel.setLayer(btnEdit, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mainPanel.setLayer(btnDelete, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mainPanel.setLayer(lblAdvert, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(upperPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spAgenda, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblAdvert, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEdit)))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(upperPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spAgenda, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete)
                    .addComponent(btnAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAdvert, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addContainerGap())
        );

        mFisiere.setText("Fisiere");

        miDeschidere.setText("Deschidere");
        miDeschidere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miDeschidereActionPerformed(evt);
            }
        });
        mFisiere.add(miDeschidere);

        miSalvare.setText("Salvare");
        miSalvare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSalvareActionPerformed(evt);
            }
        });
        mFisiere.add(miSalvare);

        miIesire.setText("Iesire");
        miIesire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miIesireActionPerformed(evt);
            }
        });
        mFisiere.add(miIesire);

        mbFisiereAjuto.add(mFisiere);

        mAjutor.setText("Ajutor");

        miInregistrare.setText("Inregistrare");
        miInregistrare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miInregistrareActionPerformed(evt);
            }
        });
        mAjutor.add(miInregistrare);

        miDespre.setText("Despre");
        miDespre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miDespreActionPerformed(evt);
            }
        });
        mAjutor.add(miDespre);

        mbFisiereAjuto.add(mAjutor);

        setJMenuBar(mbFisiereAjuto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(introPanel)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 492, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(introPanel)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(mainPanel))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        NewContactDialog newContact = new NewContactDialog(this, true);
        newContact.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void cbFiltrareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFiltrareActionPerformed
        actualizareModel();
    }//GEN-LAST:event_cbFiltrareActionPerformed

    private void cbOrdonareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbOrdonareActionPerformed
        actualizareModel();
    }//GEN-LAST:event_cbOrdonareActionPerformed

    private void btnFiltrareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrareActionPerformed
        actualizareModel();
    }//GEN-LAST:event_btnFiltrareActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try{
            if(lAgenda.isSelectionEmpty()==true)
                throw new RuntimeException("Niciun contact selectat");
            JOptionPane.showConfirmDialog(this, "Doriti sa stergeti contactul "+getSelectedContact());
            agenda.sterge(getSelectedContact());
            actualizareModel();
        }catch(RuntimeException re){
            JOptionPane.showMessageDialog(this, re.getMessage());
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        try{
            if(lAgenda.isSelectionEmpty()==true)
                throw new RuntimeException("Niciun contact selectat");
            EditContactDialog editContact = new EditContactDialog(this, true);
            editContact.setVisible(true);
        }catch(RuntimeException re){
            JOptionPane.showMessageDialog(this, re.getMessage());
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void miIesireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miIesireActionPerformed
        String options[] = {"Da", "Nu"};
        int rasp = JOptionPane.showOptionDialog(this, "Doriti parasirea aplicatiei?", "Iesire", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        
        if(rasp==JOptionPane.YES_OPTION){
            if(shareware==false)
                finishSaving();//se mai face o data salvarea in fisier
            System.exit(0);
        }
    }//GEN-LAST:event_miIesireActionPerformed

    private void miDespreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miDespreActionPerformed
        JOptionPane.showMessageDialog(this, "Autor: Mustata Dumitru-Sebastian\nDate de inregistrare:\nuser: admin\nparola: parola123");
    }//GEN-LAST:event_miDespreActionPerformed

    private void miInregistrareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miInregistrareActionPerformed
        InregistrareForm i = new InregistrareForm(this, true);
        i.setVisible(true);
    }//GEN-LAST:event_miInregistrareActionPerformed

    private void miDeschidereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miDeschidereActionPerformed
        //deschiderea unei baze de date este reprezentata doar de adaugarea contactelor din acea baza de date in cea curenta, fara vreo salvare suplimentara
        JFileChooser fc = new JFileChooser(new File("src/Resources/saves"));
        if(fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            try{
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fc.getSelectedFile().getAbsoluteFile()));
                Agenda newAgenda = (Agenda)ois.readObject();
                
                agenda.adaugaMaiMulti(newAgenda);
                actualizareModel();
                
                String sarbatoriti = "Persoane a caror zi de nastere este astazi:\n";
                newAgenda.filtrareNascutiZiuaCurenta();
                for(Contact c: newAgenda.contacte())
                    
                    sarbatoriti = sarbatoriti.concat("->"+c.toString()+"\n");
                JOptionPane.showMessageDialog(this, sarbatoriti);
            }catch(IOException | ClassNotFoundException e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }catch(RuntimeException re){
                System.out.println(re.getMessage());
            }
        }
    }//GEN-LAST:event_miDeschidereActionPerformed

    private void miSalvareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSalvareActionPerformed
        JFileChooser fc = new JFileChooser(new File("src/Resources/saves"));
        fc.setMultiSelectionEnabled(false);
        try{
            if(fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION){
                if(fc.getSelectedFile().toString().toLowerCase().endsWith(".txt"))
                    savingFile=new File(fc.getSelectedFile().toString());
                else
                    savingFile=new File(fc.getSelectedFile().toString().concat(".txt"));
                
                if(!fc.getSelectedFile().exists())
                   savingFile.createNewFile();
                
                initializareSaving();
            }
        }catch(IOException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }catch(RuntimeException re){
            System.out.println(re.getMessage());
        }
    }//GEN-LAST:event_miSalvareActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(agendaTel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(agendaTel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(agendaTel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(agendaTel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new agendaTel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnFiltrare;
    private javax.swing.JComboBox<String> cbFiltrare;
    private javax.swing.JComboBox<String> cbOrdonare;
    private javax.swing.JLayeredPane introPanel;
    private javax.swing.JList<String> lAgenda;
    private javax.swing.JLabel lblAdvert;
    private javax.swing.JLabel lblFiltrare;
    private javax.swing.JLabel lblFiltru;
    private javax.swing.JLabel lblJavaIcon;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblOrdonare;
    private javax.swing.JMenu mAjutor;
    private javax.swing.JMenu mFisiere;
    private javax.swing.JLayeredPane mainPanel;
    private javax.swing.JMenuBar mbFisiereAjuto;
    private javax.swing.JMenuItem miDeschidere;
    private javax.swing.JMenuItem miDespre;
    private javax.swing.JMenuItem miIesire;
    private javax.swing.JMenuItem miInregistrare;
    private javax.swing.JMenuItem miSalvare;
    private javax.swing.JScrollPane spAgenda;
    private javax.swing.JTextField tfFilter;
    private javax.swing.JPanel upperPanel;
    // End of variables declaration//GEN-END:variables

    int currentAdvert, numberOfAdverts;
    File[] advertFiles;
    Timer tAdverts = new Timer();
    private void initializeAdverts(){
        try{
            File advertDir = new File("src/Resources/adds");//imaginile pentru reclame sunt luate dintr-un folder si sunt afisate toate in mod succesiv
            //System.out.println(advertDir.getAbsolutePath());
            advertFiles = advertDir.listFiles(f->f.getName().toLowerCase().endsWith(".jpg"));
            numberOfAdverts = advertFiles.length;
            currentAdvert=0;            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
        this.tAdverts.schedule(advertRefresh, 0, 2000);
    }
    
    TimerTask advertRefresh = new TimerTask() {
        @Override
        public void run() {
            currentAdvert++;//se va alterna advertul curent
            currentAdvert%=numberOfAdverts;
            
            ImageIcon advertImageIcon = new ImageIcon(advertFiles[currentAdvert].getAbsolutePath());
            Image advertImage = advertImageIcon.getImage().getScaledInstance(1280, 720, java.awt.Image.SCALE_SMOOTH);
            
            lblAdvert.setIcon(new ImageIcon(advertFiles[currentAdvert].getAbsolutePath()));
        }
    };
    
    boolean alreadySaving = false;
    File savingFile;
    ObjectOutputStream oos;
    Timer tSaving = new Timer();
    private void initializareSaving(){
        if(alreadySaving == true)//daca se salveaza deja intr-un fisier, se va salva pentru o ultima data
            finishSaving();
        alreadySaving=true;
        try{
            oos = new ObjectOutputStream(new FileOutputStream(savingFile));
            oos.writeObject(agenda);
            tSaving.schedule(saving, 60000, 60000);//salvarea se face o data la un minut (60s/60 000ms), cu un delay de un minut pentru ca deja s-a facut o salvare
        }catch(IOException ioe){
            JOptionPane.showMessageDialog(null, ioe.getMessage());
        }
    }
    
    private void finishSaving(){
        try{
            saving.cancel();
            //tSaving.cancel();
            oos.writeObject(agenda);
            oos.close();
            alreadySaving=false;
        }catch(IOException io){
            JOptionPane.showMessageDialog(null, io.getMessage());
        }
    }
    
    TimerTask saving = new TimerTask(){
        public void run(){
            try{
                oos.writeObject(agenda);
            }catch(IOException io){
                JOptionPane.showMessageDialog(null, io.getMessage());
            }
            
        }
    };
}
