## 🏨 HealInn Hotel & Convention Center

## 📝 Deskripsi Singkat Proyek
HealInn adalah aplikasi desktop berbasis JavaFX yang dirancang untuk membantu pengelolaan reservasi hotel secara digital. Aplikasi ini memungkinkan customer untuk memesan kamar dan ballroom secara mandiri, serta memberikan admin kemampuan memantau seluruh operasional hotel melalui dashboard yang informatif.
Aplikasi ini dibuat sebagai Proyek Akhir mata kuliah Pemrograman Berorientasi Objek, dengan fokus pada penerapan prinsip OOP secara menyeluruh.

## 👥 Tim Pengembang

- **[Karis Kabanga] (https://github.com/kariskabanga65)** ('H071251059')
- **[Zahra Intan Pratiwi] (https://github.com/zahrara06-alt)** ('H071251004)
- **[Fadhiyah Syafikah Firman] (https://github.com/fadhiyahsyafikah)** ('H071251019)

## 🎨 Tema

**Perhotelan**: Aplikasi untuk manajemen reservasi kamar, ballroom, dan pemantauan operasional hotel.

## ✨ Fitur Aplikasi
👤 CUSTOMER
- 🔐 Registrasi akun baru dengan username, email, dan password.
- 🔑 Login dengan validasi akun dari database.
- 🛏️ melihat dan memilih kamar yang tersedia (Standard, Deluxe, Suite x Twin Bed/ Double Bed).
- 📅 Reservasi kamar dengan pilihan tanggal check-in dan check-out.
- 💳 Input nominal pembayaran sebagai konfirmasi transaksi.
- 🏛️ Reservasi ballroom dengan 3 pilihan paket durasi.
- 🎯 Mengisi Tujuan penggunaan Ballroom saat reservasi.
- 📋 Melihat riwayat seluruh reservasi pribadi.
- ❌ Membatalkan reservasi yang masih aktif.

🔑 ADMIN
- 📊 Dashboard statistik: jumlah kamar terisi, tamu aktif, dan total pendapatan.
- 🏨 Grid visual status 60 kamar (hijau = tersedia, merah = terisi).
- 📋 Tabel seluruh transaksi reservasi dari semua customer.

## 🔄 Alur Kerja Aplikasi
```text
Buka Aplikasi
└── Pilih Role
    ├── Customer
    │   ├── Login / Daftar Baru
    │   └── Dashboard
    │       ├── Pilih Kamar → Isi Tanggal → Input Pembayaran → Konfirmasi
    │       ├── Ballroom → Pilih Paket → Isi Tanggal & Tujuan → Konfirmasi
    │       └── Riwayat → Lihat / Batalkan Reservasi
    └── Admin
        ├── Login
        └── Dashboard
            ├── Status Kamar (grid visual)
            ├── Semua Reservasi (tabel)
            └── Statistik (kamar terisi, tamu aktif, pendapatan)





