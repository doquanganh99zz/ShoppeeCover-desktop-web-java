/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Form;

import java.awt.Image;
import javax.swing.ImageIcon;
import ModelLibraries.Img;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Service.Services;
/**
 *
 * @author PC
 */
public class SignUpForm extends javax.swing.JFrame {

    // This is variable Form do not delete or update if you guys do not understand applacation stream
    private MainForm _mainForm;
    private SignInForm _signInForn;
    private SignUpFormSetUpInfo _signUpFormSetInfo;

    // This is variable Form do not delete or update if you guys do not understand applacation stream
    public SignUpForm(Services s) {
        initComponents();
        
        setLogoAndContent();
        Container con = this.getContentPane();
        con.setBackground(Color.WHITE);
        setLocationRelativeTo(this);
    }

    private void setLogoAndContent() {
        ImageIcon imgLogo = new ImageIcon("C:\\Users\\PC\\Desktop\\jav3\\icon-jav3-signin\\logoshop.png");
        ImageIcon content = new ImageIcon("C:\\Users\\PC\\Desktop\\jav3\\icon-jav3-signin\\content.png");
        ImageIcon footer = new ImageIcon("C:\\Users\\PC\\Desktop\\jav3\\icon-jav3-signin\\footer.png");
        ImageIcon iconFb = new ImageIcon("C:\\Users\\PC\\Desktop\\jav3\\icon-jav3-signin\\icon-fb.png");
        ImageIcon iconGg = new ImageIcon("C:\\Users\\PC\\Desktop\\jav3\\icon-jav3-signin\\icon-gg.png");
        btnSigninFb.setIcon(new ImageIcon(Img.resizer(iconFb.getImage(), 30, 30)));
        btnSigninFb.setText("Facebook");
        btnSigninGg.setIcon(new ImageIcon(Img.resizer(iconGg.getImage(), 30, 30)));
        btnSigninGg.setText("Google");
        jlabelLogo.setIcon(new ImageIcon(Img.resizer(imgLogo.getImage(), 129, 100)));
        jlabelContent.setIcon(new ImageIcon(Img.resizer(content.getImage(), 482, 460)));
        jlabelFooter.setIcon(new ImageIcon(Img.resizer(footer.getImage(), 1376, 245)));

    }

    private boolean checkData() {
        String regexSdt = "^0[1-9][0-9]{8,9}$";
        String regexPassword = "^(?=.*[A-Z])(?=.*[0-9])\\w{6,}$";
        boolean resultCheck = true;
        if (txtSignUpPhoneNumber.getText().trim().length() == 0) {
            txtSignUpPhoneNumber.setForeground(Color.red);
            txtSignUpPhoneNumber.setText("Không được để trống..!");
            resultCheck = false;
        }
        if (String.valueOf(txtSignUpPass.getPassword()).trim().length() == 0) {
            checkerNotification.setForeground(Color.red);
            checkerNotification.setText("Vui lòng nhập mật khẩu..!");
            resultCheck = false;
        } 
        if (String.valueOf(txtSignUpReWritePass.getPassword()).trim().length() == 0) {
            checkerNotification.setForeground(Color.red);
            checkerNotification.setText("Vui lòng nhập mật khẩu..!");
            resultCheck = false;
        } 
        if (!txtSignUpPhoneNumber.getText().trim().matches(regexSdt)) {
            txtSignUpPhoneNumber.setText("Vui lòng nhập đúng số điện thoại..!");
            resultCheck = false;
        }
        if (!String.valueOf(txtSignUpPass.getPassword()).trim().matches(regexPassword) && !String.valueOf(txtSignUpReWritePass.getPassword()).trim().matches(regexPassword)) {
            checkerNotification.setForeground(Color.red);
            checkerNotification.setText("Mật khẩu phải có ít nhất 1 số 1 ký tự in hoa và tối thiểu 8 ký tự..!");
            resultCheck = false;
        } 
        if (!String.valueOf(txtSignUpPass.getPassword()).trim().equals(String.valueOf(txtSignUpReWritePass.getPassword()).trim())) {
            checkerNotification.setForeground(Color.red);
            checkerNotification.setText("Mật khẩu xác nhận không khớp..!");
            resultCheck = false;
        } 
        return resultCheck;
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
        jLabel1 = new javax.swing.JLabel();
        jlabelLogo = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jlabelContent = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtSignUpPhoneNumber = new javax.swing.JTextField();
        btnSetNewAccountInfo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        btnSigninFb = new javax.swing.JButton();
        btnSigninGg = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jlabelSignIn = new javax.swing.JLabel();
        txtSignUpPass = new javax.swing.JPasswordField();
        txtSignUpReWritePass = new javax.swing.JPasswordField();
        checkerNotification = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jlabelFooter = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Shoppee");
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximizedBounds(new java.awt.Rectangle(1376, 979, 979, 979));
        setMaximumSize(new java.awt.Dimension(1376, 979));
        setMinimumSize(new java.awt.Dimension(1376, 979));
        setResizable(false);
        setSize(new java.awt.Dimension(1376, 979));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 87, 35));
        jLabel1.setText("Bạn cần giúp đỡ?");

        jlabelLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabelLogoMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Đăng ký");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addComponent(jlabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 646, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlabelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 21, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(241, 76, 50));
        jPanel2.setMaximumSize(new java.awt.Dimension(1376, 600));
        jPanel2.setMinimumSize(new java.awt.Dimension(1376, 600));
        jPanel2.setPreferredSize(new java.awt.Dimension(1376, 600));

        jlabelContent.setMaximumSize(new java.awt.Dimension(482, 460));
        jlabelContent.setMinimumSize(new java.awt.Dimension(482, 460));
        jlabelContent.setPreferredSize(new java.awt.Dimension(482, 460));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Đăng ký");

        txtSignUpPhoneNumber.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSignUpPhoneNumber.setForeground(new java.awt.Color(204, 204, 204));
        txtSignUpPhoneNumber.setText("Số điện thoại");
        txtSignUpPhoneNumber.setMargin(new java.awt.Insets(2, 10, 2, 2));
        txtSignUpPhoneNumber.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSignUpPhoneNumberMouseClicked(evt);
            }
        });

        btnSetNewAccountInfo.setBackground(new java.awt.Color(241, 76, 50));
        btnSetNewAccountInfo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSetNewAccountInfo.setForeground(new java.awt.Color(255, 255, 255));
        btnSetNewAccountInfo.setText("TIẾP THEO");
        btnSetNewAccountInfo.setBorder(null);
        btnSetNewAccountInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetNewAccountInfoActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));

        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("HOẶC");

        btnSigninFb.setBackground(new java.awt.Color(255, 255, 255));
        btnSigninFb.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnSigninGg.setBackground(new java.awt.Color(255, 255, 255));
        btnSigninGg.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Bằng việc đăng ký bạn đồng ý rằng Quang Anh rất đẹp trai");

        jLabel5.setForeground(new java.awt.Color(241, 76, 50));
        jLabel5.setText("Chính sách về bảo mật ");

        jLabel6.setForeground(new java.awt.Color(241, 76, 50));
        jLabel6.setText("Quyền lợi khách hàng.");

        jLabel7.setText("&&");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("Bạn đã có tài khoản?");

        jlabelSignIn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlabelSignIn.setForeground(new java.awt.Color(241, 76, 50));
        jlabelSignIn.setText("Đăng nhập");
        jlabelSignIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabelSignInMouseClicked(evt);
            }
        });

        txtSignUpPass.setText("123455677889");
        txtSignUpPass.setMargin(new java.awt.Insets(2, 10, 2, 2));
        txtSignUpPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSignUpPassMouseClicked(evt);
            }
        });

        txtSignUpReWritePass.setText("123456789908");
        txtSignUpReWritePass.setMargin(new java.awt.Insets(2, 10, 2, 2));
        txtSignUpReWritePass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSignUpReWritePassMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlabelSignIn))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(btnSigninFb, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnSigninGg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(btnSetNewAccountInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtSignUpPhoneNumber)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtSignUpPass)
                                    .addComponent(txtSignUpReWritePass, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(checkerNotification, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 22, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSignUpPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSignUpPass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSignUpReWritePass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkerNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnSetNewAccountInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSigninFb, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSigninGg, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(jlabelSignIn))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(jlabelContent, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(169, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlabelContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        jlabelFooter.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlabelFooter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlabelFooter, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSignUpPhoneNumberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSignUpPhoneNumberMouseClicked
        txtSignUpPhoneNumber.setText("");
        txtSignUpPhoneNumber.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtSignUpPhoneNumberMouseClicked

    private void txtSignUpPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSignUpPassMouseClicked
        txtSignUpPass.setText("");
        // txtSignUpPass.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtSignUpPassMouseClicked

    private void txtSignUpReWritePassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSignUpReWritePassMouseClicked
        txtSignUpReWritePass.setText("");
        // txtSignUpReWritePass.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtSignUpReWritePassMouseClicked

    private void jlabelLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabelLogoMouseClicked
        _mainForm = new MainForm();
        this.dispose();
        _mainForm.setVisible(true);
    }//GEN-LAST:event_jlabelLogoMouseClicked

    private void jlabelSignInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabelSignInMouseClicked
        _signInForn = new SignInForm();
        this.dispose();
        _signInForn.setVisible(true);
    }//GEN-LAST:event_jlabelSignInMouseClicked

    private void btnSetNewAccountInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetNewAccountInfoActionPerformed
        if (checkData()) {
            checkerNotification.setText("");
            _signUpFormSetInfo = new SignUpFormSetUpInfo("","");
            this.dispose();
            _signUpFormSetInfo.setVisible(true);
        }
        return;
    }//GEN-LAST:event_btnSetNewAccountInfoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSetNewAccountInfo;
    private javax.swing.JButton btnSigninFb;
    private javax.swing.JButton btnSigninGg;
    private javax.swing.JLabel checkerNotification;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel jlabelContent;
    private javax.swing.JLabel jlabelFooter;
    private javax.swing.JLabel jlabelLogo;
    private javax.swing.JLabel jlabelSignIn;
    private javax.swing.JPasswordField txtSignUpPass;
    private javax.swing.JTextField txtSignUpPhoneNumber;
    private javax.swing.JPasswordField txtSignUpReWritePass;
    // End of variables declaration//GEN-END:variables
}
