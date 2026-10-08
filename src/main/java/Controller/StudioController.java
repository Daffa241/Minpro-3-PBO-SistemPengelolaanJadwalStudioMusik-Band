/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author ASUS
 */
import model.Jadwal;
import java.util.ArrayList;

public class StudioController {
    private ArrayList<Jadwal> daftarJadwal = new ArrayList<>();

    public void tambahJadwal(Jadwal jadwal) {
        daftarJadwal.add(jadwal);
    }

    public ArrayList<Jadwal> getDaftarJadwal() {
        return daftarJadwal;
    }

    public Jadwal cariJadwalBerdasarkanId(String idJadwal) {
        for (Jadwal j : daftarJadwal) {
            if (j.getIdJadwal().equalsIgnoreCase(idJadwal.trim())) {
                return j;
            }
        }
        return null;
    }

    // Overloading ubahJadwal (tanpa ubah harga)
    public boolean ubahJadwal(String idJadwal, String namaBaru, String tanggalBaru, String jamBaru) {
        Jadwal j = cariJadwalBerdasarkanId(idJadwal);
        if (j != null) {
            j.setNamaBand(namaBaru);
            j.setTanggal(tanggalBaru);
            j.setJam(jamBaru);
            return true;
        }
        return false;
    }

    // Overloading ubahJadwal (dengan ubah harga)
    public boolean ubahJadwal(String idJadwal, String namaBaru, String tanggalBaru, String jamBaru, double hargaBaru) {
        Jadwal j = cariJadwalBerdasarkanId(idJadwal);
        if (j != null) {
            j.setNamaBand(namaBaru);
            j.setTanggal(tanggalBaru);
            j.setJam(jamBaru);
            j.setHargaDasar(hargaBaru);
            return true;
        }
        return false;
    }

    public boolean hapusJadwal(String idJadwal) {
        Jadwal j = cariJadwalBerdasarkanId(idJadwal);
        if (j != null) {
            daftarJadwal.remove(j);
            return true;
        }
        return false;
    }
}
