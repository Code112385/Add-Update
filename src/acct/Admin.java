/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acct;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import javax.swing.table.*;

/**
 *
 * @author senju
 */
public class Admin extends JFrame {

    FileManager fm = new FileManager("C:\\Users\\senju\\Documents\\Java\\acct");

    String[] role = {"Select role", "Manager", "Employee"};
//    static String row[][] = {{"", "12524", "kiwi", "toshi", "dan", "Male", "BSIT", "1", "1CG2"}, {"", "25685", "akashi", "senju", "yin", "Female", "BSIE", "3", "2CG2"}};
    static final String Col[] = {"PICTURE", "USER ID", "LAST NAME", "FIRST NAME", "USER NAME", "GENDER", "ROLE", "EMAIL"};
    DefaultTableModel model = new DefaultTableModel(Col, 0);
    String imgpath;

    //Btn
    JButton addBtn = new JButton("ADD");
    JButton uploadBtn = new JButton("Upload Photo");
    JButton deleteBtn = new JButton("DELETE");
    JButton updateBtn = new JButton("UPDATE");
    JButton clrBtn = new JButton("CLEAR");

    //ComboBox
    JComboBox cb = new JComboBox(role);

    //RadioBtn
    JRadioButton maleRBtn = new JRadioButton("Male");
    JRadioButton femaleRBtn = new JRadioButton("Female");

    //table
    JTable jt = new JTable(model);
    JScrollPane sp = new JScrollPane(jt);

    //group btn
    ButtonGroup gender = new ButtonGroup();

    //Label
    JLabel year = new JLabel("Year:");
    JLabel gndr = new JLabel("Gender:");
    JLabel title = new JLabel("STUDENT INFORMATION");
    JLabel lname = new JLabel("LastName");
    JLabel fname = new JLabel("FirstName");
    JLabel mname = new JLabel("UserName");
    JLabel stuid = new JLabel("User Id");
    JLabel email = new JLabel("Email");
    JLabel userrole = new JLabel("Role");

    JLabel pic = new JLabel();

    //txtF
    JTextField lnametxt = new JTextField();
    JTextField fnametxt = new JTextField();
    JTextField usernametxt = new JTextField();
    JTextField idtxt = new JTextField();
    JTextField emailtxt = new JTextField();

    Admin() {

        add(clrBtn);
        add(deleteBtn);
        add(updateBtn);
        add(uploadBtn);
        add(userrole);
        add(emailtxt);
        add(email);
        add(idtxt);
        add(stuid);
        add(usernametxt);
        add(mname);
        add(fnametxt);
        add(fname);
        add(lnametxt);
        add(pic);
        add(lname);
        add(title);
        add(gndr);
        add(year);
        add(addBtn);
        add(cb);
        add(maleRBtn);
        add(femaleRBtn);
        add(sp);
        gender.add(maleRBtn);
        gender.add(femaleRBtn);

        //Table
        sp.setBounds(105, 350, 800, 100);

        //Btn
        addBtn.setBounds(500, 300, 60, 25);
        updateBtn.setBounds(580, 300, 80, 25);
        deleteBtn.setBounds(680, 300, 80, 25);
        clrBtn.setBounds(780, 300, 80, 25);
        uploadBtn.setBounds(115, 270, 120, 25);

        //Labels
        gndr.setBounds(310, 220, 60, 20);
        title.setBounds(360, 40, 290, 37);
        title.setFont(new Font("Consolas", Font.BOLD, 28));
        lname.setBounds(310, 95, 100, 20);
        fname.setBounds(500, 95, 100, 20);
        mname.setBounds(690, 95, 100, 20);
        stuid.setBounds(310, 150, 100, 20);
        email.setBounds(500, 150, 100, 20);
        userrole.setBounds(690, 150, 100, 20);

        //Radio
        maleRBtn.setBounds(375, 221, 60, 20);
        femaleRBtn.setBounds(440, 221, 80, 20);

        //Picholder
        pic.setSize(150, 150);
        pic.setBounds(100, 100, 150, 150);
        pic.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //txtf
        lnametxt.setBounds(315, 120, 150, 20);
        fnametxt.setBounds(505, 120, 150, 20);
        usernametxt.setBounds(695, 120, 150, 20);
        idtxt.setBounds(315, 175, 150, 20);
        emailtxt.setBounds(505, 175, 150, 20);

        //combobox
        cb.setBounds(695, 175, 150, 19);

        this.setSize(1020, 720);
        this.setLocationRelativeTo(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        // this.add();
        this.setVisible(true);

        uploadBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser fl = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.image", "jpg", "png");
                fl.setCurrentDirectory(new File("C:\\OOP1\\Images"));
                fl.addChoosableFileFilter(filter);

                int rslt = fl.showDialog(null, "Upload");
                if (rslt == JFileChooser.APPROVE_OPTION) {
                    File selectedfile = fl.getSelectedFile();
                    imgpath = selectedfile.getAbsolutePath();
                    ImageIcon newImage = new ImageIcon(imgpath);
                    Image image = newImage.getImage();
                    Image myImage = image.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
                    newImage = new ImageIcon(myImage);
                    pic.setIcon(newImage);
                    System.out.println("Image Uploaded");
                } else {
                    System.out.println("No File Selected");
                }
            }
        });

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = jt.getSelectedRow();
                int message = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Message", JOptionPane.YES_NO_OPTION);
                if (message == 0) {
                    model.removeRow(row);
                    clear();
                }

            }
        });

        jt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = jt.getSelectedRow();

                imgpath = model.getValueAt(row, 0).toString();
                ImageIcon newImage = new ImageIcon(imgpath);
                Image image = newImage.getImage();
                Image myImage = image.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
                newImage = new ImageIcon(myImage);
                pic.setIcon(newImage);

                Object id = model.getValueAt(row, 1).toString();
                Object lastname = model.getValueAt(row, 2).toString();
                Object firstname = model.getValueAt(row, 3).toString();
                Object username = model.getValueAt(row, 4).toString();
                Object gend = model.getValueAt(row, 5).toString();
                Object userrole = model.getValueAt(row, 6).toString();
                Object email = model.getValueAt(row, 7).toString();

                String Id = id != null ? id.toString() : " ";
                String lname = lastname != null ? lastname.toString() : " ";
                String fname = firstname != null ? firstname.toString() : " ";
                String mname = username != null ? username.toString() : " ";
                // String userRole = userrole != null ? userrole.toString() : "";
                String em = email != null ? email.toString() : " ";

                idtxt.setText(Id);
                lnametxt.setText(lname);
                fnametxt.setText(fname);
                usernametxt.setText(mname);
                emailtxt.setText(em);

                if (gend.equals(maleRBtn.getText())) {
                    maleRBtn.setSelected(true);
                } else if (gend.equals(femaleRBtn.getText())) {
                    femaleRBtn.setSelected(true);
                }

                for (String courselist : role) {

                    if (userrole.equals(courselist)) {
                        cb.setSelectedItem(courselist);
                    }
                }

            }

        });

        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(null, "Shehe", "mess", JOptionPane.OK_OPTION);

                int row = jt.getSelectedRow();

                String id = idtxt.getText();
                String lastname = lnametxt.getText();
                String firstname = fnametxt.getText();
                String username = usernametxt.getText();
                String gend = maleRBtn.isSelected() ? "Male" : "Female";
                String role = cb.getSelectedItem().toString();
                String email = emailtxt.getText();
                String pass = username + id;
                
                model.setValueAt(imgpath, row, 0);
                model.setValueAt(id, row, 1);
                model.setValueAt(lastname, row, 2);
                model.setValueAt(firstname, row, 3);
                model.setValueAt(username, row, 4);
                model.setValueAt(gend, row, 5);
                model.setValueAt(role, row, 6);
                model.setValueAt(email, row, 7);
                
                String iD = model.getValueAt(row, 1).toString();
                User updateUser = new User(imgpath, id, lastname, firstname, username, gend, role, email);
                fm.updateUserData(iD, updateUser);
                clear();

            }

        });

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String id = idtxt.getText();
                String lastname = lnametxt.getText();
                String firstname = fnametxt.getText();
                String username = usernametxt.getText();
                String gend = maleRBtn.isSelected() ? "Male" : "Female";
                String role = cb.getSelectedItem().toString();
                String email = emailtxt.getText();
                String pass = username + id;

                User user = new User(imgpath, id, lastname, firstname, username, gend, role, email);
                fm.writeToFile(user);
                Object[] rowData = new Object[]{user.getpic(), user.getId(), user.getLname(), user.getFname(), user.getUsername(), user.getgender(), user.getRole(), user.getEmail()};
                model.addRow(rowData);
                user.setpass(pass);
                System.out.println(pass);

//               model.setValueAt(imgpath, row, 0);
//                model.setValueAt(id, row, 1);
//                model.setValueAt(lastname, row, 2);
//                model.setValueAt(firstname, row, 3);
//                model.setValueAt(midname, row, 4);
//                model.setValueAt(gend, row, 5);
//                model.setValueAt(Course, row, 6);
//                model.setValueAt(Year, row, 7);
//                model.setValueAt(Section, row, 8);
            }
        });

    }

    private void clear() {
        lnametxt.setText("");
        fnametxt.setText("");
        usernametxt.setText("");
        idtxt.setText("");
        emailtxt.setText("");
        pic.setIcon(null);
    }

}
