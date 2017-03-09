package ch.arc.menu;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.sun.org.apache.bcel.internal.generic.NEW;



public class MainWindow extends JFrame
{
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menuFile = new JMenu("Fichier");
    private JMenu menuAbout = new JMenu("About");
    private JMenuItem menuItemOpen = new JMenuItem("Open");
    private JMenuItem menuItemQuit = new JMenuItem("Quit");
    private JButton btnChoose = new JButton("Choose Folder");
    private JLabel labelFolder = new JLabel("Select Folder:");
    private JTextField textField = new JTextField("Path...");
    private JButton btnStart = new JButton("start");
    private JLabel labelSize = new JLabel();
    private JProgressBar progressBar = new JProgressBar();
    
    private String path;
    
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    void showFileChooser(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.showOpenDialog(this);
        
        if(fileChooser.getSelectedFile()!=null){
            path = fileChooser.getSelectedFile().getAbsolutePath();
            textField.setText(path);
        }
    }
    
    void updateBar(int value){
        progressBar.setValue(value);
    }
    
    void fullProgessBar(){
        for(int i = 0; i< 100; i++){
            final int newValue = i;
            try
            {
                SwingUtilities.invokeLater(new Runnable()
                {
                    
                    @Override
                    public void run()
                    {
                        updateBar(newValue);
                        
                    }
                    
                });
                java.lang.Thread.sleep(10);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    
    
    public MainWindow()
    {
       JPanel panel = new JPanel();
       this.setTitle("File Counter");
       this.setSize(500,300);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setLocationRelativeTo(null);
       
       
       //ProgressBar
       progressBar.setMinimum(0);
       progressBar.setMaximum(100);
       
       //Add menu
       menuBar.add(menuFile);
       menuBar.add(menuAbout);
       
       menuFile.add(menuItemOpen);
       menuFile.add(menuItemQuit);
       
       menuItemOpen.addActionListener(new ActionListener()
    {
        
        @Override
        public void actionPerformed(ActionEvent e)
        {
            showFileChooser();
            
        }
    });
       
       menuItemQuit.addActionListener(new ActionListener()
    {
        
        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
            
        }
    });
       
       btnChoose.addActionListener(new ActionListener()
    {
        
        @Override
        public void actionPerformed(ActionEvent e)
        {
            showFileChooser();
            
        }
    });
       
       btnStart.addActionListener(new ActionListener()
    {
        
        @Override
        public void actionPerformed(ActionEvent e)
        {
            //fullProgessBar();
            MyWorker worker = new MyWorker();
            
            
        }
    });
       
       menuItemOpen.setAccelerator(KeyStroke.getKeyStroke('N', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
       menuItemQuit.setAccelerator(KeyStroke.getKeyStroke('O', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
       

       
       this.setLayout(new GridLayout(4, 0));
       this.setJMenuBar(menuBar);
       panel.add(labelFolder);
       panel.add(textField);
       panel.add(btnChoose);
       
       
       //Layout
       JPanel topPanel = new JPanel(new GridLayout(0, 3));
       topPanel.add(labelFolder, BorderLayout.CENTER);
       topPanel.add(textField, BorderLayout.CENTER);
       topPanel.add(btnChoose, BorderLayout.CENTER);
       this.getContentPane().add(topPanel);
       this.getContentPane().add(labelSize);
       this.getContentPane().add(btnStart);
       this.getContentPane().add(progressBar);

       
       this.setVisible(true);
       
       
       
       
       
       
        
    }
    
    
    

}
