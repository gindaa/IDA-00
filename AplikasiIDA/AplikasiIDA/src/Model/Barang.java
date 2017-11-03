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
public class Barang {
    String id_barang;
    String nama_barang;
    String jenis_barang;
    int stok_barang;
    double harga_barang;
      

    public Barang(String id_barang, String nama_barang, String jenis_barang, int stok_barang, double harga_barang) throws InterruptedException {
        this.id_barang = id_barang;
        this.nama_barang = nama_barang;
        this.jenis_barang = jenis_barang;
        this.stok_barang = stok_barang;
        this.harga_barang = harga_barang;
    }

 
    public String getId_barang() {
        return id_barang;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public String getJenis_barang() {
        return jenis_barang;
    }

    public int getStok_barang() {
        return stok_barang;
    }

    public double getHarga_barang() {
        return harga_barang;
    }

    public void setId_barang(String id_barang) {
        this.id_barang = id_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public void setJenis_barang(String jenis_barang) {
        this.jenis_barang = jenis_barang;
    }

    public void setStok_barang(int stok_barang) {
        this.stok_barang = stok_barang;
    }

    public void setHarga_barang(double harga_barang) {
        this.harga_barang = harga_barang;
    }
    
}
