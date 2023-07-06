package Package;
import FreshFuls.Admin;
import FreshFuls.adminMainPage;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class deletePackage extends JFrame {
        private final JComboBox pkgComboBox;
	private final JPanel contentPane;

        packageQueries query = new packageQueries();
        String[] allPkgNames = query.selectAllPackageNames();
        List<Package> allPkgList = query.displayPackages();
        Admin currentAdmin;
        
        
        public deletePackage(Admin currentAdmin) {
        this.currentAdmin=currentAdmin;
            
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(0, 0, 630, 640);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	setContentPane(contentPane);
	
	ImageIcon imageIcon = new ImageIcon(getClass().getResource("Artboard 2_1.png"));
	Image img = imageIcon.getImage();
	Image img2 = img.getScaledInstance(630, 640, Image.SCALE_SMOOTH);
	ImageIcon img3 = new ImageIcon(img2);

	contentPane.setLayout(null);
	
	JLabel lblNewLabel_1 = new JLabel("Choose Package :");
	lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
	lblNewLabel_1.setBounds(108, 275, 152, 55);
	contentPane.add(lblNewLabel_1);
	

	 pkgComboBox = new JComboBox(allPkgNames);
	pkgComboBox.setBounds(235, 271, 219, 70);
	contentPane.add(pkgComboBox);
	
	JLabel lblDeleteMeal = new JLabel("Delete Package");
	lblDeleteMeal.setForeground(new Color(153, 102, 0));
	lblDeleteMeal.setFont(new Font("GE SS", Font.BOLD, 25));
	lblDeleteMeal.setBounds(285, 89, 230, 64);
	contentPane.add(lblDeleteMeal);
	
	JButton btnDelete = new JButton("delete");
	btnDelete.setForeground(new Color(143, 188, 143));
	btnDelete.setBackground(new Color(128, 128, 0));
	btnDelete.setBounds(126, 454, 130, 29);
	contentPane.add(btnDelete);
        btnDelete.addActionListener(
                new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                deletePackageButtonActionPerformed(e);            }
                    
                }
        );
	
	JButton btnCancel = new JButton("Back");
	btnCancel.setForeground(new Color(143, 188, 143));
	btnCancel.setBackground(new Color(128, 128, 0));
	btnCancel.setBounds(264, 454, 117, 29);
	contentPane.add(btnCancel);
        btnCancel.addActionListener(
        new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                adminMainPage page = new adminMainPage(currentAdmin);
                page.setLocationRelativeTo(null);
              page.setVisible(true);
              setVisible(false);
            }
        }
        );
	
	JLabel lblNewLabel = new JLabel("");
	lblNewLabel.setBounds(0, 6, 630, 640);
	lblNewLabel.setIcon(img3);
	
		contentPane.add(lblNewLabel);

}
        public void deletePackageButtonActionPerformed(ActionEvent evt){
            
            int result =0;
             int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete "+allPkgNames[pkgComboBox.getSelectedIndex()], "Confirm", JOptionPane.YES_NO_OPTION);
            // 0=yes, 1=no, 2=cancel
            try{
            Package pkgSelected = allPkgList.get(pkgComboBox.getSelectedIndex());
            
            if (confirm==0)
                result = query.deletePackage(pkgSelected.getID());
            
            if (result == 1){
            JOptionPane.showMessageDialog(this, "Package "+allPkgNames[pkgComboBox.getSelectedIndex()]+" deleted successfully!",
            "Package deleted", JOptionPane.PLAIN_MESSAGE);
                   adminMainPage page = new adminMainPage(currentAdmin);
                   page.setLocationRelativeTo(null);
                   page.setVisible(true);
                   setVisible(false);
            }
            else
            JOptionPane.showMessageDialog(this, "Package not deleted!!",
            "Error", JOptionPane.ERROR_MESSAGE);
         
            }
            catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex.getMessage(),
            "Error", JOptionPane.PLAIN_MESSAGE);
        }       

        }
        
}
