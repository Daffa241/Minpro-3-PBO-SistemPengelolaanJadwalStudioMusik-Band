# Minpro-3-PBO-Sistem Manajemen Jadwal Studio Musik

Nama: Daffa Rizqi Fadhillah

NIM: 2509116068

Kelas: B


## Deskripsi Singkat Program
Program **Sistem Manajemen Jadwal Studio Musik** adalah aplikasi berbasis Program Java yang dirancang untuk mempermudah pengelolaan jadwal reservasi latihan musik. Aplikasi ini mengimplementasikan arsitektur **MVC (Model-View-Controller)** untuk memisahkan data, logika kontrol, dan antarmuka pengguna. Sistem ini mendukung pencatatan jadwal untuk kategori **Reguler** dan **VIP**, penampilan ringkasan data, pembaruan data, hingga penghapusan jadwal sewa.

---

## Penjelasan Struktur Package & Diagram Proyek
### Penjelasan Peran Package:
1. model: Menyimpan representasi data utama (Jadwal, JadwalReguler, JadwalVIP) dan interface DapatDiskon. Seluruh penanganan properti dan kalkulasi bisnis (seperti perhitungan total sewa dan diskon VIP) berpusat secara murni di package model.
2. controller: Menyimpan StudioController yang bertugas mengelola daftar koleksi (ArrayList), melakukan operasi pencarian ID, pembaruan, serta penghapusan data.
3. view: Menyimpan StudioView untuk menampilkan menu, menerima masukan pengguna, serta melakukan validasi string dan angka.
4. main: Menyimpan kelas Main yang menginisialisasi controller dan view saat aplikasi pertama kali dijalankan.

---

## Penjelasan Alur Program
1. Inisialisasi: Aplikasi dimulai melalui Main.java dengan membuat instansiasi StudioController dan StudioView.

<img width="265" height="142" alt="image" src="https://github.com/user-attachments/assets/bfec9a1e-ab34-4bde-a50a-f5be3826ea3c" />
 
2. Menu Interaktif: Pengguna disajikan menu CLI utama:

Pilihan 1 Tambah Jadwal: Pengguna memasukkan ID, Nama Band, Tanggal dengan format DD-MM-YYYY, Jam, Harga Dasar, serta memilih Kategori Reguler atau VIP.

<img width="286" height="311" alt="image" src="https://github.com/user-attachments/assets/2f184384-2b73-44d8-a91a-cde789244bd9" />

Pilihan 2 Tampilkan Semua Jadwal: Menampilkan rincian detail lengkap dari seluruh jadwal yang tersimpan.

<img width="284" height="323" alt="image" src="https://github.com/user-attachments/assets/f5ec00fd-66ca-4a6a-8248-ab7b3e4a1d73" />

Pilihan 3 Tampilkan Ringkasan Jadwal: Menampilkan ringkasan singkat jadwal menggunakan metode overloading.

<img width="314" height="198" alt="image" src="https://github.com/user-attachments/assets/3cfac63f-ff7b-4b05-9e39-0c22746cdeb0" />

Pilihan 4 Ubah Data Jadwal: Memperbarui nama band, tanggal, jam, atau harga dasar berdasarkan pencarian ID.

<img width="292" height="277" alt="image" src="https://github.com/user-attachments/assets/5b59c225-d1f0-4b39-ab90-d3227beb92c4" />

Pilihan 5 Hapus Jadwal: Menghapus baris jadwal dari memori berdasarkan ID.

<img width="305" height="208" alt="image" src="https://github.com/user-attachments/assets/def0b628-e00a-4c88-845a-2c60e8261a28" />

Pilihan 0 Keluar: Menutup aplikasi.

<img width="297" height="153" alt="image" src="https://github.com/user-attachments/assets/b454ee15-578e-4431-bb1d-f281db476782" />

---

## Penjelasan Penerapan Encapsulation dan Inheritance

### Encapsulation (Pengapsulan)
* Semua atribut pada kelas model dideklarasikan dengan akses modifier private (misalnya private String idJadwal;, private double hargaDasar;).
* Pembacaan dan perubahan nilai atribut diakses secara aman menggunakan metode Getter dan Setter (seperti getIdJadwal(), setHargaDasar()).

### Inheritance (Pewarisan)
* Kelas Jadwal menjadi Superclass (kelas induk).
* Kelas JadwalReguler dan JadwalVIP bertindak sebagai Subclass yang mewarisi atribut serta method umum dari Jadwal menggunakan kata kunci extends. Kedua subclass ini juga memiliki atribut spesifik masing-masing (tipeRuangan pada Reguler dan fasilitasTambahan pada VIP).

---

## Penjelasan Penerapan Polymorphism dan Abstraction

### Abstraction (Abstraksi)
* **Abstract Class**: Kelas Jadwal dideklarasikan sebagai abstract class yang tidak dapat diinstansiasi langsung dan mewajibkan subclass mengimplementasikan metode public abstract double hitungTotalSewa();.
* **Interface**: Interface DapatDiskon memuat kontrak metode hitungDiskon(double persentase yang diimplementasikan khusus oleh kelas JadwalVIP.

### Polymorphism (Polimorfisme)
* **Overriding**: Metode hitungTotalSewa() dan tampilkanInfo() di-override oleh kelas JadwalReguler dan JadwalVIP untuk menghitung total sewa sesuai ketentuan kategorinya.
* **Overloading**: 
  * Pada Jadwal.java: tampilkanInfo() dan tampilkanInfo(boolean ringkas).
  * Pada StudioController.java: ubahJadwal(...) tanpa opsi merubah harga dan ubahJadwal(...) dengan opsi merubah harga dasar.

---

## Penjelasan Letak Penerapan Nilai Tambah
1. **Penerapan Arsitektur MVC Murni**: Pemisahan struktur kode secara rapi ke dalam package model, view, dan controller sesuai standar OOP.
2. **Pembersihan Pesan Notifikasi (Pemberitahuan Ramah Pengguna)**: Menghilangkan istilah kaku seperti kata "error" pada antarmuka pengguna dan menggantinya dengan petunjuk kesalahan yang informatif dan ramah (misal: *"Pilihan harus berupa angka menu yang sesuai"*).
3. **Validasi Kosong & Spasi Ketat**: Penggunaan fungsi inputTidakBolehKosong() di kelas StudioView untuk menjamin masukan seperti Nama Band, Tanggal, dan Jam tidak berupa string kosong maupun karakter spasi belaka.
4. **Petunjuk Format Tanggal Termuat**: Menampilkan panduan format tanggal (DD-MM-YYYY) secara langsung pada petunjuk input pengguna di bagian View.
5. **Penanganan Eksepsi (Exception Handling)**: Penerapan mekanisme try-catch (NumberFormatException) untuk mencegah aplikasi terhenti tiba-tiba jika pengguna memasukkan karakter yang bukan angka pada menu dan harga.
