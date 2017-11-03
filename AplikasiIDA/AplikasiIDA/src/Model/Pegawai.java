/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author GIN
 */
public class Pegawai {
    String id_pegawai;
    String nama_pegawai;
    String alamat_pegawai;
    String jabatan_pegawai;
    String password;

    public Pegawai(String id_pegawai, String nama_pegawai, String alamat_pegawai, String jabatan_pegawai, String password) {
        this.id_pegawai = id_pegawai;
        this.nama_pegawai = nama_pegawai;
        this.alamat_pegawai = alamat_pegawai;
        this.jabatan_pegawai = jabatan_pegawai;
        this.password = password;
    }

    public String getId_pegawai() {
        return id_pegawai;
    }

    public String getNama_pegawai() {
        return nama_pegawai;
    }

    public String getAlamat_pegawai() {
        return alamat_pegawai;
    }

    public String getJabatan_pegawai() {
        return jabatan_pegawai;
    }

    public String getPassword() {
        return password;
    }

    public void setId_pegawai(String id_pegawai) {
        this.id_pegawai = id_pegawai;
    }

    public void setNama_pegawai(String nama_pegawai) {
        this.nama_pegawai = nama_pegawai;
    }

    public void setAlamat_pegawai(String alamat_pegawai) {
        this.alamat_pegawai = alamat_pegawai;
    }

    public void setJabatan_pegawai(String jabatan_pegawai) {
        this.jabatan_pegawai = jabatan_pegawai;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
 public void inputDataPegawai(String id,String nama,String alamat,String jabatan,String pass){
     setId_pegawai(id);
     setNama_pegawai(nama);
     setAlamat_pegawai(alamat);
     setJabatan_pegawai(jabatan);
     setPassword(pass);
 }
}
    