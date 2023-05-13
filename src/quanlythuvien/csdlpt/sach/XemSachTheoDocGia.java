/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlythuvien.csdlpt.sach;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hao
 */
public class XemSachTheoDocGia extends javax.swing.JFrame {

    /**
     * Creates new form XemTatCa
     */
    public XemSachTheoDocGia() {
        initComponents();
        layThongTinSach();
    }

    private void layThongTinSach() {
        DefaultTableModel model = (DefaultTableModel)tableSach.getModel();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String serverName = "ADMIN\\EXMACHINA131";
            String databaseName = "QLTV_HANOI";
            String username = "sa";
            String password = "naotomori131";
            
            String url = String.format("jdbc:sqlserver://%s:1433;databaseName=%s;user=%s;password=%s;encrypt=true;trustServerCertificate=true;", serverName, databaseName, username, password);

            con = DriverManager.getConnection(url);
            String sql = "Select Distinct(S.TenSach)\n" +
                        "From \n" +
                        "   	(Select MaDocGia From DocGia Where DiaChi = 'Nghe An') as DG Inner Join\n" +
                        "   	(Select MaDocGia, MaSach From PhieuMuon) as PM on DG.MaDocGia = PM.MaDocGia Inner Join\n" +
                        "   	(Select MaSach,TenSach From Sach) as S on PM.MaSach = S.MaSach\n" +
                        "UNION ALL\n" +
                        "Select Distinct(S.TenSach)\n" +
                        "From\n" +
                        "	(Select MaDocGia From LINK_NA.QLTV_NGHEAN.DBO.DocGia Where DiaChi = 'Nghe An') as DG1 Inner Join\n" +
                        "    (Select MaDocGia,MaSach From LINK_NA.QLTV_NGHEAN.DBO.PhieuMuon) as PM1 on DG1.MaDocGia = PM1.MaDocGia Inner Join \n" +
                        "	(Select MaSach,TenSach From Sach) as S on PM1.MaSach = S.MaSach";    
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()) {
                String tenSach = rs.getString("TenSach");
                Object[] objects = {tenSach};
                model.addRow(objects);
            }
        } catch (Exception e1) {
            System.out.println(e1);
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e2) {}
            try { if (pst != null) pst.close(); } catch (Exception e3) {}
            try { if (con != null) con.close(); } catch (Exception e4) {}
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tableSach = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tableSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ten Sach"
            }
        ));
        jScrollPane1.setViewportView(tableSach);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel1.setText("SACH DUOC MUON BOI DOC GIA NGHE AN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(334, 334, 334))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1218, 847));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(XemSachTheoDocGia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(XemSachTheoDocGia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(XemSachTheoDocGia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(XemSachTheoDocGia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new XemSachTheoDocGia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableSach;
    // End of variables declaration//GEN-END:variables
}