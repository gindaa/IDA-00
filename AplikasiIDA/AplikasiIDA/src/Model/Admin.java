/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Havez
 */
public class Admin {
    public static void tambahPegawai(String id_pegawai, String nama_pegawai, String alamat_pegawai, String jabatan_pegawai, String password){
        Pegawai p;
        p = new Pegawai(id_pegawai,nama_pegawai,alamat_pegawai,jabatan_pegawai,password);
        p.setId_pegawai(id_pegawai);
        p.setNama_pegawai(nama_pegawai);
        p.setAlamat_pegawai(alamat_pegawai);
        p.setJabatan_pegawai(jabatan_pegawai);
        p.setPassword(password);
        
        System.out.println("Data Berhasil Ditambahkan");
    }

}