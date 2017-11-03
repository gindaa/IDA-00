/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.util.Date;
import java.sql.*;
import Model.*;
import View.*;
import database.Database;
import javax.swing.table.TableModel;
import javax.swing.text.View;
/**
 *
 * @author Seagal Putra
 */
public class Handler implements ActionListener {
   /* Class handler berisi penghubung antara gui dengan kodingan
    * gui yang dimaksud berada pada package view dan kodingan yang dimaksud berada pada package model
    */
    private Admin adm;
    private Barang brg;
    private Pegawai pgw;
    private Transaksi tx;
    
    public Handler() throws SQLException {
        app = new Aplikasi();
        view = new View();
        ip = new InsertPeminjaman();
        ib = new InsertBuku();
        vp = new ViewPeminjaman();
        view.setVisible(true);
        view.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        
        try {
            // handler untuk View.java
            if (source.equals(view.getBtExit())) {
                int selectedOption = JOptionPane.showConfirmDialog(null,"Apakah anda ingin menutup aplikasi?","Keluar Aplikasi",JOptionPane.YES_NO_OPTION);
                if (selectedOption == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            } else if (source.equals(view.getBtPinjamBuku())) {
                ip.setVisible(true);
                ip.addActionListener(this);
                view.dispose();
                ip.show();
                ip.showBuku();
            } else if (source.equals(view.getBtTambahBuku())) {
                ib.setVisible(true);
                ib.addActionListener(this);
                view.dispose();
                ib.show();
                ib.showBuku();
            } else if (source.equals(view.getBtLihatPinjam())) {
                vp.setVisible(true);
                vp.addActionListener(this);
                view.dispose();
                vp.show();
            }
            
            //Handler untuk InsertBuku.java
            if (source.equals(ib.getBtReset())) {
                ib.reset();
            } else if (source.equals(ib.getBtSimpan())) {
                Buku bk = new Buku();
                bk.setIdBuku(ib.getTfIdBuku());
                bk.setNamaBuku(ib.getTfNamaBuku());
                bk.setPenerbit(ib.getTfPenerbit());
                bk.setPengarang(ib.getTfPengarang());
                bk.setKategori(ib.getTfKategori());
                bk.setGenre(ib.getTfGenre());
                bk.saveBuku();
                ib.reset();
                ib.showBuku();
            } else if (source.equals(ib.getBtKembali())) {
                view.setVisible(true);
                ib.dispose();
            } else if (source.equals(ib.getBtHapusBuku())) {
                ib.deleteActionPerformed(ae);
                ib.showBuku();
            }
            
            //Handler untuk InsertPeminjaman.java
            if (source.equals(ip.getBtReset())) {
                ip.reset();
            } else if (source.equals(ip.getBtSubmit())) {
                Peminjaman pj = new Peminjaman();
                pj.setIdMember(ip.getTfIdMember());
                pj.setNamaMember(ip.getTfNamaMember());
                pj.setIdBuku(ip.getTfBuku());
                pj.setNamaBuku(ip.getTfNamaBuku());
                pj.setTanggalPinjam(ip.getTglPinjam());
                pj.savePeminjaman();
            //    pj.setDenda(ip.getDenda());
                ip.reset();
            } else if (source.equals(ip.getBtKembali())) {
                view.setVisible(true);
                ip.dispose();
            } else if (source.equals(ip.getBtLihatBuku())) {
                //ip.viewActionPerformed(ae);
            }
            
            //Handler untuk ViewPeminjaman.java
            if (source.equals(vp.getBtKembali())) {
                view.setVisible(true);
                vp.dispose();
            } else if (source.equals(vp.getBtLihat())) {
                Database db = new Database();
                int i = 0;
                ResultSet rs = null;
                try {
                    rs = db.getData("select * from peminjaman");
                    while (rs.next()) {
                        vp.getOutputPeminjaman().setValueAt(rs.getInt("IdPeminjaman"), i, 0);
                        vp.getOutputPeminjaman().setValueAt(rs.getString("IdMember"), i, 1);
                        vp.getOutputPeminjaman().setValueAt(rs.getString("NamaMember"), i, 2);
                        vp.getOutputPeminjaman().setValueAt(rs.getString("IdBuku"), i, 3);
                        vp.getOutputPeminjaman().setValueAt(rs.getString("NamaBuku"), i, 4);
                        vp.getOutputPeminjaman().setValueAt(rs.getDate("tanggalPinjam"), i, 5);
                        i++;
                    }
                    rs.close();
                } catch(Exception e) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Error:"+e.getMessage());
                }
            }
        } catch (NumberFormatException e) {
            
        } catch (Exception e) {
            
        }
    }
}
